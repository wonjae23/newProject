package com.epasskorea.groupware;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
	
	 private static final Logger logger = LoggerFactory.getLogger(test.class);
     private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
     private static final String URL = "jdbc:sqlserver://114.141.28.231:14333;SelectMethod=cursor;DatabaseName=GROUPWARE";
     private static final String USER = "gwUser";
     private static final String PW = "gwUser2637";
     
    
     @Test
     public void test() throws Exception{
          Class.forName(DRIVER);
          try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
              System.out.println("오라클에 연결되었습니다.");
              logger.info("오라클에 연결됨.");
              
          }catch (Exception e) {
              e.printStackTrace();
          }
     }
}
