<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>Home</title>
</head>
<body>
	<div>
		<h1> 기능 </h1>
		<ul class="list-group">
			<li class="list-group-item list-group-item-white">
				<a href="${pageContext.request.contextPath}/member/memberMenu">
					<button type="button" class="btn btn-white">회원</button>
				</a>
			</li>
			<li class="list-group-item list-group-item-info">
				<a href="${pageContext.request.contextPath}/shelter">
					<button type="button" class="btn btn-info">보호소</button>
				</a>
			</li>
			<li class="list-group-item list-group-item-primary">
				<a href="${pageContext.request.contextPath}/exp">
					<button type="button" class="btn btn-primary">체험</button>
				</a>
			</li>
			<li class="list-group-item list-group-item-warning">
				<a href="${pageContext.request.contextPath}/adopt">
					<button type="button" class="btn btn-warning">입양</button>
				</a>
			</li>
			<li class="list-group-item list-group-item-dark">
				<a href="${pageContext.request.contextPath}/animal/animalList">
					<button type="button" class="btn btn-dark">동물</button>
				</a>
			</li>
			<li class="list-group-item list-group-item-danger">
				<a href="${pageContext.request.contextPath}/goods/goodsMenu">
					<button type="button" class="btn btn-danger">상품</button>
				</a>
			</li>
			<li class="list-group-item list-group-item-link">
				<a href="${pageContext.request.contextPath}/survey">
					<button type="button" class="btn btn-link">설문지</button>
				</a>
			</li>
		</ul>
	</div>
</body>
</html>
