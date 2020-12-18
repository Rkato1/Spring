package com.kim.log;

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
	//어느 시점에 적용할지 선정하여 적용
	@Autowired
	SHA256Util enc;
	
	@Pointcut("execution(* com.kim.member.model.service.MemberService.*(com.kim.member.model.vo.Member))")
	public void encPw() {}
	
	//OOP의 특이점(얉은 복사에 의한 변경으로 적용)
	@Before("encPw()")
	public void encPassword(JoinPoint jp) throws Exception{
		Object[] args = jp.getArgs();
		Member m = (Member)args[0];
		String memPw = m.getMemPw();
		String encPw = enc.encPw(memPw);
		m.setMemPw(encPw);		
		System.out.println("Before, 로직 전 암호화");
	}	
	
	@Around("encPw()")
	public Object encPassword2(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		Member m = (Member)args[0];
		String memPw = m.getMemPw();
		String encPw = enc.encPw(memPw);
		m.setMemPw(encPw);		
		System.out.println("Around, 로직 전 암호화");
		Object returnObj = pjp.proceed();
		return returnObj;
	}
	
	//수정로그인 로직을 위해 새로 만들기
	//포인트컷 추가
	@Pointcut("execution(* com.kim.member.model.service.MemberService.loginMember(..))")
	public void encPwLogin() {}
	//advice추가
	@Around("encPwLogin()")
	public Object encPasswordLogin(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		//System.out.println("0번 "+args[0]);
		//System.out.println("1번 "+args[1]);
		String memPw = (String) args[1];
		String encPw = enc.encPw(memPw);
		//String의 경우 기본형과 참조형의 특징을 공유하고 있어 어떻다라고 처리하기 애매함
		//String의 특이점(기본형의 경우는 대부분 이런식으로 처리)=>얕은(값)복사이기 때문
		//System.out.println("암호화결과 = "+encPw);
		Object[] changeArgs = {args[0],encPw};
		System.out.println("로그인 전용 Before, 로직 전 암호화");
		Object returnObj = pjp.proceed(changeArgs);
		return returnObj;
	}
}
