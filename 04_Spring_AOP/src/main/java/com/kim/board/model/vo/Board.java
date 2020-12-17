package com.kim.board.model.vo;

import java.util.ArrayList;

public class Board {
	int boardNo;
	String boardTitle;
	String boardWriter;
	String boardContent;
	String boardDate;
	ArrayList<FileVO> fileList;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, String boardDate,
			ArrayList<FileVO> fileList) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.fileList = fileList;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public ArrayList<FileVO> getfileList() {
		return fileList;
	}
	public void setfileList(ArrayList<FileVO> fileList) {
		this.fileList = fileList;
	}
	
	
}
