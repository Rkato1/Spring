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
	<h1>메인페이지(Spring-Mybatis)</h1>
	<hr>
	<c:choose>
		<c:when test="${sessionScope.m == null }">
			<form action="/login.kh" method="post">
				아이디 : <input type="text" name="memId"><br>
				비밀번호 : <input type="password" name="memPw"><br>
				<input type="submit" value="로그인">		
			</form>
			<a href="/joinForm.kh">회원가입</a>
		</c:when>
		<c:otherwise>
			<h2>[${sessionScope.m.memName }]</h2>
			<h3><a href="/mypage.kh?memNo=${sessionScope.m.memNo }">마이페이지</a></h3>
			<h3><a href="/selectAllMember.kh">전체회원조회</a></h3>
			<h3><a href="/logout.kh">로그아웃</a></h3>
			<h3><a href="/deleteMember.kh?memNo=${sessionScope.m.memNo }">회원탈퇴</a></h3>
			<h3><a href="/boardList.kh">게시판가기</a></h3>
			<h3><a href="/allMemberChat.kh">채팅하러가기</a></h3>
			<h3><a href="/dmList.kh?memId=${sessionScope.m.memId }">쪽지ㄱㄱ</a></h3>
		</c:otherwise>
	</c:choose>
</body>
</html>