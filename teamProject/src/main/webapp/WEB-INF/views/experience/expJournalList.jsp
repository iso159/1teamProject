<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp" />
	<!-- top 부분 끝-->
		<!-- 메인화면 시작 -->
		<!-- 내용 부분 시작-->
		<c:if test="${empty expJournal}">
			<script>
			alert('기록이 없습니다.');
			window.history.back();
			</script>
		</c:if>
        <div id="page-wrapper">
        	<c:forEach var="e" items="${expJournal}" varStatus="status">
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${status.count}번째 일지</h1>
                </div>
            </div>
            <div class="panel panel-default">
				<!-- 테이블 이름 시작 -->
				<div class="panel-heading"></div>
				<!-- 테이블 이름 끝 -->
				<div class="panel-body">
	<%-- 				<div class="row">
						<div class="col-sm-8">
							<div class="dataTables_length" id="dataTables-example_length">
								<label> 페이징수 <select name="rowPerPage"
									onchange="location.href=this.value"
									class="form-control input-sm">
										<option value="#">개수 선택</option>
										<option
											value="${pageContext.request.contextPath}/experience/oneAnimalExpList?rowPerPage=5&animalCode=${animalCode}">5개씩
											보기</option>
										<option
											value="${pageContext.request.contextPath}/experience/oneAnimalExpList?rowPerPage=10&animalCode=${animalCode}">10개씩
											보기</option>
										<option
											value="${pageContext.request.contextPath}/experience/oneAnimalExpList?rowPerPage=15&animalCode=${animalCode}">15개씩
											보기</option>
								</select> 리스트
								</label>
							</div>
						</div>
						<div class="col-sm-4">
							<div id="dataTables-example_filter" class="dataTables_filter"
								style="float: right;">
								<label>Search:(공사중)<input type="search"
									class="form-control input-sm" placeholder=""
									aria-controls="dataTables-example">
								</label>
							</div>
						</div>
					</div> --%>
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<td>체험 등록 일자</td>
								<td>체험 일지</td>
								<td>체험 동물 특징</td>
								<td>획득 포인트</td>
								<td>수정</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${e.expJournalDate}</td>
								<td>${e.expJournal}</td>
								<td>${e.expJournalAnimalChar}</td>
								<td>${e.expJournalPoint}</td>
								<td>
								<a href="${pageContext.request.contextPath}/experience/expJournalModify?expJournalCode=${e.expJournalCode}">
								<button>수정</button>
								</a>
								</td>
							</tr>
						</tbody>
					</table>
					<%-- <div class="row">
						<div class="col-sm-5">
							<div class="dataTables_info" id="dataTables-example_info"
								role="status" aria-live="polite">${returnMap.startRow+1}번~
								${returnMap.rowPerPage * returnMap.currentPage}번 까지 총
								${returnMap.totalCount}개</div>
						</div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="dataTables-example_paginate">
								<ul class="pagination">
									<li class="paginate_button previous"
										aria-controls="dataTables-example" tabindex="0"
										id="dataTables-example_previous"><a
										href="<c:if test="${returnMap.startRow gt 0}">${pageContext.request.contextPath}/experience/oneAnimalExpList?animalCode=${animalCode}&currentPage=${returnMap.currentPage-1}&rowPerPage=${returnMap.rowPerPage}</c:if>">«</a>
									</li>
									<c:forEach var="i" begin="0" end="${returnMap.lastPage-1}">
										<li class="paginate_button" aria-controls="dataTables-example"
											tabindex="0"><a
											href="${pageContext.request.contextPath}/experience/oneAnimalExpList?animalCode=${animalCode}&currentPage=${i+1}&rowPerPage=${returnMap.rowPerPage}">${i+1}</a>
										</li>
									</c:forEach>
									<li class="paginate_button next"
										aria-controls="dataTables-example" tabindex="0"
										id="dataTables-example_next"><a
										href="<c:if test="${returnMap.currentPage lt returnMap.lastPage}">${pageContext.request.contextPath}/experience/oneAnimalExpList?animalCode=${animalCode}&currentPage=${returnMap.currentPage+1}&rowPerPage=${returnMap.rowPerPage}</c:if>">»</a>
									</li>
								</ul>
							</div>
						</div>
					</div> --%>
				</div>
			</div>
			</c:forEach>
			</div>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
