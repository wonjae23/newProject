package com.won.project.config;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = { "com.won.project"})
@PropertySource(value = { "classpath:application.properties" })
public class WebMvcConfig  implements WebMvcConfigurer, WebApplicationInitializer {
 
	@Inject
    private Environment environment;
	
	@Bean
    public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/common/**").addResourceLocations("/common/");
    }
	
	//@Override 
    //public void addInterceptors(InterceptorRegistry registry) {
    //	registry.addInterceptor(new LoginAuthInterceptor());
    	/*registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
    	registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");*/
    //}
    
     @Override 
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {  
    	argumentResolvers.add(new HeaderMapArgumentResolver());
    }
 
   
    
     @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    	StringHttpMessageConverter sk =new StringHttpMessageConverter();
    	sk.setSupportedMediaTypes(Arrays.asList(new MediaType("text","UTF-8")));    	
    	
    	ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        converters.add(new MappingJackson2HttpMessageConverter(mapper));
    	
    /*  Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
        .indentOutput(true)
        .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
        .modulesToInstall(new ParameterNamesModule());
      converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
      converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
    */
    }
     
     @Override
     public void onStartup(ServletContext servletContext) throws ServletException {
 		  FilterRegistration.Dynamic filter 
 		  = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
 		          filter.setInitParameter("encoding", "UTF-8");
 		          filter.addMappingForServletNames(null, false, "dispatcher");
 	 }
     
     @Bean
     public CommonsMultipartResolver multipartResolver() {
         CommonsMultipartResolver resolver=new CommonsMultipartResolver();
         resolver.setMaxUploadSize(5120000);
         resolver.setDefaultEncoding("utf-8");
         return resolver;
     }
     
    
     
    
     
     /*@Bean
     public ConnectionFactoryLocator connectionFactoryLocator() {
         ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
         registry.addConnectionFactory(new FacebookConnectionFactory(
                 environment.getProperty("2104056399720115"),
                 environment.getProperty("76bf158476462805a71ab99bd54885bd")));
    
         return registry;
     }*/
     
     @Bean
     public FacebookConnectionFactory connectionFactory() {
         FacebookConnectionFactory beanfact = new FacebookConnectionFactory("2104056399720115","76bf158476462805a71ab99bd54885bd");
         return beanfact;
     }

     @Bean
     public OAuth2Parameters oAuth2Parameters() {
         OAuth2Parameters auth=new OAuth2Parameters();
         auth.setScope("email");
         auth.setRedirectUri("https://localhost:8443/return.do");
         return auth;
     }

}