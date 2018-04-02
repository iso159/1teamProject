<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('#addBtn').click(function(){
        	// 공백들어갈시 팝업창으로 알려줌
        	let adoptRequestReason = $.trim($('#adoptRequestReason').val());
	          if(adoptRequestReason == ""){
	        	  alert('입양이유를 입력해주세요');
	        	  // 텍스트비움
	        	  $('#adoptRequestReason').val('');
	          }else {
	              $('#addForm').submit();
	          }
        });
    });
</script>
	<title>입양신청</title>
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
	    <div data-layout="ch-half" class="span3 well">
	    <!-- 내용 입력 부분 -->
		<h2>입양신청</h2>
			<c:set var="m" value="${mMemberId}"/>
			<form id="addForm" action="${pageContext.request.contextPath}/adopt/adoptRequest" method="post" enctype="multipart/form-data">
				동물코드 <input class="span3" type="text" name="animalCode" value="animal_code_01"><br>
				보호소 <input class="span3" type="text" name="blCode" value="bl_code_01"><br>
				입양이유 <input class="span3" type="text" id="adoptRequestReason" name="adoptRequestReason"><br>
				회원아이디<input class="span3" type="text" name="mMemberId" value="${mMemberId}"><br>
				보호소직원<input class="span3" type="text" name="mShelterId" value="m_02"><br>
				입양상태<input class="span3" type="text" name="osCodeAdopt" value="os_adopt_4_1_1"><br>
				포인트<input class="span3" type="text" name="adoptPoint" value="500"><br>
				파일<input class="span3" type="file" name="file" multiple="multiple"><br>
				<button id="addBtn" type="button"  class="btn btn-warning">입양신청하기</button>
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
	