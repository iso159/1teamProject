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
				<table>
					<thead>
						<tr>
							<th>회원 아이디</th>
							<th>회원 이름</th>
							<th>회원 성별</th>
							<th>회원 생년월일</th>
							<th>회원 주소</th>
							<th>회원 핸드폰번호</th>
							<th>체험 승인자아이디</th>
							<th>체험 날짜</th>
							<th>체험 상태</th>
							<th>체험비 반환상태</th>
							<th>체험 목적</th>
							<th>체험 예약 신청 날짜</th>
							<th>체험 예약 승인 날짜</th>
							<th>체험 시작 날짜</th>
							<th>체험 종료 날짜</th>
							<th>동물 상태</th>
							<th>동물 코드</th>
							<th>동물 품종</th>
							<th>동물 체중</th>
							<th>동물 나이</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>${ExpOneInfo.exp.mExpId}</th>
							<th>${ExpOneInfo.memberInfo.mInfoName}</th>
							<th>${ExpOneInfo.memberInfo.mInfoGender}</th>
							<th>${ExpOneInfo.memberInfo.mInfoBirth}</th>
							<th>${ExpOneInfo.memberInfo.mInfoAddress}</th>
							<th>${ExpOneInfo.memberInfo.mInfoPhone}</th>
							<th>${ExpOneInfo.exp.mShelterIdAccept}</th>
							<th>${ExpOneInfo.expPeriod.expPeriodLevel}일</th>
							<th>${ExpOneInfo.exp.osCodeExp}</th>
							<th>${ExpOneInfo.exp.osCodeCostReturn}</th>
							<th>${ExpOneInfo.exp.expPurpose}</th>
							<th>${ExpOneInfo.exp.expReserveRequestDate}</th>
							<th>${ExpOneInfo.exp.expCheckDate}</th>
							<th>${ExpOneInfo.exp.expStartDate}</th>
							<th>${ExpOneInfo.exp.expEndDate}</th>
							<th>${ExpOneInfo.animal.osCodeAnimal}</th>
							<th>${ExpOneInfo.animal.animalIdCode}</th>
							<th>${ExpOneInfo.animal.animalBreed}</th>
							<th>${ExpOneInfo.animal.animalWeight}</th>
							<th>${ExpOneInfo.animal.animalAge}</th>
						</tr>
					</tbody>
				</table>
			
		<c:if test="${ExpOneInfo.exp.osCodeExp eq '예약 신청' or ExpOneInfo.exp.osCodeExp eq '예약 확인'}">
		<a href="${pageContext.request.contextPath}/experience/updateOsExp?osCodeExp=os_exp_12_1_5&expCode=${ExpOneInfo.exp.expCode}"><button>체험 수락</button></a>
		</c:if>
		<c:if test="${ExpOneInfo.exp.osCodeExp eq '예약 신청' or ExpOneInfo.exp.osCodeExp eq '예약 확인' or ExpOneInfo.exp.osCodeExp eq '예약 완료'}">
		<a href="${pageContext.request.contextPath}/experience/updateOsExp?osCodeExp=os_exp_12_1_6&expCode=${ExpOneInfo.exp.expCode}"><button>체험 거절</button></a>
		</c:if>
		<c:if test="${ExpOneInfo.animal.osCodeAnimal eq '체험가능동물' and ExpOneInfo.exp.osCodeExp eq '예약 완료'}">
		<a href="${pageContext.request.contextPath}/experience/animalUpdate?osCodeAnimal=os_animal_3_1_3&animalCode=${ExpOneInfo.exp.animalCode}&expCode=${ExpOneInfo.exp.expCode}&osCodeExp=os_exp_12_1_1&osCode=os_cost_13_1_1&expCost=${ExpOneInfo.exp.expCost}"><button>동물 지급 완료</button></a>
		</c:if>
		<c:if test="${ExpOneInfo.animal.osCodeAnimal eq '체험중인동물' and ExpOneInfo.exp.osCodeExp eq '체험 진행중'}">
		<a href="${pageContext.request.contextPath}/experience/animalUpdate?osCodeAnimal=os_animal_3_1_2&animalCode=${ExpOneInfo.exp.animalCode}&expCode=${ExpOneInfo.exp.expCode}&osCodeExp=os_exp_12_1_2&osCode=os_cost_13_1_2&expCost=1"><button>동물 반환 완료</button></a>
		</c:if>
		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
