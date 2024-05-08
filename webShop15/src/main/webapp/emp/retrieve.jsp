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
	$(function() {
		$("#btn1").on("click", f1);
	});

	function f1() {
		var job_id = $("#job_id").val();
		var dept_id = $("#dept_id").val();
		var salary = $("#salary").val();
		var hiredate = $("#hiredate").val();
		
		
		$.ajax({
			type:"post",
			url:"retrieve.do",
			data:{"jobid":job_id,"deptid":dept_id,"salary":salary,"hiredate":hiredate},
			success:function(responseData){
				$("#here").html(responseData);
			},
			error:function(xhr,status,error){
				alert(error);
			}
		});
	}
	
	function call(empid){
		$.ajax({
			url:"empDetail.do",
			type:"get",
			data:{"empid":empid},
			success:function(responseData){
				$("#here2").html(responseData);
			}
		});
	}
</script>

</head>
<body>
	<h1>조건 조회</h1>
	직책선택:
	<select id="job_id">
		<c:forEach var="job" items="${AllJobInfo}">
			<option value="${job.JOB_ID}" ${job.JOB_ID=='IT_PROG'?"selected":"" }>${job.JOB_ID}/${job.JOB_TITLE}</option>
		</c:forEach>
	</select> 부서선택
	<select id="dept_id">
		<c:forEach var="dept" items="${AllDeptInfo}">
			<option value="${dept.DEPARTMENT_ID}"
				${dept.DEPARTMENT_ID==60?"selected":"" }>${dept.DEPARTMENT_ID}/${dept.DEPARTMENT_NAME}</option>
		</c:forEach>
	</select> 급여(이상):
	<input type="number" id="salary" value="10000"> 입사일 :
	<input type="date" id="hiredate" value="2005-01-01">
	<button id="btn1">조건 조회</button>
	<div id="here">여기</div>
	<div id="here2">여기</div>
	
</body>
</html>