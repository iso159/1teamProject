<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
<title>Insert title here</title>
 <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	<!-- 메인화면 시작 -->
	<div id="page-wrapper">
		<!-- h태그제목 시작 -->
		<!-- 체험자 로그인 시작 -->
		<div class="container" style="width:500px; height:400px; float:left;">
			<div class="row">
				<div class="col-md-10"  style="min-width: 200px;">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">체험자 로그인</h3>
						</div>
						<div class="panel-body">
							<form role="form" id="loginForm"  action="${pageContext.request.contextPath}/member/login" method="post">
								<fieldset>
									<div class="form-group">
										<input id="userId" class="form-control" name="mId" type="text" value="experience">
									</div>
									<div class="form-group">
										<input id="userPw" class="form-control" name="mPw" type="password" value="1234">
									</div>
									<div class="checkbox">
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<button type="submit" id="loginBtn" class="btn btn-lg btn-info btn-block">Login</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
			</div>
		<!-- 체험자 로그인 끝 -->

		<!-- 입양자 로그인 시작 -->
		<div class="container" style="width:500px; height:400px; float:left;">
			<div class="row">
				<div class="col-md-10"  style="min-width: 200px;">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">입양자 로그인</h3>
						</div>
						<div class="panel-body">
							<form role="form" id="loginForm"  action="${pageContext.request.contextPath}/member/login" method="post">
								<fieldset>
									<div class="form-group">
										<input id="userId" class="form-control" name="mId" type="text" value="adopter">
									</div>
									<div class="form-group">
										<input id="userPw" class="form-control" name="mPw" type="password" value="1234">
									</div>
									<div class="checkbox">
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<button type="submit" id="loginBtn" class="btn btn-lg btn-info btn-block">Login</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
			</div>
		<!-- 입양자 로그인 끝 -->

		<!-- 보호소 로그인 시작 -->
		<div class="container" style="width:500px; height:400px; float:left;">
			<div class="row">
				<div class="col-md-10"  style="min-width: 200px;">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">보호소 로그인</h3>
						</div>
						<div class="panel-body">
							<form role="form" id="loginForm"  action="${pageContext.request.contextPath}/member/login" method="post">
								<fieldset>
									<div class="form-group">
										<input id="userId" class="form-control" name="mId" type="text" value="shelter">
									</div>
									<div class="form-group">
										<input id="userPw" class="form-control" name="mPw" type="password" value="1234">
									</div>
									<div class="checkbox">
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<button type="submit" id="loginBtn" class="btn btn-lg btn-info btn-block">Login</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
			</div>
		<!-- 보호소 로그인 끝 -->

		<!-- 보호소 로그인 시작 -->
		<div class="container" style="width:500px; height:400px; float:left;">
			<div class="row">
				<div class="col-md-10"  style="min-width: 200px;">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">관리자 로그인</h3>
						</div>
						<div class="panel-body">
							<form role="form" id="loginForm"  action="${pageContext.request.contextPath}/member/login" method="post">
								<fieldset>
									<div class="form-group">
										<input id="userId" class="form-control" name="mId" type="text" value="administrator">
									</div>
									<div class="form-group">
										<input id="userPw" class="form-control" name="mPw" type="password" value="1234">
									</div>
									<div class="checkbox">
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<button type="submit" id="loginBtn" class="btn btn-lg btn-info btn-block">Login</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<!-- 보호소 로그인 끝 -->

	<!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
