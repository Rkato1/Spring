package com.kim.member.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {		
		Member m = new Member();
		m.setMemNo(rs.getInt("mem_no"));
		m.setMemId(rs.getString("mem_id"));
		m.setMemPw(rs.getString("mem_pw"));
		m.setMemName(rs.getString("mem_name"));
		m.setAddr(rs.getString("addr"));
		m.setAge(rs.getInt("age"));
		return m;
	}
	
}
