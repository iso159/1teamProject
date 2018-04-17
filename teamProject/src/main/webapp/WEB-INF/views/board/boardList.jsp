<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>	
		#selectform {
		    float: right;
		    position: relative;
		    left: -50%;
		}
		select {
		    width: 100px;
		    height: 30px;
		    padding-left: 10px;
		    font-size: 18px;
		    color: #006fff;
		    border: 1px solid #006fff;
		    border-radius: 3px;
		}
		#type01 {
		    padding: 10px;
		    font-weight: bold;
		    vertical-align: top;
		    border-top: 2px solid gray;
		}
		#type02{
			padding: 10px;
			
		}
	</style>
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
	<div class="container">
	<h2>게시판</h2>
	<p>&nbsp;&nbsp;</p>
	
	<table class="table table-hover">
		<thead id="type01">
			<tr>
			<td>번호</td>
			<td>분류</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>등록날짜</td>
			</tr>
		</thead>
		<tbody id="type02">
			<c:set var="boardContent" value="${map.boardContent}" />
			<c:forEach var="i" items="${boardContent}">
			<tr>
			<td>${i.boardcontent.boardNumber}</td>
			<td>${i.boardName}</td>
			<td><a href="${pageContext.request.contextPath}/board/boardDetail?boardContentCode=${i.boardcontent.boardContentCode}">${i.boardcontent.boardContentTitle}</a></td>
			<td>${i.boardcontent.mMemberId}</td>
			<td><fmt:parseDate value="${i.boardcontent.boardContentDate}" var="time" pattern="yyyy-MM-dd HH:mm:ss.S"/>
			<fmt:formatDate value="${time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 이전,다음 작업 -->
	<div id="paging">														  			
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
	<p>&nbsp;</p>
	<!-- 조건검색 -->
	<div id="selectform">
	<form ID="selectForm" action="${pageContext.request.contextPath}/board/boardList" method="GET">
		<select name="boardCategory">
			<option value="m_member_id">아이디</option>
			<option value="board_content_title">제목</option>
			<option value="board_content_content">내용</option>
			<option value="board_content_date">등록날짜</option>
		</select>
		<input type="text" id="boardSearchWord" name="boardSearchWord">
		<button type="submit">검색</button>
	</form>
	</div>
	</div>
	
	<%-- <p>&nbsp;</p>
	<a href="${pageContext.request.contextPath}/board/boardAdd"><button type="button" class="btn btn-success">글등록</button></a><br> --%>
	<p>&nbsp;</p>
	<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>