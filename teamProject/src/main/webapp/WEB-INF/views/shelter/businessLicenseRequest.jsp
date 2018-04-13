<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<script>
	$(document).ready(function(){
		$('#shelterInsertBtn').click(function(){
			// 폼의 값들에 공백을 지움
			let shelterName = $.trim($('#shelterName').val());
			let shelterNum = $.trim($('#shelterNum').val());
			let shelterRegNumber = $.trim($('#shelterRegNumber').val());
			let shelterAddr = $.trim($('#shelterAddr').val());
			
			// 공백 유효성 검사
			if(shelterName==="" | shelterNum==="" | shelterRegNumber==="" | shelterAddr===""){
				alert("공백은 입력할 수 없습니다.");
			}else{
				$('#businessLicenseRequestForm').submit();
			}
		});
	});
</script>
	<title>보호소 신청</title>
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
                    <h1 class="page-header">대표보호소 신청</h1>
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
					  action="${pageContext.request.contextPath}/shelter/businessLicenseRequest"
					  method="post">
					<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
						<tr>
							<td>보호소 명</td>
							<td><input type="text" name="blShelterName" id="shelterName"></td>
						</tr>
						<tr>
							<td>보호소 전화번호</td>
							<td><input type="text" name="blShelterNumber" id="shelterNum"></td>
						</tr>
						<tr>
							<td>보호소 등록 번호</td>
							<td><input type="text" name="blShelterRegNumber" id="shelterRegNumber"></td>
						</tr>
						<tr>
							<td>보호소 주소</td>
							<td><input type="text" name="blShelterAddress" id="shelterAddr"></td>
						</tr>
						<tr>
							<td>사업자 등록증 파일</td>
							<td><input type="file" name="multipartFile" id="shelterFile" multiple="multiple"></td>
						</tr>
					</table>
					<button type="button" id="shelterInsertBtn">대표 보호소 신청</button>
				</form>
				</div>
				</div>
				</div>
				</div>
				</div>
	</div>
	  </div>
	</section>
	<!-- 메인내용 끝 : Text | Text -->

	<!-- 내용 입력 부분 끝 -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
