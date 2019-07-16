package com.won.project.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.won.project.common.MessageViewer;

/**
 * Class Name : LoginAuthInterceptor
 * Description : Login Authentication interceptor
 * Modification Information
 * Date			    Autor					Contents
 * -----------  --------------  --------------------------------
 * 2019.04.26   pwj	 	    	
 * 
 * @author: pwj
 * @version: 1.0
*/
public class LoginAuthInterceptor implements HandlerInterceptor  {

	private Logger log = LoggerFactory.getLogger(this.getClass());		
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("## LoginAuthInterceptor preHandle");		
		String reqUrl = String.valueOf(request.getRequestURL());
		log.debug("## [LoginAuthInterceptor preHandle] reqUrl =>" + reqUrl);
		
		if( reqUrl.indexOf("/main/login")>-1  || reqUrl.indexOf("/main/loginOk")>-1 ){	
			return true;
		}

		Map<String,String> loginSession = (Map<String,String>)request.getSession().getAttribute("OperatorSession");
		
		if(loginSession == null){
			MessageViewer.alert(response, "페이지이동", "로그인 화면으로 이동", "/main/login", false, false, false, "");
			return false;
		}else{
		   	return true;
		}
		
		//return true;
    }

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		log.debug("## LoginAuthInterceptor afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		log.debug("## LoginAuthInterceptor postHandle");
	}
		
}