<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	
	<!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/morrisjs/morris.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	
	

	<title></title>
</head>
<body>

<!-- wrapper시작 -->
<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">유기동물 체험을 통한 분양활성화 시스템</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
               	<!-- 회원 -->
                <li class="dropdown">
                	<c:set var="login" value="${loginId}"></c:set>
       				<c:set var="right" value="${rightName}"></c:set>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                    	<c:if test="${empty login}">
	                        <li><a href="${pageContext.request.contextPath}/member/memberAdd"><i class="fa fa-user fa-fw"></i> 회원가입</a>
	                        </li>
	                        <li><a href="${pageContext.request.contextPath}/member/login"><i class="fa fa-gear fa-fw"></i> 로그인</a>
	                        </li>
                        </c:if>
                        <li class="divider"></li>
                        <c:if test="${!empty login}">
                        	<c:if test="${right eq '관리자'}">
		                        <li><a href="${pageContext.request.contextPath}/member/memberList"><i class="fa fa-sign-out fa-fw"></i> 회원리스트</a>
		                        </li>
	                        </c:if>
	                        <li><a href="${pageContext.request.contextPath}/member/memberModify"><i class="fa fa-sign-out fa-fw"></i> 회원수정</a>
	                        </li>
	                        <li><a href="${pageContext.request.contextPath}/member/memberLogout"><i class="fa fa-sign-out fa-fw"></i> 로그아웃</a>
	                        </li>
                        </c:if>
                    </ul>
                </li>
                <!-- 회원끝 -->
            </ul>
        </nav>

		<!-- 왼쪽 사이드 메뉴 시작 -->
		<div class="navbar-default sidebar" role="navigation" >
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <!-- 보호소 시작 -->
                        <li>
                        	<c:set var="right" value="${rightName}"></c:set>
          					<c:set var="level" value="${rightLevel}"></c:set>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> 보호소<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <c:if test="${right eq '회원' or right eq '보호소'}">
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
                                </c:if>
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
                                    <a href="${pageContext.request.contextPath}/businessLicenseListPersonal">보호소 대표 신청 관리</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/shelter/requestShelterStaffList">직원 신청 목록</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <!-- 보호소 끝 -->
                        
                        <!-- 체험 시작 -->
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 체험<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                           		<c:if test="${rightLevel eq '1' or rightLevel eq '3'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/experience/expAdd?animalCode=animal_code_01&blCode=bl_code_01">체험등록</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/experience/expList">나의체험리스트</a>
                                </li>
                                </c:if>
                                <c:if test="${rightLevel eq '1' or rightLevel eq '2'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/experience/expShelterList?blCode=${loginBlCode}">보호소 체험 리스트</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <!-- 체험 끝 -->
                        
                        <!-- 입양 시작 -->
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 입양<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<c:set var="right" value="${rightName}"></c:set>
                            	<c:if test="${right eq '회원'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/animal/animalList">입양신청</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/adopt/adoptMyList">나의입양리스트</a>
                                </li>
                                </c:if>
            					<c:if test="${right eq '관리자' or right eq '보호소'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/adopt/adoptList">입양신청리스트</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <!-- 입양 끝 -->
                        
                        <!-- 동물 시작 -->
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 동물<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<c:set var="right" value="${rightName}"></c:set>
                            	<c:if test="${right eq '보호소'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/animal/animalAdd">동물등록</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/animal/animalList">동물리스트</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <!-- 동물 끝 -->
                        
                        <!-- 애견용품 시작 -->
                        <li>
                        	<c:set var="login" value="${loginId}"></c:set>
							<c:set var="right" value="${rightName}"></c:set>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 애견용품<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<c:if test="${right eq '관리자'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/goods/goodsAdd">애견용품 등록</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/goods/goodsList">애견용품 리스트</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <!-- 애견용품 끝 -->
                        <!-- 설문지 시작 -->
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 설문지<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<c:set var="right" value="${rightName}"></c:set>
                            	<c:if test="${right eq '관리자'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/survey/surveyAdd">설문지등록</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/survey/surveyList">설문지조회</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <!-- 설문지 끝 -->
                        
                        <!-- 진단 시작 -->
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 진단<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            	<c:set var="login" value="${loginId}"></c:set>
                            	<c:set var="right" value="${rightName}"></c:set>
                            	<c:if test="${right eq '회원'}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/jindan/jindanShelterList">보호소 진료 예약</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <!-- 진단 끝 -->
                        
                        <!-- 게시판 시작 -->
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 게시판<span class="fa arrow"></span></a>
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
                            </ul>
                        </li>
                        <!-- 게시판 끝 -->
               
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
           <!-- 왼쪽 사이드 메뉴 끝 -->
           
        
            
           
        