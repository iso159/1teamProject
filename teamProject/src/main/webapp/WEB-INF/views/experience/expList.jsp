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
	<h1>${loginId}님 신청 리스트</h1>
	<table>
		<thead>
			<tr>
				<td>품종</td>
				<td>신청한날짜</td>
				<td>시작 날짜</td>
				<td>종료 날짜</td>
				<td>체험 상태</td>
				<td>상세 정보</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${expAndAnimal}">
			<tr>
				<td>${e.animal.animalBreed}</td>
				<td>${e.exp.expReserveRequestDate}</td>
				<td>${e.exp.expStartDate}</td>
				<td>${e.exp.expEndDate}</td>
				<td>${e.osName}</td>
				<td><a href="${pageContext.request.contextPath}/experience/expInfo?expCode=${e.exp.expCode}">정보 확인</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>