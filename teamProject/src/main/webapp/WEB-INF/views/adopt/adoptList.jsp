<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<title>입양리스트</title>
</head>
<body>
	<h2>입양 리스트</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>입양코드</th>
				<th>동물코드</th>
				<th>보호소코드</th>
				<th>회원아이디</th>
				<th>입양상태코드</th>
				<th>입양이유</th>
				<th>입양신청날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aR" items="${list}">
			<tr>
				<td>${aR.adoptRequestCode}</td>
				<td>${aR.animalCode}</td>
				<td>${aR.blCode}</td>
				<td>${aR.mMemberId}</td>
				<td>${aR.osCodeAdopt}</td>
				<td>${aR.adoptRequestReason}</td>
				<td>${aR.adoptRequestDate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success">홈으로</button></a>
</body>
</html>