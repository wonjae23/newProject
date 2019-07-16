package com.won.project.config;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HeaderMapArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		  return Object.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		EpkMap commandMap = new EpkMap();         
	        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
	        Enumeration<?> enumeration = request.getParameterNames();         

	        String key = null;
	        String[] values = null;

	        while(enumeration.hasMoreElements()){
	            key = (String) enumeration.nextElement();
	            values = request.getParameterValues(key);
	            if(values != null){
	                commandMap.put(key, (values.length > 1) ? values:values[0] );
	            }
	        }

	        return commandMap;
	}

}
