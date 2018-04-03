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
	<title>보호소 등록증 파일 리스트</title>
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
			<c:set var="m" value="${memberIdAndBusinessLicenseFile}"></c:set>
			<h1>${m.mMemberId}님의 보호소 등록증 파일 리스트</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>파일 코드</th>
						<th>파일 명</th>
						<th>파일 사이즈</th>
						<th>등록 일자</th>
						<th>다운 로드</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="blf" items="${m.businessLicenseFileList}">
						<tr>
							<td>${blf.ofCode}</td>
							<td>${blf.ofOriginName}.${blf.ofExt}</td>
							<td>${blf.ofSize}</td>
							<td>${blf.ofDate}</td>
							<td>
								<a href="${pageContext.request.contextPath}/shelter/businessLicenseFileDownload?fileName=${blf.ofSaveName}&fileExt=${blf.ofExt}&ofOriginName=${blf.ofOriginName}">다운 로드</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table><br>
			<a href="${pageContext.request.contextPath}/businessLicenseRequestList"><button type="button">보호소 대표 신청 목록으로</button></a>
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