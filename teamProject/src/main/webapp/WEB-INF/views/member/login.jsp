<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 메인화면 시작 -->
        <div id="page-wrapper">
        	<!-- h태그제목 시작 -->
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">체험자 로그인</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<form id="loginForm" class="form-inline" action="${pageContext.request.contextPath}/member/login" method="post">
				<div class="row">
					<div class="col-md-4">
						<label for="code">아이디</label>
						<input id="userId" class="form-control" type="text"  name="mId" value="experience" > <br>
						<label for="title">비밀번호</label> 
						<input id="userPw" class="form-control" type="password"  name="mPw" value="1234"> <br>
						<button type="submit" id="loginBtn" class="btn btn-info">로그인</button>
					</div>
				</div>
			</form>
			<!-- 입양자 로그인 시작 -->
			<div class="row">
		                <div class="col-lg-12">
		                    <h1 class="page-header">입양자 로그인</h1>
		                </div>
		            </div>
				<form id="loginForm" class="form-inline" action="${pageContext.request.contextPath}/member/login" method="post">
					<div class="row">
						<div class="col-md-4">
							<label for="code">아이디</label>
							<input id="userId" class="form-control" type="text"  name="mId" value="adopter" > <br>
							<label for="title">비밀번호</label> 
							<input id="userPw" class="form-control" type="password"  name="mPw" value="1234"> <br>
							<button type="submit" id="loginBtn" class="btn btn-info">로그인</button>
						</div>
					</div>
				</form>
			<!-- 입양자 로그인 끝 -->
			
			<!-- 관리자 로그인 시작 -->
			<div class="row">
		                <div class="col-lg-12">
		                    <h1 class="page-header">관리자 로그인</h1>
		                </div>
		            </div>
				<form id="loginForm" class="form-inline" action="${pageContext.request.contextPath}/member/login" method="post">
					<div class="row">
						<div class="col-md-4">
							<label for="code">아이디</label>
							<input id="userId" class="form-control" type="text"  name="mId" value="administrator" > <br>
							<label for="title">비밀번호</label> 
							<input id="userPw" class="form-control" type="password"  name="mPw" value="1234"> <br>
							<button type="submit" id="loginBtn" class="btn btn-info">로그인</button>
						</div>
					</div>
				</form>
			<!-- 관리자 로그인 끝 -->
			
			<!-- 보호소 로그인 시작 -->
			<div class="row">
		                <div class="col-lg-12">
		                    <h1 class="page-header">보호소 로그인</h1>
		                </div>
		            </div>
				<form id="loginForm" class="form-inline" action="${pageContext.request.contextPath}/member/login" method="post">
					<div class="row">
						<div class="col-md-4">
							<label for="code">아이디</label>
							<input id="userId" class="form-control" type="text"  name="mId" value="shelter" > <br>
							<label for="title">비밀번호</label> 
							<input id="userPw" class="form-control" type="password"  name="mPw" value="1234"> <br>
							<button type="submit" id="loginBtn" class="btn btn-info">로그인</button>
						</div>
					</div>
				</form>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
