<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Insert title here</title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
		<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class= "container" >
	<h2>상품 리스트</h2>
	<!-- 내용 입력 부분 -->
	<!-- 검색 기능 시작 -->
	<div> 
		<ul class="nav top-menu">
			<li>
				<form class="navbar-form" action="${pageContext.request.contextPath}/index?rowPerPage=${rowPerPage}" method="get">
					<input class="form-control" name="searchWord" placeholder="Search" type="text">
					<button type="submit" class="btn btn-danger">검색</button>
				</form>
			</li>
		</ul> 
	</div>
	<!-- 검색 기능 끝 -->
	<table border=1 class="table table-striped">
		<c:set var="right" value="${rightName}"></c:set>
			<thead>
				<tr>
					<th>상품 코드</th>
					<th>관리자 아이디</th>
					<th>상품 이름</th>
					<th>상품 포인트</th>
					<th>상품 설명</th>
					<th>상품 등록날짜</th>
					<c:if test="${right eq '관리자'}">
					<th>상품 수정</th>
					<th>상품 삭제</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="g" items="${list}">
					<tr>
						<td>${g.pointGoodsCode}</td>
						<td>${g.mAdminId}</td>
						<td><a href="${pageContext.request.contextPath}/goods/goodsDetail?pointGoodsCode=${g.pointGoodsCode}">${g.pointGoodsName}</a></td>
						<td>${g.pointGoodsPoint}</td>
						<td>${g.pointGoodsDesc}</td>
						<td>${g.pointGoodsDate}</td>
						<c:if test="${right eq '관리자'}">
						<td><a href="${pageContext.request.contextPath}/goods/goodsModify?pointGoodsCode=${g.pointGoodsCode}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/goods/goodsRemove?pointGoodsCode=${g.pointGoodsCode}">삭제</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 메인내용 시작 : Text | Text -->
	<section>
	<div data-layout="_r">
		<div data-layout="ch-half">
		</div>
	</div>
	</section>
	<!-- 메인내용 끝 : Text | Text -->

	<!-- 내용 입력 부분 끝 -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>