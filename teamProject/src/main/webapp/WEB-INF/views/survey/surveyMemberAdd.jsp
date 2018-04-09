<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>

</script>
	<title>입양리스트</title>
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
                    <h1 class="page-header">체험 설문조사 </h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<form action="${pageContext.request.contextPath}/survey/surveyMemberAdd" method="post">
			<div class="form-group">
			<c:forEach var="surveyList" items="${list}">
                <label>Question</label>
                <p class="help-block" 
                		id="surveyListCode"
                		name="surveyListCode" 
                		value="${surveyList.surveyListCode}"></p>
                ${surveyList.surveyListQuestion}<br>
                <input
                		type="checkbox" 
						value="survey_record_1_5"
						id="surveyRecordCode"
						name="surveyRecordCode">매우그렇다
				<input
                		type="checkbox" 
						value="survey_record_2_4"
						id="surveyRecordCode"
						name="surveyRecordCode">그렇다
				<input 
                		type="checkbox" 
						value="survey_record_3_3"
						id="surveyRecordCode"
						name="surveyRecordCode">보통이다
				<input 
                		type="checkbox" 
						value="survey_record_4_2"
						id="surveyRecordCode"
						name="surveyRecordCode">그렇지않다
				<input 
                		type="checkbox" 
						value="survey_record_5_1"
						id="surveyRecordCode"
						name="surveyRecordCode">매우그렇지않다<hr>
            </c:forEach>
            </div>
            <button type="submit" id="MSBtn" class="btn btn-primary">제출하기</button>
			</form>
			
			<!-- 내용 부분 끝-->
			
	
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
			