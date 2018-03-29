<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 리스트</h2>
	<!-- 검색 기능 시작 -->
	<div> 
		<ul class="nav top-menu">
			<li>
				<form class="navbar-form"
					action="${pageContext.request.contextPath}/member/memberList?rowPerPage=${rowPerPage}" method="get">
					<input class="form-control" name="searchWord" placeholder="Search" type="text">
					<button type="submit" class="btn btn-danger">검색</button>
				</form>
			</li>
		</ul> 
	</div>
	<!-- 검색 기능 끝 -->
	<table border=1 class="table table-striped">
			<thead>
				<tr>
					<th>상품 코드</th>
					<th>상품 이름</th>
					<th>상품 포인트</th>
					<th>상품 등록날짜</th>
					<th>상품 관리자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${list}">
					<tr>
						<td>${m.mId}</td>
						<td>${m.memberInfo.mInfoName}</td>
						<td>${m.memberInfo.mInfoNickname}</td>
						<td>${m.memberInfo.mInfoGender}</td>
						<td>${m.memberInfo.mInfoBirth}</td>
						<td>${m.memberInfo.mInfoPostcode}</td>
						<td>${m.memberInfo.mInfoAddress}</td>
						<td>${m.memberInfo.mInfoEmail}</td>
						<td>${m.memberInfo.mInfoPhone}</td>
						<td>${m.memberInfo.mInfoJoindate}</td>
						<td><a href="${pageContext.request.contextPath}/member/memberModify?mId=${m.mId}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/member/memberRemove?mId=${m.mId}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
</body>
</html>