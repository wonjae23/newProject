package com.won.project.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.won.project"})
@PropertySource(value = { "classpath:application.properties" })
public class RootConfig {
	
	@Autowired
	private Environment env;
	
	@Autowired
    private ApplicationContext applicationContext;

	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	

	@Bean
    public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("datasource.jdbc.project.driver"));
        dataSource.setUrl(env.getRequiredProperty("datasource.jdbc.project.url"));
        dataSource.setUsername(env.getRequiredProperty("datasource.jdbc.project.username"));
        dataSource.setPassword(env.getRequiredProperty("datasource.jdbc.project.password"));
        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(500);
        dataSource.setMinIdle(10);
        dataSource.setMaxWaitMillis(5000);                   
        dataSource.setTestWhileIdle(true);       
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);     
        dataSource.setTimeBetweenEvictionRunsMillis(150000);
   
        return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
        /*sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mapper/mybatis-config.xml"));*/
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*Mapper.xml"));
       
        return sqlSessionFactoryBean.getObject();
	}    
	    
    @Bean
    public SqlSession sqlSession() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }
    
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
}
