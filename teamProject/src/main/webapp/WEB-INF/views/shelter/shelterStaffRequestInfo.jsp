<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>보호소 직원 신청 상세 정보</title>
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
                    <h1 class="page-header">보호소 직원 신청 상세 정보</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
					<div class="row">
					<div class="col-lg-12">
					<div class="panel panel-default">
					<!-- 테이블 이름 시작 -->
					<div class="panel-heading">보호소 직원 신청리스트</div>
					<!-- 테이블 이름 끝 -->
					<div class="panel-body">
						<div class="row">
						<div class="dataTables_length" id="dataTables-example_length">
						<div class="table-responsive">
						<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
					<thead>
						<tr>
							<th>신청자 아이디</th>
							<th>신청자 이름</th>
							<th>신청자 성별</th>
							<th>신청자 생년월일</th>
							<th>신청자 우편 번호</th>
							<th>신청자 주소</th>
							<th>신청자 이메일</th>
							<th>신청자 전화번호</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${mId}</td>
							<td>${memberInfo.mInfoName}</td>
							<td>${memberInfo.mInfoGender}</td>
							<td>${memberInfo.mInfoBirth}</td>
							<td>${memberInfo.mInfoPostcode}</td>
							<td>${memberInfo.mInfoAddress}</td>
							<td>${memberInfo.mInfoEmail}</td>
							<td>${memberInfo.mInfoPhone}</td>
						</tr>
					</tbody>
				</table>
		<a href="${pageContext.request.contextPath}/shelter/requestShelterStaffList">
			<button type="button">직원 요청 리스트</button>
		</a>
	</div>
		</div>
		</div>
		</div></div></div></div></div>
			<!-- 내용 입력 부분 끝 -->
			<!-- 내용 부분 끝-->
			<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
			