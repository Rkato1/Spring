package com.kim.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kim.member.model.vo.Member;

@Component
@Aspect
public class MemberPwEnc {
	//회원 가입, 로그인, 업데이트 포인트 컷으로 만들고
	//aop 적용 후 패스워드 암호화
	//비밀번호 암호화 로직을 Advice로 만들고
	//어느 시점에 적용할지 선정하여 적용
	@Autowired
	SHA256Util enc;
	
	@Pointcut("execution(* com.kim.member.model.service.MemberService.*Member(com.kim.member.model.vo.Member))")
	public void encPw() {}
	
	//OOP의 특이점(얉은 복사에 의한 변경으로 적용)
	@Before("encPw()")
	public void encPassword(JoinPoint jp) throws Throwable{
		Object[] args = jp.getArgs();
		Member m = (Member)args[0];
		String memPw = m.getMemPw();
		if(memPw!=null) {
			String encPw = enc.encPw(memPw);
			//System.out.println(encPw);
			m.setMemPw(encPw);
		}
	}	
}
