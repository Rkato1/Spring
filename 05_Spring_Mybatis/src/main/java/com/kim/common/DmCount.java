package com.kim.common;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kim.member.model.dao.MemberDao;

@Component
public class DmCount extends TextWebSocketHandler{
	@Autowired
	MemberDao dao;
	HashMap<String, WebSocketSession> connectMembers;
	
	public DmCount() {
		super();
		connectMembers = new HashMap<String, WebSocketSession>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		System.out.println("클라이언트 접속(DM)");
	}
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		String recMsg = message.getPayload();
		JsonParser parser = new JsonParser();
		JsonObject msg = (JsonObject)parser.parse(recMsg);
		String type = msg.get("type").getAsString();
		String data = msg.get("data").getAsString();
		if(type.equals("register")) {
			connectMembers.put(data, session);
		}else {
			int count = dao.dmCount(data);
			connectMembers.get(data).sendMessage(new TextMessage(String.valueOf(count)));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		System.out.println("클라이언트 접속(DM) 종료");
		Set<String> keys = connectMembers.keySet();
		for(String key : keys) {
			WebSocketSession currentSession = connectMembers.get(key);
			if(currentSession.equals(session)) {
				connectMembers.remove(key);
				break;
			}
		}
	}
}
