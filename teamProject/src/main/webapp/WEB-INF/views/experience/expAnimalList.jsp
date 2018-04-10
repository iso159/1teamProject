<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
	.image {
	  font-size: 0;
	  text-align: center;
	  width: 200px;  /* Container's dimensions */
	  height: 150px;
			}
	img {
	  display: inline-block;
	  vertical-align: middle;
	  max-height: 100%;
	  max-width: 100%;
	}
	.trick {
	  display: inline-block;
	  vertical-align: middle;
	  height: 150px;
	}
	</style>
	<title></title>
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
                    <h1 class="page-header">체험 동물 리스트</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<c:forEach var="i" items="${animal}">
 			<c:set var="flag" value="${f:substring(i.animalImagePath,0,4)}"></c:set>
			<c:set var="path" value="${i.animalImagePath}"></c:set>
			<div style="margin:15;">
			<div class ="col-xs-6 col-md-3">
			<table>
				<tr>
					<td colspan="2">
 						<c:if test="${empty path}">
							<div class ="image"><div class ="trick"><img class="MOD_STAFF_Picture" src="https://unsplash.it/200/200/?random" alt="" data-theme="_is1"></div></div>
						</c:if>
						<c:if test="${!empty path and flag eq 'http'}">
							<div class ="image"><div class ="trick"><img class="MOD_STAFF_Picture" src="${path}" alt="" data-theme="_is1"></div></div>
						</c:if>
						<c:if test="${!empty path and flag ne 'http'}">
							<div class ="image"><div class ="trick"><img class="MOD_STAFF_Picture" src="${pageContext.request.contextPath}/resources/animalUpload/${path}" alt="" data-theme="_is1"></div></div>
						</c:if> 
					</td>
				</tr>
				<tr>
					<td>분류 :</td>
					<td>${i.osCodeKind}</td>
				</tr>
				<tr>
					<td>종류 :</td>
					<td>${i.animalBreed}</td>
				</tr>
				<tr>
					<td>나이 :</td>
					<td>${i.animalAge}</td>
				</tr>
				<tr>
					<td>무게 :</td>
					<td>${i.animalWeight}</td>
				</tr>
				<tr>
					<td>동물병원:</td>
					<td>${i.mShelterId}</td>
				</tr>
				<tr>
					<td>동물상태:</td>
					<td>${i.osCodeAnimal}</td>
				</tr>
				<tr>
					<td>체험기록</td>
					<td>체험신청</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/experience/oneAnimalExpList?animalCode=${i.animalCode}"><button>기록</button></a></td>
					<td><a href="${pageContext.request.contextPath}/experience/expAdd?animalCode=${i.animalCode}&blCode=${i.blCode}"><button>신청</button></a></td>
				</tr>
			</table>
			</div>
			</div>
			</c:forEach>
			</div>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
