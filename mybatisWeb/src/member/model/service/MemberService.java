package member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public int insertMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().insertMember(session,member);
		
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	public Member selectMember(String memberId, String memberPw) {
		SqlSession session=SqlSessionTemplate.getSqlSession();
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("memberId", memberId);
		map.put("memberPw", memberPw);
		Member member=new MemberDao().selectMember(session,map);
		return member;
	}

	public ArrayList<Member> selectAllMember() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = new MemberDao().selectAllMember(session);
		return list;
	}

	public int deleteMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().deleteMember(session,member);
		
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

}
