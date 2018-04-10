<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>진료 신청</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
	<!-- 내용 입력 부분 -->
	<!-- 메인내용 시작 : Text | Text -->
	<section>
	  <div data-layout="_r">
	    <div data-layout="ch-half">
	<h1>사후 진료 신청</h1>
	<form id="businessLicenseRequestForm"
		  enctype="multipart/form-data"
		  action="${pageContext.request.contextPath}/shelter/shelterClinicRequest" method="post">
		<table>
			<tr>
				<td>보호소 명</td>
				<td><input type="text" name="blShelterName" id="shelterName" value="${c.blShelterName}"></td>
			</tr>
			<tr>
				<td>진료 코드</td>
				<td><input type="text" name="scCode" id="scCode" value="${c.scCode}"></td>
			</tr>
			<tr>
				<td>보호소 아아디</td>
				<td><input type="text" name="mShelterId" id="shelterId" value="${c.mShelterId}"></td>
			</tr>
			<tr>
				<td>입양자 아이디</td>
				<td><input type="text" name="mId" id="mId" value="${c.mId}"></td>
			</tr>
			<tr>
				<td>진료 종류</td>
				<td><input type="text" name="osCodeClinicKind" id="CodeClinicKind" value="${c.osCodeClinicKind}"></td>
			</tr>
			<tr>
				<td>진료 상태</td>
				<td><input type="text" name="osCodeClinicStatus" id="codeClinicStatus" value="${c.osCodeClinicStatus}"></td>
			</tr>
			<tr>
				<td>진료 날짜</td>
				<td><input type="text" name="scDate" id="scDate" value="${c.scDate}"></td>
			</tr>
			<tr>
				<td>진료 예약 날짜</td>
				<td><input type="text" name="scReserveDate" id="ReserveDate" value="${c.scReserveDate}"></td>
			</tr>
		</table>
		<button type="button" id="shelterInsertBtn">진료 신청</button>
	</form>
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
