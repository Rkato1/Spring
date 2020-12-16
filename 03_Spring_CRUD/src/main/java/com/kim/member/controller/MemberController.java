package com.kim.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

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
	public String login(HttpSession session, Member m, Model model) { 
		Member loginM = service.selectOneMember(m);
		if(loginM!=null) {
			session.setAttribute("loginM", loginM);
			model.addAttribute("msg","로그인 성공");
			//return "member/loginSuccess";
		}else {
			model.addAttribute("msg","아이디 또는 비밀번호를 확인하세요");
			//return "member/loginFailed";
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping("/join.do")
	public String join(Member m, Model model) {
		int result = service.insertMember(m);
		if(result>0) {
			model.addAttribute("msg","회원가입 성공");
			//return "member/joinSuccess";
		}else {
			model.addAttribute("msg","회원가입 실패");
			//return "member/joinFailed";
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	
	@RequestMapping("/selectAllMember.do")
	public String selectAllMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/allMember";
	}
	
	@RequestMapping("/mypage.do")
	public String mypage(int memNo, Model model) {
		Member m = service.selectOneMember(memNo);
		model.addAttribute("m",m);
		return "member/mypage";
	}
	
	@RequestMapping("/update.do")
	public String update(Member m) {
		int result = service.updateMember(m);
		return "redirect:/mypage.do?memNo="+m.getMemNo();
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, Model model, @SessionAttribute(required=false) Member loginM) {
		//세션에 저장된걸 바로 불러옴(false는 null일떄 대비해서 처리)
		//Member m = (Member)session.getAttribute("loginM");
		//System.out.println(loginM.getMemId());
		if(loginM!=null) {
			session.invalidate();
			model.addAttribute("msg","로그아웃 성공");
		}else {
			model.addAttribute("msg","로그인 되어있지않음");
		}
		model.addAttribute("loc","/");		
		return "common/msg";
	}
	
	@RequestMapping("/delete.do")
	public String deleteMember(int memNo, HttpSession session, Model model) {
		int result = service.deleteMember(memNo);
		if(result>0) {
			session.invalidate();
			model.addAttribute("msg","탈퇴 성공");
		}else {
			model.addAttribute("msg","탈퇴 실패");
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	
	//이대로 보내면 /WEB-INF/view + .jsp로 보냄
	//순수데이터가 넘어가게 처리
	@ResponseBody
	@RequestMapping("/idCheck.do")
	public String idCheck(String memId) {
		Member m = service.checkId(memId);
		//사용불가능이면
		if(m!=null) {
			return "1";
		}else {
			return "0";
		}
	}
}