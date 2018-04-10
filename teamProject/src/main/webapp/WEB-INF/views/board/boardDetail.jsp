<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    
    <c:set var="login" value="${loginId}"></c:set>
    
	<!-- 게시판그룹이름 -->
	<h2>${bc.boardName}</h2>
	<hr color="gray" width=100%>
	<!-- 게시판제목 -->
	<h3>${bc.boardcontent.boardContentTitle}</h3>
	<!-- 등록날짜 -->
	<div style="color:gray;">${bc.boardcontent.boardContentDate}</div>
	<p>&nbsp;</p>
	<!-- 사진 -->
	
	<!-- 게시판내용시작 -->
	${bc.boardcontent.boardContentContent}<br>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<!-- 파일리스트 -->
	
	<c:forEach var="i" items="${bcFile}">
		<a href="${pageContext.request.contextPath}/board/boardFileDownLoad">${i.ofOriginName}</a><br>
	</c:forEach>
	
	<p>&nbsp;</p>
	<c:if test="${login eq bc.boardcontent.mMemberId}">
	<a href="${pageContext.request.contextPath}/board/boardContentUpdate?boardContentCode=${bc.boardcontent.boardContentCode}"><button>수정</button></a>
	<a href="${pageContext.request.contextPath}/board/boardContentDelete?boardContentCode=${bc.boardcontent.boardContentCode}"><button>삭제</button></a>
	</c:if>
	<p>&nbsp;</p>
	
	<form action="${pageContext.request.contextPath}/board/boardReplyAdd" method="post">
	<table style='line-height:200%'>
	<tr>
	<td><b>댓글</b></td>
	</tr>
	<tr>
	<td><input type="hidden" id="boardContentCode" name="boardContentCode" value="${bc.boardcontent.boardContentCode}"></td>
	</tr>
	<tr>
	<td><textarea rows="2" cols="100" id="boardReplyContent" name="boardReplyContent"></textarea></td>
	</tr>
	<tr>
	<td><button type="submit">등록</button></td>
	</tr>
	</table>
	</form>
	<p>&nbsp;</p>
	
	<c:forEach var="i" items="${br}">
		<div style="color:gray"><b>${i.mMemberId}</b></div>
		${i.boardReplyContent}&nbsp;<c:if test="${login eq i.mMemberId}"><a href="${pageContext.request.contextPath}/board/boardReplyDelete?boardReplyCode=${i.boardReplyCode}&boardContentCode=${i.boardContentCode}">삭제</a></c:if><br>
		<div style="color:gray;">${i.boardReplyDate}</div>
		<br>
	</c:forEach>	
	<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>