<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 목록</title>
</head>
<style>
body {
	background-image: url('../../09/images/bg1.jpg');
}

#container {
	width: 1200px;
	margin: 0 auto
}

table, th, td {
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: justify;
}

thead {
	background-color: black;
	color: white;
}
/* 칸을 띄우면 자손을 뜻함 */
tbody tr:nth-child(2n) {
	background-color: lightgray;
	color: black;
}

tbody tr:nth-child(2n+1) {
	background-color: gray;
	color: white;
}

td[data-lname] {
	font-size: 20px;
}

td[data-lname^='A'] {
	color: red;
}

td[data-job~='IT_PROG'] {
	color: purple;
}

td[data-hdate |='2005'] {
	font-style: italic;
	color:green;
}

td[data-hdate $='07'] {
	font-style: italic;
	color:red;
}

td[data-phone *='123'] {
	font-style: italic;
	color:red;
}



h1 {
	height: 100px;
	border: 1px solid gray;
	text-align: center;
	line-height: 100px;
	background-color: beige;
	color: orange;
}

a.decoNone {
	text-decoration: none;
	background-color: black;
	color: white;
	padding: 10px;
	border-radius: 10px;
}

caption {
	font-size: 30px;
}
</style>
<body>
	<div id="container">
		<h1>전체 직원 정보</h1>
		<a class="decoNone" href="empInsert.jsp">신규 직원 등록</a>
		<table border="1">
			<caption>직원목록</caption>
			<thead>
				<tr>
					<th>직원ID</th>
					<th>이름</th>
					<th>성</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>커미션</th>
					<th>급여</th>
					<th>입사일</th>
					<th>직책</th>
				</tr>
			</thead>

			<tbody>
				<%
				EmpService eservice = new EmpService();
				List<EmpDTO> emplist = eservice.selectAll();
				%>
				<%
				for (EmpDTO emp : emplist) {
				%>
				<tr>
					<td><a href="empDetail.jsp?empid=<%=emp.getEmployee_id()%>">
							<%=emp.getEmployee_id()%></td>
					<td><a href="empDetail.jsp?empid=<%=emp.getEmployee_id()%>">
							<%=emp.getFirst_name()%></td>
					<td data-lname="<%=emp.getLast_name()%>"><%=emp.getLast_name()%></td>
					<td><%=emp.getEmail()%></td>
					<td data-phone="<%=emp.getPhone_number() %>"><%=emp.getPhone_number() %>
					<td><%=emp.getCommission_pct()%></td>
					<td><%=emp.getSalary()%></td>
					<td data-hdate="<%=emp.getHire_date()%>"><%=emp.getHire_date()%></td>
					<td data-job="<%=emp.getJob_id()%>"><%=emp.getJob_id()%></td>
				</tr>
				<%
				}
				%>
			</tbody>

		</table>
	</div>
</body>
</html>