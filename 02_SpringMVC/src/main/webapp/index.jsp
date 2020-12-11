<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>메인페이지</h1>
	<hr>
	<form action="/login.do" method="post">
		아이디 : <input type="text" name="memId"><br>
		비밀번호 : <input type="password" name="memPw"><br>
		<input type="submit" value="로그인"> 
	</form>
	<hr>
	<form action="/insert.do" method="post">
		아이디 : <input type="text" name="memId"><br>
		비밀번호 : <input type="password" name="memPw"><br>
		이름 : <input type="text" name="memName"><br>
		<input type="submit" value="로그인"> 
	</form>
</body>
</html>