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
        $('#adoptCheck').click(function(){
        	var selectValue = document.getElementById('selectBox').value;
        	$('#adoptCheckBtn').submit();
        });
    });
</script>
	<title>입양리스트</title>
</head>
<body>
	<h2>입양 리스트</h2>
	<table border="1">
		<thead>
			<tr>
				<th>입양코드</th>
				<th>회원아이디</th>
				<th>입양상태코드</th>
				<th>동물코드</th>
				<th>동물상태</th>
				<th>입양이유</th>
				<th>입양신청날짜</th>
				<th>파일확인</th>
				<th>상담한날짜</th>
				<th>상담내용</th>
				<th>결정날짜</th>
				<th>입양취소</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aR" items="${list}">
			<tr>
				<td>${aR.adoptRequest.adoptRequestCode}</td>
				<td>
					<a href="${pageContext.request.contextPath}/adopt/adoptCounsel?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}">${aR.adoptRequest.mMemberId}</a>
				</td>
				<td>${aR.adoptRequest.osCodeAdopt}</td>
				<td>${aR.adoptRequest.animalCode}</td>
				<td>${aR.osCodeAnimal}</td>
				<td>${aR.adoptRequest.adoptRequestReason}</td>
				<td>${aR.adoptRequest.adoptRequestDate}</td>
				<td>
					<a href="${pageContext.request.contextPath}/adopt/adoptFileCheck?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}">파일확인</a>
				</td>
				<td>${aR.adoptRequest.adoptRequestAdviceDate}</td>
				<td>
					<a href="${pageContext.request.contextPath}/adopt/adoptCounselList?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}&animalCode=${aR.adoptRequest.animalCode}">상담내용</a>
				</td>
				<td>${aR.adoptRequest.adoptDecideDate}</td>
				<td>
					<a href="${pageContext.request.contextPath}/adopt/adoptCancle?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}">입양취소</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		<a href="${pageContext.request.contextPath}/"><button type="button" class="btn warning">홈으로</button></a>
</body>
</html>