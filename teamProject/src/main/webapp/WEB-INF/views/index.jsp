<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>Home</title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class= "container" >
	<!-- 내용 입력 부분 -->

	<!-- 팀원소개 시작 : Staff 1 -->
	<section>
	  <div data-layout="_r" id="animalList">
		<div data-layout="ch8 ec4">
			<img class="MOD_STAFF_Picture" src="https://unsplash.it/400/400/?random" alt="" data-theme="_is1">
			<p class="MOD_STAFF_Name" data-theme="_bb1">Jane Smith</p>
			<p class="MOD_STAFF_Positon">Position</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>
		<div data-layout="ch8 ec4">
			<img class="MOD_STAFF_Picture" src="https://unsplash.it/400/400/?random" alt="" data-theme="_is1">
			<p class="MOD_STAFF_Name" data-theme="_bb1">Jane Smith</p>
			<p class="MOD_STAFF_Positon">Position</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>
		<div data-layout="ch8 ec4">
			<img class="MOD_STAFF_Picture" src="https://unsplash.it/400/400/?random" alt="" data-theme="_is1">
			<p class="MOD_STAFF_Name" data-theme="_bb1">Jane Smith</p>
			<p class="MOD_STAFF_Positon">Position</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>
		<div data-layout="ch8 ec4">
			<img class="MOD_STAFF_Picture" src="https://unsplash.it/400/400/?random" alt="" data-theme="_is1">
			<p class="MOD_STAFF_Name" data-theme="_bb1">Jane Smith</p>
			<p class="MOD_STAFF_Positon">Position</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>
	  </div>
	</section>
	<!-- 팀원소개 끝 : Staff 1 -->

	<!-- 메인내용 시작 : Text | Text -->
	<section>
	  <div data-layout="_r">
	    <div data-layout="ch-half">
	    
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
