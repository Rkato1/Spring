<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/join.do" method="post">
		<fieldset>
			<legend>회원가입</legend>
			아이디 : <input type="text" name="memId"><br>
			비밀번호 : <input type="password" name="memPw"><br>
			이름 : <input type="text" name="memName"><br>
			주소 : <input type="text" name="addr"><br>
			나이 : <input type="text" name="age"><br>
			<input type="submit" value="회원가입">
		</fieldset>
	</form>
</body>
</html>