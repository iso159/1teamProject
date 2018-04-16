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
                    <h1 class="page-header">체험 일지 작성</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            체험 일지
                        </div>
                        <!-- .panel-heading -->
                        <div class="panel-body">
                        	<form action="${pageContext.request.contextPath}/experience/expJournalAdd" method="post">
                      	  	<input type="hidden" name="expCode" value="${expCode}">
							<input type="hidden" name="expJournalPoint" value="20">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">1. 체험 일지 작성</a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                      		체험 일지를 작성해주세요. 하루 일과를 작성해 주셔도 됩니다. <br><br>
											체험 일지 : <input type="text" name="expJournal"><br><br>
											(다른 체험자가 입력 일지를 확인할수 있습니다.)
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">2. 체험 동물 특징</a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                        	체험 동물 특징을 입력해 주세요.<br><br>
                                        	체험 동물 특징 : <input type="text" name="expJournalAnimalChar"><br><br>
                                        	(다른 체험자가 입력 특징을 확인할수 있습니다.)
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="submit">입력</button>
                            </form>
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            	</div>
	    <!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
