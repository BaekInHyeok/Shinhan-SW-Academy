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
		var facid = $("#facility_id").val();
		if (facid == "") {
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
				var message;
				if(responseData==1){
					
					$("#facility_id").addClass("is-invalid");
					$("#facility_id").removeClass("is-valid");
					
					$("#chkMessage").addClass("invalid-feedback");
					$("#chkMessage").removeClass("valid-feedback");
					//document.getElementById("chkMessage").innerHTML = "이미 존재하는 ID입니다";
					$("#chkMessage").html("이미 존재하는 ID입니다");
					$("#chkMessage").css("display","block");
				}else if(responseData==0){
					
					$("#facility_id").addClass("is-valid");
					$("#facility_id").removeClass("is-invalid");
					
					$("#chkMessage").removeClass("invalid-feedback");
					$("#chkMessage").addClass("valid-feedback");
					//document.getElementById("chkMessage").innerHTML = "사용 가능한 ID입니다";
					$("#chkMessage").html("사용 가능한 ID입니다");
					$("#chkMessage").css("display","block");
				}else if(responseData==2){
					
					$("#facility_id").addClass("is-invalid");
					$("#facility_id").removeClass("is-valid");
					
					$("#chkMessage").addClass("invalid-feedback");
					$("#chkMessage").removeClass("valid-feedback");
					//document.getElementById("chkMessage").innerHTML = "이미 존재하는 ID입니다";
					$("#chkMessage").html("아이디는 2자리 숫자입니다.");
					$("#chkMessage").css("display","block");
				}
			},
			error : function(data) {
				alert(data);
			}
		});
	}
	
	function changefac(){
		$("#selected_facType").val($("#facility_type").val());
	}
	function changemgr(){
		$("#manager").val($("#facility_manager_id").val());
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
	margin-top: 20px;
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
			<h1>공용시설 등록</h1>
			<a href="facpage.do">이전 화면으로</a>

		</div>
	</div>
	<div class="container mt-3">
		<form action="facInsert.do" method="post">
			<div class="mb-3 mt-3">
				<label for="facility_id" class="col-form-label col-form-label-lg">시설ID</label>
				<div class="residcon">
				<input type="number"
					class="form-control form-control-lg" id=facility_id placeholder="시설 ID를 입력하세요"
					name="facility_id" required="required"> 
					<input type="button" value="중복체크" class="btn btn-primary" id="btnDupChk">
				</div>
				<div id="chkMessage">ID 중복 여부를 확인해주세요</div>
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_name" class="col-form-label col-form-label-lg">시설명</label> <input type="text"
					class="form-control form-control-lg" id="facility_name" placeholder="시설명을 입력하세요"
					name="facility_name" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_date" class="col-form-label col-form-label-lg">준공일자</label> <input type="date"
					class="form-control form-control-lg" id="facility_date" placeholder="입주 일자를 선택해주세요"
					name="facility_date" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_type" class="col-form-label col-form-label-lg">시설종류 선택</label>
				<input type="text" class="form-control form-control-lg" id="selected_facType"
					placeholder="시설 종류를 선택하세요"
					 readonly="readonly">
			</div>
			<div>
				<select onchange="changefac()" class="form-select" size="4" id="facility_type" name="facility_type" required>
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
					placeholder="24시간제 hh:mm:ss 형식으로 입력" name="facility_start_time" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_end_time" class="col-form-label col-form-label-lg">운영종료시각</label> <input type="text"
					class="form-control form-control-lg" id="facility_end_time"
					placeholder="24시간제 hh:mm:ss 형식으로 입력" name="facility_end_time" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="facility_manager_id" class="col-form-label col-form-label-lg">매니저ID</label> <input type="number"
					class="form-control form-control-lg" id="manager"
					placeholder="관리 담당자를 선택하세요" name="manager" readonly="readonly">
			</div>
			<div>
				<select onchange="changemgr()" class="form-select" size="4" id="facility_manager_id" name="facility_manager_id">
					<option value="0">0 : 담당자 X</option>
					<c:forEach var="wkr" items="${wkrList}">
						<option value="${wkr.WORKER_ID}">${wkr.WORKER_ID} : ${wkr.WORKER_NAME} - ${wkr.WORKER_WORK}</option>
					</c:forEach>
					
				</select>
			</div>

			<button type="submit" id ="registerBtn" class="btn btn-primary">등록하기</button>
		</form>
	</div>
</body>
</html>