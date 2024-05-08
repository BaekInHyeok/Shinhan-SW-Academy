<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="${pageContext.request.servletContext.contextPath}/static/js/jquery-3.7.1.min.js"></script>
<script>
	function call(deptid){
		$.ajax({
			url:"../emp/empList.do",
			type:"post",
			data:{"deptid":deptid},
			success:function(responseData){
				$("#empList").html(responseData);
			}
			
		});
	}

</script>
</head>
<body>
	<h1>부서목록</h1>
	<table>
		<thead>
			<tr>
				<th>부서ID</th>
				<th>부서명</th>
				<th>매니저ID</th>
				<th>위치지역ID</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="dept" items="${AllDeptInfo}">
				<tr>
					<td><a href="javascript:call(${dept.DEPARTMENT_ID})">
							${dept.DEPARTMENT_ID}</a></td>
					<td>${dept.DEPARTMENT_NAME}</td>
					<td>${dept.MANAGER_ID}</td>
					<td>${dept.LOCATION_ID}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div id="empList">이 곳에 해당 부서의 직원 목록 출력</div>
	
	

</body>
</html>