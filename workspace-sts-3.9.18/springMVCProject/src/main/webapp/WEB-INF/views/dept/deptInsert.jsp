<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img alt="" src="${path}/resources/image/apartment.jpg" width=100 height=100>
	<h1>부서등록</h1>
	
	<form action="${path}/dept/deptInsert.do" method="post">
		부서번호(가짜):<input type="number" name="deptid2" value="300">
		부서번호:<input type="number" name="department_id" value="300">
		부서이름:<input type="text" name="department_name" value="aa">
		부서매니저:
		<select name="manager_id">
			<c:forEach var="manager" items="${mlist}">
			<option value="${manager.employee_id}">${manager.fullname}</option>
			</c:forEach>
		</select>
		부서번호:<input type="number" name="location_id" value="1700">
			
		<input type="submit" value="부서저장">
	</form>

</body>
</html>