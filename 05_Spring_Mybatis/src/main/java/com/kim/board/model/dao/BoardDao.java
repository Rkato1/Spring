package com.kim.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.board.model.vo.Board;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;

	public ArrayList<Board> selectAllBoard() {
		List<Board> list = sqlSession.selectList("selectAllBoard");
		return (ArrayList<Board>) list;
	}

	public Board selectOneBoard(int boardNo) {
		return sqlSession.selectOne("selectOneBoard", boardNo);
	}
}
