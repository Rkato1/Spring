package com.dsshop.member.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/rest.do")
	public String rest() {
		String deptCode;
		InputStream is = null;
	    DataInputStream dis = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		//DataInputStream dis = new DataInputStream(is);
		//System.out.println("받은값 = "+deptCode);
		System.out.println("insertMember 호출");
		return "redirect:/";
	}
}
