<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.member==null }">
		<h2><a href="/views/common/login.jsp">르그인</a></h2>
		<h2><a href="/views/common/join.jsp">회원가입</a></h2>
	</c:if>
	<c:if test="${sessionScope.member!=null }">
		<h2><a href="/searchAllMember">전체회원조회</a></h2>
		<h2><a href="/views/common/mypage.jsp">마이페이지</a></h2>
		<h2><a href="/deleteMember">회원탈퇴</a></h2>
		<h2><a href="/logout">로그아웃</a></h2>
	</c:if>
</body>
</html>