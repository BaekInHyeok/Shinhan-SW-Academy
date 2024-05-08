<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- JSTL 문법(Tag Library) : ex)<c:forEach....--%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	// JavaScript의 빽틱문법 : JSP 문법과 혼란... JSP에서 백틱은 \$를 사용한다.
	var myname = "jj"
	var bb = `나의 이름은 \${myname}`;
	//jquery
	$(function() {
		$("tr th").css("backgroundColor", "orange");
	});
	//jsp의 EL(Expression Language)문법
	var aa = "${emplist}";

	function f_insert() {
		location.href = 'empInsert.do';
	}
</script>
</head>
<body>
	<h1>${loginEmp.first_name}님환영합니다.</h1>
	<a href="../auth/logout.do">로그아웃</a>
	
	<%--include 지시자 : JSP를 합쳐서 컴파일 --%>
	<%--include 액션태그 : 각자 컴파일해서 합친다 --%>
	<%@ include file="../common/loginHeader.jsp" %>
	<%--<jsp:include page="../common/loginHeader.jsp"></jsp:include>--%>
	<h2>현재 접속한 사용자  : ${loginUser.user_id }</h2>
	<h2>현재 접속자 수  : ${loginUser.total_user}</h2>
		
	
	<hr>
	<h1>세션에서 읽기 : ${memberid }</h1>
	<h1>세션에서 읽기 : ${memberpw }</h1>
	<h1>myinfo(다른 서블릿의 request에는 접근 불가):${myinfo}</h1>
	<h1>myinfo2(같은 브라우저 내 접근 가능):${myinfo2}</h1>
	<h1>myinfo3(모든 서블릿에서 접근 가능, 모든 사용자가 공유):${myinfo3}</h1>
	<p>다음은 주소창에 주소를 바꾸는 방법(재요청)</p>
	<a href="empInsert.do">신규직원 등록1</a>
	<a href="javascript:location.href='empInsert.do'">신규직원 등록2</a>
	<button onclick="location.href='empInsert.do'">신규직원등록3</button>
	<button onclick="f_insert()">신규직원등록4</button>
	<form action="empInsert.do">
		<input type="submit" value="신규직원등록5">
	</form>
	<hr>
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
					<td><a href="empDetail.do?empid=${emp.employee_id}">
							${emp.employee_id}</a></td>
					<td>${emp.first_name}--(${fn:length(emp.first_name)})</td>
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
					<td><button
							onclick="location.href='empdelete.do?empid=${emp.employee_id}'">삭제</button>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>