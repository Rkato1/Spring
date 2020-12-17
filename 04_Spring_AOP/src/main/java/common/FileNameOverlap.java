package common;

import java.io.File;

public class FileNameOverlap {
	public String rename(String path, String filename) {
		//aclass.txt ->aclass(1).txt
		//파일명 시작부터 마지막.바로 앞까지
		String fileFrontName = filename.substring(0,filename.lastIndexOf('.'));
		//마지막.부터 끝까지
		String fileExtention = filename.substring(filename.lastIndexOf('.'));
		StringBuilder sb = new StringBuilder();
		//파일명 중복 시 붙일 숫자
		int num = 0;
		//이름 중복시 처리할 로직
		while(true) {
			sb.setLength(0);
			sb.append(fileFrontName);
			if(num!=0) {
				sb.append("("+num+")");
			}
			sb.append(fileExtention);
			//중복체크로직
			File checkFile = new File(path+sb.toString());
			if(!checkFile.exists()) {
				break;
			}
			num++;
		}
		return sb.toString();
	}
}
