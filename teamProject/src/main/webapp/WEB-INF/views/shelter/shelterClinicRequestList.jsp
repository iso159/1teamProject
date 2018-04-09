<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>직원 신청 보호소 리스트</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
	<!-- 메인내용 시작 : Text | Text -->
	<section>
	  <div data-layout="_r">
	    <div>
	    <!-- 내용 입력 부분 -->
	<div>
		<h1>진료 신청 리스트</h1>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>보호소 아이디</th>
					<th>입양자 아이디</th>
					<th>진료 상태</th>
					<th>보호소 진료 날짜</th>
					<th>보호소 잔료 요청 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sc" items="${list}">
					<tr>
						<td>${sc.mShelterId}</td>
						<td>${sc.mAdoptId}</td>
						<td>${sc.osCodeClinicKind}</td>
						<td>${sc.scDate}</td>
						<td>${sc.scReserveDate}</td>
						<td>
							<button type="button">Look!!</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	    <!-- 내용 입력 부분 끝 -->
		</div>
	  </div>
	</section>
	<!-- 메인내용 끝 : Text | Text -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>