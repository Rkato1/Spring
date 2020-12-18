package com.kim.log;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeLog(JoinPoint jp) {
		//비즈니스 호출 메소드이름 가져옴
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[BEFORE]로그");
		System.out.println("실행 메소드 : "+methodName);
		System.out.println("첫번째 매개변수 : "+args[0]);
	}
}
