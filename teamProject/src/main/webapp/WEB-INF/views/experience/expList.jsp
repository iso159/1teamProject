<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title></title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class= "container" >
		<!-- 내용 입력 부분 -->
		<!-- 메인내용 시작 : Text | Text -->
		<section>
		<div data-layout="_r">
			<div data-layout="ch-half">
				<h1>${loginId}님 신청 리스트</h1>
				<table>
					<thead>
						<tr>
							<th>품종</th>
							<th>신청한날짜</th>
							<th>시작 날짜</th>
							<th>종료 날짜</th>
							<th>체험 상태</th>
							<th>상세 정보</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${expAndAnimal}">
						<tr>
							<td>${a.animal.animalBreed}</td>
							<td>${a.exp.expReserveRequestDate}</td>
							<td>${a.exp.expStartDate}</td>
							<td>${a.exp.expEndDate}</td>
							<td>${a.overallStatus.osName}</td>
							<td><a href="${pageContext.request.contextPath}/experience/expInfo?expCode=${a.exp.expCode}">정보 확인</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
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