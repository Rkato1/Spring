package com.kim.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kim.board.model.service.BoardService;
import com.kim.board.model.vo.Board;
import com.kim.board.model.vo.FileVO;

import common.FileNameOverlap;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		ArrayList<Board> list = service.selectBoardList();
		model.addAttribute("list",list);
		return "board/boardList";
	}
	
	@RequestMapping("/boardForm.do")
	public String boardForm() {
		return "board/boardForm";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(Board b, MultipartFile[] files, Model model, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"resources/upload/board";
		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		System.out.println("foreach전");
		System.out.println("배열의 길이 = "+files.length);
		for(MultipartFile file : files) {
			System.out.println("foreach안");
			if(!file.isEmpty()) {
				System.out.println("if안");
				String filename = file.getOriginalFilename();
				String filepath = new FileNameOverlap().rename(path, filename);
				System.out.println("filename = "+filename);
				System.out.println("filepath = "+filepath);
				try {
					byte[] bytes = file.getBytes();
					File upFile = new File(path+filepath);
					FileOutputStream fos = new FileOutputStream(upFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					bos.write(bytes);
					bos.close();
					FileVO fv = new FileVO();
					fv.setFilename(filename);
					fv.setFilepath(filepath);
					fileList.add(fv);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}						
		}
		b.setfileList(fileList);
		System.out.println("controller : "+b.getfileList().size());
		int result = service.insertBoard(b);
		System.out.println("값넣은후");
		if(result>0) {
			model.addAttribute("msg","작성완료");
		}else {
			model.addAttribute("msg","작성실패");
		}
		model.addAttribute("loc","/boardList.do");
		return "common/msg";
	}
	
	@RequestMapping("/boardView.do")
	public String boardView(int boardNo, Model model) {
		Board b = service.selectOneBoard(boardNo);
		model.addAttribute("b",b);
		return "board/boardView";
	}
}

