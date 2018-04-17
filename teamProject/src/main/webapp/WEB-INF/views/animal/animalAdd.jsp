<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(document).ready(function(){
		var itemSize;
		$.ajax({
			url:'AnimalBreed',
			type: 'post',
			dataType: 'json',
			success: function(msg){
				itemSize = Object.keys(msg.response.body.items.item).length;
				$('#animalKind').empty();
				for(let i=0; i<itemSize; i++){
					let optionVal = '<option value="' + msg.response.body.items.item[i].KNm + '">' + msg.response.body.items.item[i].KNm + '</option>'
					$('#animalKind').append(optionVal);
				}
				var animalBreed = '${animalBreed}';
				if(animalBreed != ""){
					$('#animalKind').val(animalBreed);
				}
			}
		});		
		
		$('#addBtn').click(function(){
			//공백이 들어가면 알려준다
			if($('#animalBreed').val() == ""){
				$('#Helper').text('품종을 입력해주세요');
			}else if($('#animalArea').val() == ""){
				$('#Helper').text('지역을 입력해주세요');
			}else if($('#animalWeight').val() == ""){
				$('#Helper').text('체중을 입력해주세요');
			}else if($('#animalAge').val() == ""){
				$('#Helper').text('나이를 입력해주세요');
			}else {
	              $('#addForm').submit();
	          }
		});
	});
</script>
<title>동물 등록</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<div id="page-wrapper">
		<!-- 메인 화면 내용 부분 -->
		<div class="container">
		<!-- 메인내용 시작 : Text | Text -->
		<section>
		  <div data-layout="_r">
		    <div style="width:500px;">
		    <!-- 내용 입력 부분 -->
			<h2>동물등록폼</h2>
			<form role="form" id="addForm" 
				  action="${pageContext.request.contextPath}/animal/animalAdd"
				  enctype="multipart/form-data" 
				  method="post">
				<input type="hidden" name="animalImagePath" value="${imagePath}">
				<div class="form-group" >		
					품종   <select class="form-control" name="animalBreed" id="animalKind">
						 </select>
				</div>
				<div class="form-group">
					<label>보호소 주소</label>
					<c:set var="bl" value="${businessLicense}"></c:set>
					<c:if test="${empty bl}">
						<input type="text" class="form-control" id="animalArea" name="animalArea" value="${animalArea}" readonly="readonly">
					</c:if>
					<c:if test="${!empty bl}">
						<input type="text" class="form-control" id="animalArea" name="animalArea" value="${bl.blShelterAddress}" readonly="readonly">
					</c:if>
				</div>
					<c:if test="${!empty bl}">
						<input type="hidden" class="form-control" id="animalIdCode" name="blShelterName" value="${bl.blShelterName}">
					</c:if>
					<c:if test="${empty bl}">
						<input type="hidden" class="form-control" id="animalIdCode" name="animalIdCode" value="${animalIdCode}">
					</c:if>
				<div class="form-group">
					<label>체중</label>
					<input type="text" class="form-control" id="animalWeight" name="animalWeight" value="${animalWeight}">
				</div>
					<label>나이</label>
					<input type="text" class="form-control" id="animalAge" name="animalAge" value="${animalAge}">
					<br>
					<input type="file" name="file" value="사진첨부">
					<span id="Helper"></span>
					<br>
					<button class="btn btn-outline btn-success" id="addBtn" type="button">등록</button>
			</form>
		<!-- 내용 입력 부분 끝 -->
			</div>
		  </div>
		</section>
		<!-- 메인내용 끝 : Text | Text -->
		</div>
		<!-- 메인 화면 내용 부분 끝 -->
	</div>
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>