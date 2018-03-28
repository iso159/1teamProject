<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>보호소 직원 신청 상세 정보</title>
</head>
<body>
	<div>
		<h1>보호소 직원 신청 상세 정보</h1>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>신청자 아이디</th>
					<th>신청자 이름</th>
					<th>신청자 성별</th>
					<th>신청자 생년월일</th>
					<th>신청자 우편 번호</th>
					<th>신청자 주소</th>
					<th>신청자 이메일</th>
					<th>신청자 전화번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${mId}</td>
					<td>${memberInfo.mInfoName}</td>
					<td>${memberInfo.mInfoGender}</td>
					<td>${memberInfo.mInfoBirth}</td>
					<td>${memberInfo.mInfoPostcode}</td>
					<td>${memberInfo.mInfoAddress}</td>
					<td>${memberInfo.mInfoEmail}</td>
					<td>${memberInfo.mInfoPhone}</td>
				</tr>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/shelter/requestShelterStaffList">
			<button type="button">직원 요청 리스트</button>
		</a>
	</div>
</body>
</html>