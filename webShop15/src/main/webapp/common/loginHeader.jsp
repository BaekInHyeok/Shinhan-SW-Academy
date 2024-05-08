<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>${loginEmp.first_name}님환영합니다.</h1>
<a href="${pageContext.request.servletContext.contextPath}/auth/logout.do">로그아웃</a>
<hr>
<%
//자바코드...service method 안으로 들어간다
%>
<%!
//선언문(멤버변수, 멤버메서드)
String subject = "자바";
void call(){
	
}
%>
<%=subject %>
<%-- 주석 --%>