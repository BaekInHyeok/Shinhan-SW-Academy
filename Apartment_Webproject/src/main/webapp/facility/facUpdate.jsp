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
		var resid = $("#facility_id").val();
		if (resid == "") {
			alert("시설 ID를 입력하세요");
			return;
		}

		$.ajax({
			url : "facIdCheck.do",
			data : {
				"facid" : facid
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
	
	function changefac(){
		$("#facility_type").val($("#selected_facType").val());
	}
	
	function changemgr(){
		$("#facility_manager_id").val($("#manager").val());
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
	margin-top: 10px;
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
			<h1>공용시설 수정</h1>
			<a href="facpage.do">이전 화면으로</a>

		</div>
	</div>
	<div class="container mt-3">

		<form action="facUpdate.do" method="post">
			<div class="mb-3 mt-3">
				<label for="facility_id" class="col-form-label col-form-label-lg">시설ID</label> <input type="number"
					class="form-control form-control-lg" id=facility_id placeholder="시설 ID를 입력하세요"
					name="facility_id" required="required"
					value="${facinfo.facility_id}" readonly="readonly">
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_name" class="col-form-label col-form-label-lg">시설명</label> <input type="text"
					class="form-control form-control-lg" id="facility_name" placeholder="시설명을 입력하세요"
					name="facility_name" required value="${facinfo.facility_name}">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_date" class="col-form-label col-form-label-lg">준공일자</label> <input type="date"
					class="form-control form-control-lg" id="facility_date" placeholder="준공 일자를 선택해주세요"
					name="facility_date" required value="${facinfo.facility_date}">
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_type" class="col-form-label col-form-label-lg">시설종류</label>
				<input type="text"
					class="form-control form-control-lg" placeholder="시설 종류를 선택하세요"
					id="facility_type" name ="facility_type" value="${facinfo.facility_type}" readonly="readonly">
			</div>
			<div>
				<select onchange="changefac()" class="form-select" size="4" id="selected_facType" name="selected_facType">
					<option value="독서실">독서실</option>
					<option value="도서관">도서관</option>
					<option value="운동시설">운동시설</option>
					<option value="휴게시설">휴게시설</option>
					<option value="어린이집">어린이집</option>
					<option value="경비시설">경비시설</option>
					<option value="주차장">주차장</option>
					<option value="경로시설">경로시설</option>
					<option value="놀이터">놀이터</option>
					<option value="위생시설">위생시설</option>
					<option value="기타">기타</option>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_start_time" class="col-form-label col-form-label-lg">운영시작시각</label> <input type="text"
					class="form-control form-control-lg" id="facility_start_time"
					placeholder="HH:mm:ss 형식으로 입력" name="facility_start_time" required
					value="${facinfo.facility_start_time}">
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_end_time" class="col-form-label col-form-label-lg">운영종료시각</label> <input type="text"
					class="form-control form-control-lg" id="facility_end_time"
					placeholder="HH:mm:ss 형식으로 입력" name="facility_end_time" required
					value="${facinfo.facility_end_time}">
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_manager_id" class="col-form-label col-form-label-lg">매니저ID</label>
				<input type="number"
					class="form-control form-control-lg" id="facility_manager_id"
					placeholder="관리 담당자를 선택하세요" name="facility_manager_id" required
					value="${facinfo.facility_manager_id}">
			</div>
			<div>
				<select onchange="changemgr()" class="form-select" size="4" id="manager" name="manager">
					<option value="0">0 : 담당자 X</option>
					<c:forEach var="wkr" items="${wkrList}">
						<option value="${wkr.WORKER_ID}">${wkr.WORKER_ID} : ${wkr.WORKER_NAME} - ${wkr.WORKER_WORK}</option>
					</c:forEach>
					
				</select>
			</div>

			<button type="submit" id ="registerBtn" class="btn btn-primary">수정하기</button>
		</form>
	</div>
</body>
</html>