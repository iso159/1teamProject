<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/morrisjs/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
    
</head>
	<!-- wrapper시작 -->
	<div id="wrapper">
	<nav class="navbar navbar-default navbar-static-top" role="navigation"
		style="margin-bottom: 0">
		<!-- 메인 로고부분 -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/"><i class="fa fa-paw"></i>유기동물 체험을 통한 분양 활성화 시스템<i class="fa fa-paw"></i></a>
		</div>
		<!-- 메인 로고부분 끝 -->
		<!-- 메인 상단 로그인 관리 부분 -->
		<ul class="nav navbar-top-links navbar-right">
			<c:set var="login" value="${loginId}"></c:set>
			<c:set var="right" value="${rightName}"></c:set>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user fa-fw"></i><i class="fa fa-caret-down"></i></a>
				<ul class="dropdown-menu dropdown-messages">
					<c:if test="${empty login}">
						<li><a
							href="${pageContext.request.contextPath}/member/memberAdd"><i
								class="fa fa-user fa-fw"></i> 회원가입</a></li>
						<li><a href="${pageContext.request.contextPath}/member/login"><i
								class="fa fa-gear fa-fw"></i> 로그인</a></li>
					</c:if>
					<c:if test="${!empty login}">
						<c:if test="${right eq '관리자'}">
							<li><a
								href="${pageContext.request.contextPath}/member/memberList"><i
									class="fa fa-gear fa-fw"></i> 회원리스트</a></li>
						</c:if>
						<li><a
							href="${pageContext.request.contextPath}/member/memberModify"><i
								class="fa fa-user fa-fw"></i> 회원수정</a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath}/member/memberLogout"><i
								class="fa fa-sign-out fa-fw"></i> 로그아웃</a></li>
					</c:if>
				</ul>
			</li>
		</ul>
		<!-- 메인 상단 로그인 관리 부분 끝 -->

		<!-- 왼쪽 사이드 메뉴 시작 -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="https://github.com/iso159/1teamProject">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button" onclick = "window.open('https://github.com/iso159/1teamProject')">
									<i class="fa fa-git"></i>
								</button>
							</span>
						</div> <!-- /input-group -->
					</li>
					
					<c:if test="${right eq '회원' or right eq '보호소' or right eq '관리자'}">
                    <!-- 보호소 시작 -->
                    <li>
                    	<c:set var="right" value="${rightName}"></c:set>
      					<c:set var="level" value="${rightLevel}"></c:set>
                        <a href="#"><i class="fa fa-hospital-o fa-fw"></i>보호소 관리<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
      						<c:if test="${right eq '회원' and level eq '1'}">
	                            <li>
	                                <a href="${pageContext.request.contextPath}/shelter/businessLicenseRequest">보호소 대표 신청</a>
	                            </li>
                            </c:if>
                            <c:if test="${right eq '회원' or right eq '보호소'}">
	                            <li>
	                                <a href="${pageContext.request.contextPath}/businessLicenseListPersonal">보호소 대표 신청 관리</a>
	                            </li>
                            </c:if>
                            <c:if test="${right eq '회원' and level eq '1'}">
	                            <li>
	                                <a href="${pageContext.request.contextPath}/shelter/staffBusinessLicenseGet">보호소 직원 신청</a>
	                            </li>
	                             <li>
	                                <a href="${pageContext.request.contextPath}/shelter/requestShelterStaffPersonal">보호소 직원 신청 관리</a>
	                            </li>
                            </c:if>
                            <c:if test="${right eq '관리자'}">
	                            <li>
	                                <a href="${pageContext.request.contextPath}/businessLicenseRequestList">대표 보호소 신청 목록</a>
	                            </li>
                            </c:if>
                            <c:if test="${right eq '보호소' and level eq '2'}">
	                            <li>
	                                <a href="${pageContext.request.contextPath}/shelter/requestShelterStaffList">직원 신청 목록</a>
	                            </li>
                            </c:if>
                        </ul>
                    </li>
                    </c:if>
                    <!-- 보호소 끝 -->

					<!-- 체험 시작 -->
					<li>
					<a href="#"><i class="fa fa-dribbble fa-fw"></i> 체험<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<c:if test="${rightLevel ne '2'}">
							<li>
							<a href="${pageContext.request.contextPath}/experience/expAnimalList">체험하기</a>
							</li>
							</c:if>
							<c:if test="${rightLevel ne '2'}">
							<li>
							<a href="${pageContext.request.contextPath}/experience/expList">나의체험리스트</a>
							</li>
							</c:if>
							<c:if test="${rightLevel eq '1' or rightLevel eq '2'}">
							<li><a href="${pageContext.request.contextPath}/experience/expShelterList?blCode=${loginBlCode}">체험 리스트</a></li>
							</c:if>
						</ul>
					</li>
					<!-- 체험 끝 -->

					<!-- 입양 시작 -->
					<li>
					<a href="#"><i class="fa fa-gittip fa-fw"></i> 입양<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
								<c:if test="${right eq '회원'}">
								<li><a
									href="${pageContext.request.contextPath}/adopt/adoptAnimalList">입양신청</a>
								</li>
								<li><a
									href="${pageContext.request.contextPath}/adopt/adoptMyList">나의입양리스트</a>
								</li>
								</c:if>
								<c:if test="${right eq '관리자' or right eq '보호소'}">
								<li><a
									href="${pageContext.request.contextPath}/adopt/adoptList">입양 신청 리스트</a>
								</li>
								</c:if>
								<c:if test="${right eq '관리자' or right eq '보호소'}">
								<li><a
									href="${pageContext.request.contextPath}/adopt/adopterList">입양자 리스트</a>
								</li>
								</c:if>
								
						</ul>
					</li>
					<!-- 입양 끝 -->
			
					<!-- 동물 관리 시작 -->
					<c:if test="${right eq '보호소'}">
					<li>
					<a href="#"><i class="fa fa-paw fa-fw"></i>동물 관리<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<c:set var="right" value="${rightName}"></c:set>
								<li><a
									href="${pageContext.request.contextPath}/animal/animalAdd">동물등록</a>
								</li>
							
							<li><a
								href="${pageContext.request.contextPath}/animal/animalList">동물리스트</a>
							</li>
						</ul>
					</li>
					</c:if>
					<!-- 동물 관리 끝 -->

					<c:if test="${right eq '관리자'}">
						<!-- 설문지 시작 -->
						<li><a href="#"><i class="fa fa-pencil-square-o fa-fw"></i> 설문지<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								
									<li><a
										href="${pageContext.request.contextPath}/survey/surveyAdd">설문지등록</a>
									</li>
									<li><a
										href="${pageContext.request.contextPath}/survey/surveyList">설문지조회</a>
									</li>
							</ul>
						</li>					
						<!-- 설문지 끝 -->
					</c:if>
					
					<c:if test="${right eq '회원' or right eq '보호소' }">
					<!-- 진단 시작 -->
	               <li><a href="#"><i class="fa fa-medkit fa-fw"></i> 진단<span class="fa arrow"></span></a>
	                  <ul class="nav nav-second-level">
	                     <c:set var="login" value="${loginId}"></c:set>
	                     <c:set var="right" value="${rightName}"></c:set>
	                     <c:if test="${right eq '회원'}">
	                        <li>
	                           <a href="${pageContext.request.contextPath}/jindan/jindanShelterList">보호소 진료 예약</a>
	                        </li>
	                     </c:if>
	                        <li>
	                           <a href="${pageContext.request.contextPath}/shelter/shelterClinicRequestList">보호소 진료 예약 리스트</a>
	                        </li>
	                  </ul>
	               </li>
	               <!-- 진단 끝 -->
					</c:if>

					<!-- 게시판 시작 -->
					<li><a href="#"><i class="fa fa-files-o fa-fw"></i> 게시판<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<c:set var="login" value="${loginId}"></c:set>
							<c:set var="right" value="${rightName}"></c:set>
							<c:if test="${right eq '회원'}">
								<li>
									<a href="${pageContext.request.contextPath}/board/boardAdd">게시판등록</a>
								</li>
							</c:if>
							<li>
								<a href="${pageContext.request.contextPath}/board/boardList">게시판리스트</a>
							</li>
							<c:if test="${right eq '관리자'}">
								<li>
									<a href="${pageContext.request.contextPath}/board/boardGroupList">게시판관리</a>
								</li>
							</c:if>
						</ul>
					</li>
					<!-- 게시판 끝 -->
				</ul>
			</div>
		</div>
		<!-- 왼쪽 사이드 메뉴 끝 -->
	</nav>
	<!-- wrapper시작 끝-->