<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근무자 항목</title>
<link rel="stylesheet" href="../static/css/bootstrap.css">
<link rel="stylesheet" href="../static/css/bootstrap-icons.min.css">
<link rel="stylesheet" href="../static/css/prism-okaidia.css">
<link rel="stylesheet" href="../static/css/custom.min.css">
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#btn1").on("click", f1);//전체 근무자 목록 조회
		$("#btn2").on("click", f2);//업무별 근무자 목록 조회
	});

	function f1() {
		$.ajax({
			type : "get",
			url : "wkrcon.do",
			success : function(responseData) {
				$("#resList").html(responseData);
			},
			error : function(xhrmstatus, error) {
				alert(error);
			}
		});
	}

	function f2() {
		$.ajax({
			type : "post",
			url : "wkrcon.do",
			data : {
				"work" : $("#work").val()
			},
			success : function(responseData) {
				$("#resList").html(responseData);
			},
			error : function(xhrmstatus, error) {
				alert(error);
			}
		})
	}
</script>

<style>
body {
	background: url('../static/images/apartment.jpg') left top no-repeat
		fixed;
	background-size: cover;
}

#container {
	background-color: white;
	margin: 0 auto;
	padding: 30px;
	width: 1400px;
	height: 700px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border-radius: 30px;
	text-align: center;
}

#resList {
	width: 100%;
	margin: 0 auto;
	border-collapse: collapse;
	justify-center: center;
	align-items: flex-start;
}

#restable {
	width: 90%;
}

h1 {
	font-size: 50px;
	text-align: center;
	margin: 20px;
}

select {
	width: 200px;
	height: 40px;
	font-size: 20px;
	border-radius: 10px;
}

option {
	font-size: 20px;
	border-radius: 20px;
}

#btn1, #btn2, #btn3 {
	width: 200px;
	height: 40px;
	font-size: 20px;
	border-radius: 10px;
}

#btn1, #btn2 {
	margin-bottom: 10px;
}

#btn3 {
	margin-top: 30px;
}

#updatebtn, #deletebtn {
	margin-right: 2px;
}

td {
	border-bottom: 1px solid black; /* 왼쪽 세로줄만 그리기 */
	padding: 8px;
	text-align: center;
	background-color: white;
	font-size: 20px;
}

td:last-child, td:nth-last-child(2) {
	border-left: none; /* 첫 번째 열에는 세로줄 제거 */
	background-color: transparent;
}

th {
	background-color: #78d6b1;
	color: #ffffff;
	font-size: 20px;
	position: sticky; /* 고정 헤더를 만듭니다. */
	top: 0; /* 고정 헤더를 상단에 고정시킵니다. */
	z-index: 1; /* 다른 요소 위로 헤더를 배치합니다. */
}

th, tr {
	padding: 10px;
}

#navbar {
	font-size: 30px;
	color: white;
}

.btn-primary {
	height: 50px;
	font-size: 25px;
}

#topbar {
	height: 80px;
}

.table-wrapper {
	overflow-y: auto;
	height: 300px; /* 테이블이 화면에 가득 차도록 최대 높이 설정 */
	display: flex;
	justify-content: center;
	align-items: center;
}

.addResbtn {
	text-align: right;
}

.changeListBar {
	display: flex;
	justify-content: space-between;
}

.allSearch {
	text-align: left;
	margin-left: 55px;
}

.selectsearch {
	text-align: left;
}
</style>
</head>
<body>
	<div id="topbar" class="navbar navbar-extends-lg fixed-top bg-primary"
		data-bs-theme="dark">
		<div class="container">
			<a href="../MainPage.html" class="navbar=brand" id="navbar">OOO
				아파트 관리시스템</a>
			<button type="button" class="btn btn-primary"
				onclick="window.location.href='../resident/respage.do'">Resident</button>
			<button type="button" class="btn btn-primary"
				onclick="window.location.href='../facility/facpage.do'">Facility</button>
			<button type="button" class="btn btn-primary"
				onclick="window.location.href='wkrpage.do'">Worker</button>
			<button type="button" class="btn btn-primary"
				onclick="window.location.href='../store/strpage.do'">Store</button>
		</div>
	</div>
	<div id="container">
		<div class="page-header">
			<h1>근무자</h1>
		</div>

		<div class="changeListBar">
			<div class="allSearch">
				<button id="btn1" type="button" class="btn btn-primary">전체
					근무자 목록</button>
			</div>
			<div class="selectsearch">
				<select id="work">
					<c:forEach var="wkr" items="${workList}">
						<option value="${wkr}">${wkr}</option>
					</c:forEach>
				</select>
				<button id="btn2" type="button" class="btn btn-info">업무별
					근무자 목록</button>
			</div>
		</div>

		<div id="resList" class="table-wrapper">
			<table id="restable">
				<thead>
					<tr>
						<th>근무자ID</th>
						<th>근무자명</th>
						<th>나이</th>
						<th>성별</th>
						<th>H.P</th>
						<th>입사일</th>
						<th>근무지ID</th>
						<th>업무</th>
						<th>급여</th>
						<th></th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="wkr" items="${wkrList}">
						<tr>
							<td>${wkr.WORKER_ID}</td>
							<td>${wkr.WORKER_NAME}</td>
							<td>${wkr.WORKER_AGE}</td>
							<td>${wkr.WORKER_GENDER}</td>
							<td>${wkr.WORKER_PHONE}</td>
							<td>${wkr.WORKER_HIREDATE}</td>
							<td>${wkr.WORKER_WORKPLACE_ID}</td>
							<td>${wkr.WORKER_WORK}</td>
							<td>${wkr.WORKER_SALARY}</td>
							<td><button id="updatebtn" class="btn btn-info"
									onclick="location.href='wkrUpdate.do?wkrid=${wkr.WORKER_ID}'">수정</button>
							<td><button id="deletebtn" class="btn btn-danger"
									onclick="location.href='wkrDelete.do?wkrid=${wkr.WORKER_ID}'">삭제</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="addResbtn">
			<button id="btn3" type="button" class="btn btn-success"
				onclick="location.href='wkrInsert.do'">근무자 등록</button>
		</div>
	</div>
</body>
</html>