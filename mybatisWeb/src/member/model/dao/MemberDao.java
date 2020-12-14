package member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;



import member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession session, Member member) {
		
		return session.insert("mem.insert", member);
	}

	public Member selectMember(SqlSession session, HashMap<String, String> map) {
		
		return session.selectOne("mem.join", map);
	}

	public ArrayList<Member> selectAllMember(SqlSession session) {
		List<Member> list = session.selectList("mem.selectAllMember");
		return (ArrayList<Member>)list;
	}

	public int deleteMember(SqlSession session, Member member) {
		
		return session.delete("mem.deleteMember", member);
	}

}
