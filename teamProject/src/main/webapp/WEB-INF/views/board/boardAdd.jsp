<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
                    <h1 class="page-header"></h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
	<h2>게시판 글 등록</h2>
	<p>&nbsp;</p>
	<form id="boardContentAdd" action="${pageContext.request.contextPath}/board/boardAdd" method="post">
	글종류:<select name="boardCode">
		 <c:forEach var="i" items="${board}">
			<option value="${i.boardCode}">${i.boardName}</option>
		</c:forEach>
		</select><br>
	글제목:<input type="text" id="boardContentTitle" name="boardContentTitle"><br>
	글내용:<br>
	<textarea rows="20" cols="100" id="boardContentContent" name="boardContentContent"></textarea><br>
	<button id="addBtn" type="submit">등록</button>
	</form>
	<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>