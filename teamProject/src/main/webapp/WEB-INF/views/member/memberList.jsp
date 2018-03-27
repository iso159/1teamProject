<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 리스트</h2>
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
					<th>회원 아이디</th>
					<th>회원 이름</th>
					<th>회원 닉네임</th>
					<th>회원 성별</th>
					<th>회원 생년월일</th>
					<th>화원 우편번호</th>
					<th>회원 주소</th>
					<th>회원 이메일</th>
					<th>회원 휴대폰</th>
					<th>회원 가입날짜</th>
					<th>수정</th>
					<th>삭제</th>
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