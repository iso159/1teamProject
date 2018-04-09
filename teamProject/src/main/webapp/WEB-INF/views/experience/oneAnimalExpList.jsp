<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

	
	<title>Home</title>
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
                    <h1 class="page-header">체험 기록</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작 -->
			<table>
				<thead>
					<tr>
						<td>체험 내용</td>
						<td>동물 특징</td>
						<td>체험 시작날짜</td>
						<td>체험 종료날짜</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${expAndAnimalAndExpJournal}">
					<tr>
						<td>${e.expJourmal.expJournal}</td>
						<td>${e.expJourmal.expJournalAnimalChar}</td>
						<td>${e.exp.expStartDate}</td>
						<td>${e.exp.expEndDate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:forEach var="i" items="${expAndAnimalAndExpJournal}" varStatus="status" end="0">
			<a href="${pageContext.request.contextPath}/experience/expAdd?animalCode=${i.exp.animalCode}&blCode=${i.exp.blCode}"><button>체험 신청</button></a>
			</c:forEach>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
