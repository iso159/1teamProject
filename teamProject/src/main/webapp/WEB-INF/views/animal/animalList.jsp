<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var itemSize;
		var animalArray;
		$('#animalStatusKind').change(function(){
			var selectAnimalStatusKind = {"animalStatusKind" : $('#animalStatusKind').val()};
			$.ajax({
				url:'yugiAnimalList',
				type:'post',
				dataType:'json',
				data: selectAnimalStatusKind,
				success: function(msg){
					$('#animalList').empty();					
					if($('#animalStatusKind').val() === "yugi"){
						itemSize = Object.keys(msg.response.body.items.item).length;
						console.log('유기동물');
						for(let i=0; i<itemSize; i++){
							let divTag = '<div data-layout="ch8 ec4"> <img class="MOD_STAFF_Picture" src="'+ msg.response.body.items.item[i].filename + '" alt="" data-theme="_is1">';
						    divTag += '<p class="MOD_STAFF_Name" data-theme="_bb1">'+ msg.response.body.items.item[i].noticeNo + '</p>';
						    divTag += '<p class="MOD_STAFF_Positon">' + msg.response.body.items.item[i].kindCd + '</p>';
						    divTag += '<p> 동물 나이' + msg.response.body.items.item[i].age + '</p>';
						    divTag += '<p> 보호소 위치 : ' + msg.response.body.items.item[i].careAddr + '</p>';
						    divTag += '<p> 보호소 명 : ' + msg.response.body.items.item[i].careNm + '</p>';
						    divTag += '<p> 보호소 전화번호 : ' +  msg.response.body.items.item[i].careTel + '</p>';
						    divTag += '<p> 체중 : ' +  msg.response.body.items.item[i].weight + '</p>';
						    divTag += '<p> 동물 등록 : <a href="${pageContext.request.contextPath}/animal/animalAdd?animalArea=' + msg.response.body.items.item[i].careAddr + '&animalIdCode=' + msg.response.body.items.item[i].noticeNo + '&animalWeight=' + msg.response.body.items.item[i].weight + '&animalAge=' + msg.response.body.items.item[i].age +'&imagePath=' + msg.response.body.items.item[i].filename + '">동물등록</a></p></div>'
							$('#animalList').append(divTag);
						}
					}else{
						console.log('등록동물');
						let divTag = '<c:forEach var="i" items="${AnimalList}">	';
						divTag += '<div data-layout="ch8 ec4">' + '<c:set var="flag" value="${f:substring(i.animalImagePath,0,4)}"></c:set><c:set var="path" value="${i.animalImagePath}"></c:set>';
						divTag += '<c:if test="${empty path}"><img class="MOD_STAFF_Picture" src="https://unsplash.it/400/400/?random" alt="" data-theme="_is1"></c:if>';
						divTag += '<c:if test="${!empty path and flag eq \'http\'}"><img class="MOD_STAFF_Picture" src="${path}" alt="" data-theme="_is1"></c:if>';
						divTag += '<c:if test="${!empty path and flag ne \'http\'}"><img class="MOD_STAFF_Picture" src="${pageContext.request.contextPath}/resources/animalUpload/${path}" alt="" data-theme="_is1"></c:if>';
						divTag += '<p class="MOD_STAFF_Name" data-theme="_bb1"><a href="${pageContext.request.contextPath}/animal/animalDetail?animalCode=${i.animalCode}">${i.animalIdCode}</a></p>';	
						divTag += '<p class="MOD_STAFF_Positon">${i.osNameAnimalKind} ${i.animalBreed}</p>';
						divTag += '<p>동물 나이 : ${i.animalAge}</p>'+'<p>보호소 위치 : ${i.animalArea}</p>'+'<p>보호소 명 : ${i.blShelterName}</p>';
						divTag += '<p>동물 상태 : ${i.osName}</p>' + '<p>동물 체중 : ${i.animalWeight}</p>' + '<p>동물 등록날짜 : ${i.animalEnrollDate}</p>';
						divTag += '<p>동물 수정 : <a href="${pageContext.request.contextPath}/animal/animalUpdate?animalCode=${i.animalCode}">수정</a></p>';
						divTag += '<p>동물 삭제 : <a href="${pageContext.request.contextPath}/animal/animalDelete?animalCode=${i.animalCode}">삭제</a></p>';
						divTag += '<p>진단서 등록 : <a href="${pageContext.request.contextPath}/jindan/animalJindan?animalCode=${i.animalCode}">진단서 등록</a></p>';
						divTag += '</div> </c:forEach>'
						$('#animalList').append(divTag);
					}
				},
				error: function(error){
					console.log('없음');
					$('#animalList').empty();
				}
			});
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
		<option value="insert">등록동물</option>
		<option value="yugi">유기동물</option>
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
				<div data-layout="ch8 ec4">
					<c:set var="flag" value="${f:substring(i.animalImagePath,0,4)}"></c:set>
					<c:set var="path" value="${i.animalImagePath}"></c:set>
					<c:if test="${empty path}">
						<img class="MOD_STAFF_Picture" src="https://unsplash.it/400/400/?random" alt="" data-theme="_is1">
					</c:if>
					<c:if test="${!empty path and flag eq 'http'}">
						<img class="MOD_STAFF_Picture" src="${path}" alt="" data-theme="_is1">
					</c:if>
					<c:if test="${!empty path and flag ne 'http'}">
						<img class="MOD_STAFF_Picture" src="${pageContext.request.contextPath}/resources/animalUpload/${path}" alt="" data-theme="_is1">
					</c:if>
					<p class="MOD_STAFF_Name" data-theme="_bb1"><a href="${pageContext.request.contextPath}/animal/animalDetail?animalCode=${i.animalCode}">${i.animalIdCode}</a></p>
					<p class="MOD_STAFF_Positon">${i.osNameAnimalKind} ${i.animalBreed}</p>
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