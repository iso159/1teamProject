<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var itemSize;
		$.ajax({
			url:'AnimalBreed',
			type: 'post',
			dataType: 'json',
			success: function(msg){
				console.log('성공');
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
<title>Insert title here</title>
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
	<h2>동물 수정화면</h2>
	<form 	action="${pageContext.request.contextPath}/animal/animalUpdate"
			enctype="multipart/form-data"  
			method="post">
		<input type="hidden" name="animalCode" value="${animal.animalCode}">
		<input type="hidden" name="filePath" value="${animal.animalImagePath}">
		<table>			
			<tr>
				<td>품종:</td>
				<td>
					<select name="animalBreed" id="animalKind">
					</select>
				</td>
			</tr>
			<tr>
				<td>지역:</td>
				<td>
					<input type="text" name="animalArea" value="${animal.animalArea}"><br>
				</td>
			</tr>
			<tr>
				<td>동물식별코드:</td>
				<td>
					<input type="text" name="animalIdCode" value="${animal.animalIdCode}" readonly="readonly"><br>
				</td>
			</tr>
			<tr>
				<td>동물몸무게:</td>
				<td>
					<input type="text" name="animalWeight" value="${animal.animalWeight}"><br>
				</td>
			</tr>
			<tr>
				<td>동물나이:</td>
				<td>
					<input type="text" name="animalAge" value="${animal.animalAge}">
				</td>
			</tr>
			<tr>
				<td><input type="file" name="file" value="사진첨부"></td>
			</tr>
		</table>
		<button type="submit">수정 완료</button>
	</form>
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