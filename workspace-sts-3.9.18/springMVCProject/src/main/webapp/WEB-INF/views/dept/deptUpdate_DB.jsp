<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
input[readonly] {
	background-color: lightgray;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서정보 수정</h1>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<form action="${path}/dept/deptDBUpdate.do" method="post">
		부서번호:<input type="number" name="department_id"
			value="${dept.department_id}" readonly="readonly"> 부서이름:<input
			type="text" name="department_name" value="${dept.department_name}">
		매니저ID:
		<input type="number" name="manager_id" value="${dept.manager_id}"/>
>		<select name="manager_id">
			<c:forEach var="manager" items="${mlist}">
			<option value="${manager.employee_id}" ${dept.manager_id==manager.employee_id?"selected":""}>${manager.fullname}/${manager.employee_id}</option>
			</c:forEach>
		</select>
		지역코드:<input type="number"
			name="location_id" value="${dept.location_id}"> <input
			type="submit" value="DB저장">
	</form>
</body>
</html>