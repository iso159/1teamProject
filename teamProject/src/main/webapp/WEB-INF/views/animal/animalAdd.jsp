<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>동물등록폼</h2>
	<form action="${pageContext.request.contextPath}/animal/animalList" method="post">
		<table>
			<tr>
				<td><!-- 동물상태 --></td>
				<td><input type="hidden" name="osCodeAnimal" value="os_animal_3_1_1"></td>
			</tr>
			<tr>
				<td>동물종류코드:</td>
				<td><input type="text" name="osCodeKind"></td>
			</tr>
			<tr>
				<td>보호소통합관리코드:</td>
				<td><input type="text" name="blCode" value=""></td>
			</tr>
			<tr>
				<td>동물코드:</td>
				<td><input type="text" name="animalCode"></td>
			</tr>
			<tr>
				<td>품종:</td>
				<td><input type="text" name="animalBreed"></td>
			</tr>
			<tr>
				<td>지역:</td>
				<td><input type="text" name="animalArea"></td>
			</tr>
			<tr>
				<td>동물식별코드:</td>
				<td><input type="text" name="animalIdCode"></td>
			</tr>
			<tr>
				<td>체중:</td>
				<td><input type="text" name="animalWeight"></td>
			</tr>
			<tr>
				<td>나이:</td>
				<td><input type="text" name="animalAge"></td>
			<tr>
			<tr>
				<td><button type="submit">입력</button></td>
			</tr>
		</table>
	</form>
</body>
</html>