<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
	<title>설문지 리스트</title>
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
                    <h1 class="page-header">설문지 수정화면</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<form  action="${pageContext.request.contextPath}/survey/surveyModify?surveyCode=${survey.surveyCode}" method="post">
				설문지이름 <input type="text" id="surveyName" name="surveyName" value="${survey.surveyName}"><br>
				포인트 <input type="text" id="surveyPoint" name="surveyPoint" value="${survey.surveyPoint}"><hr>
				<button type="submit" id="surveyBtn" class="btn btn-info">설문지수정완료</button>
			</form>
			<a href="${pageContext.request.contextPath}/survey/surveyList"><button type="button" class="btn info">설문지조회</button></a>
 		 <!-- 내용 입력 부분 끝 -->
		 <!-- 내용 입력 부분 끝 -->
		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>

	