package com.kim.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.member.model.dao.MemberDao;
import com.kim.member.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public MemberService() {
		super();
		System.out.println("MemberService 생성완료!");
	}

	public Member selectOneMember(Member m) {
		Member loginM = dao.selectOneMember(m);
		return loginM;
	}

	public int insertMember(Member m) {
		System.out.println("id : "+m.getMemId());
		System.out.println("pw : "+m.getMemPw());
		System.out.println("name : "+m.getMemName());
		System.out.println("addr : "+m.getAddr());
		System.out.println("age : "+m.getAge());
		System.out.println("no : "+m.getMemNo());
		return 1;
	}	
	
}


