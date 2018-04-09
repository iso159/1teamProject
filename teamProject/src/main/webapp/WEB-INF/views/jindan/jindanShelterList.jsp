<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>동물 진단 예약 보호소 목록</title>
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
	    <h1>동물 진료 예약 보호소 목록</h1>
	    <table border="1">
			<thead>
				<tr>
					<th>보호소 명</th>
					<th>보호소 전화번호</th>
					<th>보호소 우편번호</th>
					<th>보호소 주소</th>
					<th>사후관리 진료 예약</th>
					<th>일반 진료 예약</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${list}">
					<tr>
						<td>${c.blShelterName}</td>
						<td>${c.blShelterNumber}</td>
						<td>${c.blShelterRegNumber}</td>
						<td>${c.blShelterAddress}</td>
						<td>
							<a href="${pageContext.request.contextPath}/shelter/shelterClinicRequest?blShelterName=${c.blShelterName}">
								진료 예약
							</a>
						</td>
						<td>
							<a href="#">
								진료 예약
							</a>
						</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
	    
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
	