<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forward1</h1>
<%-- forward1.jsp 요청 시 forward2.jsp로 위임한다. --%>
<jsp:forward page="forward2.jsp"></jsp:forward>

<%-- foward2가 현재 페이지에 포함됨--%>
<jsp:include page="forward2.jsp"></jsp:include>
<jsp:include page="forward2.jsp"></jsp:include>
</body>
</html>