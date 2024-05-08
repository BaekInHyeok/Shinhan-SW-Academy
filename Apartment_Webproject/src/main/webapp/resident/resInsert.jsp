<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입주민 항목 입력</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../static/js/jquery-3.7.1.min.js"></script>
<script>
	$(function() {
		$("input[type=radio][name=resident_owner]").on("click",function(){
			var chkValue=$("input[type=radio][name=resident_owner]:checked").val();
			
			if(chkValue==1){
				$("#resident_car").prop("readonly",false);
				$("#resident_fee").prop("readonly",false);
			}else{
				$("#resident_car").prop("readonly",true);
				$("#resident_fee").prop("readonly",true);
			}
		});

		$("form").on("submit", call);
		$("#btnDupChk").on("click", f_dupCheck);
	});

	function call(event) {
		var fee = $("#resident_fee").val();
		var feeInput = $("#resident_owner").val();
		console.log(fee);
		if ((fee == "" || fee <= 0)&&feeInput==1 ) {
			alert("관리비는 0보다 큰 값입니다.");
			event.preventDefault();
			document.querySelector("#resident_fee").focus();
		}
	}
	
	function f_dupCheck(){
		var resid = $("#resident_id").val();
		if(resid==""){
			alert("입주민 번호를 입력하세요");
			return;
		}
		
		$.ajax({
			url:"resIdCheck.do",
			data:{"resid":resid},
			type:"get",
			success:function(responseData){
				$("#resultMessage").val(responseData);
			},
			error:function(data){
				alert(data);
			}
		});
	}
</script>
</head>
<body>
	<div class="container mt-3">
		<a href="respage.do">이전 화면으로</a>
		<h2>입주민 등록</h2>
		<form action="resInsert.do" method="post">
			<div class="mb-3 mt-3">
				<label for="resident_id">입주민ID:</label> <input type="number"
					class="form-control" id="resident_id" placeholder="입주자 ID를 입력하세요"
					name="resident_id" required="required">
					<input type="button" value="중복체크" id="btnDupChk">
					<input type="text" value="ID입력후 중복체크" id="resultMessage">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_name">입주자명:</label> <input type="text"
					class="form-control" id="resident_name" placeholder="입주자명을 입력하세요"
					name="resident_name" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_phone">전화번호:</label> <input type="text"
					class="form-control" id="resident_phone"
					placeholder="입주자의 전화번호를 입력하세요" name="resident_phone" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_dong">거주동:</label> <input type="number"
					class="form-control" id="resident_dong" placeholder="거주 동을 입력하세요"
					name="resident_dong" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="resdient_ho">거주호수:</label> <input type="number"
					class="form-control" id="resdient_ho" placeholder="거주 호수를 입력하세요"
					name="resdient_ho" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_date">입주일자:</label> <input type="date"
					class="form-control" id="resident_date" placeholder="입주 일자를 선택해주세요"
					name="resident_date" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="">세대주 여부:</label> <input type="radio"
					name="resident_owner" id="resident_owner_yes" value="1">예 <input
					type="radio" name="resident_owner" id="resident_owner_no" value="0"
					checked="checked">아니오
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_car">보유 차량 수:</label> <input type="text"
					class="form-control" id="resident_car"
					placeholder="보유 차량 대수를 입력해주세요" name="resident_car" readonly="readonly" value="해당없음">
			</div>
			<div class="mb-3 mt-3">
				<label for="resident_fee">관리비:</label> <input type="text"
					class="form-control" id="resident_fee" placeholder="관리비를 입력하세요"
					name="resident_fee" readonly="readonly" value="해당없음">
			</div>

			<button type="submit" class="btn btn-primary">등록하기</button>
		</form>
	</div>
</body>
</html>