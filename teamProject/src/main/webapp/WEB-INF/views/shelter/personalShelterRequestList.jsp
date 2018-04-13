<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>회원 보호소 직원 신청 리스트</title>
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
                    <h1 class="page-header">회원 보호소 직원 신청 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
		<!-- 내용 부분 시작-->
			<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
			<!-- 테이블 이름 시작 -->
			<div class="panel-heading">대표보호소 신청리스트</div>
			<!-- 테이블 이름 끝 -->
			<div class="panel-body">
				<div class="row">
				<div class="dataTables_length" id="dataTables-example_length">
				<div class="table-responsive">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
					<thead>
						<tr>
							<th>회원 아이디</th>
							<th>신청 보호소 명</th>
							<th>신청 상태</th>
							<th>신청 날짜</th>
							<th>결정 날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${list}">
							<tr>
								<td>${c.shelterStaffRequest.mId}</td>
								<td>${c.blShelterName}</td>
								<td>${c.shelterStaffRequest.osCodeStaffRequest}</td>
								<td>${c.shelterStaffRequest.ssrRequestDate}</td>
								<td>${c.shelterStaffRequest.ssrClearDate}</td>
							</tr>
						</c:forEach>				
					</tbody>
				</table>
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
