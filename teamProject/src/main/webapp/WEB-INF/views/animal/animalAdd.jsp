<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
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
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
	<!-- 메인내용 시작 : Text | Text -->
	<section>
	  <div data-layout="_r">
	    <div>
	    <!-- 내용 입력 부분 -->
		<h2>동물등록폼</h2>
		<form id="addForm" 
			  action="${pageContext.request.contextPath}/animal/animalAdd"
			  enctype="multipart/form-data" 
			  method="post">
			<input type="hidden" name="animalImagePath" value="${imagePath}">
			<table>
				<tr>
					<td><!-- 동물상태 --></td>
					<td><input type="hidden" name="osCodeAnimal" value="os_animal_3_1_1"></td>
				</tr>
				<tr>
					<td>품종 :</td>
					<td>
						<select name="animalBreed" id="animalKind">

						</select>
					</td>
				</tr>
				<tr>
					<td>보호소 위치:</td>
					<td><input type="text" id="animalArea" name="animalArea" value="${animalArea}"></td>
				</tr>
				<tr>
					<td>동물식별코드:</td>
					<td><input type="text" id="animalIdCode" name="animalIdCode" value="${animalIdCode}"></td>
				</tr>
				<tr>
					<td>체중:</td>
					<td><input type="text" id="animalWeight" name="animalWeight" value="${animalWeight}"></td>
				</tr>
				<tr>
					<td>나이:</td>
					<td><input type="text" id="animalAge" name="animalAge" value="${animalAge}"></td>
				<tr>
				<tr>
					<td><input type="file" name="file" value="사진첨부"></td>
				</tr>
				<tr>
					<td></td>
					<td><span id="Helper"></span></td>
				</tr>
				<tr>
					<td><button id="addBtn" type="button">등록</button></td>
				</tr>
			</table>
		</form>
		<script>
			$(document).ready(function(){
				$('#addBtn').click(function(){
					//공백이 들어가면 알려준다
					if($('#animalBreed').val() == ""){
						$('#Helper').text('품종을 입력해주세요');
					}else if($('#animalArea').val() == ""){
						$('#Helper').text('지역을 입력해주세요');
					}else if($('#animalIdCode').val() == ""){
						$('#Helper').text('동물식별코드를 입력해주세요');
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