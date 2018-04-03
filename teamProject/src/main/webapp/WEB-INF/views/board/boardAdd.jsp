<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
	<!-- 메인내용 시작 : Text | Text -->
	<section>
	  <div data-layout="_r">
	    <div>
	    <!-- 내용 입력 부분 -->
<h2>게시판 글 등록</h2>
	<form id="boardContentAdd" action="${pageContext.request.contextPath}/board/boardList" method="post">
	글종류:<select name="boardCode">
			<option value="board_code_01">체험후기</option>
			<option value="board_code_02">입양후기</option>
		</select><br>
	글제목:<input type="text" id="boardContentTitle" name="boardContentTitle"><br>
	글내용:<br>
	<textarea rows="20" cols="50" id="boardContentContent" name="boardContentContent"></textarea><br>
	<button id="addBtn" type="submit">등록</button>
	</form>
	<!-- 내용 입력 부분 끝 -->
		</div>
	  </div>
	</section>
	<!-- 메인내용 끝 : Text | Text -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>