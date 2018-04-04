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
    <c:set var="login" value="${loginId}"></c:set>
	<!-- 게시판그룹이름 -->
	<h2>${bc.boardName}</h2>
	<hr color="gray" width=100%>
	<!-- 게시판제목 -->
	<h4>${bc.boardcontent.boardContentTitle}</h4>
	<hr color="lightgray" width=100%>
	<!-- 게시판내용시작 -->
	${bc.boardcontent.boardContentContent}<br>
	<p>&nbsp;</p>
	<c:if test="${login eq bc.boardcontent.mMemberId}">
	<a href="${pageContext.request.contextPath}/board/boardContentUpdate?boardContentCode=${bc.boardcontent.boardContentCode}"><button>수정하기</button></a>
	</c:if>
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