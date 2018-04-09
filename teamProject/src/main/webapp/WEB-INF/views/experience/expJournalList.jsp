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
        <div id="page-wrapper">
        	<c:forEach var="e" items="${expJournal}" varStatus="status">
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${status.count}번째 일지</h1>
                </div>
            </div>
			<table>
				<thead>
					<tr>
						<td>체험 등록 일자</td>
						<td>체험 일지</td>
						<td>체험 동물 특징</td>
						<td>획득 포인트</td>
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
			</c:forEach>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
