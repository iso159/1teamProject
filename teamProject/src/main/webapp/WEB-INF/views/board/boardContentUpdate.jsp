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
	    <h3>게시글 수정하기</h3>
	    <p>&nbsp;</p>
		${bc.boardName}
	    <form action="${pageContext.request.contextPath}/board/boardUpdate" method="post">
	    <table>
	    	<tr>
	    	<td><input type="hidden" name="boardContentCode" value="${bc.boardcontent.boardContentCode}"></td>
	    	</tr>
		    <tr>
	    	<td><input type="text" readonly="readonly" style="background-color: lightgray" value="${bc.boardcontent.mMemberId}"></td>
	    	</tr>
		   <tr>
		   	<td><input type="text" name="boardContentTitle" value="${bc.boardcontent.boardContentTitle}"></td>
		   </tr>
		   <tr>
		   	<td><textarea rows="20" cols="100" name="boardContentContent">${bc.boardcontent.boardContentContent}</textarea>
		   </tr>
		   <tr>
		   	<td><button type="submit">수정</button></td>
		   </tr>	   
	    </table>
	    </form>	   
		<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>