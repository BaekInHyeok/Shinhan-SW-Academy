<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>확인</h1>
<p><%=request.getParameter("input1") %></p>
<p><%=request.getParameter("input2") %></p>
<p><%=request.getParameter("input3") %></p>
<p><%=request.getParameter("input4") %></p>
<p><%=request.getParameter("input5") %></p>
<p><%=request.getParameter("input6") %></p>
<p><%=request.getParameter("input7") %></p>
<p>8.성별:<%=request.getParameter("gender") %></p>
<p>8.전공:<%=request.getParameter("major") %></p>
<p>9.학습과목</p>
<ul>
<%
String[] arr=request.getParameterValues("subject");

for(int i=0;arr!=null && i<arr.length;i++){	
	out.print("<li>"+arr[i]+"</li>");
	//out는 HTML 문서의 Body를 의미하는 JSP가 내장하는 객체
	//System.out는 모니터(수행되는 곳의 console)를 의미
	System.out.println(i+">>"+arr[i]);
}
%>
</ul>
<p>10.number:<%=request.getParameter("input8") %></p>
<p>11.range:<%=request.getParameter("input9") %></p>
<p>12.date:<%=request.getParameter("input10") %></p>
<p>12.week:<%=request.getParameter("input11") %></p>
<p>12.month:<%=request.getParameter("input12") %></p>
<p>16.hidden:<%=request.getParameter("input16") %></p>
<p>17.textarea:<%=request.getParameter("memo") %></p>
<p>18.select:<%=request.getParameter("week1") %></p>
<p>18.select:<%=request.getParameter("week3") %></p>
<%
String[] arr2 = request.getParameterValues("week2");

for(int i=0; arr2!=null && i<arr2.length;i++){
	out.print("<li>"+arr2[i]+"</li>");
}

%>

</body>
</html>