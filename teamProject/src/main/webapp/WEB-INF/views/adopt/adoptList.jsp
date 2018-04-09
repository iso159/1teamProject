<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>입양리스트</title>
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
                    <h1 class="page-header">입양 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
	
			<!-- 조건검색 -->
			<form id="selectForm" action="${pageContext.request.contextPath}/adopt/adoptlCategory" method="post">
				<select name="OsCategory" id="selectOsCode">
					<option value="전체조회">--전체조회--</option>
					<option value="os_adopt_4_1_1">입양신청</option>
					<option value="os_adopt_4_1_2">입양신청완료</option>
					<option value="os_adopt_4_1_5">상담진행중</option>
					<option value="os_adopt_4_1_7">입양완료</option>
					<option value="os_adopt_4_1_8">입양거절</option>
				</select>
				<button type="submit">검색</button>
			</form>
			<!-- 리스트 -->
			<table border="1">
				<thead>
					<c:set var="right" value="${rightName}"></c:set>
					<tr>
						<th>입양코드</th>
						<th>회원아이디</th>
						<th>입양상태코드</th>
						<th>동물코드</th>
						<th>동물상태</th>
						<th>입양이유</th>
						<th>입양신청날짜</th>
						<c:if test="${right eq '관리자'}">
						<th>파일확인</th>
						</c:if>
						<th>상담한날짜</th>
						<th>상담내용</th>
						<th>결정날짜</th>
						<c:if test="${right eq '관리자'}">
						<th>입양취소</th>
						</c:if>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="aR" items="${list}">
					<c:set var="date" value="${aR.adoptRequest.adoptRequestAdviceDate}"></c:set>
					<c:set var="right" value="${rightName}"></c:set>
					<tr>
						<td>${aR.adoptRequest.adoptRequestCode}</td>
						<td>
							<a href="${pageContext.request.contextPath}/adopt/adoptCounsel?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}">${aR.adoptRequest.mMemberId}</a>
						</td>
						<td>${aR.adoptRequest.osCodeAdopt}</td>
						<td>${aR.adoptRequest.animalCode}</td>
						<td>${aR.osCodeAnimal}</td>
						<td>${aR.adoptRequest.adoptRequestReason}</td>
						<td>${aR.adoptRequest.adoptRequestDate}</td>
						<c:if test="${right eq '관리자'}">
						<td>
							<a href="${pageContext.request.contextPath}/adopt/adoptFileCheck?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}">파일확인</a>
						</td>
						</c:if>
						<td>${aR.adoptRequest.adoptRequestAdviceDate}</td>
							<td>
								<c:if test="${!empty date}">
									<a id="linkCurrentPage" href="${pageContext.request.contextPath}/adopt/adoptCounselList?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}&animalCode=${aR.adoptRequest.animalCode}">상담내용</a>
								</c:if>
							</td>
						<td>${aR.adoptRequest.adoptDecideDate}</td>
						<c:if test="${right eq '관리자'}">
						<td>
							<a href="${pageContext.request.contextPath}/adopt/adoptCancle?adoptRequestCode=${aR.adoptRequest.adoptRequestCode}&animalCode=${aR.adoptRequest.animalCode}">입양취소</a>
						</td>
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>
				<a href="${pageContext.request.contextPath}/"><button type="button" class="btn warning">홈으로</button></a>
			<!-- 내용 부분 끝-->
			
	
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
