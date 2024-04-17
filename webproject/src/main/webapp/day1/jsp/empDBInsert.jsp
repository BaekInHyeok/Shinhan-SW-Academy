<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="java.sql.Date"%>
<%@page import="com.shinhan.util.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");//post 방식일 때에는 필수

int empid = Integer.parseInt(request.getParameter("employee_id"));
String fname = request.getParameter("first_name");
String lname = request.getParameter("last_name");
String email = request.getParameter("email");
String phone = request.getParameter("phone_number");
Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
String job = request.getParameter("job_id");
int salary = Integer.parseInt(request.getParameter("salary"));
double com = Double.parseDouble(request.getParameter("commission_pct"));
int mid = Integer.parseInt(request.getParameter("manager_id"));
int did = Integer.parseInt(request.getParameter("department_id"));

EmpService eservice = new EmpService();
EmpDTO emp = new EmpDTO();

emp.setCommission_pct(com);
emp.setDepartment_id(did);
emp.setEmail(email);
emp.setEmployee_id(empid);
emp.setHire_date(hdate);
emp.setFirst_name(fname);
emp.setJob_id(job);
emp.setLast_name(lname);
emp.setManager_id(mid);
emp.setPhone_number(phone);
emp.setSalary(salary);

System.out.println(emp);
eservice.empInsert(emp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DB에 입력하기.....</h1>
</body>
</html>