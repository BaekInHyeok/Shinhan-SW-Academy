<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid=request.getParameter("userid");
	String upw=request.getParameter("userpw");
	String remember=request.getParameter("remember");



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전송받은 값</h1>

<p>아이디는<%=uid %>
<p>PW는<%=upw %>
<p>remember:<%=remember %>
</body>
</html>