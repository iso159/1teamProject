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
        $('#addBtn').click(function(){
        	// 공백들어갈시 팝업창으로 알려줌
        	let adoptRequestAdviceContents = $.trim($('#adoptRequestAdviceContents').val());
	          if(adoptRequestAdviceContents == ""){
	        	  alert('모든질문에 답을 입력해주세요');
	        	  // 텍스트비움
	        	  $('#adoptRequestAdviceContents').val('');
	          }else {
	              $('#addForm').submit();
	          }
        });
    });
</script>

	<title>상담 내용</title>
</head>
<body>
	<h2>상담내용입력</h2>
	<h5>상담내용</h5>
	<c:set var="aRC" value="${adoptRequestCode}"/>
	<form id="addForm" action="${pageContext.request.contextPath}/adopt/adoptCounsel?adoptRequestCode=${adoptRequestCode}" method="post">
		<c:forEach var="surveyQuestion" items="${list}">
				<tr>
					<td>${surveyQuestion.surveyListQuestion}</td><br>
					<td><input	type="textarea" cols="100" size="100"
								id="adoptRequestAdviceContents"
								name="adoptRequestAdviceContents"></td><br>
				</tr>
		</c:forEach>
		<button id="addBtn" type="button" class="btn btn-info">상담완료</button>
	</form>
	
</body>
</html>