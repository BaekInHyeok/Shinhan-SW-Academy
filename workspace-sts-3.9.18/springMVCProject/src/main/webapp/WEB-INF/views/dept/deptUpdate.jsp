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
	<h1>부서 상세보기</h1>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<form action="${path}/dept/deptDetail.do" method="post">
		부서번호:<input type="number" name="department_id" value="${dept.department_id}" readonly="readonly">
		부서이름:<input type="text" name="department_name" value="${dept.department_name}" readonly="readonly">
		매니저ID:<input type="number" name="manager_id" value="${dept.manager_id}" readonly="readonly">
		지역코드:<input type="number" name="location_id" value="${dept.location_id}" readonly="readonly">
		<input type="submit" value="수정하러가기">
	</form>
</body>
</html>