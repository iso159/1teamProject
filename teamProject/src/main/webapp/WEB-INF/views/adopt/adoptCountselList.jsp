<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

	<title>회원상담내용 리스트</title>
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
                    <h1 class="page-header">상담내용</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
			<!-- 테이블 이름 시작 -->
			<div class="panel-heading">${loginId}님 파일리스트</div>
			<!-- 테이블 이름 끝 -->
			<div class="panel-body">
				<div class="row">
				<div class="col-sm-8">
				<div class="dataTables_length" id="dataTables-example_length">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>상담내용</th>
					</tr>
				</thead>	
				<tbody>
				<c:set var="aR" value="${adoptRequest}"/>
					<tr>
						<td>
							${aR.adoptRequestAdviceContents}
						</td><br>
					</tr>
				</tbody>
			</table><br>
			<a href="${pageContext.request.contextPath}/adopt/adoptDecide?adoptRequestCode=${aR.adoptRequestCode}&animalCode=${aR.animalCode}"><button type="submit" class="btn danger">입양결정!</button></a>
			<a href="${pageContext.request.contextPath}/adopt/adoptList"><button type="button" class="btn warning">분양리스트로</button></a><br><br>
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
