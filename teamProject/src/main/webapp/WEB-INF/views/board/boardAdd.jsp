<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 글 등록</h2>
	<form id="boardContentAdd" action="${pageContext.request.contextPath}/board/boardList" method="post">
	글종류:<select name="boardCode">
			<option value="board_code_01">체험후기</option>
			<option value="board_code_02">입양후기</option>
		</select>
	글제목:<input type="text" id="boarContentTitle" name="boarContentTitle">
	글내용:<textarea rows="20" cols="50" id="boarContentContent" name="boarContentContent"></textarea>
	</form>
</body>
</html>