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
import com.kim.member.model.vo.DirectMessage;
import com.kim.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("/login.kh")
	public String loginMember(Member m, HttpSession session, Model model) {
		Member member = service.selectOneMember(m);			
		if(member!=null) {
			session.setAttribute("m", member);
			model.addAttribute("msg","로그인 성공");
		}else {
			model.addAttribute("msg","아이디 또는 비밀번호를 확인해주세요");
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	
	@RequestMapping("/joinForm.kh")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping("/join.kh")
	public String join(Member m, Model model) {
		int result = service.insertMember(m);
		if(result>0) {
			model.addAttribute("msg","회원가입 성공");
		}else {
			model.addAttribute("msg","회원가입 실패");
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	
	//ajax처리용 문구
	@ResponseBody
	@RequestMapping("/idCheck.kh")
	public String idCheck(Member m) {
		Member member = service.selectOneMember(m);
		if(member==null) {
			return "0";
		}else {
			return "1";
		}
	}
	
	@RequestMapping("/mypage.kh")
	public String mypage(Member m, Model model) {
		Member member = service.selectOneMemberNum(m);
		model.addAttribute("m", member);
		return "member/mypage";
	}
	
	@RequestMapping("/selectAllMember.kh")
	public String AllMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		//System.out.println(list.size());
		model.addAttribute("list", list);
		return "member/allMember";
	}
	
	@RequestMapping("/update.kh")
	public String update(Member m) {
		int result = service.updateMember(m);
		return "redirect:/mypage.kh?memNo="+m.getMemNo();
	}
	
	@RequestMapping("/logout.kh")
	public String logout(HttpSession session, Model model, @SessionAttribute(required=false) Member loginM) {		
		if(loginM!=null) {
			session.invalidate();
			model.addAttribute("msg","로그아웃 성공");
		}else {
			model.addAttribute("msg","로그인 되어있지않음");
		}
		model.addAttribute("loc","/");		
		return "common/msg";
	}
	
	@RequestMapping("/deleteMember.kh")
	public String deleteMember(Member m, HttpSession session, Model model) {
		int result = service.deleteMember(m);
		if(result>0) {
			session.invalidate();
			model.addAttribute("msg","탈퇴 성공");
		}else {
			model.addAttribute("msg","탈퇴 실패");
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	
	@RequestMapping("/allMemberChat.kh")
	public String allMemberChar() {
		return "member/allMemberChat";
	}
	
	@RequestMapping("/dmList.kh")
	public String dmList(String memId, Model model) {
		ArrayList<DirectMessage> list = service.selectDMList(memId);
		model.addAttribute("list",list);
		return "member/dmList";
	}
	
	@ResponseBody
	@RequestMapping("/dmInsert.kh")
	public int dmInsert(DirectMessage dm) {
		return service.insertDM(dm);
	}
}
