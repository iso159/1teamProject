<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title></title>
</head>
<body>
<div class="container">
		<h2>입양 메뉴</h2>
		<form id="edong" class="form-inline" action="${pageContext.request.contextPath}/adopt/adoptRequest">
			<div class="row">
				<div class="col-md-4">				
					<li>
						<button type="submit" id="signUpBtn" class="btn btn-info">입양신청 하러가기</button>
					</li>
				</div>
			</div>
		</form>
	</div>
</body>
</html>