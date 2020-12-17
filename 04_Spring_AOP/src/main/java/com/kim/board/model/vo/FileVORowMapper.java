package com.kim.board.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileVORowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		FileVO f = new FileVO();
		f.setFileNo(rs.getInt("file_no"));
		f.setBoardNo(rs.getInt("board_no"));
		f.setFilename(rs.getString("filename"));
		f.setFilepath(rs.getString("filepath"));
		return f;
	}
	
}
