<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용시설 항목 입력</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../static/css/bootstrap.css">
<link rel="stylesheet" href="../static/css/bootstrap-icons.min.css">
<link rel="stylesheet" href="../static/css/prism-okaidia.css">
<link rel="stylesheet" href="../static/css/custom.min.css">
<script src="../static/js/jquery-3.7.1.min.js"></script>
<script>
	$(function() {
		$("form").on("submit", call);
	});

	function call(event) {
		var sal = $("#WORKER_SALARY").val();
		console.log(sal);
		if ((fee == "" || fee <= 0)) {
			alert("급여는 0보다 큰 값입니다.");
			event.preventDefault();
			document.querySelector("#WORKER_SALARY").focus();
		}
	}
	
	function changefac(){
		$("#WORKER_WORKPLACE_ID").val($("#workplace").val());
	}
</script>

<style>
#topbar {
	height: 120px;
}

h1 {
	font-weight: bold;
}

.residcon {
	display: flex;
}

#btnDupChk {
	margin-left: 30px;
}

/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
/* Firefox */
input[type=number] {
	-moz-appearance: textfield;
}

a {
	color: #5a5a5a;
	font-size: 25px;
}

#registerBtn {
	width: 200px;
	height: 50px;
	font-size: 25px;
	margin-bottom: 30px;
	margin-top:10px;
}

option{
	font-size:20px;
}
</style>
</head>
<body>
	<div id="topbar" class="navbar navbar-extends-lg fixed-top bg-primary"
		data-bs-theme="dark">
		<div class="container">
			<h1>근무자 수정</h1>
			<a href="wkrpage.do">이전 화면으로</a>
		</div>
	</div>
	<div class="container mt-3">
		<form action="wkrUpdate.do" method="post">
			<div class="mb-3 mt-3">
				<label for="WORKER_ID" class="col-form-label col-form-label-lg">근무자ID</label>
				<input type="number" class="form-control form-control-lg"
					id=WORKER_ID placeholder="근무자 ID를 입력하세요" name="WORKER_ID"
					required="required" readonly="readonly"
					value="${wkrinfo.WORKER_ID}">
			</div>
			<div class="mb-3 mt-3">
				<label for="WORKER_NAME" class="col-form-label col-form-label-lg">근무자명</label>
				<input type="text" class="form-control form-control-lg"
					id="WORKER_NAME" placeholder="근무자의 이름을 입력하세요" name="WORKER_NAME"
					required value="${wkrinfo.WORKER_NAME}">
			</div>
			<div class="mb-3 mt-3">
				<label for="WORKER_AGE" class="col-form-label col-form-label-lg">근무자
					나이</label> <input type="number" class="form-control form-control-lg"
					id=WORKER_AGE placeholder="근무자의 나이를 입력하세요" name="WORKER_AGE"
					required="required" value="${wkrinfo.WORKER_AGE}">
			</div>

			<div class="mb-3 mt-3">
				<label for="WORKER_GENDER" class="col-form-label col-form-label-lg">근무자 성별</label>
			</div>
			<div class="btn-group" role="group" aria-label="Basic radio toggle button group">		
				<input type="radio" name="WORKER_GENDER" id="WORKER_GENDER_MALE" class="btn-check" value="남" ${wkrinfo.WORKER_GENDER=="남"?"checked":""}>
					<label class="btn btn-outline-primary" for="WORKER_GENDER_MALE">남</label>
				<input type="radio" name="WORKER_GENDER" id="WORKER_GENDER_FEMALE" class="btn-check" value="여" ${wkrinfo.WORKER_GENDER=="여"?"checked":""}>
					<label class="btn btn-outline-primary" for="WORKER_GENDER_FEMALE">여</label>
			</div>
			<div class="mb-3 mt-3">
				<label for="WORKER_PHONE" class="col-form-label col-form-label-lg">전화번호</label>
				<input type="text" class="form-control form-control-lg"
					id="WORKER_PHONE" placeholder="전화번호를 입력하세요" name="WORKER_PHONE"
					required value="${wkrinfo.WORKER_PHONE}">
			</div>
			<div class="mb-3 mt-3">
				<label for="WORKER_HIREDATE"
					class="col-form-label col-form-label-lg">입사일자</label> <input
					type="date" class="form-control form-control-lg"
					id="WORKER_HIREDATE" placeholder="입사 일자를 선택해주세요"
					name="WORKER_HIREDATE" required value="${wkrinfo.WORKER_HIREDATE}">
			</div>
			<div class="mb-3 mt-3">
				<label for="WORKER_WORKPLACE_ID"
					class="col-form-label col-form-label-lg">근무시설ID</label> <input
					type="number" class="form-control form-control-lg"
					id="WORKER_WORKPLACE_ID" placeholder="근무 시설을 선택하세요"
					name="WORKER_WORKPLACE_ID" required="required"
					value="${wkrinfo.WORKER_WORKPLACE_ID}">
			</div>
			<div>
				<select onchange="changefac()" class="form-select" size="4" id="workplace" name="workplace">
					<c:forEach var="fac" items="${facList}">
						<option value="${fac.facility_id}">${fac.facility_id } : ${fac.facility_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="WORKER_WORK" class="col-form-label col-form-label-lg">업무</label>
				<input type="text" class="form-control form-control-lg"
					id="WORKER_WORK" placeholder="업무를 입력하세요" name="WORKER_WORK"
					required value="${wkrinfo.WORKER_WORK}">
			</div>
			<div class="mb-3 mt-3">
				<label for="WORKER_SALARY" class="col-form-label col-form-label-lg">급여</label>
				<input type="number" class="form-control form-control-lg"
					id="WORKER_SALARY" placeholder="급여를 입력하세요" name="WORKER_SALARY"
					required value="${wkrinfo.WORKER_SALARY}">
			</div>

			<button type="submit" id="registerBtn" class="btn btn-primary">수정하기</button>
		</form>
	</div>
</body>
</html>