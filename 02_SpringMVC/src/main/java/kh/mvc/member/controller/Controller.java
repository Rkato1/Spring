package kh.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String handelRequest(HttpServletRequest request, HttpServletResponse response);
}
