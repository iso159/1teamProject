<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $('#addBtn').click(function(){
	        	  alert('정말등록하시겠습니까?');
	      
	              $('#addForm').submit();
	        
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
                    <h1 class="page-header">입양자 등록하기</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			
			 <div class="panel-body">
               <div class="row">
                   <div class="col-lg-6">
                   <c:set var="adopt" value="${adopt}"></c:set>
					<form role="form" id="addForm" action="${pageContext.request.contextPath}/adopt/adoptAdd" method="post">
						회원아이디 <input class="form-control" type="text" name="mMemberId" value="${adopt.mMemberId}" readonly><br>
						보호소 <input class="form-control" type="text" name="blCode" value="${adopt.blCode}" readonly><br>
						동물코드 <input class="form-control" type="text" name="animalCode" value="${adopt.animalCode}" readonly><br>
						관리자아이디 <input class="form-control" type="text" name="mAdminId" value="${adopt.mAdminId}" readonly><br>
						<input type=hidden class="form-control" name="adoptRequestCode" value="${adopt.adoptRequestCode}" readonly>
						<button id="addBtn" type="button"  class="btn btn-warning">입양자등록</button>
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
