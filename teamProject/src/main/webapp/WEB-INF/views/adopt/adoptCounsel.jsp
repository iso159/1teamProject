<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>

<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
$('#addBtn').click(function(){
	$("input[type='checkbox'].adoptRequestAdviceContents").change(function(){
		var a = $("input[type='checkbox'].adoptRequestAdviceContents");
		if(a.length == a.filter(":checked").length){
			$('#addForm').submit();
		}else{
			alert('모두 체크해주세요');
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
									value="${surveyQuestion.surveyListQuestion}"
									id="adoptRequestAdviceContents"
									name="adoptRequestAdviceContents" readonly>
							<input 	type="checkbox" 
									value="동의합니다"
									id="adoptRequestAdviceContents"
									name="adoptRequestAdviceContents">동의합니다
							<input 	type="checkbox" 
									value="동의하지않습니다"
									id="adoptRequestAdviceContents"
									name="adoptRequestAdviceContents">동의하지않습니다
									
						</div>
						
			</c:forEach>
			<button id="addBtn" type="button" class="btn btn-primary pull-right">상담완료</button>			
	        </form><br><br>
    
    
    <!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
    