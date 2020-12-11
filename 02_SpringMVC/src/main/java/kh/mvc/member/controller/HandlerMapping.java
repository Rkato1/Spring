package kh.mvc.member.controller;

import java.util.HashMap;

public class HandlerMapping {
	//사용자의 요청 URL을 처리해줄 Controller검색
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do",new LoginController());
		mappings.put("/insert.do",new InsertController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
