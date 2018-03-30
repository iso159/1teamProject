<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<h2>유기동물 상세페이지</h2>
	
		동물종류:${animalDetail.osNameAnimalKind}<br>
		품종:${animalDetail.animalBreed}<br>
		지역:${animalDetail.animalArea}<br>
		동물식별코드:${animalDetail.animalIdCode}<br>
		체중:${animalDetail.animalWeight}<br>
		나이:${animalDetail.animalAge}<br>
		보호소이름:${animalDetail.blShelterName}<br>
		등록일자:${animalDetail.animalEnrollDate}<br>
		
		<a href="${pageContext.request.contextPath}/experience/expAdd?animalCode=${animalDetail.animalCode}&blCode=${blCode}">체험신청하기</a><br>
		<a href="${pageContext.request.contextPath}/adopt/adoptRequest?animalCode=${animalDetail.animalCode}">입양신청하기</a><br>
		
	<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success">홈으로</button></a>	
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