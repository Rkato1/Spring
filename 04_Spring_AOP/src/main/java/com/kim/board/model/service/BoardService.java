package com.kim.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.board.model.dao.BoardDao;
import com.kim.board.model.vo.Board;
import com.kim.board.model.vo.FileVO;

@Service
public class BoardService {
	@Autowired
	BoardDao dao;

	public ArrayList<Board> selectBoardList() {
		ArrayList<Board> list = dao.selectBoardList();		
		return list;
	}

	public int insertBoard(Board b) {
		int result = dao.insertBoard(b);
		System.out.println("result : "+result);
		if(result>0) {
			int boardNo = dao.selectBoardNo();
			for(FileVO fv : b.getfileList()) {
				result = dao.insertFile(boardNo, fv.getFilename(), fv.getFilepath());
			}
		}
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		Board b = dao.selectOneBoard(boardNo);
		if(b!=null) {
			ArrayList<FileVO> fileList = dao.selectFileList(boardNo);
			b.setfileList(fileList);
		}
		return b;
	}
}
