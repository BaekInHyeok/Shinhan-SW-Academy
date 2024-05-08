<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입주민 항목</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btn1").on("click",f1);//아파트 전체 입주자 목록 조회
		$("#btn2").on("click",f2);//동별 입주자 목록 조회
	});
	
	function f1(){
		$.ajax({
			type:"get",
			url:"rescon1.do",
			success:function(responseData){
				$("#resList").html(responseData);
			},
			error:function(xhrmstatus,error){
				alert(error);
			}
		});
	}
	
	function f2(){
		$.ajax({
			type:"post",
			url:"rescon1.do",
			data:{"dong":$("#ap_dong").val()},
			success:function(responseData){
				$("#resList").html(responseData);
			},
			error:function(xhrmstatus,error){
				alert(error);
			}
		})
	}
</script>

<style>

body {
	background: url('../static/images/apartment.jpg') left top no-repeat fixed;
	background-size: cover;
}
#container {
	background-color: gray;
	margin: 0 auto;
	padding: 30px;
	width: 1400px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border-radius: 30px;
}

#resList {
	width: 100%;
	margin: 0 auto;
	border: 1px solid black;
	padding: 20px;
	margin: 0 auto;
}

h1 {
	color: white;
	font-size: 50px;
	text-align: center;
	margin: 20px;
}

select {
	width: 300px;
	height: 40px;
	font-size: 20px;
	border-radius: 10px;
}

option {
	font-size: 20px;
	border-radius: 20px;
}

#btn1, #btn2, #btn3 {
	width: 250px;
	height: 40px;
	font-size: 20px;
	border-radius: 20px;
	margin: 10px;
}

#updatebtn, #deletebtn {
	margin-right: 2px;
}

td {
	border-left: 1px solid black; /* 왼쪽 세로줄만 그리기 */
	padding: 8px;
	text-align: left;
	background-color: white;
	font-size: 20px;
}

td:last-child, td:nth-last-child(2){
	border-left: none; /* 첫 번째 열에는 세로줄 제거 */
	background-color: transparent;
}

th {
	background-color: black;
	color: white;
	font-size: 20px;
	padding: 5px;
	margin: 3px;
}
</style>
</head>
<body>
	<div id="container">
		<h1>입주민</h1>
		<div>
			<button id="btn1" type="button" class="btn btn-dark">입주민 전체
				목록</button>
			<select id="ap_dong">
				<!-- <option selected="selected">101</option>
				<option>102</option>
				<option>103</option>
				<option>104</option>
				<option>105</option>
				<option>106</option>
				<option>107</option>
				<option>108</option>
				<option>109</option> -->
				<c:forEach var="dong" begin="101" end="109">
					<option>${dong}</option>
				</c:forEach>
			</select>
			<button id="btn2" type="button" class="btn btn-dark">동별 입주민 조회</button>
		</div>
		<div id="resList">
			<table>
				<thead>
					<tr>
						<th>입주민ID</th>
						<th>입주민명</th>
						<th>H.P</th>
						<th>동</th>
						<th>호</th>
						<th>입주일</th>
						<th>보유차량</th>
						<th>관리비</th>
						<th>세대주 여부</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="res" items="${resList}">
						<tr>
							<td>${res.resident_id}</td>
							<td>${res.resident_name}</td>
							<td>${res.resident_phone}</td>
							<td>${res.resident_dong}</td>
							<td>${res.resident_ho}</td>
							<td>${res.resident_date}</td>
							<td>${res.resident_car}</td>
							<td>${res.resident_fee}</td>
							<td>${res.resident_owner}</td>
							<td><button id="updatebtn" onclick="location.href='resUpdate.do?resid=${res.resident_id}'">수정</button>
							<td><button id="deletebtn" onclick="location.href='resDelete.do?resid=${res.resident_id}'">삭제</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<button id="btn3" type="button" class="btn btn-dark"
			onclick="location.href='resInsert.do'">입주민 정보 등록</button>
	</div>
</body>
</html>