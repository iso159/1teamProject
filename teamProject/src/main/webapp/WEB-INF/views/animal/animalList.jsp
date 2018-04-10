<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var itemSize;
		var animalArray;
		var boxSelect = '${boxSelect}';
		
		// 셀렉트 박스 selected
		if(boxSelect === 'yugi'){
			$('#animalStatusKind').val(boxSelect);
		}else{
			$('#animalStatusKind').val("${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=" + boxSelect);
		}
		
		// 동물 상태별 리스트 처리
		$('#animalStatusKind').change(function(){
			var selectAnimalStatusKind = {"animalStatusKind" : $('#animalStatusKind').val() };
			var animalStatusKind = $('#animalStatusKind').val();
			if(animalStatusKind === "yugi"){
				$.ajax({
					url:'yugiAnimalList',
					type:'post',
					dataType:'json',
					data: selectAnimalStatusKind,
					success: function(msg){
						$('#animalList').empty();					
						itemSize = Object.keys(msg.response.body.items.item).length;
						console.log('유기동물');
						for(let i=0; i<itemSize; i++){
							let divTag = '<div data-layout="ch8 ec4" style="float:left;"> <img class="MOD_STAFF_Picture" style="width:200px; height:200px;" src="'+ msg.response.body.items.item[i].filename + '" alt="" data-theme="_is1">';
						    divTag += '<p class="MOD_STAFF_Name" data-theme="_bb1">'+ msg.response.body.items.item[i].noticeNo + '</p>';
						    divTag += '<p class="MOD_STAFF_Positon">' + msg.response.body.items.item[i].kindCd + '</p>';
						    divTag += '<p> 동물 나이' + msg.response.body.items.item[i].age + '</p>';
						    divTag += '<p> 보호소 위치 : ' + msg.response.body.items.item[i].careAddr + '</p>';
						    divTag += '<p> 보호소 명 : ' + msg.response.body.items.item[i].careNm + '</p>';
						    divTag += '<p> 보호소 전화번호 : ' +  msg.response.body.items.item[i].careTel + '</p>';
						    divTag += '<p> 체중 : ' +  msg.response.body.items.item[i].weight + '</p>';
						    divTag += '<p> 동물 등록 : <a href="${pageContext.request.contextPath}/animal/animalAdd?animalArea=' + msg.response.body.items.item[i].careAddr + '&animalIdCode=' + msg.response.body.items.item[i].noticeNo + '&animalWeight=' + msg.response.body.items.item[i].weight + '&animalAge=' + msg.response.body.items.item[i].age +'&imagePath=' + msg.response.body.items.item[i].filename + '">동물등록</a></p></div>';
							$('#animalList').append(divTag);
						}
					},
					error: function(error){
						console.log('없음');
						$('#animalList').empty();
					}
				});
			}else {
				location.href = animalStatusKind;
			}
		});
		
		
	});
</script>
<title>유기동물 리스트</title>
</head>
<body class="modern">
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<!-- 메인 화면 내용 부분 -->
	<div class="container">
	<!-- 메인내용 시작 : Text | Text -->
	<h2>유기동물 리스트</h2>	
	<select id="animalStatusKind">
		<option value="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=등록동물">등록동물</option>
		<option value="yugi">유기동물</option>
		<option value="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=체험(입양)가능동물">체험(입양)가능동물</option>
		<option value="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=체험중인동물">체험중인동물</option>
	</select>
	<!-- 조건검색 -->
	<section>
		<form ID="selectForm" action="${pageContext.request.contextPath}/animal/animalCategory" method="post">
			<select name="AnimalCategory">
				<option value="animal_area">지역</option>
				<option value="animal_breed">품종</option>
				<option value="animal_id_code">동물식별코드</option>
				<option value="animal_enroll_date">등록날짜</option>
				<option value="bl.bl_shelter_name">보호소이름</option>
			</select>
			<input type="text" id="selectName" name="selectName">
			<button type="submit">검색</button>
		</form>
	  	<div data-layout="_r" id="animalList">
	  		<c:forEach var="i" items="${AnimalList}">		
				<div data-layout="ch8 ec4" style="float:left;">
					<c:set var="flag" value="${f:substring(i.animalImagePath,0,4)}"></c:set>
					<c:set var="path" value="${i.animalImagePath}"></c:set>
					<c:if test="${empty path}">
						<img class="MOD_STAFF_Picture" src="https://unsplash.it/400/400/?random" style="width:200px; height:200px;" alt="" data-theme="_is1">
					</c:if>
					<c:if test="${!empty path and flag eq 'http'}">
						<img class="MOD_STAFF_Picture" src="${path}" style="width:200px; height:200px;" alt="" data-theme="_is1">
					</c:if>
					<c:if test="${!empty path and flag ne 'http'}">
						<img class="MOD_STAFF_Picture" src="${pageContext.request.contextPath}/resources/animalUpload/${path}" style="width:200px; height:200px;" alt="" data-theme="_is1">
					</c:if>
					<p>동물 식별코드 : ${i.animalIdCode}</p>
					<p>종류 : ${i.osNameAnimalKind} </p>
					<p>품종 : ${i.animalBreed}</p>
					<p>동물 나이 : ${i.animalAge}</p>					
					<p>보호소 위치 : ${i.animalArea}</p>
					<p>보호소 명 : ${i.blShelterName}</p>
					<p>동물 상태 : ${i.osName}</p>				
					<p>동물 체중 : ${i.animalWeight}</p>		
					<p>동물 등록날짜 : ${i.animalEnrollDate}</p>
					<p>동물 수정 : <a href="${pageContext.request.contextPath}/animal/animalUpdate?animalCode=${i.animalCode}">수정</a></p>
					<c:if test="${!empty path and flag eq 'http'}">
						<p>동물 삭제: <a href="${pageContext.request.contextPath}/animal/animalDelete?animalCode=${i.animalCode}">삭제</a></p>
					</c:if>
					<c:if test="${!empty path and flag ne 'http'}">
						<p>동물 삭제: <a href="${pageContext.request.contextPath}/animal/animalDelete?animalCode=${i.animalCode}&animalImagePath=${i.animalImagePath}">삭제</a></p>
					</c:if>				
					<p>진단서 등록 : <a href="${pageContext.request.contextPath}/jindan/animalJindan?animalCode=${i.animalCode}">진단서 등록</a></p>
				</div>
			</c:forEach>
	    <div>
	    <!-- 내용 입력 부분 -->
	<!-- 내용 입력 부분 끝 -->
		</div>
	  </div>
	</section>
	<!-- 메인내용 끝 : Text | Text -->
	</div>
	<!-- 메인 화면 내용 부분 끝 -->
	
	<!-- 메인화면 끝 -->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>