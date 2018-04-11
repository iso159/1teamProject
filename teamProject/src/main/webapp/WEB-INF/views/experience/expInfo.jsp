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
			<div class="col-lg-8">
            	<div class="panel panel-default">
                	<div class="panel-heading">
                        신청 체험 정보
                    </div>
                    	<div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#home" data-toggle="tab">보호소 정보</a>
                                </li>
                                <li><a href="#profile" data-toggle="tab">동물 정보</a>
                                </li>
                                <li><a href="#messages" data-toggle="tab">체험 정보</a>
                                </li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="home">
	                            <h4>보호소 이름</h4>
	                            <blockquote>
	                                <p>${selectExpOneInfo.businessLicense.blShelterName}</p>
	                                <small>
	                                    <cite title="Source Title">해당 동물 보유중인 보호소 명</cite>
	                                </small>
	                            </blockquote>
	                            <h4>보호소 주소</h4>
	                            <blockquote>
	                                <p>${selectExpOneInfo.businessLicense.blShelterAddress}</p>
	                                <small>
	                                    <cite title="Source Title">해당 동물 보유중인 보호소 주소</cite>
	                                </small>
	                            </blockquote>
	                            </div>
                                <div class="tab-pane fade" id="profile">
                                	<h4>동물 품종</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.animal.animalBreed}</p>
		                                <small>
		                                    <cite title="Source Title">해당 동물 품종</cite>
		                                </small>
		                            </blockquote>
		                            <h4>동물 체중</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.animal.animalWeight}</p>
		                                <small>
		                                    <cite title="Source Title">해당 동물 체중</cite>
		                                </small>
		                            </blockquote>
		                            <h4>동물 나이</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.animal.animalAge}</p>
		                                <small>
		                                    <cite title="Source Title">해당 동물 나이</cite>
		                                </small>
		                            </blockquote>    
                                </div>
                                <div class="tab-pane fade" id="messages">
                                    <c:if test="${!empty selectExpOneInfo.exp.mShelterIdAccept}">
		                            <h4>보호소 아이디</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.exp.mShelterIdAccept}</p>
		                                <small>
		                                    <cite title="Source Title">체험 승인일 경우 승인 진행한 보호소 아이디</cite>
		                                </small>
			                        </blockquote>
			                            </c:if>
			                            <h4>체험 상태</h4>
			                        <blockquote>
		                                <p>${selectExpOneInfo.exp.osCodeExp}</p>
		                                <small>
		                                    <cite title="Source Title">체험 진행 상태</cite>
		                                </small>
		                            </blockquote>
		                            <h4>총 일치 횟수</h4>
			                            <blockquote>
		                                <p>${selectExpOneInfo.exp.expJournalCount}회</p>
			                                <small>
			                                    <cite title="Source Title">체험 진행 중 작성해야 할 총 일지 횟수</cite>
			                                </small>
			                            </blockquote>
			                            <h4>남은 일지 횟수</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.exp.expJournalCount - count}회</p>
		                                <small>
		                                    <cite title="Source Title">체험 진행 중 작성하고 남은 일지 횟수 </cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 책임비</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.exp.expCost}</p>
		                                <small>
		                                    <cite title="Source Title">체험에 따른 책임비</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 목적</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.exp.expPurpose}</p>
		                                <small>
		                                    <cite title="Source Title">체험 신청 목적</cite>
		                                </small>
		                            </blockquote>
		                            <h4>예약 신청 날짜</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.exp.expReserveRequestDate}</p>
		                                <small>
		                                    <cite title="Source Title">체험 예약 신청 날짜</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 시작 날짜</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.exp.expStartDate}</p>
		                                <small>
		                                    <cite title="Source Title">체험 시작 날짜</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 종료 날짜</h4>
		                            <blockquote>
		                                <p>${selectExpOneInfo.exp.expEndDate}</p>
		                                <small>
		                                    <cite title="Source Title">체험 종료 날짜</cite>
		                                </small>
		                            </blockquote>
	                            </div>
	                        </div>
	                    </div>
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
	                </div>
	                <!-- /.panel -->
            	</div>
		</div>
		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
