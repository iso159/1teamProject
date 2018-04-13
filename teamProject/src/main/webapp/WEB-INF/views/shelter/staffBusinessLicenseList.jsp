<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>직원 신청 보호소 리스트</title>
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
                    <h1 class="page-header">직원 신청 보호소 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
		<!-- 내용 부분 시작-->
			<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
			<!-- 테이블 이름 시작 -->
			<div class="panel-heading">직원 신청 보호소 리스트</div>
			<!-- 테이블 이름 끝 -->
			<div class="panel-body">
				<div class="row">
				<div class="dataTables_length" id="dataTables-example_length">
				<div class="table-responsive">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
			<thead>
				<tr>
					<th>보호소 코드</th>
					<th>보호소 명</th>
					<th>보호소 전화번호</th>
					<th>보호소 등록번호</th>
					<th>보호소 주소</th>
					<th>보호소 직원 신청</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bl" items="${list}">
					<tr>
						<td>${bl.blCode}</td>
						<td>${bl.blShelterName}</td>
						<td>${bl.blShelterNumber}</td>
						<td>${bl.blShelterRegNumber}</td>
						<td>${bl.blShelterAddress}</td>
						<td>
							<a href="${pageContext.request.contextPath}/shelter/requestShelterStaff?blCode=${bl.blCode}">
								<button type="button">직원신청</button>
							</a>
						</td>
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
			