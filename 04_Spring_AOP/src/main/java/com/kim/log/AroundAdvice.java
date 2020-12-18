package com.kim.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	//pjp가 무조건 있어야함
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		System.out.println("수행 메소드 : "+methodName);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//System.out.println("비즈니스로직 전 수행 동작");
		//비즈니스 메소드 수행
		Object returnObj = pjp.proceed();
		//System.out.println("비즈니스로직 후 수행 동작");
		stopWatch.stop();
		System.out.println(methodName+"메소드 수행시간 : "+stopWatch.getTotalTimeMillis()+"(ms)");
		return returnObj;
	}
}
