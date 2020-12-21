package com.kim.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kim.member.model.dao.MemberDao;
import com.kim.member.model.vo.Member;
@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	public Member selectOneMember(Member m) {		
		return dao.selectOneMember(m);
	}
	
	@Transactional
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	public Member selectOneMemberNum(Member m) {
		return dao.selectOneMemberNum(m);
	}

	public ArrayList<Member> selectAllMember() {		
		return dao.selectAllMember();
	}

	public int updateMember(Member m) {
		return dao.updateMember(m);
	}

	public int deleteMember(Member m) {
		return dao.deleteMember(m);
	}
}
