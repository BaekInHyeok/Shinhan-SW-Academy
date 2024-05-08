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
	<h1>장바구니 결과</h1>
	<table>
		<tr>
			<th>메뉴 이름</th>
			<th>주문 수량</th>
		</tr>
		<c:forEach items="${cart }" var="menu">
			<tr>
				<td>${menu.key}</td>
				<td>${menu.value}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="orderRemove.go">
		<input type="submit" value="장바구니 비우기">
	</form>
	<a href="order.go">계속 주문하기</a>
</body>

</html>