<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container"> 
	<h2>체험자 로그인</h2>
		<form id="loginForm" class="form-inline" action="${pageContext.request.contextPath}/member/login" method="post">
			<div class="row">
				<div class="col-md-4">
					<label for="code">아이디</label>
					<input id="userId" class="form-control" type="text"  name="mId" value="m_02" > <br>
					<label for="title">비밀번호</label> 
					<input id="userPw" class="form-control" type="password"  name="mPw" value="1234"> <br>
					<button type="submit" id="loginBtn" class="btn btn-info">로그인</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>