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
                    <h1 class="page-header">보호소체험리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
				<table>
					<thead>
						<tr>
						<td>회원 아이디</td>
						<td>승인 아이디</td>
						<td>체험 상태</td>
						<td>체험 신청 날짜</td>
						<td>상세정보</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${exp}">
						<tr>
						<td>${e.mExpId}</td>
						<td>${e.mShelterIdAccept}</td>
						<td>${e.osName}</td>
						<td>${e.expReserveRequestDate}</td>
						<td><a href="${pageContext.request.contextPath}/experience/expShelterInfo?expCode=${e.expCode}">상세정보</a></td>
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
