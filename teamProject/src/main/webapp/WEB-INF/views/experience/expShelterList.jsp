<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<title></title>
</head>
<body>
	<table>
		<thead>
			<tr>
			<td>회원 아이디</td>
			<td>확인자 아이디</td>
			<td>체험 상태</td>
			<td>체험 신청 날짜</td>
			<td>상세정보</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${exp}">
			<tr>
			<td>${e.mExpId}</td>
			<td>${e.mShelterId}</td>
			<td>${e.osName}</td>
			<td>${e.expReserveRequestDate}</td>
			<td><a href="${pageContext.request.contextPath}/experience/expShelterInfo?expCode=${e.expCode}">상세정보</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>