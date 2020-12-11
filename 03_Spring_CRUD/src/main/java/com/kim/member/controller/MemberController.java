package com.kim.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.member.model.service.MemberService;
import com.kim.member.model.vo.Member;
//component와 유사한 기능 이지만 controller사용할거다
@Controller
public class MemberController {
	//그냥 두면 null값이니까 객체 생성 시켜주는 기능
	@Autowired
	private MemberService service;
	
	public MemberController() {
		super();
		System.out.println("MemberController 생성완료!");
	}
	
	//메소드 mapping
	@RequestMapping("/login.do")
	public String login(HttpSession session, Member m) { 
		Member loginM = service.selectOneMember(m);
		if(loginM!=null) {
			session.setAttribute("loginM", loginM);
			return "member/loginSuccess";
		}else {
			return "member/loginFailed";			
		}
	}
	
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping("/join.do")
	public String join(Member m) {
		int result = service.insertMember(m);
		if(result>0) {
			return "member/joinSuccess";
		}else {
			return "member/joinFailed";
		}
	}
}
