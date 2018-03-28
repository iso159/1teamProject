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
				<th>품종</th>
				<th>신청한날짜</th>
				<th>시작 날짜</th>
				<th>종료 날짜</th>
				<th>체험 상태</th>
				<th>상세 정보</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${expAndAnimal}" varStatus="status">
			<c:forEach var="b" items="${a.animal}">
			<c:forEach var="c" items="${a.exp}">
			<c:forEach var="d" items="${a.overallStatus}">
			<tr>
				<td>${b.animalBreed}</td>
				<td>${c.expReserveRequestDate}</td>
				<td>${c.expStartDate}</td>
				<td>${c.expEndDate}</td>
				<td>${d.osName}</td>
				<td><a href="${pageContext.request.contextPath}/experience/expInfo?expCode=${c.expCode}">정보 확인</a></td>
			</tr>
			</c:forEach>
			</c:forEach>
			</c:forEach>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>