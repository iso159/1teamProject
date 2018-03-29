<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title></title>
</head>
<body>
	<div class="container">
		<h2>회원 메뉴</h2>
			<div class="row">
				<div class="col-md-4">
				<a href="${pageContext.request.contextPath}/member/memberAdd">
						<button type="button" id="signUpBtn" class="btn btn-info"> 회원가입</button>
				</a>
				</div>
				
				<div class="col-md-4">
				<a href="${pageContext.request.contextPath}/member/login">
						<button type="button" id="signUpBtn" class="btn btn-info"> 로그인</button>
				</a>
				</div> 
				<div class="col-md-4">
				<a href="${pageContext.request.contextPath}/member/memberList">
						<button type="button" id="signUpBtn" class="btn btn-info"> 회원 리스트</button>
				</a>
				</div>
				<div class="col-md-4">
				<a href="${pageContext.request.contextPath}/member/memberModify">
						<button type="button" id="signUpBtn" class="btn btn-info"> 회원 수정</button>
				</a>
				</div>
			</div> 
	</div>
</body>
</html>