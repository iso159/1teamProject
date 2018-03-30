<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title></title>
</head>
<body>
	<div class="container">
		<h2>상품 메뉴</h2>
			<div class="row">
				<div class="col-md-4">
					<a href="${pageContext.request.contextPath}/goods/goodsAdd">
						<button type="button" id="signUpBtn" class="btn btn-info"> 상품 등록</button>
					</a>
				</div>
				<div class="col-md-4">
					<a href="${pageContext.request.contextPath}/goods/goodsList">
						<button type="button" id="signUpBtn" class="btn btn-info"> 상품 리스트</button>
					</a>
				</div>
			</div> 
	</div>
</body>
</html>