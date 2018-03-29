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
	<title>보호소 메인</title>
</head>
<body>
	<h1>보호소 기능</h1>
	<ul class="list-group">
		<li class="list-group-item list-group-item-primary">
			<a href="${pageContext.request.contextPath}/shelter/businessLicenseRequest">
				<button type="button" class="btn btn-danger">대표 보호소 신청</button>
			</a>
		</li>
		<li class="list-group-item list-group-item-primary">
			<a href="${pageContext.request.contextPath}/businessLicenseList">
				<button type="button" class="btn btn-info">대표 보호소 신청 리스트</button>
			</a>
		</li>
		<li class="list-group-item list-group-item-primary">
			<a href="${pageContext.request.contextPath}/businessLicenseListPersonal">
				<button type="button" class="btn btn-danger">대표 보호소 신청 개인 조회</button>
			</a>
		</li>
		<li class="list-group-item list-group-item-primary">
			<a href="${pageContext.request.contextPath}/shelter/staffBusinessLicenseGet">
				<button type="button" class="btn btn-info">직원 신청 보호소 리스트</button>
			</a>
		</li>
		<li class="list-group-item list-group-item-primary">
			<a href="${pageContext.request.contextPath}/shelter/requestShelterStaffList">
				<button type="button" class="btn btn-success">직원 신청 리스트</button>
			</a>
		</li>
		<li class="list-group-item list-group-item-primary">
			<a href="${pageContext.request.contextPath}/shelter/requestShelterStaffPersonal">
				<button type="button" class="btn btn-danger">직원 신청 개인 조회</button>
			</a>
		</li>
	</ul>
</body>
</html>