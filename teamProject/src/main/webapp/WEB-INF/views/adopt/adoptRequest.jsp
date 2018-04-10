<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $('#addBtn').click(function(){
        	// 공백들어갈시 팝업창으로 알려줌
        	let adoptRequestReason = $.trim($('#adoptRequestReason').val());
	          if(adoptRequestReason == ""){
	        	  alert('입양이유를 입력해주세요');
	        	  // 텍스트비움
	        	  $('#adoptRequestReason').val('');
	          }else {
	              $('#addForm').submit();
	          }
        });
    });
</script>
<title>입양신청</title>
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
                    <h1 class="page-header">입양신청하기</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<c:set var="m" value="${mMemberId}"/>
			 <div class="panel-body">
               <div class="row">
                   <div class="col-lg-6">
					<form role="form" id="addForm" action="${pageContext.request.contextPath}/adopt/adoptRequest" method="post" enctype="multipart/form-data">
						동물코드 <input class="form-control" type="text" name="animalCode" value="${animalCode}" readonly><br>
						보호소 <input class="form-control" type="text" name="blCode" value="${blCode}" readonly><br>
						입양이유 <input class="form-control" type="text" id="adoptRequestReason" name="adoptRequestReason"><br>
						회원아이디<input class="form-control" type="text" name="mMemberId" value="${mMemberId}" readonly><br>
						보호소직원<input class="form-control" type="text" name="mShelterId" value="${mShelterId}" readonly><br>
						파일<input type="file" name="file" multiple="multiple"><br>
						<input class="form-control" type="hidden" name="osCodeAdopt" value="os_adopt_4_1_1"><br>
						<input class="form-control" type="hidden" name="adoptPoint" value="500"><br>
						
						<button id="addBtn" type="button"  class="btn btn-warning">입양신청하기</button>
					</form>
					</div>
                  </div>
              </div>
 		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
