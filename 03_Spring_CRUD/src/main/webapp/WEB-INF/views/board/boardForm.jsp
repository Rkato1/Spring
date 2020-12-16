<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<hr>
	<form action="/insertBoard.do" method="post" enctype="multipart/form-data">
		<fieldset>
			제목 : <input type="text" name="boardTitle"><br>
			작성자 : <input type="text" name="boardWriter" value="${sessionScope.loginM.memId }"><br>
			파일 : <input type="file" name="files" multiple><br>
			내용 <textarea rows="3" cols="30" name="boardContent"></textarea><br>
			<input type="submit" value="등록">
		</fieldset>
	</form>
</body>
</html>