package com.kim.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.board.model.service.BoardService;
import com.kim.board.model.vo.Board;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/boardList.kh")
	public String boardList(Model model) {
		ArrayList<Board> list = service.selectAllBoard();
		model.addAttribute("list",list);
		return "board/boardList";
	}
	
	@RequestMapping("/showBoard.kh")
	public String selectOneBoard(Board b, Model model) {
		Board board = service.selectOneBoard(b.getBoardNo());
		System.out.println(board.getBoardNo());
		model.addAttribute("b",board);
		return "board/showBoard";
	}
}
