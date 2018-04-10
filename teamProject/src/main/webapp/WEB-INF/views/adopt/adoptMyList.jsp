<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<title>나의 입양신청 현황</title>
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
                    <h1 class="page-header">나의 입양 신청 현황</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
			<!-- 테이블 이름 시작 -->
			<div class="panel-heading">${loginId}님신청리스트</div>
			<!-- 테이블 이름 끝 -->
			<div class="panel-body">
				<div class="row">
				<div class="col-sm-8">
				<div class="dataTables_length" id="dataTables-example_length">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
					<thead>
						<tr>
							<th>입양코드</th>
							<th>회원아이디</th>
							<th>입양상태코드</th>
							<th>동물코드</th>
							<th>동물상태</th>
							<th>입양이유</th>
							<th>입양신청날짜</th>
							<th>상담한날짜</th>
							<th>상담내용</th>
							<th>결정날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myList" items="${list}">
						<tr>
							<td>${myList.adoptRequest.adoptRequestCode}</td>
							<td>${myList.adoptRequest.mMemberId}</td>
							<td>${myList.adoptRequest.osCodeAdopt}</td>
							<td>${myList.adoptRequest.animalCode}</td>
							<td>${myList.osCodeAnimal}</td>
							<td>${myList.adoptRequest.adoptRequestReason}</td>
							<td>${myList.adoptRequest.adoptRequestDate}</td>
							<td>${myList.adoptRequest.adoptRequestAdviceDate}</td>
								<td>
									<c:if test="${!empty date}">
										<a id="linkCurrentPage" href="${pageContext.request.contextPath}/adopt/adoptCounselList?adoptRequestCode=${myList.adoptRequest.adoptRequestCode}&animalCode=${myList.adoptRequest.animalCode}">상담내용</a>
									</c:if>
								</td>
							<td>${myList.adoptRequest.adoptDecideDate}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="${pageContext.request.contextPath}/"><button type="button" class="btn warning">홈으로</button></a>
		   </div>
		</div>
		</div>
		</div>
		   <!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
