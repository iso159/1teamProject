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
                    <h1 class="page-header">체험정보</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
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
							<td>총 일치 횟수</td>
							<td>남은 일지 횟수</td>
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
							<td>${selectExpOneInfo.exp.expJournalCount}회</td>
							<td>${selectExpOneInfo.exp.expJournalCount - count}회</td>
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
					<a href="${pageContext.request.contextPath}/experience/expJournalAdd?expCode=${selectExpOneInfo.exp.expCode}"><button type="button" style="float: right;">체험 일지 등록</button></a>
				</c:if>
				<c:if test="${selectExpOneInfo.exp.osCodeExp eq '체험 완료' or selectExpOneInfo.exp.osCodeExp eq '체험 진행중'}">
				<a href="${pageContext.request.contextPath}/experience/expJournalList?expCode=${selectExpOneInfo.exp.expCode}"><button type="button" type="button" style="float: right;">체험 일지 확인</button></a>
				</c:if>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
