<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>
<p>${path }</p>
<a href="${path}/emp/empInsert.do">신규 직원 등록</a>
<h1>직원목록</h1>
<table>
		<thead>
			<tr>
				<th>직원번호</th>
				<th>직원명</th>
				<th>직원성</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직책</th>
				<th>급여</th>
				<th>부서</th>
				<th>매니저</th>
				<th>커미션</th>
				<th>입사일</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach var="emp" items="${emplist}">
				<tr>
					<td><a href="${path}/emp/empDetail.do?empid=${emp.employee_id}">
							${emp.employee_id}</a></td>
					<td>${emp.first_name}</td>
					<td>${emp.last_name}</td>
					<td>${emp.email}</td>
					<td>${emp.phone_number}</td>
					<td>${emp.hire_date}</td>
					<td>${emp.job_id}</td>
					<td>
					
					<!--${emp.salary}-->
					<fmt:formatNumber value="${emp.salary}" groupingUsed="true" type="currency" currencySymbol="\\">
					
					</fmt:formatNumber>
					</td>
					<td>${emp.department_id}</td>
					<td>${emp.manager_id}</td>
					<td>${emp.commission_pct}</td>
					<td><fmt:formatDate value="${emp.hire_date}" pattern="YYYY/MM/dd hh:mm:ss"/></td>
					<td><button onclick="location.href='${path}/emp/empDelete.do?empid=${emp.employee_id}'">삭제</button>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>