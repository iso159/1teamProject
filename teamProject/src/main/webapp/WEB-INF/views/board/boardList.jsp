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
	<h2>게시판</h2>
	<p></p>
	
	<table class="table table-hover">
		<thead>
			<tr>
			<td>번호</td>
			<td>분류</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>등록날짜</td>
			</tr>
		</thead>
		<tbody>
			<c:set var="boardContent" value="${map.boardContent}" />
			<c:forEach var="i" items="${boardContent}">
			<tr>
			<td>${i.boardcontent.boardNumber}</td>
			<td>${i.boardName}</td>
			<td><a href="${pageContext.request.contextPath}/board/boardDetail?boardContentCode=${i.boardcontent.boardContentCode}">${i.boardcontent.boardContentTitle}</a></td>
			<td>${i.boardcontent.mMemberId}</td>
			<td>${i.boardcontent.boardContentDate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 이전,다음 작업 -->
	<div>														  			
		<ul class="pagination">
			<c:set var="currentPage" value="${currentPage}"/> <!-- currentPage = ${currentPage} -->
			<c:if test="${currentPage!=1}"> <!-- if(currentPage!=1) -->
				<li class="page-item">
 					<a class = "page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&boardSearchWord=${boardSearchWord}">이전</a>
 					</li>
 				</c:if>
			<c:if test="${currentPage!=lastPage}"> <!-- if(currentPage!=lastPage) -->
				<li class="page-item">
 					<a class = "page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&boardSearchWord=${boardSearchWord}">다음</a>
 					</li>
			</c:if>
			</ul> 	
	</div>
	<!-- 조건검색 -->
	<form ID="selectForm" action="${pageContext.request.contextPath}/board/boardCategory" method="post">
		<select name="boardCategory">
			<option value="m_member_id">아이디</option>
			<option value="board_content_title">제목</option>
			<option value="board_content_content">동물식별코드</option>
			<option value="board_content_date">등록날짜</option>
		</select>
		<input type="text" id="selectName" name="selectName">
		<button type="submit">검색</button>
	</form>
	<p></p>
	<a href="${pageContext.request.contextPath}/board/boardAdd">글등록</a><br>
	<a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success">홈으로</button></a>
	<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>