<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title>진료 신청</title>
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
                    <h1 class="page-header">사후진료 신청</h1>
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
				
	<form id="businessLicenseRequestForm"
		  enctype="multipart/form-data"
		  action="${pageContext.request.contextPath}/shelter/shelterClinicRequest" method="post">
		<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
			<tr>
				<td>보호소 명</td>
				<td><input type="text" name="blShelterName" id="shelterName" value="${c.blShelterName}"></td>
			</tr>
			<tr>
				<td>진료 코드</td>
				<td><input type="text" name="scCode" id="scCode" value="${c.scCode}"></td>
			</tr>
			<tr>
				<td>보호소 아아디</td>
				<td><input type="text" name="mShelterId" id="shelterId" value="${c.mShelterId}"></td>
			</tr>
			<tr>
				<td>입양자 아이디</td>
				<td><input type="text" name="mId" id="mId" value="${c.mId}"></td>
			</tr>
			<tr>
				<td>진료 종류</td>
				<td><input type="text" name="osCodeClinicKind" id="CodeClinicKind" value="${c.osCodeClinicKind}"></td>
			</tr>
			<tr>
				<td>진료 상태</td>
				<td><input type="text" name="osCodeClinicStatus" id="codeClinicStatus" value="${c.osCodeClinicStatus}"></td>
			</tr>
			<tr>
				<td>진료 날짜</td>
				<td><input type="text" name="scDate" id="scDate" value="${c.scDate}"></td>
			</tr>
			<tr>
				<td>진료 예약 날짜</td>
				<td><input type="text" name="scReserveDate" id="ReserveDate" value="${c.scReserveDate}"></td>
			</tr>
		</table>
		<button type="button" id="shelterInsertBtn">진료 신청</button>
	</form>
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
			