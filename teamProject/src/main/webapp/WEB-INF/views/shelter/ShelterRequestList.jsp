<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>보호소 직원 신청 리스트</title>
</head>
<body>
	<h1>보호소 직원 신청 리스트</h1>
		<table border="1">
			<thead>
				<tr>
					<th>회원 아이디</th>
					<th>신청 상태</th>
					<th>신청 날짜</th>
					<th>결정 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${list}">
					<tr>
						<td>${c.shelterStaffRequest.mId}</td>
						<td>${c.shelterStaffRequest.osCodeStaffRequest}</td>
						<td>${c.shelterStaffRequest.ssrRequestDate}</td>
						<td>${c.shelterStaffRequest.ssrClearDate}</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
</body>
</html>