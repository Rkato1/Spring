package kh.mvc.member.model.service;

import kh.mvc.member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member m) {
		Member loginM = new Member("u1","1234","유저1");
		if(m.getMemId().equals(loginM.getMemId())&&m.getMemPw().equals(loginM.getMemPw())) {
			return loginM;
		}
		return null;
	}

	public int insertMember(Member m) {
		if(m.getMemId().equals("u1")) {
			return 0;
		}
		return 1;
	}

}
