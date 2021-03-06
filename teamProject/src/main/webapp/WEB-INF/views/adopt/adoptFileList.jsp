<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>

	<title>입양파일리스트</title>
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
                    <h1 class="page-header">입양파일 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
			<!-- 테이블 이름 시작 -->
			<div class="panel-heading">입양파일리스트</div>
			<!-- 테이블 이름 끝 -->
			<div class="panel-body">
				<div class="row">
				<div class="col-lg-12">
				<div class="dataTables_length" id="dataTables-example_length">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>파일코드</th>
						<th>입양코드</th>
						<th>이름</th>
						<th>확장자</th>
						<th>사이즈</th>
						<th>등록날짜</th>
						<th>다운로드</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="aF" items="${list}">
						<tr>
							<td>${aF.ofCode}</td>
							<td>${aF.adoptRequestCode}</td>
							<td>${aF.ofOriginName}</td>
							<td>${aF.ofExt}</td>
							<td>${aF.ofSize}</td>
							<td>${aF.ofDownDate}</td>
							<td>
								<a href="${pageContext.request.contextPath}/adopt/adoptFileDownload?ofSaveName=${aF.ofSaveName}&ofExt=${aF.ofExt}&ofOriginName=${aF.ofOriginName}">다운로드</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table><br>
			<a href="${pageContext.request.contextPath}/adopt/adoptList"><button type="button" id="Btn" class="btn btn-success">상담결정</button></a>
			</div>
		</div>
		</div>
		</div>
			<!-- 내용 입력 부분 끝 -->
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
