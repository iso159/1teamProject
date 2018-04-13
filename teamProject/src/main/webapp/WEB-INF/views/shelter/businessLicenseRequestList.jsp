<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<title>보호소 대표 신청 리스트</title>
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
                    <h1 class="page-header">대표보호소 신청리스트</h1>
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
					<th>보호소 대표 신청 코드</th>
					<th>보호소 대표 회원 아이디</th>
					<th>신청 상태</th>
					<th>보호소 명</th>
					<th>보호소 전화번호</th>
					<th>보호소 등록번호</th>
					<th>보호소 주소</th>
					<th>보호소 대표 신청 날짜</th>
					<th>보호소 등록증 확인</th>
					<th>거절 사유</th>
					<th>등록 결정</th>
					<th>등록 거절</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bl" items="${list}">
					<tr>
						<c:set var="osCode" value="${bl.osCodeLicenseStatus}"></c:set>
						<td>${bl.blCode}</td>
						<td>${bl.mMemberId}</td>
						<td>${bl.osCodeLicenseStatus}</td>
						<td>${bl.blShelterName}</td>
						<td>${bl.blShelterNumber}</td>
						<td>${bl.blShelterRegNumber}</td>
						<td>${bl.blShelterAddress}</td>
						<td>${bl.blShelterDate}</td>
						<td><a href="${pageContext.request.contextPath}/shelter/fileList?blCode=${bl.blCode}">보호소 등록증 확인</a></td>
						<td>${bl.blShelterDenyReason}</td>
						<td>
							<c:if test="${osCode eq '신청확인'}">
								<a href="${pageContext.request.contextPath}/shelter/businessLicenseSet?blCode=${bl.blCode}&mMemberId=${bl.mMemberId}">등록 결정</a>
							</c:if>
						</td>
						<td>
							<c:if test="${osCode eq '신청확인'}">
								<a href="${pageContext.request.contextPath}/shelter/businessLicenseDeny?blCode=${bl.blCode}">등록 거부</a>
							</c:if>
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
			