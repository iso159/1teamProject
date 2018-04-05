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
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인화면 시작 -->
        <div id="page-wrapper">
        	<!-- h태그제목 시작 -->
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">상담내용</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작--> 
	    	<c:set var="aRC" value="${adoptRequestCode}"/>
	        <form id="addForm" role="form-control" action="${pageContext.request.contextPath}/adopt/adoptCounsel?adoptRequestCode=${adoptRequestCode}" method="post">
	        <br style="clear:both">
	    				<c:forEach var="surveyQuestion" items="${list}">
	    				<div class="form-group">
							<input  type="textarea" 
									class="form-control"
									value="<br>${surveyQuestion.surveyListQuestion}<br>"
									id="adoptRequestAdviceContents"
									name="adoptRequestAdviceContents" readonly>
						</div>
						<div class="form-group">
							<input 	type="text" 
									class="form-control" 
									placeholder="질문에 답해주세요" 
									id="adoptRequestAdviceContents"
									name="adoptRequestAdviceContents">
						</div>
			</c:forEach>
			<button id="addBtn" type="button" class="btn btn-primary pull-right">상담완료</button>			
	        </form>
    
    
    <!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
    