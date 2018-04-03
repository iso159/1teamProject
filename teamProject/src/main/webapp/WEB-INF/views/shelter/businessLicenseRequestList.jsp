<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<title>보호소 대표 신청 리스트</title>
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
	    <!-- 내용 입력 부분 -->
	<div>
		<h1>보호소 대표 신청 리스트</h1>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>보호소 대표 신청 코드</th>
					<th>보호소 대표 회원 아이디</th>
					<th>신청 상태</th>
					<th>보호소 명</th>
					<th>보호소 전화번호</th>
					<th>보호소 등록번호</th>
					<th>보호소 주소</th>
					<th>보호소 대표 신청 날짜</th>
					<th>보호소 등록증 확인</th>
					<th>거절 사유</th>
					<th>등록 결정</th>
					<th>등록 거절</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bl" items="${list}">
					<tr>
						<c:set var="osCode" value="${bl.osCodeLicenseStatus}"></c:set>
						<td>${bl.blCode}</td>
						<td>${bl.mMemberId}</td>
						<td>${bl.osCodeLicenseStatus}</td>
						<td>${bl.blShelterName}</td>
						<td>${bl.blShelterNumber}</td>
						<td>${bl.blShelterRegNumber}</td>
						<td>${bl.blShelterAddress}</td>
						<td>${bl.blShelterDate}</td>
						<td><a href="${pageContext.request.contextPath}/shelter/fileList?blCode=${bl.blCode}">보호소 등록증 확인</a></td>
						<td>${bl.blShelterDenyReason}</td>
						<td>
							<c:if test="${osCode eq '신청확인'}">
								<a href="${pageContext.request.contextPath}/shelter/businessLicenseSet?blCode=${bl.blCode}&mMemberId=${bl.mMemberId}">등록 결정</a>
							</c:if>
						</td>
						<td>
							<c:if test="${osCode eq '신청확인'}">
								<a href="${pageContext.request.contextPath}/shelter/businessLicenseDeny?blCode=${bl.blCode}">등록 거부</a>
							</c:if>
						</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
  <!-- 내용 입력 부분 끝 -->
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