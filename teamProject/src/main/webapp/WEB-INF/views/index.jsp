<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
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
                    <h1 class="page-header">Team Project Intro</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			
			<!-- 프로젝트  -->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h3>프로젝트 소개</h3>
                            <p>반려동물 인구 1000만시대를 맞아 성숙한 반려 문화가 요구되는 요즘 유기동물 또한 급증하고 있다. 유기동물 체험을 통해 분양을 활성화 하고 주민 사이의 인식차이 극복과 동물 복지에 대한 의식 개선을 이뤄내는 데 목적이 있다.</p>
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th colspan="2">
                                              	  개발환경
                                                <small></small>
                                            </th>
                                            <th>
                                                	서비스환경
                                                <small></small>
                                            </th>
                                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th>OS</th>
                                            <td colspan="2">Linux</td>
                                           
                                        </tr>
                                        <tr>
                                            <th>웹 브라우저</th>
                                            <td colspan="2">Crome</td>
                                            
                                        </tr>
                                        <tr>
                                            <th>WAS</th>
                                            <td colspan="2">
                                               apache-tomcat-8.0.X
                                            </td>
                                            
                                        </tr>
                                        <tr>
                                            <th rowspan="7">개발언어</th>
                                        </tr>
                                        <tr>
                                            <th rowspan="2">서버</td>
                                           	<td>Java 1.8</td>
                                        </tr>
                                        <tr>
                                        	<td>Servlet 3.1</td>
                                        </tr>
                                        <tr>
                                        	<th rowspan="5">클라이언트</td>
                                       		<td>JavaScript</td>
                                        </tr>
                                         <tr>
                                        	
                                        </tr>
                                         <tr>
                                        	<td>HTML5</td>
                                        </tr>
                                         <tr>
                                        	<td>CSS</td>
                                        	
                                        </tr>
                                         <tr>
                                        	<td>JSP</td>
                                        </tr>
                                        <tr>
                                        	<td>JQuery</td>
                                        </tr>
                                        <tr>
                                            <th>Framework</th>
                                            <td colspan="2">bootstrap 3.3.6</td>
                                        </tr>
                                        <tr>
                                            <th>DBMS</th>
                                            <td>MySQL5.7</td>
                                        </tr>
                                        <tr>
                                            <th>Tools</th>
                                         	<td colspan="2">Spring Tool Suite 3.9.2</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <p>Grid classes apply to devices with screen widths greater than or equal to the breakpoint sizes, and override grid classes targeted at smaller devices. Therefore, applying any
                                <code>.col-md-</code> class to an element will not only affect its styling on medium devices but also on large devices if a
                                <code>.col-lg-</code> class is not present.</p>
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
			
			<!-- 팀프로젝트 및 팀원소개 시작 -->
			<div class="chat-panel panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-heart fa-fw"></i> Introduction
                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="chat">
                                <li class="left clearfix">
                                    <span class="chat-img pull-left">
                                        <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <strong class="primary-font">
                                             <i class="fa fa-user fa-fw"></i>프로젝트 팀원 소개</strong>
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 12 mins ago
                                            </small>
                                        </div>
                                        <p>
                                        	한국스마트정보교육원 26기 개발자
                                        </p>
                                    </div>
                                </li>
                                <li class="right clearfix">
                                    <span class="chat-img pull-right">
                                        <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <small class=" text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 13 mins ago</small>
                                            <strong class="pull-right primary-font">
                                            <i class="fa fa-github-alt fa-fw"></i>김장성</strong>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                                <li class="left clearfix">
                                    <span class="chat-img pull-left">
                                        <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <strong class="primary-font">
                                            <i class="fa fa-github-alt fa-fw"></i>송인석</strong>
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 14 mins ago</small>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                                <li class="right clearfix">
                                    <span class="chat-img pull-right">
                                        <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <small class=" text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 15 mins ago</small>
                                            <strong class="pull-right primary-font">
                                            <i class="fa fa-github-alt fa-fw"></i>김항수</strong>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                                <li class="left clearfix">
                                    <span class="chat-img pull-left">
                                        <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <strong class="primary-font">
                                            <i class="fa fa-github-alt fa-fw"></i>진 영</strong>
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 14 mins ago</small>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                                <li class="right clearfix">
                                    <span class="chat-img pull-right">
                                        <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <small class=" text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 15 mins ago</small>
                                            <strong class="pull-right primary-font">
                                            <i class="fa fa-github-alt fa-fw"></i>차선영</strong>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <div class="input-group">
                                <input id="btn-input" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                                <span class="input-group-btn">
                                    <button class="btn btn-warning btn-sm" id="btn-chat">
                                        Send
                                    </button>
                                </span>
                            </div>
                        </div>
                        <!-- /.panel-footer -->
                    </div>
			<!-- 내용 부분 끝-->
			</div>
	
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
