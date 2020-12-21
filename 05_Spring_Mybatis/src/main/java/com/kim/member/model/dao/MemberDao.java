package com.kim.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.member.model.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Member selectOneMember(Member m) {
		return sqlSession.selectOne("member.selectOneMember",m);
	}

	public int insertMember(Member m) {
		return sqlSession.insert("member.insertMember",m);
	}

	public Member selectOneMemberNum(Member m) {
		return sqlSession.selectOne("member.selectOneMemberNum",m);
	}

	public ArrayList<Member> selectAllMember() {
		List<Member> list = sqlSession.selectList("member.selectAllMember");
		return (ArrayList<Member>) list;
	}

	public int updateMember(Member m) {
		return sqlSession.update("member.updateMember",m);
	}

	public int deleteMember(Member m) {
		return sqlSession.delete("member.deleteMember",m);
	}
}
