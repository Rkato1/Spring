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
	<h1>공지사항</h1>
	<hr>
	<table border=1>
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
		</tr>
		<c:forEach	items="${list }" var="n">
			<tr>
				<td>${n.noticeNo }</td>
				<td><a href="/noticeView.do?noticeNo=${n.noticeNo }">${n.noticeTitle }</a></td>
				<td>${n.noticeWriter }</td>
				<td>${n.noticeDate }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" style="text-align:center">${pageNavi }</td>
		</tr>
	</table>
	<a href="/noticeForm.do">공지사항 작성</a>
</body>
</html>