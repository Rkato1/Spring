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
<body>
	<form action="/join.kh" method="post">
		<fieldset>
			아이디 : <input type="text" name="memId"><span id="idChk"></span><br>
			비밀번호 : <input type="password" name="memPw"><br>
			이름 : <input type="text" name="memName"><br>
			주소 : <input type="text" name="addr"><br>
			나이 : <input type="text" name="age"><br>
			<input type="submit" value="가입하기"><br>
		</fieldset>
	</form>
</body>
<script type="text/javascript">
	$("[name=memId]").keyup(function(){
		var memId = $(this).val();
		$.ajax({
			url:"/idCheck.kh",
			data:{memId:memId},
			type:"get",
			success:function(data){
				console.log(data);
				if(data == 0){
					$("#idChk").html("사용 가능한 아이디");
				}else{
					$("#idChk").html("이미 사용중인 아이디");
				}
			}
		});
	});
</script>
</html>