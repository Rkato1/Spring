<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 작성</h1>
	<hr>
	<!-- 파일 주고 받을때 필수로 post와 enctype 적어야함 -->
	<form action="/insertNotice.do" method="post" enctype="multipart/form-data">
		<fieldset>
			제목 : <input type="text" name="noticeTitle"><br>
			작성자 : <input type="text" name="noticeWriter" value="${sessionScope.loginM.memId }"><br>
			첨부파일 : <input type="file" name="file"><br>
			내용 : <textarea rows="5" cols="30" name="noticeContent"></textarea><br>
			<input type="submit" value="작성">
		</fieldset>
	</form>
</body>
</html>