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

	</section>
	<!-- 메인내용 끝 : Text | Text -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->

	<table border=1 class="table table-striped">
		<c:set var="right" value="${rightName}"></c:set>
		<thead>
			<tr>
				<th>상품 코드</th>
				<th>관리자 아이디</th>
				<th>상품 이름</th>
				<th>상품 포인트</th>
				<th>상품 설명</th>
				<th>상품 삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="g" items="${list}">
				<tr>
					<td>${g.pointGoodsCode}</td>
					<td>${g.mAdminId}</td>
					<td>${g.pointGoodsName}</td>
					<td>${g.pointGoodsPoint}</td>
					<td>${g.pointGoodsDesc}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp" />
	<!-- foot 부분 끝 -->
</body>
</html>