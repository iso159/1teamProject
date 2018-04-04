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
	    <h3>게시글 수정하기</h3>
	    <p>&nbsp;</p>
	   <table>
		   <tr>
		   <td>
		   	<select>
		   		<c:forEach var="i" items="${board}">
		   		<option value="${i.boardName}">${i.boardName}</option>
		   		</c:forEach>
		   	</select>
		   </td>
		   </tr>
		   <tr>
		   	<td><input type="text" name="boardName" value="${bc.boardcontent.boardContentTitle}"></td>
		   </tr>
		   <tr>
		   	<td><textarea rows="20" cols="100" name="boardContent">${bc.boardcontent.boardContentContent}</textarea>
		   </tr>	   
	   </table>	   
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