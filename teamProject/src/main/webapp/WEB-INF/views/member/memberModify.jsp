<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<title>회원수정</title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
		<h1 class="page-header">회원수정</h1>
		<div class="col-lg-4">
		<form role="form" id="modifyForm" action="${pageContext.request.contextPath}/member/memberModify" method="post" enctype="multipart/form-data">
			 
				아이디<input class="form-control" type="text"  name="mId" value="${loginId}" readonly="readonly"><br>
					비밀번호
					<input class="form-control" type="password" name="mPw"><br>
					이름
					<input class="form-control" type="text" name="mInfoName" value="${MemberInfo.mInfoName}"><br>
					닉네임
					<input class="form-control" type="text" name="mInfoNickname" value="${MemberInfo.mInfoNickname}"><br>
					성별
					<input class="form-control" type="text" name="mInfoGender" value="${MemberInfo.mInfoGender}"><br>
					생년월일
					<input class="form-control" type="text" name="mInfoBirth" value="${MemberInfo.mInfoBirth}"><br>
					우편번호
					<input class="form-control" type="text" name="mInfoPostcode" value="${MemberInfo.mInfoPostcode}"><br>
					주소
					<input class="form-control" type="text" name="mInfoAddress" value="${MemberInfo.mInfoAddress}"><br>
					이메일
					<input class="form-control" type="text" name="mInfoEmail" value="${MemberInfo.mInfoEmail}"><br>
					핸드폰
					<input class="form-control" type="text" name="mInfoPhone" value="${MemberInfo.mInfoPhone}"><br>
			<button id="modifyBtn" type="submit" class="btn btn-warning">수정완료</button>
		</form>
		</div>
	</div>
	<!-- 메인 화면 내용 끝 -->
	<!-- 내용 입력 부분 끝 -->
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>