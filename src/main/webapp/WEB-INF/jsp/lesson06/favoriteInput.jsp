<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가 </title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
	
		<h1>즐겨찾기 추가하기</h1>
		<label>제목</label>
		<input type="text" id="nameInput" class="form-control">
		<label>주소</label>
		<div class="d-flex ">
			<input type="text" id="urlInput" class="form-control col-11"> 
			<button type="button" class="btn btn-info col-1" id="duplicateBtn">중복확인</button>
		</div>
		<div id="duplicateText" class="d-none"> <small class="text-danger">중복된 url 입니다.</small> </div>
		<div id="possibleText" class="d-none"> <small class="text-success">저장 가능한 url 입니다.</small></div>
		
		<button type="button" id="addBtn" class="btn btn-info btn-block">추가</button>
	
	</div>
	
	<script>
		$(document).ready(function() {
			
			// 중복체크를 했는지 여부 저장하는 변수
			var isChecked = false;
			
			// 중복된 상태인지 확인하는 변수 
			var isDucplicate = true;
			
			
			// url 입력내용 수정
			$("#urlInput").on("input", function() {
				// 중복관련 변수 값 초기화
				isChecked = false;
				isDucplicate = true;
				
				// 중복관련 텍스트 숨기기
				$("#duplicateText").addClass("d-none");
				$("#possibleText").addClass("d-none");
				
			});
			
			$("#duplicateBtn").on("click", function() {
				
				let url = $("#urlInput").val();
				
				if(url == "") {
					alert("주소를 입력하세요");
					return ;
				}
				
				
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소형식이 잘못 되었습니다");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/lesson06/url_duplicate",
					data:{"url":url},
					success:function(data) {
						// {"is_duplicate":true}
						// {"is_duplicate":false}
						
						// 중복체크 완료
						isChecked = true;
						
						// 안내 텍스트를 숨긴다
						$("#duplicateText").addClass("d-none");
						$("#possibleText").addClass("d-none");
						
						if(data.is_duplicate) {
							// 중복 안내 텍스트를 보여준다
							isDucplicate = true;
							$("#duplicateText").removeClass("d-none");
							
						} else {
							// 사용가능 안내 텍스트를 보여준다
							isDucplicate = false;
							$("#possibleText").removeClass("d-none");
						}
					},
					error:function() {
						alert("중복확인 에러");
					}
					
				});
				
				
			});
			
			
			$("#addBtn").on("click", function() {
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				// 유효성 검사 
				if(name == "") {
					alert("이름을 입력하세요");
					return ;
				}
				
				if(url == "") {
					alert("주소를 입력하세요");
					return ;
				}
				
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소형식이 잘못 되었습니다");
					return;
				}
				
				// 중복 체크 확인 여부 
				if(isChecked == false) {
					alert("중복확인을 진행해 주세요");
					return;
				}
				
				if(isDucplicate) {
					alert("url이 중복되었습니다. ");
					return;
				}
				
				// ajax를 통한 api 호출
				$.ajax({
					type:"post",
					url:"/lesson06/add_favorite",
					data:{"name":name, "url":url},
					success:function(data) {
						
						// successs
						if(data.result == "success") {
							location.href = "/lesson06/favorite_list";
						} else {
							alert("즐겨찾기 추가 실패");
						}
						
						// fail
						
					}, 
					error:function() {
						alert("입력실패");
					}
				});
				
				// 성공여부에 따른 기능 분기
				
			});
			
			
		}) ;
	
	</script>

</body>
</html>