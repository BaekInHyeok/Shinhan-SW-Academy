<%@page import="java.util.HashMap"%>
<%@page import="org.firstzone.myapp.dept.DepDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>신규직원등록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../static/js/jquery-3.7.1.min.js"></script>
<script>
	$(function() {
		$("form").on("submit", call);
		$("#btnDupCheck").on("click", f_dupCheck);
	});
	function f_dupCheck() {
		var empid = $("#employee_id").val();
		if (empid == "") {
			alert("직원번호를 입력하세요");
			document.querySelector("#employee_id").focus();
			return;
		}
		$.ajax({
			url : "${path}/emp/empIdCheck.do",
			data : {
				"empid" : empid
			},
			type : "get",
			success : function(responseData) {
				var message = "";
				if (responseData == "0") {
					message = "사용가능";
				} else {
					message = "사용불가능";
					$("#employee_id").val("");
					document.querySelector("#employee_id").focus();
				}
				$("#resultMessage").val(message);
			},
			error : function(data) {
				alert(data);
			}
		});
	}

	function call(event) {
		var salary = $("#salary").val();
		if (salary == "" || salary <= 0) {
			alert("salary값은 0보다 큰 값이어야한다. ");
			event.preventDefault(); //default이벤트 취소 (서버전송 취소)
			document.querySelector("#salary").focus();
		}
	}
</script>
</head>
<body>
	<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>

	<div class="container mt-3">
		${path} <a href="empList.do">직원리스트</a>
		<h2>신규 직원 등록</h2>
		<form action="${path}/emp/empInsert.do" method="post">
			<div class="mb-3 mt-3">
				<label for="employee_id">직원번호:</label> <input type="number"
					class="form-control" id="employee_id"
					placeholder="Enter Employee ID" name="employee_id"
					required="required"> <input type="button" value="중복체크"
					id="btnDupChk"> <input type="text" placeholder="ID입력후 중복체크"
					id="resultMessage">
			</div>
			<div class="mb-3 mt-3">
				<label for="first_name">이름:</label> <input type="text"
					class="form-control" id="first_name" placeholder="Enter first_name"
					name="first_name">
			</div>
			<div class="mb-3 mt-3">
				<label for="last_name">성:</label> <input type="text"
					class="form-control" id="last_name" placeholder="Enter last_name"
					name="last_name" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="email">이메일:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="phone_number">전화번호:</label> <input type="text"
					class="form-control" id="phone_number"
					placeholder="Enter phone_number" name="phone_number">
			</div>
			<div class="mb-3 mt-3">
				<label for="hire_date">입사일:</label> <input type="date"
					class="form-control" id="hire_date" placeholder="Enter hire_date"
					name="hire_date" required>
			</div>
			<%--Scriptlet 문법보다는 EL, JSTL 문법을 사용하는 것이 좋다. --%>
			<div class="mb-3 mt-3">
				<label for="job_id">업무ID:</label> <select name="job_id">
					<c:forEach items="${jlist}" var="job">
						<option value="${job.job_id}">${job.job_title}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="salary">급여:</label> <input type="number"
					class="form-control" id="salary" placeholder="Enter salary"
					name="salary">
			</div>
			<div class="mb-3 mt-3">
				<label for="commission_pct">커미션:</label> <input type="text"
					class="form-control" id="commission_pct"
					placeholder="Enter commission_pct" name="commission_pct">
			</div>
			<div class="mb-3 mt-3">
				<label for="manager_id">매니저ID:</label> <select name="manager_id">

					<c:forEach items="${mlist}" var="manager">
						<option value="${manager.employee_id}">${manager.fullname}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="department_id">부서ID:</label> <select
					name="department_id">
					<c:forEach items="${deptlist}" var="dep">
						<option value="${dep.department_id}">${dep.department_name}</option>
					</c:forEach>

				</select>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>
