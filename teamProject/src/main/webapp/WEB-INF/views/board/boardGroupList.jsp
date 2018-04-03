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
<h2>게시판그룹추가</h2>
	<form id="boardGroupAdd" action="${pageContext.request.contextPath}/board/boardGroupAdd" method="post">
	게시판 그룹이름:<input type="text" id="boardName" name="boardName">
	<button type="submit">이름등록</button>
	</form>
	
	게시판 그룹이름 리스트
	<c:forEach var="i" items="${board}">
		<div>${i.boardName}</div>
	</c:forEach>
</body>
</html>