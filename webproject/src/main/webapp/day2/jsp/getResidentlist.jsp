<%@page import="com.shinhan.javasqlproject.residentSERVICE"%>
<%@page import="com.shinhan.javasqlproject.residentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주민 목록</title>
</head>
<style>
table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table {
	width: 1000px;
	color: white;
	font-size: 25px;
}

th{
	background-color:black;
}

body {
	background: url('apartment.jpg') left top no-repeat fixed;
	background-size: cover;
}

#container {
	background-color: gray;
	margin: 0 auto;
	padding: 30px;
	width: 1000px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border-radius: 30px;
}

#submit {
	font-size: 40px;
	color: white;
	background-color: black;
	border-radius: 15px;
}

h1 {
	color: white;
	font-size: 50px;
	text-align: center;
}

h3 {
	color: white;
	font-size: 40px;
	text-align: center;
}

select {
	width: 300px;
	height: 60px;
	font-size: 40px;
	border-radius: 20px;
}

option {
	font-size: 40px;
	border-radius: 20px;
}

caption {
	font-size: 30px;
	color: white;
	font-style: italic;
}
</style>
<body>
	<div id="container">
		<h1>아파트 동별 입주민 목록 검색</h1>
		<h3>동 선택</h3>
		<form action="getResidentlist.jsp" method="get">
			<select name="dong">
				<option selected="selected">101</option>
				<option>102</option>
				<option>103</option>
				<option>104</option>
				<option>105</option>
				<option>106</option>
				<option>107</option>
				<option>108</option>
				<option>109</option>
			</select> <input type="submit" id="submit" value="조회하기">
		</form>

		<br>
        <%
        String dong = request.getParameter("dong");
		if(dong!=null){
		
		
        %>
		<table>
			<caption>주민 목록</caption>
			<thead>
				<tr>
					<th>이름</th>
					<th>H.P</th>
					<th>호</th>
					<th>관리비</th>
				</tr>
			</thead>

			<tbody>
				<%
				
				residentSERVICE resService = new residentSERVICE();
			 
				List<residentDTO> reslist = resService.findBYDONG(Integer.parseInt(dong));
				%>

				<%
				for (residentDTO res : reslist) {
				%>
				<tr>
					<td><%=res.getResident_name()%></td>
					<td><%=res.getResident_phone()%></td>
					<td><%=res.getResident_ho()%></td>
					<td><%=res.getResident_fee()%></td>
					<%
					}
					%>
				
			</tbody>
		</table>
		<%} %>
	</div>


</body>
</html>