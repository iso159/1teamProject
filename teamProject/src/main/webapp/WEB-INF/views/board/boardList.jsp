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
<h2>게시판</h2>
<table>
	<thead>
	<tr>
	<!-- <td>번호</td> -->
	<td>분류</td>
	<td>글제목</td>
	<td>작성자</td>
	<td>등록날짜</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="i" items="${boardContent}">
		<tr>
		
		<td>${i.boardCode}</td>
		<td>${i.boardContentTitle}</td>
		<td>${i.mMemberId}</td>
		<td>${i.boardContentDate}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/board/boardAdd">글등록</a><br>
	<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success">홈으로</button></a>
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