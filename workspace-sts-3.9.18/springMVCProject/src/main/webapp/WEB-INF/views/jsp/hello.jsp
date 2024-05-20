<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello!!</h1>
<h2>이름은 ${myname }</h2>
<h2>성적은 ${myscore }</h2>
<h3>Get방식 요청(요청 주소에 param 이용:값 일치/field 존재/값 불일치)</h3>
<form action="${pageContext.servletContext.contextPath}/sample/hello6.do">
	email:<input type="email" name="email" value="zzilre@gmail.com"><br>
	password:<input type="password" name="pwd" value="1234"><br>
	phone:<input type="text" name="phone" value="010-1234-5678"><br>
	<input type="submit" value="서버전송(get)">
</form>
<hr>
<h3>Post방식 요청</h3>
<form method="post" action="${pageContext.servletContext.contextPath}/sample/hello6.do">
	email:<input type="email" name="email" value="zzilre@gmail.com"><br>
	password:<input type="password" name="pwd" value="1234"><br>
	phone:<input type="text" name="phone" value="010-1234-5678"><br>
	<input type="submit" value="서버전송(post)">
</form>
</body>
</html>