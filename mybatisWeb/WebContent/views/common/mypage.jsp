<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>마이페이지</h2>
	<hr>
	회원번호: ${sessionScope.member.memNo }<br>
	아이디: ${sessionScope.member.memId }<br>
	이름: ${sessionScope.member.memName }<br>
	나이: ${sessionScope.member.age }<br>
	주소: ${sessionScope.member.addr }<br>
	가입일: ${sessionScope.member.regDate}<br>
	
	<h3><a href="/">마이페이지로</a></h3>
</body>
</html>