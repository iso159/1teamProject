<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유기동물 리스트</title>
</head>
<body>
<h2>유기동물 리스트</h2>
<table>
	<thead>
		<tr>
			<td>동물상태</td>		
			<td>동물종류</td>
			<td>품종</td>
			<td>지역</td>
			<td>동물식별코드</td>
			<td>체중</td>
			<td>나이</td>
			<td>보호소이름</td>
			<td>등록일자</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="i" items="${AnimalList}">		
		<tr>
			<td>${i.osName}</td>
			<td>${i.osNameAnimalKind}</td>
			<td>${i.animalBreed}</td>
			<td>${i.animalArea}</td>
			<td>${i.animalIdCode}</td>
			<td>${i.animalWeight}</td>
			<td>${i.animalAge}</td>
			<td>${i.blShelterName}</td>
			<td>${i.animalEnrollDate}</td>
			<td><a href="${pageContext.request.contextPath}/animal/animalUpdate?animalCode=${i.animalCode}">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/animal/animalDelete?animalCode=${i.animalCode}">삭제</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/animal/animalAdd">동물등록</a>
<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success">홈으로</button></a>
</body>
</html>