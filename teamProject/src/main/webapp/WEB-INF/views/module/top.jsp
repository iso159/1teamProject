<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
	
	<link href="${pageContext.request.contextPath}/resources/css/modules.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.min.css" rel="stylesheet">
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<title></title>
</head>
<body class="modern">


<!-- TOP 메인로고 : header1 -->
<header class="MOD_HEADER1">
  <div data-layout="_r">
    <div data-layout="al16 de10" class="MOD_HEADER1_Title">
      <h1 class="MOD_HEADER1_TextLogo">Company</h1>
      <p class="MOD_HEADER1_Slogan">Company slogan, byline or additional message</p>
    </div>
    <div data-layout="al16 de6" class="MOD_HEADER1_Details">
      <p class="MOD_HEADER1_Phone">Phone: <a href="tel:#">01234 567 8910</a></p>
      <!-- Search -->
      <form name="Header1" action="" method="">
        <input id="MOD_HEADER1_Search" class="MOD_HEADER1_Search" type="search" placeholder="Search"></input>
        <label for="MOD_HEADER1_Search">Search</label>
      </form>
      <!-- Facebook SVG -->
      <a href="#" class="smIcon"><svg class="fb" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm16 7h-1.923c-.616 0-1.077.252-1.077.889v1.111h3l-.239 3h-2.761v8h-3v-8h-2v-3h2v-1.923c0-2.022 1.064-3.077 3.461-3.077h2.539v3z"/></svg></a>
      <!-- Twitter SVG -->
      <a href="#" class="smIcon"><svg class="tw" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm18.862 9.237c.208 4.617-3.235 9.765-9.33 9.765-1.854 0-3.579-.543-5.032-1.475 1.742.205 3.48-.278 4.86-1.359-1.437-.027-2.649-.976-3.066-2.28.515.098 1.021.069 1.482-.056-1.579-.317-2.668-1.739-2.633-3.26.442.246.949.394 1.486.411-1.461-.977-1.875-2.907-1.016-4.383 1.619 1.986 4.038 3.293 6.766 3.43-.479-2.053 1.079-4.03 3.198-4.03.944 0 1.797.398 2.396 1.037.748-.147 1.451-.42 2.085-.796-.245.767-.766 1.41-1.443 1.816.664-.08 1.297-.256 1.885-.517-.44.656-.997 1.234-1.638 1.697z"/></svg></a>
      <!-- LinkedIn SVG -->
      <a href="#" class="smIcon"><svg class="li" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm8 19h-3v-11h3v11zm-1.5-12.268c-.966 0-1.75-.79-1.75-1.764s.784-1.764 1.75-1.764 1.75.79 1.75 1.764-.783 1.764-1.75 1.764zm13.5 12.268h-3v-5.604c0-3.368-4-3.113-4 0v5.604h-3v-11h3v1.765c1.397-2.586 7-2.777 7 2.476v6.759z"/></svg></a>
      <!-- Google Plus SVG-->
      <a href="#" class="smIcon"><svg class="gp" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm8.667 16.667c-2.581 0-4.667-2.087-4.667-4.667s2.086-4.667 4.667-4.667c1.26 0 2.313.46 3.127 1.22l-1.267 1.22c-.347-.333-.954-.72-1.86-.72-1.593 0-2.893 1.32-2.893 2.947s1.3 2.947 2.893 2.947c1.847 0 2.54-1.327 2.647-2.013h-2.647v-1.6h4.406c.041.233.074.467.074.773 0 2.666-1.787 4.56-4.48 4.56zm11.333-4h-2v2h-1.333v-2h-2v-1.333h2v-2h1.333v2h2v1.333z"/></svg></a>
      <!-- Pinterest SVG -->
      <a href="#" class="smIcon"><svg class="pi" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm12 20c-.825 0-1.62-.125-2.369-.357.326-.531.813-1.402.994-2.098l.499-1.901c.261.498 1.023.918 1.833.918 2.413 0 4.151-2.219 4.151-4.976 0-2.643-2.157-4.62-4.932-4.62-3.452 0-5.286 2.317-5.286 4.841 0 1.174.625 2.634 1.624 3.1.151.07.232.039.268-.107l.222-.907c.019-.081.01-.15-.056-.23-.331-.4-.595-1.138-.595-1.825 0-1.765 1.336-3.472 3.612-3.472 1.965 0 3.341 1.339 3.341 3.255 0 2.164-1.093 3.663-2.515 3.663-.786 0-1.374-.649-1.185-1.446.226-.951.663-1.977.663-2.664 0-.614-.33-1.127-1.012-1.127-.803 0-1.448.831-1.448 1.943 0 .709.239 1.188.239 1.188s-.793 3.353-.938 3.977c-.161.691-.098 1.662-.028 2.294-2.974-1.165-5.082-4.06-5.082-7.449 0-4.418 3.582-8 8-8s8 3.582 8 8-3.582 8-8 8z"/></svg></a>
    </div>
  </div>
</header>
<!-- TOP 메인로고 : Header 1 -->

<!-- 기능메뉴 : Menu 1 -->
<section class="MOD_MENU" data-theme="_bgp">
  <div data-layout="_r" class="nopadding">
    <nav class="MOD_MENU_Nav">
      <p class="MOD_MENU_Title">Menu</p>
      <svg class="MOD_MENU_Button" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="30px" height="30px" viewBox="0 0 30 30" enable-background="new 0 0 30 30" xml:space="preserve">
        <rect width="30" height="6"/>
        <rect y="24" width="30" height="6"/>
        <rect y="12" width="30" height="6"/>
      </svg>
      <ul class="AP_Menu_List">
        <li>
          <a href="#" data-theme="_bgp">회원</a>
          <ul>
            <li>
              <a href="${pageContext.request.contextPath}/member/memberAdd" data-theme="_bgpd">회원가입</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/member/login" data-theme="_bgpd">로그인</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/member/memberList" data-theme="_bgpd">회원리스트</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/member/memberModify" data-theme="_bgpd">회원수정</a>
            </li>
          </ul>
        </li>
       
        <li>
          <a href="#" data-theme="_bgp">보호소</a>
          <ul>
            <li>
              <a href="${pageContext.request.contextPath}/shelter/businessLicenseRequest" data-theme="_bgpd">대표 보호소 신청</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/businessLicenseList" data-theme="_bgpd">대표 보호소 신청 리스트</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/businessLicenseListPersonal" data-theme="_bgpd">대표 보호소 신청 개인 조회</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/shelter/staffBusinessLicenseGet" data-theme="_bgpd">직원 신청 보호소 리스트</a>
            </li>
             <li>
              <a href="${pageContext.request.contextPath}/shelter/requestShelterStaffList" data-theme="_bgpd">직원 신청 리스트</a>
            </li>
             <li>
              <a href="${pageContext.request.contextPath}/shelter/requestShelterStaffPersonal" data-theme="_bgpd">직원 신청 개인 조회</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#" data-theme="_bgp">체험</a>
           <ul>
            <c:if test="${empty member.blCode}">
            <li>
              <a href="${pageContext.request.contextPath}/experience/expAdd?animalCode=animal_code_01&blCode=bl_code_01" data-theme="_bgpd">체험등록</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/experience/expList" data-theme="_bgpd">나의체험리스트</a>
            </li>
            </c:if>
            <c:if test="${!empty member.blCode}">
            <li>
              <a href="${pageContext.request.contextPath}/experience/expShelterList?blCode=${member.blCode}" data-theme="_bgpd">보호소 체험 리스트</a>
            </li>
             </c:if>
          </ul>
        </li>
        <li>
          <a href="#" data-theme="_bgp">입양</a>
           <ul>
            <li>
              <a href="${pageContext.request.contextPath}/adopt/adoptRequest" data-theme="_bgpd">입양신청</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/adopt/adoptList" data-theme="_bgpd">입양신청리스트</a>
            </li>
          </ul>
        </li>
         <li>
          <a href="${pageContext.request.contextPath}/animal/animalList" data-theme="_bgp">동물</a>
        	<ul>
            <li>
              <a href="${pageContext.request.contextPath}/animal/animalAdd" data-theme="_bgpd">동물등록</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/animal/animalList" data-theme="_bgpd">동물리스트</a>
            </li>
          </ul>
        </li>
         <li>
          <a href="#" data-theme="_bgp">상품</a>
           <ul>
            <li>
              <a href="${pageContext.request.contextPath}/goods/goodsAdd" data-theme="_bgpd">상품등록</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/goods/goodsList" data-theme="_bgpd">상품리스트</a>
            </li>
          </ul>
        </li>
         <li>
          <a href="#" data-theme="_bgp">설문지</a>
          <ul>
            <li>
              <a href="${pageContext.request.contextPath}/survey/surveyAdd" data-theme="_bgpd">설문지등록</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/survey/surveyList" data-theme="_bgpd">설문지조회</a>
            </li>
          </ul>
        </li>
        
      </ul>
    </nav>
  </div>
</section>
<!-- 기능메뉴 끝: Menu 1 -->


</body>
</html>