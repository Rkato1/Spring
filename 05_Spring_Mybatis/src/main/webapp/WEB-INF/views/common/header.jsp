<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- core태그 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<c:if test="${sessionScope.m != null }">
	<h2>여기는 헤더</h2>
	<h3>[${sessionScope.m.memName} }]쪽지함 <span id="dmCount"></span>개</h3>
</c:if>
<script>
	var ws;
	var memId = '${sessionScope.m.memId}';
	function connect(){
		ws = new WebSocket("ws://localhost/dmCount.kh");
		ws.onopen = onOpen;
		ws.onmessage = onMessage;
		ws.onclose = onClose;
	}
	function onOpen(){
		console.log("접속 성공");
		var msg = {
				type:"register",
				data:memId
		}
		ws.send(JSON.stringify(msg));
		sendMsg(memId);
	}
	function onMessage(e){
		var count = e.data;
		$("#dmCount").html(count);
	}
	function onClose(){
		console.log("접속 종료");
	}
	function sendMsg(receiver){
		var msg = {
				type:"count",
				data:receiver
		}
		ws.send(JSON.stringify(msg));
	}
	$(function(){
		connect();
	});
	
</script>