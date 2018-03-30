<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#shelterInsertBtn').click(function(){
			// 폼의 값들에 공백을 지움
			let shelterName = $.trim($('#shelterName').val());
			let shelterNum = $.trim($('#shelterNum').val());
			let shelterPost = $.trim($('#shelterPost').val());
			let shelterAddr = $.trim($('#shelterAddr').val());
			
			// 공백 유효성 검사
			if(shelterName==="" | shelterNum==="" | shelterPost==="" | shelterAddr===""){
				alert("공백은 입력할 수 없습니다.");
			}else{
				$('#businessLicenseRequestForm').submit();
			}
		});
	});
</script>
	<title>보호소 신청</title>
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
	<h1>대표 보호소 신청</h1>
	<form id="businessLicenseRequestForm"
		  enctype="multipart/form-data"
		  action="${pageContext.request.contextPath}/shelter/businessLicenseRequest"
		  method="post">
		<table>
			<tr>
				<td>보호소 명</td>
				<td><input type="text" name="blShelterName" id="shelterName"></td>
			</tr>
			<tr>
				<td>보호소 전화번호</td>
				<td><input type="text" name="blShelterNumber" id="shelterNum"></td>
			</tr>
			<tr>
				<td>보호소 우편번호</td>
				<td><input type="text" name="blShelterPostcode" id="shelterPost"></td>
			</tr>
			<tr>
				<td>보호소 주소</td>
				<td><input type="text" name="blShelterAddress" id="shelterAddr"></td>
			</tr>
			<tr>
				<td>사업자 등록증 파일</td>
				<td><input type="file" name="multipartFile" id="shelterFile" multiple="multiple"></td>
			</tr>
		</table>
		<button type="button" id="shelterInsertBtn">대표 보호소 신청</button>
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
