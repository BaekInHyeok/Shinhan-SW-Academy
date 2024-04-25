<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--JSP 주석 : 브라우저에서 안보임 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/webproject/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$("#btnDupCheck").on("click",f_dupCheck);
});

function f_dupCheck(){
	$.ajax({
		url:"/webproject/day8/emailCheck.jsp",
		type:"get",
		data:{email:$("input[name='email']").val()};
		success:function(responseText){
			if(responseText==1){
				message="이미 존재한다(사용불가)";
			}else{
				message="사용가능";
			}
			
			$("#message").html(message);
		}
	});
}
</script>

</head>
<style>
#container {
	width: 800px;
	margin: 0 auto;
	padding-bottom: 20px;
	padding-top: 20px;
}

h1 {
	height: 80px;
	text-align: center;
	line-height: 80px;
	background-color: beige;
	color: orange;
	font-size: 30px;
}

#required {
	background-color: lightgray;
	margin: 0 auto;
	padding: 15px;
}

#notrequired {
	margin: 2 auto;
	padding: 15px;
	border: 1px solid black;
}

legend {
	text-align: center;
	font-style: italic;
	font-size: 30px;
	font-family: "Nanum Pen Script", cursive, "맑은 고딕", 굴림;
}
/*
inline:content만큼만 자리 차지(width 불가),label
block:한 라인의 자리 차지(width 가능)
inline-block:inline 요소가 block 특징을 가질 수 있음, input
*/
label {
	width: 100px;
	display: inline-block;
	font-family: "Nanum Pen Script", cursive, "맑은 고딕", 굴림;
	font-size: 20px;
}

input {
	width: 200px;
	font-size: 20px;
	border-radius: 10px;
}

/* input[value] {
	background-color: lightblue;
} */

/* input[type="submit"], input[type="reset"] {
	background-color: gray;
} */

/* input:focus {
	background-color: beige;
}

input:hover {
	background-color: hotpink;
} */


#submit {
	text-decoration: none;
	background-color: black;
	width: 100px;
	color: white;
	padding: 3px;
	border:1px solid black;
	border-radius: 10px;
	font-family: "Nanum Pen Script", cursive, "맑은 고딕", 굴림;
	font-size: 30px;
}

#reset {
	text-decoration: none;
	background-color: white;
	width: 100px;
	color: black;
	padding: 3px;
	border:1px solid black;
	border-radius: 10px;
	font-family: "Nanum Pen Script", cursive, "맑은 고딕", 굴림;
	font-size: 30px;
}
</style>
<body>
	<div id="container">
		<h1>신규직원등록</h1>
		<!-- HTML용 주석 : 브라우저 창에서 보임 -->
		<!--
	method 생략 >> get이 디폴트
	method = "get" : 주소창에 서버에 전달되는 파라메타 노출됨. 자동으로 인코딩됨. 자릿수 제한 있음(4096byte)
	method = "post" : 주소창에 서버에 전달되는 파라메타가 보이지 않음. 요청문서의 body 넘어감.
	submit 버튼 >> 자동으로 action으로 넘어가면서 input들을 action에 전달한다
	input 태그의 name을 전달하는 형태(name이 parameter의 이름임)
	
	name:문서 내에서 같은 이름이 여러 개 가능함
	
	-->

		<form action="empDBInsert.jsp" method="post">

			<fieldset id="required">
				<legend>필수항목</legend>
				<label>직원번호</label> <input type="number" name="employee_id"
					id="employee_id"><br> <label>LastName</label> <input
					type="text" name="last_name"><br> <label>이메일</label> <input
					type="email" name="email"><input type="button" value="중복체크" id="btnDupCheck">
					<span id="message"></span>
					<br><label>입사일</label> <input
					type="text" name="hire_date"><br> <label>업무명</label> <input
					type="text" name="job_id" value="IT_PROG"><br>
			</fieldset>

			<fieldset id="notrequired">
				<legend>선택입력항목</legend>
				<label>FirstName</label> <input type="text" name="first_name"><br>
				<label>전화번호</label> <input type="text" name="phone_number"><br>
				<label>급여</label> <input type="number" name="salary"><br>
				<label>커미션</label> <input type="text" name="commission_pct"><br>
				<label>매니저ID</label> <input type="number" name="manager_id"
					value="100"><br> <label>부서ID</label> <input
					type="number" name="department_id" value="100"><br>
			</fieldset>
			<br> <input id="submit" type="submit" class="btn btn-success" value="입력"> <input
				id="reset" type="reset" class="btn btn-success" value="지우기">


		</form>
	</div>
</body>
</html>