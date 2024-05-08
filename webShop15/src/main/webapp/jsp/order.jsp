<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/loginHeader.jsp" %>
<h1>주문선택</h1>
<form action="order.go" method="post">
	메뉴 : <input type="radio" name="lunch" value="김밥">김밥
	<input type="radio" name="lunch" value="라면">라면
	<input type="radio" name="lunch" value="자장면">자장면
	<input type="radio" name="lunch" value="초밥">초밥
	<input type="radio" name="lunch" value="햄버거">햄버거
	<input type="radio" name="lunch" value="국밥">국밥
	<input type="radio" name="lunch" value="열무국수">열무국수
	<input type="number" value="1" name="count">
	<input type="submit" value="주문">
</form>
</body>
</html>