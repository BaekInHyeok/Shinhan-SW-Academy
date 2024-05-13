<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입주민 항목 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../static/css/bootstrap.css">
<link rel="stylesheet" href="../static/css/bootstrap-icons.min.css">
<link rel="stylesheet" href="../static/css/prism-okaidia.css">
<link rel="stylesheet" href="../static/css/custom.min.css">
<script src="../static/js/jquery-3.7.1.min.js"></script>
<script>
	$(function() {
		$("input[type=radio][name=resident_owner]").on("click",function(){
			var chkValue=$("input[type=radio][name=resident_owner]:checked").val();
			
			if(chkValue=="O"){
				$("#resident_car").prop("readonly",false);
				$("#resident_fee").prop("readonly",false);
			}else{
				$("#resident_car").prop("readonly",true);
				$("#resident_fee").prop("readonly",true);
			}
		});

		$("form").on("submit", call);
	});

	function check(event) {
		//alert("이 곳에 도착했습니다.");
		var fee = $("#resident_fee").val();
		var car = $("#resident_car").val();
		var owner = $("input[name='resident_owner']:checked").val();
		
		var intfee = parseInt(fee);
		
		if((car=="해당없음" || car=="") && owner=="O"){
			alert("세대주는 세대의 보유 차량 수를 입력해야 합니다.");
			event.preventDefault();
			document.querySelector("#resident_car").focus();
		}
		
		if(intfee<=0 && owner=="O"){
			alert("관리비는 0원이 될 수 없습니다.");
			event.preventDefault();
			document.querySelector("#resident_fee").focus();
		}
		
		if((fee=="해당없음" || fee=="") && owner=="O"){
			alert("관리비는 반드시 입력해야 합니다.");
			event.preventDefault();
			document.querySelector("#resident_fee").focus();
		}
	}
	
	function clickYes(){
		var dong = $("#resident_dong").val();
		var ho = $("#resdient_ho").val();
		
		$.ajax({
			url:"resOwnerExistCheck.do",
			data:{"resdong":dong,"resho":ho},
			type:"get",
			success:function(responseData){
				if(responseData=="yes"){
					alert("해당 주소에는 이미 세대주가 있습니다.");
					 // "예" 라디오 버튼을 선택하도록 설정
		            $("#resident_owner_yes").prop("checked", false);
		            // "아니오" 라디오 버튼을 선택 해제
		            $("#resident_owner_no").prop("checked", true);
		            $("#resident_car").prop("readonly", true);
					$("#resident_fee").prop("readonly", true);
					$("#resident_car").val("해당없음");
					$("#resident_fee").val("해당없음");
				}
			},
			error : function(data) {
				alert(data);
			}
		});
	}
	
	function clickNo(){
		$("#resident_car").val("해당없음");
		$("#resident_fee").val("해당없음");
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

#btnDupChk{
	margin-left: 30px;
}

/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}

a{
	color: #5a5a5a;
	font-size:25px;
}

#registerBtn{
	width:200px;
	height:50px;
	font-size:25px;
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<div id="topbar" class="navbar navbar-extends-lg fixed-top bg-primary"
		data-bs-theme="dark">
		<div class="container">
			<h1>입주민 정보 수정</h1>
			<a href="respage.do">이전 화면으로</a>

		</div>
	</div>
	<div class="container mt-3">
		<form action="resUpdate.do" method="post">
			<div class="mb-3 mt-3">
				<label for="resident_id" class="col-form-label col-form-label-lg">입주민ID</label> <input type="number"
					class="form-control form-control-lg" id="resident_id" placeholder="입주자 ID를 입력하세요"
					name="resident_id" required="required" value="${resinfo.resident_id}" readonly="readonly">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_name" class="col-form-label col-form-label-lg">입주자명</label> <input type="text"
					class="form-control form-control-lg" id="resident_name" placeholder="입주자명을 입력하세요"
					name="resident_name" required value="${resinfo.resident_name}">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_phone" class="col-form-label col-form-label-lg">전화번호</label> <input type="text"
					class="form-control form-control-lg" id="resident_phone"
					placeholder="입주자의 전화번호를 입력하세요" name="resident_phone" required value="${resinfo.resident_phone}">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_dong"  class="col-form-label col-form-label-lg">거주동</label> <input type="number"
					class="form-control form-control-lg" id="resident_dong" placeholder="거주 동을 입력하세요"
					name="resident_dong" required value="${resinfo.resident_dong}">
			</div>
			<div class="mb-3 mt-3">
				<label for="resdient_ho" class="col-form-label col-form-label-lg">거주호수</label> <input type="number"
					class="form-control form-control-lg" id="resdient_ho" placeholder="거주 호수를 입력하세요"
					name="resdient_ho" required value="${resinfo.resident_ho}">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_date" class="col-form-label col-form-label-lg">입주일자</label> <input type="date"
					class="form-control form-control-lg" id="resident_date" placeholder="입주 일자를 선택해주세요"
					name="resident_date" required value="${resinfo.resident_date}">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_owner" class="col-form-label col-form-label-lg">세대주 여부</label>
			</div>
			<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
					<input type="radio" name="resident_owner" id="resident_owner_yes" class="btn-check" value="O" onclick="clickYes()" ${resinfo.resident_owner=='O'?"checked":""}>
					<label class="btn btn-outline-primary" for="resident_owner_yes">예</label>
					<input type="radio" name="resident_owner" id="resident_owner_no" class="btn-check" value="X" onclick="clickNo()" ${resinfo.resident_owner=='X'?"checked":""}>
					<label class="btn btn-outline-primary" for="resident_owner_no">아니오</label>
				</div>
			<div class="mb-3 mt-3">
				<label for="resident_car" class="col-form-label col-form-label-lg">보유 차량 수:</label> <input type="text"
					class="form-control form-control-lg" id="resident_car" re
					placeholder="보유 차량 대수를 입력해주세요" name="resident_car" ${resinfo.resident_owner=='X'?"readonly":""} value="${resinfo.resident_car}">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_fee" class="col-form-label col-form-label-lg">관리비:</label> <input type="text"
					class="form-control form-control-lg" id="resident_fee" placeholder="관리비를 입력하세요"
					name="resident_fee" ${resinfo.resident_owner=='X'?"readonly":""} value="${resinfo.resident_fee}">
			</div>

			<button type="submit" id ="registerBtn" onclick="check(event)" class="btn btn-primary">수정하기</button>
		</form>
	</div>
</body>
</html>