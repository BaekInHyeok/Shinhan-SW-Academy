<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="${path}/board/boardInsert.do" method="post"
	enctype="multipart/form-data">

		title:<input type="text" name="title" value="title"><br>
		content:<input type="text" name="content" value="content"><br>
		pic:<input type="file" name="pic"><br>
		<input type="submit" value="입력">
	</form>
</body>
</html>