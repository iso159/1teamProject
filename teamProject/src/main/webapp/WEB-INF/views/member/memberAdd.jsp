<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#duplication").click(function(){
			if($("#mId").val()){
				var query = {id:$("#checkMemberId").val()};
				$.ajax({
					url : "/member/memberAdd",
					type : "post",
					data : query,
					success : function(data){
						if(data==1){
							alert("사용할 수 없는 아이디");
							$("#mId").val("");
						}else if(data==-1){
							alert("사용할 수 있는 아이디 입니다.");
						}
					}
				});
			}else{
				alert("사용할 아이디를 입력하세요");
				$("#mId").focus();
			}
		});
	});
</script>
	<title>회원가입</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<section>
	<div id="page-wrapper">
		<div data-layout="_r">
			<div>
				<!-- 내용 입력 부분 -->
				<div class="container">
					<div>
						<h2 class="page-header">회원가입</h2>
						<div class="col-lg-4">
							<div>
								<form role="form" id="signUpForm" action="${pageContext.request.contextPath}/member/memberAdd" method="post">
									아이디 
									<input class="form-control" type="text" name="mId" placeholder="아이디" required/>
									<input type="button" id="duplication" value="아이디 중복검사"/>
									비밀번호 
									<input class="form-control" type="password" name="mPw"><br>
									이름 
									<input class="form-control" type="text" name="mInfoName"><br> 
									닉네임 
									<input class="form-control" type="text" name="mInfoNickname"><br> 
									성별 
									<input class="form-control" type="text" name="mInfoGender"><br> 
									생년월일 
									<input class="form-control" type="text" name="mInfoBirth"><br> 
									우편번호 
									<input class="form-control" type="text" name="mInfoPostcode"><br> 
									주소 
									<input class="form-control" type="text" name="mInfoAddress"><br> 
									이메일 
									<input class="form-control" type="text" name="mInfoEmail"><br> 
									핸드폰 
									<input class="form-control" type="text" name="mInfoPhone"><br>
									<button id="addBtn" type="submit" class="btn btn-warning">회원가입</button>
								</form>
							</div>
						</div>
						<!-- 내용 입력 부분 끝 -->
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 메인 화면 내용 끝 -->
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>