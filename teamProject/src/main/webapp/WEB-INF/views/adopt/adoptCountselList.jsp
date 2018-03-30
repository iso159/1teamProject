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

	<title>회원상담내용 리스트</title>
</head>
<body>
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
		<h2>회원상담내용 리스트</h2>
		<table border="1">
			<thead>
				<tr>
					<th>상담내용</th>
				</tr>
			</thead>	
			<tbody>
			<c:set var="aR" value="${adoptRequest}"/>
				<tr>
					<td>
						${aR.adoptRequestAdviceContents}
					</td><br>
				</tr>
			</tbody>
		</table><br>
			<a href="${pageContext.request.contextPath}/adopt/adoptDecide?adoptRequestCode=${aR.adoptRequestCode}&animalCode=${aR.animalCode}"><button type="submit" class="btn danger">입양결정!</button></a>
			<a href="${pageContext.request.contextPath}/adopt/adoptList"><button type="button" class="btn warning">분양리스트로</button></a><br><br>
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