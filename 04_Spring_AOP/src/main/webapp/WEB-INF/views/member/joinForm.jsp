<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<body>
	<form action="/join.do" method="post">
		<fieldset>
			<legend>회원가입</legend>
			아이디 : <input type="text" name="memId"><p id="chkMsg"></p><br>
			비밀번호 : <input type="password" name="memPw"><br>
			이름 : <input type="text" name="memName"><br>
			주소 : <input type="text" name="addr"><br>
			나이 : <input type="text" name="age"><br>
			<input type="submit" value="회원가입">
		</fieldset>
	</form>
	<script>
		$("[name=memId]").keyup(function(){
			var memId = $(this).val();
			$.ajax({
				url:"/idCheck.do",
				data:{memId:memId},
				type:"get",
				success:function(data){
					console.log(data);
					$("#chkMsg").html(data.msg);
					/*
					if(data==0){
						$("#chkMsg").html("사용가능");
					}else{
						$("#chkMsg").html("중복");
					}
					*/
				}
			});
		});
	</script>
</body>
</html>
