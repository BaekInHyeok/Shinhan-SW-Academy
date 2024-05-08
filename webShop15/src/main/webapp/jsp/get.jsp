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
	<h1>get.jsp</h1>
	<h2>request : ${myinfo}</h2>
	<h2>session : ${myinfo2}</h2>
	<h2>context : ${myinfo3}</h2>
	<h2>initParameter : ${initParam['menu_member']}</h2>
	<h2>initParameter : ${initParam['menu_order']}</h2>
	<h2>은행이름:${initParam['bankname']}</h2>

	<c:forTokens var="member" items="${initParam['menu_member']}"
		delims=" ">
		<li>${member}
		</c:forTokens>
	<c:forTokens var="member" items="${initParam['menu_order']}"
		delims=" ">
		<li>${member}
		</c:forTokens>
</body>
</html>