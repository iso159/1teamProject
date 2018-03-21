<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#signUpBtn').click(function(){
			// 공백 제거
			let userId = $.trim($('#userId').val());
			let userPw = $.trim($('#userPw').val());
			if(userId==="" || userPw===""){
				// 공백일경우 경고창
				alert('공백은 입력할 수 없습니다.');
				// 텍스트 비움
				$('#userId').val('');
				$('#userPw').val('');
			}else{
				// 공백이 아닐경우 서브밋
				$('#signUpForm').submit();
			}
		});
	});
</script>
<title>회원가입</title>
</head>
<body>
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
		<h2>회원 가입 화면</h2>
		<form id="signUpForm" class="form-inline" action="${pageContext.request.contextPath}/member/memberAdd" method="post">
			<div class="row">
				<div class="col-md-4">
					<label for="code">아이디</label>
					<input id="userId" class="form-control" type="text"  name="mId"><br>
					
					<label for="code">비밀번호</label>
					<input id="userPw" class="form-control" type="password"  name="mPw"><br>

					<label for="title">이름</label>
					<input id="userName" class="form-control" type="text"  name="mInfoName"><br>

					<label for="title">닉네임</label>
					<input id="userNickname" class="form-control" type="text" name="mInfoNickname"><br>

					<label for="title">성별</label>
					<input id="userGender" class="form-control" type="text" name="mInfoGender"><br>

					<label for="title">생년월일</label>
					<input id="userBirth" class="form-control" type="text" name="mInfoBirth"><br>
										
					<label for="title">우편번호</label>
					<input id="userPostcode" class="form-control" type="text" name="mInfoPostCode"><br>
								
					<label for="title">주소</label>
					<input id="userAddress" class="form-control" type="text" name="mInfoAddress"><br>
									
					<label for="title">이메일</label>
					<input id="userEmail" class="form-control" type="text" name="mInfoEmail"><br>
														
					<label for="title">핸드폰 번호</label>
					<input id="userPhone" class="form-control" type="text" name="mInfoPhone"><br>
					
					<button type="submit" id="signUpBtn" class="btn btn-info">회원 가입 하기.</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 메인 화면 내용 끝 -->
</body>
</html>