<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title></title>
</head>
<body>
<div class="container">
		<h2>회원 메뉴</h2>
		<form id="edong" class="form-inline" action="${pageContext.request.contextPath}/member/memberAdd" method="post">
			<div class="row">
				<div class="col-md-4">ss				
					<button type="submit" id="signUpBtn" class="btn btn-info">회원가입 하러가기</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>