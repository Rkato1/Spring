package com.kim.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kim.log.LogAdvice2;
import com.kim.log.SHA256Util;
import com.kim.member.model.dao.MemberDao;
import com.kim.member.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	//암호화 처리를 위한 클래스 선언
	@Autowired
	private SHA256Util enc;
	
	public MemberService() {
		super();
		System.out.println("MemberService 생성완료!");
	}
	
	//수정로그인 방식, 트랜잭션이 commit, rollback 담당
	@Transactional
	public Member loginMember(String memId, String memPw) {
		Member loginM = dao.selectOneMember(memId,memPw);
		return loginM;
	}

	//기존 로그인 방식
	public Member selectOneMember(Member m) throws IllegalArgumentException{
		System.out.println("로그인 로직 수행");
		if(m.getMemId().equals("") || m.getMemPw().equals("")) {
			//강제 예외 처리
			throw new IllegalArgumentException("아이디나 패스워드가 누락됨");
		}
		Member loginM = dao.selectOneMember(m);
		return loginM;
	}

	public int insertMember(Member m) {
		System.out.println("회원가입 로직 수행");
		//비밀번호 암호화 과정
//		String memPw = m.getMemPw();
//		try {
//			String encPw = enc.encPw(memPw);
//			//암호화된 패스워드로 변경
//			m.setMemPw(encPw);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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


