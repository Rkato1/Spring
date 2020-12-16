<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>메인페이지</h1>
	<hr>
	<c:choose>
		<c:when test="${sessionScope.loginM == null }">
			<!-- 넘길때 name이 변수명과 일치하면 알아서 스프링이 처리해줌 -->
			<form action="/login.do" method="post">
				<fieldset>
					아이디 : <input type="text" name="memId"><br>
					비밀번호 : <input type="password" name="memPw"><br>
					<input type="submit" value="로그인">
				</fieldset>
			</form>
			<a href="/joinForm.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<h2>[${sessionScope.loginM.memName }]</h2>
			<h3><a href="/selectAllMember.do">1. 전체회원조회</a></h3>
			<h3><a href="/mypage.do?memNo=${sessionScope.loginM.memNo }">2. 마이페이지</a></h3>
			<h3><a href="/logout.do">3. 로그아웃</a></h3>
			<h3><a href="/delete.do?memNo=${sessionScope.loginM.memNo }">4. 회원탈퇴</a></h3>
			<hr>
			<h3><a href="/noticeList.do?reqPage=1">공지사항</a></h3>
			<h3><a href="/boardList.do">게시판</a></h3>
		</c:otherwise>
	</c:choose>
	
</body>
</html>