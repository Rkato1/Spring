package com.kim.log;

import org.aspectj.lang.JoinPoint;

import com.kim.member.model.vo.Member;

public class AfterReturningAdvice {
	public void success(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		//Member타입인지 여부 확인
		if(returnObj instanceof Member) {
			Member m = (Member) returnObj;
			System.out.println("methodName : "+methodName);
			System.out.println("["+m.getMemName()+"]님이 로그인 하였습니다.");
		}
	}
}
