<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>신규직원등록</h1>
	<form action="empDBInsert.jsp">

		<fieldset>
			<legend>필수항목</legend>
			<label>직원번호</label> <input type="number" name="employee_id"><br>
			<label>LastName</label> <input type="text" name="last_name"><br>
			<label>이메일</label> <input type="text" name="email"><br>
			<label>입사일</label> <input type="text" name="hire_date"><br>
			<label>업무명</label> <input type="text" name="job_id" value="IT_PROG"><br>
		</fieldset>

		<fieldset>
			<legend>선택입력항목</legend>
			<label>FirstName</label> <input type="text" name="first_name"><br>
			<label>전화번호</label> <input type="text" name="phone_number"><br>
			<label>급여</label> <input type="number" name="salary"><br>
			<label>커미션</label> <input type="text" name="commission_pct"><br>
			<label>매니저ID</label> <input type="number" name="manager_id" value="100"><br>
			<label>부서ID</label> <input type="number" name="department_id" value="100"><br>
		</fieldset>
		
		<input type="submit" value="입력">
		<input type="reset" value="지우기">


	</form>
</body>
</html>