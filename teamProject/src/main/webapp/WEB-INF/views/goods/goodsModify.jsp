<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>????</title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 시작 -->
	<div class= "container" >
	<!-- 메인 화면  -->
	<div class="container">
		<h2>상품수정</h2>
		<form id="signUpForm" class="form-inline" action="${pageContext.request.contextPath}/goods/goodsModify" method="post">
			<table>
				<tr>
					<td>상품 이름</td>
					<td><input type="text" name="pointGoodsName" value="${pointGoodsName}"></td>
				</tr>
				<tr>
					<td>상품 포인트</td>
					<td><input type="text" name="pointGoodsPoint" value="${pointGoodsPoint}"></td>
				</tr>
				<tr>
					<td>상품 설명</td>
					<td><input type="text" name="pointGoodsDesc" value="${pointGoodsDesc}"></td>
				</tr>
			</table>
			<button type="submit" id="signUpBtn">수정완료</button>
		</form>
	</div>
	</div>
	<!-- 메인 화면 내용 끝 -->
		<section>
	<div data-layout="_r">
		<div data-layout="ch-half">
		</div>
	</div>
	</section>
	<!-- 메인내용 끝 : Text | Text -->

	<!-- 내용 입력 부분 끝 -->
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>