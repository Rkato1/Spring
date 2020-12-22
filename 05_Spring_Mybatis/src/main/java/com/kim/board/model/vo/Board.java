package com.kim.board.model.vo;

import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/*
@Getter 이 두개를 합친게 @Data
@Setter
*/
//알아서 getter,setter,생성자 만들어줌
@Data
public class Board {
	int boardNo;
	String boardTitle;
	String boardWriter;
	String boardContent;
	String boardDate;
	ArrayList<FileVO> fileList;
}
