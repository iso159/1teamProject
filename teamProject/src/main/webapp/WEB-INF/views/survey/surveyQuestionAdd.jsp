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
		$(function() {
		     $('#surveyQBtn').click(function(){
		    	 $('#frmTest').submit();
		     });
		});

</script>

</script>
	<title>설문지내용</title>
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
		<h2>설문지 질문 등록</h2>
		<c:set var="surveyCode" value="${surveyCode}"/>
		<form id="frmTest" action="${pageContext.request.contextPath}/survey/surveyQuestionAdd" method="post" >
				<table id="surveyQuestionTable" border="1" style="width:500px;">
				    <tr>
				        <td><input type="text" id="surveyCode" name="surveyCode" value="${surveyCode}" readonly/></td>
				        <td>
				        	<input 	type="text" id="surveyListQuestion" 
				        			name="surveyListQuestion" 
				        			placeholder="질문내용"
				        			cols="100" size="100"/>
				        </td>
				        <td style="width:50px;"></td>
				    </tr>
				</table>
				<button type="button" id="surveyQBtn">설문지 질문등록</button>
				<a href="${pageContext.request.contextPath}/survey/surveyList"><button type="button" class="btn info">설문지조회</button></a>
			</form>
			
	
		<h2>등록된 질문 리스트 </h2>	
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
	