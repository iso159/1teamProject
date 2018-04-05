<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h3>게시판그룹추가</h3>
	<form id="boardGroupAdd" action="${pageContext.request.contextPath}/board/boardGroupAdd" method="post">
	게시판 그룹이름:<input type="text" id="boardName" name="boardName">
	<button type="submit">이름등록</button>
	</form>
	<p>&nbsp;</p>
	<h3>게시판 그룹이름 리스트</h3>
	
	<c:forEach var="i" items="${board}">
		<div>
		${i.boardName}&nbsp;
		<a href="${pageContext.request.contextPath}/board/boardDelete?boardCode=${i.boardCode}">삭제</a>
		</div>
	</c:forEach>

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