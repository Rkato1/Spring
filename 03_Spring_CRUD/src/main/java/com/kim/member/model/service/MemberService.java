package com.kim.member.model.service;

import java.util.ArrayList;

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
		int result = dao.insertMember(m);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		ArrayList<Member> list = dao.selectAllMember();
		return list;
	}

	public Member selectOneMember(int memNo) {
		Member m = dao.selectOneMember(memNo);
		return m;
	}

	public int updateMember(Member m) {
		int result = dao.updateMember(m);
		return result;
	}

	public int deleteMember(int memNo) {
		int result = dao.deleteMember(memNo);
		return result;
	}	
	
}


