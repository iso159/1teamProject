<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Home</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp" />
	<!-- top 부분 끝-->

	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
		<!-- 메인내용 시작 : Text | Text -->
		<section>
			<div data-layout="_r">
				<div>
					<!-- 내용 입력 부분 -->
					<c:forEach var="e" items="${expJournal}" varStatus="status">
					<h3>${status.count}번째 일지</h3>
					<table>
						<thead>
							<tr>
								<td>체험 등록 일자</td>
								<td>체험 일지</td>
								<td>체험 동물 특징</td>
								<td>획득 포인트</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${e.expJournalDate}</td>
								<td>${e.expJournal}</td>
								<td>${e.expJournalAnimalChar}</td>
								<td>${e.expJournalPoint}</td>
								<td><a href="${pageContext.request.contextPath}/experience/expJournalModify?expJournalCode=${e.expJournalCode}">
								<button>수정</button></a></td>
							</tr>
						</tbody>
					</table>
					</c:forEach>
					<!-- 내용 입력 부분 끝 -->
				</div>
			</div>
		</section>
		<!-- 메인내용 끝 : Text | Text -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->

	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp" />
	<!-- foot 부분 끝 -->
</body>
</html>
