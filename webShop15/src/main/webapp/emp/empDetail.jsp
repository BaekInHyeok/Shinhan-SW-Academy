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
	<h1>직원상세보기</h1>
	<form action="empDetail.do" method="post">
		<div class="mb-3 mt-3">
			<label for="employee_id">직원번호:</label> <input type="number"
				class="form-control" id="employee_id"
				placeholder="Enter Employee ID" name="employee_id"
				value="${empInfo.employee_id }">
		</div>
		<div class="mb-3 mt-3">
			<label for="first_name">이름:</label> <input type="text"
				class="form-control" id="first_name" placeholder="Enter first_name"
				name="first_name" value="${empInfo.first_name}">
		</div>
		<div class="mb-3 mt-3">
			<label for="last_name">성:</label> <input type="text"
				class="form-control" id="last_name" placeholder="Enter last_name"
				value="${empInfo.last_name}">
		</div>
		<div class="mb-3 mt-3">
			<label for="email">이메일:</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				value="${empInfo.email}">
		</div>
		<div class="mb-3 mt-3">
			<label for="phone_number">전화번호:</label> <input type="text"
				class="form-control" id="phone_number"
				placeholder="Enter phone_number" name="phone_number" value="${empInfo.phone_number}">
		</div>
		<div class="mb-3 mt-3">
			<label for="hire_date">입사일:</label> <input type="date"
				class="form-control" id="hire_date" placeholder="Enter hire_date"
				name="hire_date" value="${empInfo.hire_date}">
		</div>
		<%--Scriptlet 문법보다는 EL, JSTL 문법을 사용하는 것이 좋다. --%>
		<div class="mb-3 mt-3">
			<label for="job_id">업무ID:</label> <select name="job_id">
				<%-- <%
					List<HashMap<String, Object>> jlist = (List<HashMap<String, Object>>) request.getAttribute("jlist");
					for (HashMap<String, Object> map : jlist) {
					%>
					<option value="<%=map.get("job_id")%>"><%=map.get("job_title")%></option>
					<%
					}
					%> --%>
				<c:forEach items="${jlist}" var="job">
					<option value="${job.job_id}" ${empInfo.job_id==job.job_id?"selected":""}>${job.job_title}</option>

				</c:forEach>

			</select>
		</div>
		<div class="mb-3 mt-3">
			<label for="salary">급여:</label> <input type="number"
				class="form-control" id="salary" placeholder="Enter salary"
				name="salary" value="${empInfo.salary}">
		</div>
		<div class="mb-3 mt-3">
			<label for="commission_pct">커미션:</label> <input type="text"
				class="form-control" id="commission_pct"
				placeholder="Enter commission_pct" name="commission_pct" value="${empInfo.commission_pct}">
		</div>
		<div class="mb-3 mt-3">
			<label for="manager_id">매니저ID:</label> <select name="manager_id">
				<%-- <%
					List<HashMap<String, Object>> mlist = (List<HashMap<String, Object>>) request.getAttribute("mlist");
					for (HashMap<String, Object> map : mlist) {
					%>
					<option value="<%=map.get("employee_id")%>"><%=map.get("fullname")%></option>
					<%
					}
					%> --%>

				<c:forEach items="${mlist }" var="manager">
					<option value="${manager.employee_id}" ${manager.employee_id==empInfo.manager_id?"selected":"" }>${manager.fullname}</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3 mt-3">
			<label for="department_id">부서ID:</label> <select name="department_id">
				<%-- <%
					List<DepDTO> dlist = (List<DepDTO>) request.getAttribute("deptlist");
					for (DepDTO dept : dlist) {
					%>
					<option value="<%=dept.getDEPARTMENT_ID()%>"><%=dept.getDEPARTMENT_NAME()%></option>
					<%
					}
					%> --%>
				<c:forEach items="${dlist }" var="dep">
					<option value="${dep.DEPARTMENT_ID}" ${dep.DEPARTMENT_ID==empInfo.department_id?"selected":""}>${dep.DEPARTMENT_NAME}</option>
				</c:forEach>

			</select>
		</div>

		<input type="submit" class="btn btn-primary" value="수정하기"></button>
	</form>
</body>
</html>