<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                    <h1 class="page-header">설문지 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
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
				<div class="table-responsive">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>설문지코드</th>
						<th>관리자아이디</th>
						<th>설문지이름</th>
						<th>설문지포인트</th>
						<th>등록날짜</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="survey" items="${list}">
					<c:out value="${fn:replace(aR.adoptRequestAdviceContents, ',', '<br/>')}"/>
					<tr>
						<td>${survey.surveyCode}</td>
						<td>${survey.mAdminId}</td>
						<td>
							<a href="${pageContext.request.contextPath}/survey/surveyQuestionAdd?surveyCode=${survey.surveyCode}">${survey.surveyName}</a>
						</td>
						<td>${survey.surveyPoint}</td>
						<td>${survey.surveyEnrollDate}</td>
						<td>
							<a href="${pageContext.request.contextPath}/survey/surveyModify?surveyCode=${survey.surveyCode}">수정</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/survey/surveyDelete?surveyCode=${survey.surveyCode}">삭제</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="${pageContext.request.contextPath}/"><button type="button" class="btn warning">홈으로</button></a>
	 		</div>
	 		</div>
		</div>
		</div>
		</div>
	 		<!-- 내용 입력 부분 끝 -->
		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>

	