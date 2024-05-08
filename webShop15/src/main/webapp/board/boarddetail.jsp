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
<a>${loginEmp.first_name }</a>
	<c:set var="loginUser" value="${loginEmp.first_name}" />
	<form
		action="${pageContext.request.servletContext.contextPath}/board/boardDetail.do"
		method="post"}>
		bno:<input type="number" name="bno" value="${board.bno}" readonly="readonly"><br>
		title:<input type="text" name="title" value="${board.title}"><br>
		content:<input type="text" name="content" value="${board.content}"><br>
		writer:<input type="text" name="writer" value="${board.writer}"
			readonly="readonly"><br> pic:<input type="text"
			name="pic" value="${board.pic}"><br> 작성일:<input
			type="date" name="pic" value="${board.create_date}"><br>

		<c:if test="${loginUser==board.writer }">
			<input type="submit" value="수정하기">
	</c:if>
		<c:if test="${loginUser!=board.writer }">
			<input type="submit" value="수정불가" disabled="disabled">
	</c:if>



	</form>
</body>
</html>