package com.won.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
		
		if( reqUrl.indexOf("/apotest.epk")>-1 || reqUrl.indexOf("/login.do")>-1 || reqUrl.indexOf("/loginOk.do")>-1 || reqUrl.indexOf("mo/interface.do")>-1 || reqUrl.indexOf("/checkplus/process.do")>-1 || reqUrl.indexOf("/checkplus/error.do")>-1){	//�씤利앹떎�뙣�떆 login�쑝濡� redirect泥섎━�뿉 ���븳 �삁�쇅, mo/interface�쑝濡� 紐⑤컮�씪 �겢�씪�슦�뱶 �뿰�룞 �쉶�썝,而⑦뀗痢� �룞湲고솕�뿉 ���븳 �삁�쇅
			return true;
		}

		/*Map<String,String> loginSession = (Map<String,String>)request.getSession().getAttribute("OperatorSession");
		
		if(loginSession == null){
			MessageViewer.alert(response, "loginagain", "loginagain", "/login.do", false, false, false, "");
			return false;
		}else{
		   	return true;
		}*/
		
		return true;
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