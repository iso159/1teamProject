<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>동물 수정화면</h2>
	<form action="${pageContext.request.contextPath}/animal/animalUpdate" method="post">
		<input type="hidden" name="animalCode" value="${animal.animalCode}">
		품종:<input type="text" name="animalBreed" value="${animal.animalBreed}"><br>
		지역:<input type="text" name="animalArea" value="${animal.animalArea}"><br>
		동물식별코드:<input type="text" name="animalIdCode" value="${animal.animalIdCode}"><br>
		동물몸무게:<input type="text" name="animalWeight" value="${animal.animalWeight}"><br>
		동물나이:<input type="text" name="animalAge" value="${animal.animalAge}">
		<button type="submit">수정 완료</button>
	</form>
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