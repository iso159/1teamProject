<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
	<title></title>
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
                    <h1 class="page-header">${loginId}님 신청 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
				<table>
					<thead>
						<tr>
							<th>품종</th>
							<th>신청한날짜</th>
							<th>시작 날짜</th>
							<th>종료 날짜</th>
							<th>체험 상태</th>
							<th>상세 정보</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${expAndAnimal}">
						<tr>
							<td>${a.animal.animalBreed}</td>
							<td>${a.exp.expReserveRequestDate}</td>
							<td>${a.exp.expStartDate}</td>
							<td>${a.exp.expEndDate}</td>
							<td>${a.overallStatus.osName}</td>
							<td><a href="${pageContext.request.contextPath}/experience/expInfo?expCode=${a.exp.expCode}">정보 확인</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
