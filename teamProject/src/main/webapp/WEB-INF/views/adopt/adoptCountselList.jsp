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

	<title>회원상담내용 리스트</title>
</head>
<body>
<div class="container">
	<h2>회원상담내용 리스트</h2>
	<table border="1">
		<thead>
			<tr>
				<th>상담내용</th>
			</tr>
		</thead>	
		<tbody>
		<c:set var="aR" value="${adoptRequest}"/>
			<tr>
				<td>
					${aR.adoptRequestAdviceContents}
				</td><br>
			</tr>
		</tbody>
	</table><br>
	<a href="${pageContext.request.contextPath}/adopt/adoptDecide?adoptRequestCode=${aR.adoptRequestCode}"><button type="submit" class="btn danger">입양결정!</button></a>
	<a href="${pageContext.request.contextPath}/adopt/adoptList"><button type="button" class="btn warning">분양리스트로</button></a><br><br>
</div>
</body>
</html>