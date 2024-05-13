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
			url : "sub1.do",
			success : function(responseData) {
				$("#here1").html(responseData);
			},
			error : function(xhrmstatus, error) {
				alert(error);
			}
		});
	}
</script>
<body>
<h4>서브페이지1</h4>
<div id="here1">여기2</div>
<button id="btn1">서브페이지1버튼</button>
</body>
</html>