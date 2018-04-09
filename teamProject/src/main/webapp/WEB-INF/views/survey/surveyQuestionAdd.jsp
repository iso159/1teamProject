<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
		$(function() {
		     $('#surveyQBtn').click(function(){
		    	 $('#frmTest').submit();
		     });
		});

</script>

</script>
	<title>설문지내용</title>
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
                    <h1 class="page-header">설문지 질문 등록</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<c:set var="surveyCode" value="${surveyCode}"/>
			<form id="frmTest" action="${pageContext.request.contextPath}/survey/surveyQuestionAdd" method="post" >
					<table id="surveyQuestionTable" border="1" style="width:500px;">
					    <tr>
					        <td><input type="text" id="surveyCode" name="surveyCode" value="${surveyCode}" readonly/></td>
					        <td>
					        	<input 	type="text" id="surveyListQuestion" 
					        			name="surveyListQuestion" 
					        			placeholder="질문내용">
					        </td>
					        <td><button type="button" id="surveyQBtn">설문지 질문등록</button></td>
					    </tr>
					</table>
					<a href="${pageContext.request.contextPath}/survey/surveyList"><button type="button" class="btn info">설문지조회</button></a>
				</form>
			
	
			<!-- h태그제목 시작 -->
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">등록된 설문지 질문 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<table border="1">
				<thead>
					<tr>
						<th>설문지코드</th>
						<th>질문 내용</th>
						<th>등록날짜</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="surveyList" items="${list}">
					<tr>
						<td>${surveyList.surveyCode}</td>
						<td>${surveyList.surveyListQuestion}</td>
						<td>
							${surveyList.surveyListDate}
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/survey/surveyQuestionDelete?surveyListCode=${surveyList.surveyListCode}&surveyCode=${surveyList.surveyCode}">삭제</a>
						</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
 		<!-- 내용 입력 부분 끝 -->
		 <!-- 내용 입력 부분 끝 -->
		
		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>

	