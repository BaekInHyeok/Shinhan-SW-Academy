<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#btn1").on("click", f1);//전체 시설목록 조회
	});

	function f1() {
		$.ajax({
			type : "get",
			url : "main.do",
			success : function(responseData) {
				$("#here").html(responseData);
			},
			error : function(xhrmstatus, error) {
				alert(error);
			}
		});
	}
</script>
<body>
	<h3>메인페이지</h3>
	<div id="here">여기1</div>
	<button id="btn1">메인페이지버튼</button>
</body>
</html>