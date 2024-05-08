<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DepService"%>
<%@page import="com.shinhan.dept.DepDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 연습</h1>
	<%
	request.setAttribute("score", 100);
	int score2 = 300;
	request.setAttribute("greeting", "hello");
	request.setAttribute("dept", new DepDTO(10, "개발부", 100, 1700));
	pageContext.setAttribute("data1", 10);
	request.setAttribute("data2", 20);
	session.setAttribute("data3", 30);
	application.setAttribute("data4", 40);
	String p1 = request.getParameter("a");
	String p2 = request.getParameter("b");

	DepService service = new DepService();
	List<DepDTO> deptlist = service.selectAll();
	request.setAttribute("deptlist", deptlist);
	
	HashMap<String,Integer> cart = new HashMap<>();
	cart.put("아메리카노",10);
	cart.put("latte",30);
	cart.put("모카골드",20);
	request.setAttribute("cart", cart);
	
	HashMap<String,List<DepDTO>> cart2 = new HashMap<>();
	cart2.put("부서",deptlist);
	request.setAttribute("cart2", cart2);
	
	
	%>
	<pre>
1.boolean: ${10>20}
2.string : ${"hello"}${String.valueOf(100)}
3.null:${null+100 }
4.score:${score+200}
5.score2:<%=score2%>
6.나누기:${10/3}
6.나누기:${10 div 3}
6.나누기:${10 % 3}
6.나누기:${10 mod 3}
7.비교:${"hello"==greeting}....${greeting}
7.비교:${"hello" eq greeting}
8.논리:${score>=100 && greeting=="hello"}
9.dept : ${dept}
9.dept : ${dept.DEPARTMENT_NAME}
9.dept : ${empty dept }
9.dept : ${not empty dept }
11.scope:${data1}
12.scope:${pageScope.data1}
13.scope:${requestScope.data2}
14.scope:${sessionScope.data3}
15.scope:${applicationScope.data4}
16.param : ${param.a }
16.param : ${param.b }
17.Collection 읽기 : ${deptlist[0]}
17.Collection 읽기 : ${deptlist[1]}
18.map 읽기:${cart["아메리카노"]}
18.map 읽기:${cart.latte}
</pre>
<ul>
<c:forEach items="${deptlist}">
	<li>${dept.DEPARTMENT_NAME}</li>
</c:forEach>
</ul>

</body>
</html>