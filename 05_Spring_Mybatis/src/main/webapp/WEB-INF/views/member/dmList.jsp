<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h1>DM</h1>
	<hr>
	<h2>받은 편지함</h2>
	<table border="1">
		<tr>
			<th>번호</th><th>보낸사람</th><th>메시지</th><th>확인여부</th><th>시간</th>
		</tr>
		<c:forEach items="${list }" var="dm">
			<c:if test="${dm.dmReceiver.equals(sessionScope.m.memId) }">
				<tr>
					<td>${dm.dmNo }</td>
					<td>${dm.dmSender }</td>
					<td>${dm.message }</td>
					<td>${dm.checkMessage }</td>
					<td>${dm.dmDate }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<hr>
	<h2>보낸 편지함</h2>
	<table border="1">
		<tr>
			<th>번호</th><th>받은사람</th><th>메시지</th><th>확인여부</th><th>시간</th>
		</tr>
		<c:forEach items="${list }" var="dm">
			<c:if test="${dm.dmSender.equals(sessionScope.m.memId) }">
				<tr>
					<td>${dm.dmNo }</td>
					<td>${dm.dmReceiver }</td>
					<td>${dm.message }</td>
					<td>${dm.checkMessage }</td>
					<td>${dm.dmDate }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<hr>
	<div>
		수신자 아이디 입력 : <input type="text" name="dmReceiver"><br>
		<textarea rows="10" cols="30" name="message"></textarea><br>
		<button onclick="insertDm('${sessionScope.m.memId}')">보내기</button>
	</div>
	<script>
		function insertDm(dmSender){
			var dmReceiver = $("[name=dmReceiver]").val();
			var message = $("[name=message]").val();
			$.ajax({
				url:"/dmInsert.kh",
				data:{dmReceiver:dmReceiver,dmSender:dmSender,message:message},
				type:"post",
				success:function(data){
					if(data == 1){
						alert("쪽지보내기 성공");
						sendMsg(dmReceiver);
						location.reload();
					}else{
						alert("쪽지보내기 실패");
					}
				}
			});
		}
	</script>
</body>
</html>