package kh.mvc.member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mvc.member.model.service.MemberService;
import kh.mvc.member.model.vo.Member;

public class InsertController implements Controller{

	@Override
	public String handelRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			Member m = new Member();
			m.setMemId(request.getParameter("memId"));
			m.setMemPw(request.getParameter("memPw"));
			m.setMemName(request.getParameter("memName"));
			int result = new MemberService().insertMember(m);
			if(result>0) {
				return "insertSuccess";
			}else {
				return "insertFailed";
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
