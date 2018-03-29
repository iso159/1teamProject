<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title>동물 메뉴</title>
</head>
<body>
<div class="container">
		<h2>동물 메뉴</h2>
			<div class="row">
				<div class="col-md-4">				
					<li>
						<a href="${pageContext.request.contextPath}/animal/animalAdd">
							<button type="submit" id="signUpBtn" class="btn btn-info">동물등록</button>
						</a>
					</li><hr>
					<li>
						<a href="${pageContext.request.contextPath}/animal/animalList">
						<button type="submit" id="signUpBtn" class="btn btn-info">동물리스트 </button>
					</li>
				</div>
			</div>
	</div>
</body>
</html>