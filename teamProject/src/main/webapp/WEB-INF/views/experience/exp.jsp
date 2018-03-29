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
	<c:if test="${empty member.blCode}">
	<a href="${pageContext.request.contextPath}/experience/expAdd?animalCode=animal_code_01&blCode=bl_code_01">체험 등록</a>
	<br>
	<a href="${pageContext.request.contextPath}/experience/expList">자기 체험리스트</a>
	</c:if>
	<c:if test="${!empty member.blCode}">
	<a href="${pageContext.request.contextPath}/experience/expShelterList?blCode=${member.blCode}">보호소 체험 리스트</a>
	</c:if>
</body>
</html>