<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
#resList {
	width: 100%;
	margin: 0 auto;
	border: 1px solid black;
	padding: 20px;
	margin: 0 auto;
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

td:last-child, td:nth-last-child(2) {
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
</body>
</html>