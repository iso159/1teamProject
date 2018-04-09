<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>회원가입</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<section>
	  <div data-layout="_r">
	    <div>
	    	<!-- 내용 입력 부분 -->
			<div class="container">
				<div>
					<h2>회원가입</h2>
				</div>
				<div>
					<form id="signUpForm" action="${pageContext.request.contextPath}/member/memberAdd" method="post">
						<table>
							<tr>
								<td>아이디</td>
								<td><input type="text" name="mId"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="mPw"></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" name="mInfoName"></td>
							</tr>
							<tr>
								<td>닉네임</td>
								<td><input type="text" name="mInfoNickname"></td>
							</tr>
							<tr>
								<td>성별</td>
								<td><input type="text" name="mInfoGender"></td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td><input type="text" name="mInfoBirth"></td>
							</tr>
							<tr>
								<td>우편번호</td>
								<td><input type="text" name="mInfoPostcode"></td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input type="text" name="mInfoAddress"></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="mInfoEmail"></td>
							</tr>
							<tr>
								<td>핸드폰</td>
								<td><input type="text" name="mInfoPhone"></td>
							</tr>
						</table>
						<button type="submit" id="signUpBtn">회원가입</button>
					</form>
				</div>
			</div>
			<!-- 내용 입력 부분 끝 -->
		</div>
	  </div>
	</section>
	<!-- 메인 화면 내용 끝 -->
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>