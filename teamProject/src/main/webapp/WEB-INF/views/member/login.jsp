<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<!-- <script>
	$(document).ready(function(){
		$('#loginBtn').click(function(){
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
				$('#loginForm').submit();
			}
		});
	});
</script> -->
<title>Insert title here</title>
</head>
<body>
	<div class="container"> 
	<h2>로그인 화면</h2>
		<form id="loginForm" class="form-inline" action="${pageContext.request.contextPath}/member/login" method="post">
			<div class="row">
				<div class="col-md-4">
					<label for="code">아이디</label>
					<input id="userId" class="form-control" type="text"  name="mId" value="login" >
					<label for="title">비밀번호</label> 
					<input id="userPw" class="form-control" type="password"  name="mPw" value="1234">
					<button type="submit" id="loginBtn" class="btn btn-info">로그인</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>