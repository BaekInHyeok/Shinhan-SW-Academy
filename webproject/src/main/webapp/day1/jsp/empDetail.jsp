<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
EmpService eservice = new EmpService();
EmpDTO emp =null;
String empid= request.getParameter("empid");
int i_empid= 0;

if(empid!=null){
	i_empid = Integer.parseInt(empid);
	emp = eservice.selectById(i_empid);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 직원 정보 조회</title>
</head>
<body>
	<h1>사용자 정보 상세보기</h1>
	<p>직원번호:<%=emp.getEmployee_id() %></p>
	<p>직원이름:<%=emp.getFirst_name() %></p>
	<p>직원성:<%=emp.getLast_name() %></p>
	<p>직원H.P:<%=emp.getPhone_number() %></p>
	<p>직원급여:<%=emp.getSalary() %></p>
	<p>직원보너스:<%=emp.getCommission_pct() %></p>
	<p>직원입사일:<%=emp.getHire_date() %></p>
	<p>매니저ID:<%=emp.getManager_id() %></p>
	<p>부서ID:<%=emp.getDepartment_id() %></p>
	<p>업무ID:<%=emp.getJob_id() %></p>
</body>
</html>