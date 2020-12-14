package com.kim.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kim.member.model.vo.Member;
import com.kim.member.model.vo.MemberRowMapper;

@Repository
public class MemberDao {
	//의존성 주입(어노테이션으로 생성한 객체 값 받아오기)
	@Autowired
	JdbcTemplate jdbc;
	
	public MemberDao() {
		super();
		System.out.println("MemberDao 생성완료!");
	}

	public Member selectOneMember(Member m) {
		//preparedstatement 방식으로 쿼리문 작성
		String query = "select * from member where mem_id=? and mem_pw=?";
		//위치홀더에 들어갈 값 Object[] 형태로 변환
		Object[] params = {m.getMemId(),m.getMemPw()};
		//쿼리문 실행(매개변수 3개, 1->쿼리,2->매개변수,3->데이터저장용 rowMapper객체)=>결과값 반환
		List<Member> list = jdbc.query(query,params, new MemberRowMapper());
		Member loginM = null;
		if(list.size()!=0) {
			loginM = list.get(0);
		}		
		return loginM;
	}

	public int insertMember(Member m) {
		String query = "insert into member values(mem_seq.nextval,?,?,?,?,?)";
		Object[] params = {m.getMemId(),m.getMemPw(),m.getMemName(),m.getAddr(),m.getAge()};
		int result = jdbc.update(query,params);		
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		String query = "select * from member";
		List<Member> list = jdbc.query(query, new MemberRowMapper());		
		return (ArrayList<Member>) list;
	}

	public Member selectOneMember(int memNo) {
		//preparedstatement 방식으로 쿼리문 작성
		String query = "select * from member where mem_no=?";
		//위치홀더에 들어갈 값 Object[] 형태로 변환
		Object[] params = {memNo};
		//쿼리문 실행(매개변수 3개, 1->쿼리,2->매개변수,3->데이터저장용 rowMapper객체)=>결과값 반환
		List<Member> list = jdbc.query(query,params, new MemberRowMapper());
		Member m = null;
		if(list.size()!=0) {
			m = list.get(0);
		}
		return m;
	}

	public int updateMember(Member m) {
		String query = "update member set mem_pw=?, mem_name=?, addr=?, age=? where mem_no=?";
		Object[] params = {m.getMemPw(),m.getMemName(),m.getAddr(),m.getAge(),m.getMemNo()};		
		int result = jdbc.update(query,params);
		return result;
	}

	public int deleteMember(int memNo) {
		String query = "delete from member where mem_no=?";
		Object[] params = {memNo};
		int result = jdbc.update(query,params);
		return result;
	}

}
