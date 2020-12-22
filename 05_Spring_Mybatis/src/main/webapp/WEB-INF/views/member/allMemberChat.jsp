<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<style>
	.chatArea{
		display:none;
	}
	.chatMsg{
		width:400px;
		height:600px;
		border:1px solid #333;
		background-color: #b2c7d9;
		display:flex;
		flex-direction:column;
		overflow:scroll;
	}
	.text-center{
		text-align:center;
	}
	.chatMsg>p{
		paddin:8px;
		border-radius:5px;
	}
	.others{
		background-color: #fff;
		max-width:300px;
		align-self:flex-start;
	}
	.me{
		background-color: #ffeb33;
		max-width:300px;
		align-self:flex-end;
	}
</style>
<body>
	<button onclick="startChat();">채팅 시작하기</button>
	<div class="chatArea">
		<div class="chatMsg"></div>
		<input type="text" id="sendMsg">
		<button onclick="sendMsg('${sessionScope.m.memId}');">보내기</button>	
	</div>
	<script>
		var ws;
		function startChat(){
			$(".chatArea").show();
			//localhost적힌 부분은 원래 아이피가 들어갈 자리
			ws = new WebSocket("ws://localhost/allChat.kh");
			//함수의 이름만 적어도 연결됨
			//웹소켓 연결 성공시 진행할 함수
			ws.onopen = onOpen;
			//서버에서 메시지가 왔을때 수행할 함수
			ws.onmessage = onMessage;
			//웹소켓 연결이 끊어졌을때 동작할 함수
			ws.onclose = onClose;
		}
		
		function onOpen(){
			console.log("서버 접속 완료");
			var msg = {
					type:"register",
					data:"${sessionScope.m.memId}"
			}
			ws.send(JSON.stringify(msg));
		}
		function onMessage(e){
			 $(".chatMsg").append(e.data);
		}
		function onClose(){
			console.log("서버 접속 종료");
		}
		function sendMsg(memId){
			var sendMsg = $("#sendMsg").val();
			if(sendMsg != ''){
				var sendData = "<p class='others'>"+memId+" : "+sendMsg+"</p>";
				var msg = {
						type:"chat",
						data:sendData
				}
				ws.send(JSON.stringify(msg));
				$(".chatMsg").append("<p class='me'>"+sendMsg+"</p>");
				$("#sendMsg").val('');
			}
		}
	</script>
</body>
</html>