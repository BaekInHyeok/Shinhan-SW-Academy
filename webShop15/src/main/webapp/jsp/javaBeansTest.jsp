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
<%
DepDTO dep = new DepDTO();
dep.setDEPARTMENT_ID(100);
dep.setDEPARTMENT_NAME("개발부");
dep.setLOCATION_ID(1700);
dep.setMANAGER_ID(10);
%>

<h1>JAVA Beans 이용하기(setting)</h1>

<%--이름을 소문자까지 다 맞추면 이렇게도 쓸 수 있다 --%>
<jsp:setProperty property="*" name="dep2"/>


<%-- <jsp:useBean id="dep2" class="com.shinhan.dept.DepDTO" scope="request"></jsp:useBean>
<jsp:setProperty property="DEPARTMENT_ID" name="dep2" param="department_id"/>
<jsp:setProperty property="DEPARTMENT_NAME" name="dep2" param="department_name"/>
<jsp:setProperty property="LOCATION_ID" name="dep2" param="location_id"/>
<jsp:setProperty property="MANAGER_ID" name="dep2" param="manager_id"/> --%>


<jsp:forward page="javaBeansTest2.jsp"></jsp:forward>


</body>
</html>