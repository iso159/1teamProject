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
	<title>설문지 리스트</title>
</head>
<body>
	<h2>설문지 리스트</h2>
	<table border="1">
		<thead>
			<tr>
				<th>설문지코드</th>
				<th>관리자아이디</th>
				<th>설문지이름</th>
				<th>설문지포인트</th>
				<th>등록날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="survey" items="${list}">
			<tr>
				<td>${survey.surveyCode}</td>
				<td>${survey.mAdminId}</td>
				<td>
					<a href="${pageContext.request.contextPath}/survey/surveyQuestionList?surveyCode=${survey.surveyCode}">${survey.surveyName}</a>
				</td>
				<td>${survey.surveyPoint}</td>
				<td>${survey.surveyEnrollDate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		<a href="${pageContext.request.contextPath}/"><button type="button" class="btn warning">홈으로</button></a>
</body>
</html>