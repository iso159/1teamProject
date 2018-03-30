<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<title>????</title>
</head>
<body>
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
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
	<!-- 메인 화면 내용 끝 -->
</body>
</html>