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
		$("#btnDupChk").on("click", f_dupCheck);
	});

	function f_dupCheck() {
		var wkrid = $("#STORE_ID").val();
		if (wkrid == "") {
			alert("상점ID를 입력하세요");
			return;
		}

		$.ajax({
			url : "strIdCheck.do",
			data : {
				"str" : wkrid
			},
			type : "get",
			success : function(responseData) {
				$("#resultMessage").val(responseData);
			},
			error : function(data) {
				alert(data);
			}
		});
	}
	function changetype(){
		$("#STORE_TYPE").val($("#selected_strType").val());
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
			<h1>상점 정보 수정</h1>
			<a href="strpage.do">이전 화면으로</a>
		</div>
	</div>
	<div class="container mt-3">
		<form action="strUpdate.do" method="post">
			<div class="mb-3 mt-3">
				<label for="STORE_ID" class="col-form-label col-form-label-lg">상점ID</label>
				<input type="number" class="form-control form-control-lg"
					id=STORE_ID placeholder="상점 ID를 입력하세요" name="STORE_ID"
					required="required" readonly="readonly" value="${strinfo.STORE_ID}">
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_BUSSINESS_NUMBER"
					class="col-form-label col-form-label-lg">사업자등록번호</label> <input
					type="text" class="form-control form-control-lg"
					id="STORE_BUSSINESS_NUMBER" placeholder="사업자등록번호를 입력하세요"
					name="STORE_BUSSINESS_NUMBER" required
					value="${strinfo.STORE_BUSSINESS_NUMBER}" readonly>
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_NAME" class="col-form-label col-form-label-lg">상점명</label>
				<input type="text" class="form-control form-control-lg"
					id="STORE_NAME" placeholder="상점명을 입력하세요" name="STORE_NAME" required
					value="${strinfo.STORE_NAME}">
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_OWNER" class="col-form-label col-form-label-lg">사업자명</label>
				<input type="text" class="form-control form-control-lg"
					id="STORE_OWNER" placeholder="사업자명을 입력하세요" name="STORE_OWNER"
					required value="${strinfo.STORE_OWNER}">
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_PHONE" class="col-form-label col-form-label-lg">H.P</label>
				<input type="text" class="form-control form-control-lg"
					id="STORE_PHONE" placeholder="전화번호를 입력하세요" name="STORE_PHONE"
					required value="${strinfo.STORE_PHONE}">
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_TYPE" class="col-form-label col-form-label-lg">업종</label>
				<input type="text" class="form-control form-control-lg" id="STORE_TYPE" name="STORE_TYPE"
					placeholder="업종을 선택하세요" 
					value="${strinfo.STORE_TYPE}" readonly="readonly">
			</div>
			<div>
				<select onchange="changetype()" class="form-select" size="6" id="selected_strType"
					name="selected_strType">
					<option value="양식">양식</option>
					<option value="한식">한식</option>
					<option value="일식">일식</option>
					<option value="중식">중식</option>
					<option value="분식">분식</option>
					<option value="아이스/빙수">아이스/빙수</option>
					<option value="음료">음료</option>
					<option value="제과제빵">제과제빵</option>
					<option value="주점">주점</option>
					<option value="커피">커피</option>
					<option value="패스트푸드">패스트푸드</option>
					<option value="PC방">PC방</option>
					<option value="교육">교육</option>
					<option value="배달">배달</option>
					<option value="부동산">부동산</option>
					<option value="스포츠">스포츠</option>
					<option value="미용">미용</option>
					<option value="이사">이사</option>
					<option value="세탁">세탁</option>
					<option value="안경">안경</option>
					<option value="병원">병원</option>
					<option value="약국">약국</option>
					<option value="편의점">편의점</option>
					<option value="종합소매점">종합소매점</option>
					<option value="식품전문점">식품전문점</option>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_STARTDATE"
					class="col-form-label col-form-label-lg">개업일자</label> <input
					type="date" class="form-control form-control-lg"
					id="STORE_STARTDATE" placeholder="개업일자를 선택해주세요"
					name="STORE_STARTDATE" required value="${strinfo.STORE_STARTDATE}">
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_START_TIME"
					class="col-form-label col-form-label-lg">영업시작시각</label> <input
					type="text" class="form-control form-control-lg"
					id=STORE_START_TIME placeholder="hh:mm:ss 형식으로 입력하세요"
					name="STORE_START_TIME" required="required"
					value="${strinfo.STORE_START_TIME}">
			</div>
			<div class="mb-3 mt-3">
				<label for="STORE_END_TIME" class="col-form-label col-form-label-lg">영업종료시각</label>
				<input type="text" class="form-control form-control-lg"
					id="STORE_END_TIME" placeholder="hh:mm:ss 형식으로 입력하세요"
					name="STORE_END_TIME" required value="${strinfo.STORE_END_TIME}">
			</div>

			<button type="submit" id="registerBtn" class="btn btn-primary">수정하기</button>
		</form>
	</div>
</body>
</html>