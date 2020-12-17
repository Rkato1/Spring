package com.kim.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.log.LogAdvice2;
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
		System.out.println("한명조회 로직 수행+멤버");
		Member loginM = dao.selectOneMember(m);
		return loginM;
	}

	public int insertMember(Member m) {
		System.out.println("회원가입 로직 수행");
		int result = dao.insertMember(m);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		
		System.out.println("전체조회 로직 수행");
		ArrayList<Member> list = dao.selectAllMember();
		return list;
	}

	public Member selectOneMember(int memNo) {
		
		System.out.println("한명조회 로직 수행+번호");
		Member m = dao.selectOneMember(memNo);
		return m;
	}

	public int updateMember(Member m) {
		
		System.out.println("정보갱신 로직 수행");
		int result = dao.updateMember(m);
		return result;
	}

	public int deleteMember(int memNo) {
		
		System.out.println("회원삭제 로직 수행");
		int result = dao.deleteMember(memNo);
		return result;
	}

	public Member checkId(String memId) {
		
		System.out.println("아이디체크 로직 수행");
		Member m = dao.checkId(memId);
		return m;
	}	
	
}


