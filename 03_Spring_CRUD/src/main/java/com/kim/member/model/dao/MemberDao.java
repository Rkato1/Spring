package com.kim.member.model.dao;

import org.springframework.stereotype.Repository;

import com.kim.member.model.vo.Member;

@Repository
public class MemberDao {

	public MemberDao() {
		super();
		System.out.println("MemberDao 생성완료!");
	}

	public Member selectOneMember(Member m) {
		System.out.println("id : "+m.getMemId());
		System.out.println("pw : "+m.getMemPw());
		Member loginM = new Member();
		loginM.setMemName("식");
		return loginM;
	}

}
