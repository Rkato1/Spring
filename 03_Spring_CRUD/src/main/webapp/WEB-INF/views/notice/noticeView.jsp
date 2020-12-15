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
	<h1>글 자세히 보기</h1>
	<hr>
	글 제목 : ${n.noticeTitle}<br>
	작성자 : ${n.noticeWriter }<br>
	첨부파일이름 : ${n.filename }<br>
	첨부파일경로 : ${n.filepath }<br>
	내용 : ${n.noticeContent }<br>
	작성일 : ${n.noticeDate }<br>
</body>
</html>