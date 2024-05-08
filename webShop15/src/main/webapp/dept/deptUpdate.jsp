<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 상세보기</h1>
<p>부서번호:${deptinfo.DEPARTMENT_ID}</p>
<p>부서명:${deptinfo.DEPARTMENT_NAME}</p>
<p>매니저:${deptinfo.MANAGER_ID}</p>
<p>위치:${deptinfo.LOCATION_ID}</p>
</body>
</html>