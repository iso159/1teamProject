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
                    <h1 class="page-header">expShelterInfo</h1>
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
                                <li class="active"><a href="#home" data-toggle="tab">신청 회원 정보</a>
                                </li>
                                <li><a href="#profile" data-toggle="tab">체험 정보</a>
                                </li>
                                <li><a href="#messages" data-toggle="tab">동물 정보</a>
                                </li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="home">
	                            <h4>회원 아이디</h4>
	                            <blockquote>
	                                <p>${ExpOneInfo.exp.mExpId}</p>
	                                <small>
	                                    <cite title="Source Title">신청한 회원 아이디</cite>
	                                </small>
	                            </blockquote>
	                            <h4>회원 이름</h4>
	                            <blockquote>
	                                <p>${ExpOneInfo.memberInfo.mInfoName}</p>
	                                <small>
	                                    <cite title="Source Title">신청한 회원 이름</cite>
	                                </small>
	                            </blockquote>
	                            <h4>회원 성별</h4>
	                            <blockquote>
	                                <p>${ExpOneInfo.memberInfo.mInfoGender}</p>
	                                <small>
	                                    <cite title="Source Title">신청한 회원 성별</cite>
	                                </small>
	                            </blockquote>
	                            <h4>회원 생년월일</h4>
	                            <blockquote>
	                                <p>${ExpOneInfo.memberInfo.mInfoBirth}</p>
	                                <small>
	                                    <cite title="Source Title">신청한 회원 생년월일</cite>
	                                </small>
	                            </blockquote>
	                            <h4>회원 주소</h4>
	                            <blockquote>
	                                <p>${ExpOneInfo.memberInfo.mInfoAddress}</p>
	                                <small>
	                                    <cite title="Source Title">신청한 회원 주소</cite>
	                                </small>
	                            </blockquote>
	                            <h4>회원 핸드폰번호</h4>
	                            <blockquote>
	                                <p>${ExpOneInfo.memberInfo.mInfoPhone}</p>
	                                <small>
	                                    <cite title="Source Title">신청한 회원 핸드폰 번호</cite>
	                                </small>
	                            </blockquote>
	                            </div>
                                <div class="tab-pane fade" id="profile">
                                	<h4>체험 승인자아이디</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.mShelterIdAccept}</p>
		                                <small>
		                                    <cite title="Source Title">체험 승인자 아이디</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 날짜</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.expPeriod.expPeriodLevel}일</p>
		                                <small>
		                                    <cite title="Source Title">체험 총 진행 일자</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 상태</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.osCodeExp}</p>
		                                <small>
		                                    <cite title="Source Title">체험 상태</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험비 반환상태</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.osCodeCostReturn}</p>
		                                <small>
		                                    <cite title="Source Title">체험 비용 반환상태</cite>
		                                </small>
		                            </blockquote> 
		                            <h4>체험 목적</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.expPurpose}</p>
		                                <small>
		                                    <cite title="Source Title">체험 목적</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 예약 신청 날짜</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.expReserveRequestDate}</p>
		                                <small>
		                                    <cite title="Source Title">체험 예약 신청 날짜</cite>
		                                </small>
		                            </blockquote>
		                            <h4>체험 예약 승인 날짜</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.expCheckDate}</p>
		                                <small>
		                                    <cite title="Source Title">체험 예약 승인 날짜</cite>
		                                </small>
		                            </blockquote>   
		                            <h4>체험 시작 날짜</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.expStartDate}</p>
		                                <small>
		                                    <cite title="Source Title">체험 시작 날짜</cite>
		                                </small>
		                            </blockquote>  
		                            <h4>체험 종료 날짜</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.exp.expEndDate}</p>
		                                <small>
		                                    <cite title="Source Title">체험 종료 날짜</cite>
		                                </small>
		                            </blockquote>    
                                </div>
                                <div class="tab-pane fade" id="messages">
		                            <h4>동물 상태</h4>
		                            <blockquote>
		                                <p>${ExpOneInfo.animal.osCodeAnimal}</p>
		                                <small>
		                                    <cite title="Source Title">동물 현재 상태</cite>
		                                </small>
			                        </blockquote>
			                            <h4>동물 코드</h4>
			                        <blockquote>
		                                <p>${ExpOneInfo.animal.animalIdCode}</p>
		                                <small>
		                                    <cite title="Source Title">동물 코드</cite>
		                                </small>
		                            </blockquote>
		                            <h4>동물 품종</h4>
			                        <blockquote>
		                                <p>${ExpOneInfo.animal.animalBreed}</p>
		                                <small>
		                                    <cite title="Source Title">동물 품종</cite>
		                                </small>
		                            </blockquote>
		                            <h4>동물 체중</h4>
			                        <blockquote>
		                                <p>${ExpOneInfo.animal.animalWeight}</p>
		                                <small>
		                                    <cite title="Source Title">동물 체중</cite>
		                                </small>
		                            </blockquote>
		                            <h4>동물 나이</h4>
			                        <blockquote>
		                                <p>${ExpOneInfo.animal.animalAge}</p>
		                                <small>
		                                    <cite title="Source Title">동물 나이</cite>
		                                </small>
		                            </blockquote>
	                            </div>
	                        </div>
	                    </div>
	                    <div style="float: right;">
							<c:if test="${ExpOneInfo.exp.osCodeExp eq '예약 신청' or ExpOneInfo.exp.osCodeExp eq '예약 확인'}">
							<a href="${pageContext.request.contextPath}/experience/updateOsExp?osCodeExp=os_exp_12_1_5&expCode=${ExpOneInfo.exp.expCode}"><button>체험 수락</button></a>
							</c:if>
							<c:if test="${ExpOneInfo.exp.osCodeExp eq '예약 신청' or ExpOneInfo.exp.osCodeExp eq '예약 확인' or ExpOneInfo.exp.osCodeExp eq '예약 완료'}">
							<a href="${pageContext.request.contextPath}/experience/updateOsExp?osCodeExp=os_exp_12_1_6&expCode=${ExpOneInfo.exp.expCode}"><button>체험 거절</button></a>
							</c:if>
							<c:if test="${ExpOneInfo.animal.osCodeAnimal eq '체험(입양)가능동물' and ExpOneInfo.exp.osCodeExp eq '예약 완료'}">
							<a href="${pageContext.request.contextPath}/experience/animalUpdate?osCodeAnimal=os_animal_3_1_3&animalCode=${ExpOneInfo.exp.animalCode}&expCode=${ExpOneInfo.exp.expCode}&osCodeExp=os_exp_12_1_1&osCode=os_cost_13_1_1&expCost=${ExpOneInfo.exp.expCost}"><button>동물 지급 완료</button></a>
							</c:if>
							<c:if test="${ExpOneInfo.animal.osCodeAnimal eq '체험중인동물' and ExpOneInfo.exp.osCodeExp eq '체험 진행중'}">
							<a href="${pageContext.request.contextPath}/experience/animalUpdate?osCodeAnimal=os_animal_3_1_2&animalCode=${ExpOneInfo.exp.animalCode}&expCode=${ExpOneInfo.exp.expCode}&osCodeExp=os_exp_12_1_2&osCode=os_cost_13_1_2&expCost=1"><button>동물 반환 완료</button></a>
							</c:if>
						</div>
	                </div>
	                <!-- /.panel -->
            	</div>
		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
