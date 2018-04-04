<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<title></title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class= "container" >
		<!-- 내용 입력 부분 -->
		<!-- 메인내용 시작 : Text | Text -->
		<section>
		<div data-layout="_r">
			<div data-layout="ch-half">
				<table style="border: 1">
					<thead>
						<tr>
							<td>보호소 이름</td>
							<td>보호소 주소</td>
							<td>동물 품종</td>
							<td>동물 체중</td>
							<td>동물 나이</td>
							<c:if test="${!empty selectExpOneInfo.exp.mShelterIdAccept}">
							<td>보호소 아이디</td>
							</c:if>
							<td>체험 상태</td>
							<td>일치 횟수</td>
							<td>체험 책임비</td>
							<td>체험 목적</td>
							<td>예약 신청 날짜</td>
							<td>체험 시작 날짜</td>
							<td>체험 종료 날짜</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${selectExpOneInfo.businessLicense.blShelterName}</td>
							<td>${selectExpOneInfo.businessLicense.blShelterAddress}</td>
							<td>${selectExpOneInfo.animal.animalBreed}</td>
							<td>${selectExpOneInfo.animal.animalWeight}</td>
							<td>${selectExpOneInfo.animal.animalAge}</td>
							<c:if test="${!empty selectExpOneInfo.exp.mShelterIdAccept}">
							<td>${selectExpOneInfo.exp.mShelterIdAccept}</td>
							</c:if>
							<td>${selectExpOneInfo.exp.osCodeExp}</td>
							<td>${selectExpOneInfo.exp.expJournalCount}</td>
							<td>${selectExpOneInfo.exp.expCost}</td>
							<td>${selectExpOneInfo.exp.expPurpose}</td>
							<td>${selectExpOneInfo.exp.expReserveRequestDate}</td>
							<td>${selectExpOneInfo.exp.expStartDate}</td>
							<td>${selectExpOneInfo.exp.expEndDate}</td>
						</tr>
					</tbody>
				</table>
				<c:choose>
				<c:when test="${selectExpOneInfo.exp.osCodeExp eq '체험 완료'}">
				</c:when>
				<c:when test="${selectExpOneInfo.exp.osCodeExp eq '체험 진행중'}">
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/experience/deleteExp?expCode=${selectExpOneInfo.exp.expCode}"><button type="button" style="float: right;">삭제</button></a>
				</c:otherwise>
				</c:choose>
				<c:if test="${selectExpOneInfo.exp.osCodeExp eq '체험 진행중' and selectExpOneInfo.exp.expJournalCount != count}">
					<a href="${pageContext.request.contextPath}/experience/expJournalAdd?expCode=${selectExpOneInfo.exp.expCode}"><button>체험 일지 등록</button></a>
				</c:if>
			</div>
		</div>
		</section>
		<!-- 메인내용 끝 : Text | Text -->
	
		<!-- 내용 입력 부분 끝 -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>