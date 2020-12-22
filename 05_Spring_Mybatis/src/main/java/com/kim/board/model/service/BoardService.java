package com.kim.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.board.model.dao.BoardDao;
import com.kim.board.model.vo.Board;

@Service
public class BoardService {
	@Autowired
	BoardDao dao;

	public ArrayList<Board> selectAllBoard() {		
		return dao.selectAllBoard();
	}
	
	public Board selectOneBoard(int boardNo) {
		return dao.selectOneBoard(boardNo);
	}
}
