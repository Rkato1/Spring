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
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h1>전체게시물조회</h1>
	<hr>
	<table border="1">
		<tr>
			<th>글번호</th><th>작성자</th><th>제목</th><th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td>${b.boardNo }</td>
				<td>${b.boardWriter }</td>
				<td><a href="/showBoard.kh?boardNo=${b.boardNo }">${b.boardTitle }</a></td>
				<td>${b.boardDate }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>