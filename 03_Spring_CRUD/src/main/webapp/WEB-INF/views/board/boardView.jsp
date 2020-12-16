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
	<h1>게시글 상세보기</h1>
	<hr>
	<table border="1">
		<tr>
			<th>글번호</th><td>${b.boardNo }</td>
		</tr>
		<tr>
			<th>제목</th><td>${b.boardTitle }</td>
		</tr>
		<tr>
			<th>작성자</th><td>${b.boardWriter }</td>
		</tr>
		<tr>
			<th>작성일</th><td>${b.boardDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<c:forEach items="${b.fileList }" var="f">
					<p>${f.filename }</p>					
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>내용</th><td>${b.boardContent }</td>
		</tr>
	</table>
</body>
</html>