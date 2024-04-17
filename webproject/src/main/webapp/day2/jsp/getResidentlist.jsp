<%@page import="com.shinhan.javasqlproject.residentSERVICE"%>
<%@page import="com.shinhan.javasqlproject.residentDTO"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주민 목록</title>
</head>
<body>

	<table border="1">
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
		String dong=request.getParameter("dong");
		List<residentDTO> reslist = resService.findBYDONG(Integer.parseInt(dong));
		%>
		
		<%for(residentDTO res : reslist){ %>
		<tr>
		<td><%=res.getResident_name() %></td>
		<td><%=res.getResident_phone() %></td>
		<td><%=res.getResident_ho() %></td>
		<td><%=res.getResident_fee() %></td>
		<%} %>
		
		</tbody>
	</table>

</body>
</html>