package com.dsshop.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsshop.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	//인터페이스로 선언뒤 값은 impl클래스로 할당
	@Autowired
	MemberService service;
	
	//회원가입 처리용 메소드 생성
	@RequestMapping("/insert.do")
	public String insertMember() {
		System.out.println("insertMember 호출");
		return "redirect:/";
	}
	@RequestMapping("/select.do")
	public String selectMember() {
		System.out.println("selectMember 호출");
		return "redirect:/";
	}
	@RequestMapping("/update.do")
	public String updateMember() {
		System.out.println("updateMember 호출");
		return "redirect:/";
	}
}
