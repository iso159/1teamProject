<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	 <link rel="icon" type="image/png"  href="${pageContext.request.contextPath}/resources/img/dog.png"/>
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
                    <h1 class="page-header"><i class="fa fa-cube"></i>Team Project Intro</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			
			<!-- 프로젝트  -->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                         <i class="fa fa-play-circle-o"></i>프로젝트 시작하기<p class="text-left"><button onclick = "location.href='${pageContext.request.contextPath}/member/login'" type="button" class="btn btn-danger btn-sm">Get Start!</button></p>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                         <!-- Nav tabs -->
                            <ul class="nav nav-pills">
                                <li class="active"><a href="#home-pills" data-toggle="tab">프로젝트소개</a>
                                </li>
                                <li><a href="#profile-pills" data-toggle="tab">전체기능 분석도</a>
                                </li>
                                <li><a href="#messages-pills" data-toggle="tab">ERD</a>
                                </li>
                                
                            </ul>
                          <!-- Nav tabs 끝 -->
                          <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="home-pills">
	                            <h3><i class="fa fa-quote-left  "></i>프로젝트 소개<i class="fa fa-quote-right"></i></h3>
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
	                                            <td colspan="2">Windows 7</td>
	                                           	<td>Windows 7</td>
	                                        </tr>
	                                        <tr>
	                                            <th>웹 브라우저</th>
	                                            <td colspan="2">Chrome</td>
	                                            <td>Chrome 최적화</td>
	                                        </tr>
	                                        <tr>
	                                            <th>WAS</th>
	                                            <td colspan="2">
	                                               apache-tomcat-8.0.X
	                                            </td>
	                                            <td>apache-tomcat-8.0.X</td>
	                                        </tr>
	                                        <tr>
	                                            <th rowspan="9">개발언어</th>
	                                        </tr>
	                                        <tr>
	                                            <th rowspan="3">서버</td>
	                                           	<td>Java 1.8</td>
	                                           	<td>Servlet 3.1</td>
	                                        </tr>
	                                        <tr>
	                                        	<td>Servlet 3.1</td>
	                                        	<td>JDK 1.8.X</td>
	                                        </tr>
	                                        <tr>
	                                        	<td></td>
	                                        	<td>JSP 2.3</td>
	                                        </tr>
	                                        <tr>
	                                        	<th rowspan="5">클라이언트</td>
	                                       		<td>JavaScript</td>
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
	                                        	<td>jQuery</td>
	                                        </tr>
	                                        <tr>
	                                            <th rowspan="3">Framework</th>
	                                            <td colspan="3">bootstrap 3.3.6</td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="3">Spring Framework 4.3.7</td>
	                                        </tr>
	                                         <tr>
	                                            <td colspan="3">Mybatis 3.4.1</td>
	                                        </tr>
	                                        <tr>
	                                            <th>DBMS</th>
	                                            <td colspan="2">MySQL5.7</td>
	                                            <td>MySQL5.5.X UTF-8</td>
	                                        </tr>
	                                        <tr>
	                                            <th rowspan="6">Tools</th>
	                                         	<td colspan="2">Spring Tool Suite 3.9.2</td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2">MySQL Workbench 6.3.10</td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2">GitHub(https://github.com/iso159/1teamProject)</td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2">eXERD</td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2">SourceTree</td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2">Maven</td>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                            <!-- 프로젝트소개 끝 -->
                            
                            <p></p>
                        </div>
	                        <!-- 전체기능 구성도 -->
	                        <div class="tab-pane fade" id="profile-pills">
	                            <h3><i class="fa fa-quote-left  "></i>전체기능 구성도<i class="fa fa-quote-right"></i></h3>
	                        	<p><img src="${pageContext.request.contextPath}/resources/img/process.png" width:100%></p>
	                         </div>
	                        <!-- 전체기능 구성도 끝 -->
	                        <!-- ERD -->
	                        <div class="tab-pane fade" id="messages-pills">
	                      	 <h3><i class="fa fa-quote-left  "></i>물리 ERD<i class="fa fa-quote-right"></i></h3>
	                      	 <p><img src="${pageContext.request.contextPath}/resources/img/P_erd.jpg" width:100%></p>
	                     	</div>
	                        <!-- ERD 끝 -->
                      </div>
                    </div>
                </div>
            </div>
            </div>
            <!-- 프로젝트 끝 -->
            
        
            
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
                                            <i class="fa fa-github-alt fa-fw"></i>김장성(팀장)</strong>
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
                                            <i class="fa fa-github-alt fa-fw"></i>송인석(팀원)</strong>
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 14 mins ago</small>
                                        </div>
                                        <p>
                                            개인 프로젝트를 진행할때는 계획을 수립하고 문제를 해결할 때 혼자 진행하기 때문에 스스로 해결하면 됬지만 팀 프로젝트를 진행할때는 계획을 수립할 때도 의견충돌이 생기고 문제 해결 시에도 충돌이 생겼습니다. 하지만 이를 통해 해결된 문제나 자료들은 더 정교하고 완성도가 높아졌습니다. 개개인의 생각이 모여서 다듬어지고 나온 자료와 개인의 생각이 모여 다듬어진 자료는 차이가 큰 것 같습니다.마지막 들어서 급하게 한 것 같지만 그래도 열심히 노력해준 팀원 분들 정말 고생하셨습니다.
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
                                            <i class="fa fa-github-alt fa-fw"></i>김항수(팀원)</strong>
                                        </div>
                                        <p>
                                           팀 프로젝트를 진행하면서 진행전 생각했던 것보다 훨씬 더 많은 시행착오가 생겼고, 그것을 해결하는것에 많은 벽이 있엇지만 팀원들과의 담당역할의 적절한 조율로 문제를 하나하나 풀어나갔습니다. 처음이지만 이번 프로젝트를 해보면서 프로젝트란 것이 절대로 코드가 중요한게 아니라는 생각을 깊히 새기게 되었습니다. 확실한 EDR 그리고 데이터베이스 설계가 정말 중요하고 그것을 확실하게 만든다는 것은 앞으로 내가 더 열심히 배우고 익혀나가야 한다는 것을 느꼈습니다.
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
                                            <i class="fa fa-github-alt fa-fw"></i>진 영(팀원)</strong>
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 14 mins ago</small>
                                        </div>
                                        <p>
                                           약 2개월간의 팀프로젝트를 진행하며 수업 중에 배웠던 내용들을 활용하여 한층 더 성장하는 시간이였습니다. 5명으로 구성된 팀으로 프로젝트 한 경험은 처음이라 걱정도 많이 되었지만, 팀장은 팀원들을 잘 이끌어 주었고, 팀원들은 팀장과 팀원 서로를 잘 도와주고 협력하여 원활하게 프로젝트가 진행되었던 것 같습니다. 코드 구현도 중요하지만 설계부분 또한 중요하다는 것, 팀원들간의 의사소통능력과 통일성, 그리고 할 수 있다는 자신감을 가져야 한다는 것을 느꼈습니다. 개발자로서 꼭 필요한 경험을 하고 수료해서 뿌듯합니다. 마지막까지 고생한 팀원들에게 감사합니다.
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
                                            <i class="fa fa-github-alt fa-fw"></i>차선영(팀원)</strong>
                                        </div>
                                        <p>
                                           회사에서 프로젝트를 진행해보지 못했지만 팀프로젝트를 진행하며 비슷한 경험을 해볼 수 있는 기회가 된 것 같습니다. 그리고 수업시간에 배운 내용들을 적용해보면서 다시 정리할 수 있는 시간이었습니다. 팀원들 각각의 역할도 중요하지만 팀원들 간에 소통이 정말 중요하다고 느꼈습니다. 혼자 해결하기 어려운 부분은 팀원들과 협력하면서 문제 해결하였고, 문제해결을 하면서 많이 배우고 성장할 수 있었습니다. 
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
