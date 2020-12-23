package com.dsshop.member.model.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dsshop.member.model.dao.MemberDao;

import jdk.nashorn.internal.ir.annotations.Reference;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	//밑에걸 통해서 어떤거에 접근할지 설정
	@Qualifier("dao1")
	MemberDao dao;
	
	//위와 같은 뜻
	@Resource(name = "dao1")
	MemberDao dao1;
}
