<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title></title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp" />
	<!-- top 부분 끝-->
	<!-- 메인화면 시작 -->
	<div id="page-wrapper">
		<!-- h태그제목 시작 -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">개인 회원 체험 리스트</h1>
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
									<label> 페이징수
									<select name="rowPerPage" onchange="location.href=this.value" class="form-control input-sm">
									<option value="#">개수 선택</option>
									<option value="${pageContext.request.contextPath}/experience/expList?rowPerPage=5">5개씩 보기</option>
									<option value="${pageContext.request.contextPath}/experience/expList?rowPerPage=10">10개씩 보기</option>
									<option value="${pageContext.request.contextPath}/experience/expList?rowPerPage=15">15개씩 보기</option>
									</select> 리스트
									</label>
								</div>
							</div>
							<div class="col-sm-4">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<label>Search:<input type="search" class="form-control input-sm" placeholder="" aria-controls="dataTables-example">
									</label>
								</div>
							</div>
						</div>
						<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
							<thead>
								<tr>
									<th>품종</th>
									<th>신청한날짜</th>
									<th>시작 날짜</th>
									<th>종료 날짜</th>
									<th>체험 상태</th>
									<th>상세 정보</th>
									<th>설문 조사</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="a" items="${expAndAnimal.expAndAnimal}">
									<c:set var="expC" value="${a.overallStatus.osName}"></c:set>
									<tr>
										<td>${a.animal.animalBreed}</td>
										<td>${a.exp.expReserveRequestDate}</td>
										<td>${a.exp.expStartDate}</td>
										<td>${a.exp.expEndDate}</td>
										<td>${a.overallStatus.osName}</td>
										<td>
										<a href="${pageContext.request.contextPath}/experience/expInfo?expCode=${a.exp.expCode}">정보 확인</a></td>
										<c:if test="${expC eq '체험 완료'}">
											<td><a
												href="${pageContext.request.contextPath}/survey/surveyMemberAdd?expCode=${a.exp.expCode}">설문하기</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-7">
								<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">${expAndAnimal.startRow+1}번 ~ ${expAndAnimal.rowPerPage * expAndAnimal.currentPage}번 까지 총 ${expAndAnimal.totalCount}개</div>
							</div>
							<div class="col-sm-5">
								<div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
									<ul class="pagination">
										<li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
											<a href="#">Previous</a>
										</li>
										<c:forEach var="i" begin="0" end="${expAndAnimal.lastPage-1}">
										<li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
										<a href="${pageContext.request.contextPath}/experience/expList?currentPage=${i+1}&rowPerPage=${expAndAnimal.rowPerPage}">${i+1}</a>
										</li>
										</c:forEach>
										<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next">
										<a href="#">Next</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 내용 부분 끝-->
		<!-- foot 부분 시작 -->
		<jsp:include page="/WEB-INF/views/module/foot.jsp" />
		<!-- foot 부분 끝 -->
</body>
</html>
