package kh.mvc.member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mvc.member.model.service.MemberService;
import kh.mvc.member.model.vo.Member;



public class LoginController implements Controller{

	@Override
	public String handelRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			Member m = new Member();
			m.setMemId(request.getParameter("memId"));
			m.setMemPw(request.getParameter("memPw"));
			Member loginM = new MemberService().loginMember(m);
			if(loginM !=null) {
				return "loginSuccess";
			}else {
				return "loginFailed";
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
