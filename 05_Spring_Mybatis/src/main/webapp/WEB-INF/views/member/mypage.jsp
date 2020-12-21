<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<form action="/update.kh" method="post">
		<fieldset>
			<legend>정보수정</legend>
			번호 : <input type="text" name="memNo" value="${m.memNo }" readonly><br>
			아이디 : <input type="text" name="memId" value="${m.memId }" readonly><br>
			비밀번호 : <input type="text" name="memPw" value="${m.memPw }"><br>
			이름 : <input type="text" name="memName" value="${m.memName }"><br>
			주소 : <input type="text" name="addr" value="${m.addr }" ><br>
			나이 : <input type="text" name="age" value="${m.age }" ><br>
			<input type="submit" value="정보수정">
		</fieldset>
	</form>
	<a href="/">메인페이지로</a>
</body>
</html>