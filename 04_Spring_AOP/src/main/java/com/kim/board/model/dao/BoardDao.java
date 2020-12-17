package com.kim.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kim.board.model.vo.Board;
import com.kim.board.model.vo.BoardRowMapper;
import com.kim.board.model.vo.FileVO;
import com.kim.board.model.vo.FileVORowMapper;

@Repository
public class BoardDao {
	@Autowired
	JdbcTemplate jdbc;

	public ArrayList<Board> selectBoardList() {
		String query = "select * from board order by 1 desc";
		List<Board> list = jdbc.query(query, new BoardRowMapper());
		return (ArrayList<Board>)list;
	}

	public int insertBoard(Board b) {
		String query = "insert into board values(board_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		Object[] params = {b.getBoardTitle(), b.getBoardWriter(), b.getBoardContent()};
		int result = jdbc.update(query,params);
		return result;
	}

	public int selectBoardNo() {
		String query = "select max(board_no) from board";
		int boardNo = jdbc.queryForObject(query, int.class);
		return boardNo;
	}

	public int insertFile(int boardNo, String filename, String filepath) {
		String query = "insert into file_tbl values(file_seq.nextval,?,?,?)";
		Object[] params = {boardNo, filename, filepath};
		int result = jdbc.update(query,params);
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		String query = "select * from board where board_no=?";
		Object[] params = {boardNo};
		List<Board> list = jdbc.query(query,params,new BoardRowMapper());
		Board b = null;
		if(list.size()!=0) {
			b = list.get(0);
		}
		return b;
	}

	public ArrayList<FileVO> selectFileList(int boardNo) {
		String query = "select * from file_tbl where board_no=?";
		Object[] params = {boardNo};
		List<FileVO> list = jdbc.query(query,params,new FileVORowMapper());
		return (ArrayList<FileVO>)list;
	}
}
