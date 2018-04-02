<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp" />
	<!-- top 부분 끝-->

	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
		<!-- 메인내용 시작 : Text | Text -->
		<section>
		<div data-layout="_r">
			<div>
				<h2>상품 상세 정보</h2>
				<table border=1 class="table table-striped">
					<thead>
						<tr>
							<th>상품 코드</th>
							<th>관리자 아이디</th>
							<th>상품 이름</th>
							<th>상품 포인트</th>
							<th>상품 설명</th>
							<th>상품 등록날짜</th>
							<th>장바구니에 담기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${goodsDetail.pointGoodsCode}</td>
							<td>${goodsDetail.mAdminId}</td>
							<td>${goodsDetail.pointGoodsName}</td>
							<td>${goodsDetail.pointGoodsPoint}</td>
							<td>${goodsDetail.pointGoodsDesc}</td>
							<td>${goodsDetail.pointGoodsDate}</td>
							<td><a href="${pageContext.request.contextPath}/goods/goodsRemove?pointGoodsCode=${g.pointGoodsCode}">삭제</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		</section>
		<!-- 메인내용 끝 : Text | Text -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->

	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp" />
	<!-- foot 부분 끝 -->
</body>
</html>