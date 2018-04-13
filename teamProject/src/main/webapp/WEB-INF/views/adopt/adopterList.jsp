<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>입양자 리스트</title>
	
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
                    <h1 class="page-header">입양자 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
		<!-- 내용 부분 시작-->
		<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				
			<!-- 리스트 -->
			<div class="panel-body">
			<div class="row">
			<div class="dataTables_length" id="dataTables-example_length">
			<div class="table-responsive">
			<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>입양코드</th>
						<th>보호소코드</th>
						<th>동물코드</th>
						<th>입양신청코드</th>
						<th>회원아이디</th>
						<th>관리자아이디</th>
						<th>입양자등록날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="adopt" items="${list}">
					<tr>
						<td>${adopt.adoptCode}</td>
						<td>${adopt.blCode}</td>
						<td>${adopt.animalCode}</td>
						<td>${adopt.adoptRequestCode}</td>
						<td>${adopt.mMemberId}</td>
						<td>${adopt.mAdminId}</td>
						<td>${adopt.adoptDate}</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
				<a href="${pageContext.request.contextPath}/"><button type="button" class="btn warning">홈으로</button></a>
			</div>
			</div>
				</div>
			</div>
			</div></div></div>
		</div>
			<!-- 내용 부분 끝-->
			
	
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
