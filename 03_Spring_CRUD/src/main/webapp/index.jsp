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
	<!-- 넘길때 name이 변수명과 일치하면 알아서 스프링이 처리해줌 -->
	<form action="/login.do" method="post">
		<fieldset>
			아이디 : <input type="text" name="memId"><br>
			비밀번호 : <input type="password" name="memPw"><br>
			<input type="submit" value="로그인">
		</fieldset>
	</form>
	<a href="/joinForm.do">회원가입</a>
</body>
</html>