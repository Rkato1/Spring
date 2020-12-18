package com.kim.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
//aop에 쓰이는 어노테이션
@Aspect
public class LogAdvice {
	//포인트컷
	@Pointcut("execution(* com.kim.member.model.service.MemberService.*(..))")
	//내용없는 메소드가 id 역할을 함
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void beforeLog() {
		System.out.println("[BEFORE] 비즈니스로직 수행 전 동작");
	}
	
	@Around("allPointcut()")
	public Object timeCheck(ProceedingJoinPoint pjp) throws Throwable{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = pjp.proceed();
		stopWatch.stop();
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName+" 메소드 수행 시간 : "+stopWatch.getTotalTimeMillis()+"초(ms)");
		return returnObj;
	}
}
