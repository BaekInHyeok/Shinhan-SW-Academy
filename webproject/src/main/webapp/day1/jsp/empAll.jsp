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
#container {
	width: 515px;
	border:1px solid gray;
	margin:0 auto
	
}
table, th, td{
	border-collapse: collapse;
}
th, td{
	padding:10px;
	text-align: justify;
}
thead{
	background-color: lightgreen;
	color:gray;
}
/* 칸을 띄우면 자손을 뜻함 */
tbody tr:nth-child(2n){
	background-color:lightgray;
	color:white;
}
tbody tr:nth-child(2n+1){
	background-color:gray;
	color:white;
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
					<th>커미션</th>
					<th>급여</th>
					<th>입사일</th>
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
					<td><%=emp.getLast_name()%></td>
					<td><%=emp.getEmail()%></td>
					<td><%=emp.getCommission_pct()%></td>
					<td><%=emp.getSalary()%></td>
					<td><%=emp.getHire_date()%></td>
				</tr>
				<%
				}
				%>
			</tbody>

		</table>
	</div>
</body>
</html>