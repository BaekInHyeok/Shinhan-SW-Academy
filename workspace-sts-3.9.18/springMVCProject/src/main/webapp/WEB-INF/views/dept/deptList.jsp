<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%@ include file="../common/header.jsp"%>
	${path}
	<a href="${path}/dept/deptInsert.do">신규 부서 등록</a>
	<h1>부서목록</h1>
	<p>${deptResult}</p>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>매니저ID</th>
				<th>지역코드</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${deptlist}">
				<tr>
					<td><a
						href="${path}/dept/deptUpdate.do?deptid=${dept.department_id}">${dept.department_id}</a></td>
					<td>${dept.department_name}</td>
					<td>${dept.manager_id}</td>
					<td>${dept.location_id}</td>
					<td><button
							onclick="location.href='${path}/dept/deptDelete.do?deptid=${dept.department_id}'">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<script>
	setTimeout(() => {
		var message = "${deptResult}";
		if (message != "") {
			alert(message);
		}
	}, 100);
		
	</script>
</body>
</html>