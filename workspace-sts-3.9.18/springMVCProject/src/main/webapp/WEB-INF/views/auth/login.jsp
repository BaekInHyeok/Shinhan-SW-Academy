<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>
	<div>
	<h2>${loginResult}</h2>
		<form action="${path}/auth/login.do" method="post">
			<div class="mb-3 mt-3">
				<label for="email" class="form-label">Email:</label> <input
					type="text" class="form-control" id="email"
					name="email" value="SKING">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">Password:</label> <input
					type="password" class="form-control" id="pwd"
					name="pswd" value="515.123.4567">
			</div>
			<div class="form-check mb-3">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" id="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		$(function(){
			$("form").on("submit",f);
			$("#email").val(localStorage.getItem("email"));
			$("#pwd").val(localStorage.getItem("pwd"));
			var checkStatus=localStorage.getItem("checkStatus");
			if(checkStatus==1){
				$("#remember").prop("checked",true);
			}
		});
		
		function f(){
			var check = $("#remeber").prop("checked");
			if(check){
				localStorage.setItem("email",$("#email").val());
				localStorage.setItem("pwd",$("#pwd").val());
				localStroage.setItem("checkStatus",1);
			}else{
				localStorage.removeItem("email");
				localStorage.removeItem("pwd");
				localStroage.removeItem("checkStatus");
			}
		}
	</script>


</body>
</html>