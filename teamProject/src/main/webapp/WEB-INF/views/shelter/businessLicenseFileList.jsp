<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>

	<title>보호소 등록증 파일 리스트</title>
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
                <c:set var="m" value="${memberIdAndBusinessLicenseFile}"></c:set>
                    <h1 class="page-header">${m.mMemberId}님의 보호소 등록증 파일 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
          	
	    <!-- 내용 입력 부분 -->
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
						<th>파일 코드</th>
						<th>파일 명</th>
						<th>파일 사이즈</th>
						<th>등록 일자</th>
						<th>다운 로드</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="blf" items="${m.businessLicenseFileList}">
						<tr>
							<td>${blf.ofCode}</td>
							<td>${blf.ofOriginName}.${blf.ofExt}</td>
							<td>${blf.ofSize}</td>
							<td>${blf.ofDate}</td>
							<td>
								<a href="${pageContext.request.contextPath}/shelter/businessLicenseFileDownload?fileName=${blf.ofSaveName}&fileExt=${blf.ofExt}&ofOriginName=${blf.ofOriginName}">다운 로드</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table><br>
			<a href="${pageContext.request.contextPath}/businessLicenseRequestList"><button type="button">보호소 대표 신청 목록으로</button></a>
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
			