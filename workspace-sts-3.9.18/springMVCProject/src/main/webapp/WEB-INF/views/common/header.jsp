<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 경로세팅 -->
<c:set var="path" value="${pageContext.servletContext.contextPath}"></c:set>
<div>
로그인 사용자:
<c:if test="${emp==null}">손님
<a href="${path}/auth/login.do">로그인 화면으로</a>
</c:if>
<c:if test="${emp!=null}">
	${emp.first_name}님 환영합니다.
	<a href="${path}/auth/logout.do">로그아웃</a>
</c:if>
</div>