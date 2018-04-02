<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<!-- 체험자 로그인 시작 -->
	<div class="container"> 
	<h2>체험자 로그인</h2>
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
	</div>
	<!-- 체험자 로그인 끝 -->
	
	<!-- 입양자 로그인 시작 -->
	<div class="container"> 
	<h2>입양자 로그인</h2>
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
	</div>
	<!-- 입양자 로그인 끝 -->
	
	<!-- 관리자 로그인 시작 -->
	<div class="container"> 
	<h2>관리자 로그인</h2>
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
	</div>
	<!-- 관리자 로그인 끝 -->
	
	<!-- 보호소 로그인 시작 -->
	<div class="container"> 
	<h2>보호소 로그인</h2>
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
	</div>
	<!-- 보호소 로그인 끝 -->
</body>
</html>