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
<script>
    $(document).ready(function(){
        $('#surveyBtn').click(function(){
        	// 공백들어갈시 팝업창으로 알려줌
        	let surveyName = $.trim($('#surveyName').val());
        	let surveyPoint = $.trim($('#surveyPoint').val());
	          if(surveyName == "" ||surveyPoint == ""){
	        	  alert('입력되지 않은 사항이 있습니다. 모두 입력해주세요');
	        	  // 텍스트비움
	        	  $('#surveyName').val('');
	        	  $('#surveyPoint').val('');
	          }else {
	              $('#formSurveySubmit').submit();
	          }
        });
    });
</script>
	
	<title>설문지</title>
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
		<h2>설문지 등록 </h2>
			<form  id="formSurveySubmit" name="actionTag" action="${pageContext.request.contextPath}/survey/surveyAdd" method="post">
				설문지이름 <input type="text" id="surveyName" name="surveyName"><br>
				포인트	<input type="text" id="surveyPoint" name="surveyPoint"><hr>
				<button type="button" id="surveyBtn" class="btn btn-info">설문지 등록</button>
			</form>
			
		<h2>설문지 리스트 </h2>	
			<table border="1">
				<thead>
					<tr>
						<th>설문지코드</th>
						<th>관리자아이디</th>
						<th>설문지이름</th>
						<th>설문지포인트</th>
						<th>등록날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="survey" items="${list}">
					<tr>
						<td>${survey.surveyCode}</td>
						<td>${survey.mAdminId}</td>
						<td>
							<a href="${pageContext.request.contextPath}/survey/surveyQuestionAdd?surveyCode=${survey.surveyCode}">${survey.surveyName}</a>
						</td>
						<td>${survey.surveyPoint}</td>
						<td>${survey.surveyEnrollDate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
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
	