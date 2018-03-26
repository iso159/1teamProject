<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	<title>보호소 대표 신청 거절 </title>
</head>
<body>
	<div>
		<h1>보호소 대표 신청 거절 폼</h1>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/shelter/businessLicenseDeny" method="POST">
			<input type="hidden" name="blCode" value="${blCode}">
			<table>
				<tr>
					<td><textarea rows="10" cols="100" name="blShelterDenyReason"></textarea></td>
				<tr>
				<tr>
					<td style="text-align: right"><button type="submit">거절 사유 등록</button></td>
				<tr>
			</table>
		</form>
	</div>
</body>
</html>