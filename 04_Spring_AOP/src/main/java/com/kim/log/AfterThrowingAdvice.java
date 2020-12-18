package com.kim.log;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("메소드 이름 : "+methodName);
		System.out.println("발생한 예외 메시지 : "+exceptionObj.toString());
	}
}
