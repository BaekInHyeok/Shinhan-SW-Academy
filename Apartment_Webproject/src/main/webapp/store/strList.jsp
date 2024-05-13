<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../static/css/bootstrap.css">
<link rel="stylesheet" href="../static/css/bootstrap-icons.min.css">
<link rel="stylesheet" href="../static/css/prism-okaidia.css">
<link rel="stylesheet" href="../static/css/custom.min.css">

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
	width: 100%;
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

#btn1, #btn2, #btn3, #btn4 {
	width: 200px;
	height: 40px;
	font-size: 20px;
	border-radius: 10px;
}

#btn1, #btn2 {
	margin-bottom: 10px;
}

#btn3, #btn4 {
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
	<div id="resList" class="table-wrapper">
		<table id="restable">
			<thead>
				<tr>
					<th>상점ID</th>
					<th>사업자등록번호</th>
					<th>상점명</th>
					<th>사업자명</th>
					<th>H.P</th>
					<th>업종</th>
					<th>개점일</th>
					<th>영업시작시각</th>
					<th>영업종료시각</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="str" items="${strList}">
					<tr>
						<td>${str.STORE_ID}</td>
						<td>${str.STORE_BUSSINESS_NUMBER}</td>
						<td>${str.STORE_NAME}</td>
						<td>${str.STORE_OWNER}</td>
						<td>${str.STORE_PHONE}</td>
						<td>${str.STORE_TYPE}</td>
						<td>${str.STORE_STARTDATE}</td>
						<td>${str.STORE_START_TIME}</td>
						<td>${str.STORE_END_TIME}</td>
						<td><button id="updatebtn" class="btn btn-info"
								onclick="location.href='strUpdate.do?strid=${str.STORE_ID}'">수정</button>
						<td><button id="deletebtn" class="btn btn-danger"
								onclick="location.href='strDelete.do?strid=${str.STORE_ID}'">삭제</button>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>