<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h2>동물등록폼</h2>
	<form id="addForm" action="${pageContext.request.contextPath}/animal/animalList" method="post">
		<table>
			<tr>
				<td><!-- 동물상태 --></td>
				<td><input type="hidden" name="osCodeAnimal" value="os_animal_3_1_1"></td>
			</tr>
			<tr>
				<td>동물종류:</td>
				<td>
					<select name="osCodeKind">
						<option value="os_animal_kinds_11_1_1">강아지</option>
						<option value="os_animal_kinds_11_1_2">고양이</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>품종:</td>
				<td><input type="text" id="animalBreed" name="animalBreed"></td>
			</tr>
			<tr>
				<td>지역:</td>
				<td><input type="text" id="animalArea" name="animalArea"></td>
			</tr>
			<tr>
				<td>동물식별코드:</td>
				<td><input type="text" id="animalIdCode" name="animalIdCode"></td>
			</tr>
			<tr>
				<td>체중:</td>
				<td><input type="text" id="animalWeight" name="animalWeight"></td>
			</tr>
			<tr>
				<td>나이:</td>
				<td><input type="text" id="animalAge" name="animalAge"></td>
			<tr>
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
</body>
</html>