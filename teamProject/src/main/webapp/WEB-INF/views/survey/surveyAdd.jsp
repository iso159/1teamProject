<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>	
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
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인화면 시작 -->
        <div id="page-wrapper">
        	<!-- h태그제목 시작 -->
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">설문지 등록</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<form  id="formSurveySubmit" name="actionTag" action="${pageContext.request.contextPath}/survey/surveyAdd" method="post">
				설문지이름 <input type="text" id="surveyName" name="surveyName" class="form-control"><br>
				포인트	<input type="text" id="surveyPoint" name="surveyPoint" class="form-control"><hr>
				<button type="button" id="surveyBtn" class="btn btn-info">설문지 등록</button>
			</form>
			
			<!-- h태그제목 시작 -->
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">설문지 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
          	
			<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
			<!-- 테이블 이름 시작 -->
			<div class="panel-heading">설문지 리스트</div>
			<!-- 테이블 이름 끝 -->
			<div class="panel-body">
				<div class="row">
				<div class="col-sm-8">
				<div class="dataTables_length" id="dataTables-example_length">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
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
			</div>
		</div>
		</div>
		</div>
		<!-- 내용 입력 부분 끝 -->
		</div>
	 
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
	