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
	<form id="updateForm" action="${path}/dept/deptDBUpdate.do" method="post">
		부서번호:<input type="number" name="department_id" id="department_id"
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
	<hr>
	<button onclick="f_deptUpdate()">Restful API를 이용해서 수정(ajax)</button>
	<button onclick="f_deptDelete(${dept.department_id})">Restful API를 이용해서 삭제(ajax)</button>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		function f_deptUpdate() {
			var arr = $("#updateForm").serializeArray();

			var obj = {};
			$.each(arr, function(index, item) {
				obj[item.name] = item.value;
			});

			console.log(obj);
			//contentType 설정 생략시 : Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
			$.ajax({
				url:"${path}/dept/api/update",
				type:"put",
				data:JSON.stringify(obj),//@RequestBody
				contentType:"application/json;charset=utf-8",
				success:function(responseStr){
					
					alert(responseStr);
				},
				error:function(){}
			});
		}
		
		function f_deptDelete(deptid){
			$.ajax({
				url:"${path}/dept/api/delete/"+deptid,
				type:"delete",
				success:function(responseResult){
					alert(responseResult);
				},
				error:function(){}
			});
		}
	</script>
</body>
</html>