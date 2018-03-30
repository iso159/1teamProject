<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>회원수정임</title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
		<h2>회원수정</h2>
		<form id="signUpForm" class="form-inline" action="${pageContext.request.contextPath}/member/memberModify" method="post">
			<table>
			 	<tr>
					<td>아이디</td>
					<td><input class="form-control" type="text"  name="mId" value="${loginId}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mPw"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="mInfoName" value="${MemberInfo.mInfoName}"></td>
				</tr>
			 	<tr>
					<td>닉네임</td>
					<td><input type="text" name="mInfoNickname" value="${MemberInfo.mInfoNickname}"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="mInfoGender" value="${MemberInfo.mInfoGender}"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="mInfoBirth" value="${MemberInfo.mInfoBirth}"></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="text" name="mInfoPostcode" value="${MemberInfo.mInfoPostcode}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="mInfoAddress" value="${MemberInfo.mInfoAddress}"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="mInfoEmail" value="${MemberInfo.mInfoEmail}"></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><input type="text" name="mInfoPhone" value="${MemberInfo.mInfoPhone}"></td>
				</tr>
			</table>
			<button type="submit" id="signUpBtn">수정완료</button>
		</form>
	</div>
	<!-- 메인 화면 내용 끝 -->
	<!-- 메인내용 시작 : Text | Text -->
	<section>
	<div data-layout="_r">
		<div data-layout="ch-half">
		</div>
	</div>
	</section>
	<!-- 메인내용 끝 : Text | Text -->

	<!-- 내용 입력 부분 끝 -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>