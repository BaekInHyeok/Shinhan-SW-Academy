<%@page import="com.shinhan.dept.DepDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>JAVA Beans 이용하기(getting)</h1>
<jsp:useBean id="dep2" class="com.shinhan.dept.DepDTO" scope="request"></jsp:useBean>
부서번호:<jsp:getProperty property="DEPARTMENT_ID" name="dep2"/>
부서이름:<jsp:getProperty property="DEPARTMENT_NAME" name="dep2"/>
지역번호:<jsp:getProperty property="LOCATION_ID" name="dep2"/>
매니저:<jsp:getProperty property="MANAGER_ID" name="dep2"/>


</body>
</html>