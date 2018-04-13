<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>보호소 대표 신청 거절 </title>
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
                    <h1 class="page-header">보호소 대표 신청 거절 폼</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
			<!-- 테이블 이름 시작 -->
			<div class="panel-heading">보호소 대표 신청 거절</div>
			<!-- 테이블 이름 끝 -->
			<div class="panel-body">
				<div class="row">
				<div class="dataTables_length" id="dataTables-example_length">
				<div class="table-responsive">
					<form action="${pageContext.request.contextPath}/shelter/businessLicenseDeny" method="POST">
						<input type="hidden" name="blCode" value="${blCode}">
						<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
							<tr>
								<td><textarea rows="10" cols="100" name="blShelterDenyReason"></textarea></td>
							<tr>
							<tr>
								<td style="text-align: right"><button type="submit">거절 사유 등록</button></td>
							<tr>
						</table>
					</form>
					</div>
					</div>
					</div>
					</div>
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
			