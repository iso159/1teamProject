<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인화면 시작 -->
        <div id="page-wrapper">
        	<!-- h태그제목 시작 -->
        	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">홈화면</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
		    <form action="${pageContext.request.contextPath}/experience/expJournalAdd" method="post">
		    <input type="hidden" name="expCode" value="${expCode}"><br>
		    체험 일지 : <input type="text" name="expJournal"><br>
		    <input type="hidden" name="expJournalPoint" value="20"><br>
		    체험 동물 특징 : <input type="text" name="expJournalAnimalChar"><br>
		    <button type="submit">입력</button>
		    </form>
	    <!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
