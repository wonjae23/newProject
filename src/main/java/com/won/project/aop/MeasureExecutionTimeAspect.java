package com.won.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//dao 실행시간을 보기위한 aop
@Aspect
@Component
public class MeasureExecutionTimeAspect {
	
	@Around("execution(* com.won.project.dao..*.*(..))")
	public Object aroundAdvice( ProceedingJoinPoint pjp) throws Throwable {
		// before advice
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		
		// after advice
		sw.stop();
		Long total = sw.getTotalTimeMillis();
		
		// 어떤 클래스의 메서드인지 출력하는 정보는 pjp 객체에 있다.
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		
		System.out.println("[AOP ExecutionTime] " + taskName + " , " + total + "(ms)");
		
		return result;
	}
}
