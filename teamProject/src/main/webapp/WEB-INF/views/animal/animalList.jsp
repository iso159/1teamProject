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
			$('#animalStatusKind').val("${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=" + boxSelect + "&currentPage=${currentPage}&pagePerRow=${pagePerRow}");
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
						$('#pagingDiv').hide();
						for(let i=0; i<itemSize; i++){
							let divTag='<div class="col-lg-4"><div class="panel panel-default"><div class="panel-heading">' + msg.response.body.items.item[i].noticeNo + '</div><div class="panel-body">';
							divTag += '<img style="width:200px; height:200px;" src="'+ msg.response.body.items.item[i].filename + '" alt="" data-theme="_is1">';
						    divTag += '<p> 품종 : ' + msg.response.body.items.item[i].kindCd + '</p>';
						    divTag += '<p> 동물 나이' + msg.response.body.items.item[i].age + '</p>';
						    divTag += '<p> 보호소 위치 : ' + msg.response.body.items.item[i].careAddr + '</p>';
						    divTag += '<p> 보호소 명 : ' + msg.response.body.items.item[i].careNm + '</p>';
						    divTag += '<p> 체중 : ' +  msg.response.body.items.item[i].weight + '</p>';
						    divTag += '<p> 동물 등록 : <a href="${pageContext.request.contextPath}/animal/animalAdd?animalArea=' + msg.response.body.items.item[i].careAddr + '&animalIdCode=' + msg.response.body.items.item[i].noticeNo + '&animalWeight=' + msg.response.body.items.item[i].weight + '&animalAge=' + msg.response.body.items.item[i].age +'&imagePath=' + msg.response.body.items.item[i].filename + '&animalBreed=' + msg.response.body.items.item[i].kindCd + '"><button class="btn btn-outline btn-success">동물등록</button></a></p>';
						    divTag += '</div></div></div>';
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
	
	function remove_animal(animal){
		var requestVal = animal.value;
		console.log(requestVal);
		if(confirm("등록동물을 삭제하시겠습니까?")){
			location.href = requestVal;
			return true;
		}else{
			return false;
		}
	};
	
</script>
<title>유기동물 리스트</title>
</head>
<body>
	<!-- top 부분 시작-->
	<jsp:include page="/WEB-INF/views/module/top.jsp"/>
	<!-- top 부분 끝-->
	
	<!-- 메인 화면  -->
	<div id="page-wrapper">
		<!-- 메인 화면 내용 부분 -->
		<div class="container" style="position: static;">
		<!-- 메인내용 시작 : Text | Text -->
		<h2>유기동물 리스트</h2>	
		<select id="animalStatusKind">
			<option value="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=등록동물&currentPage=${currentPage}&pagePerRow=${pagePerRow}">등록동물</option>
			<option value="yugi">유기동물</option>
			<option value="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=체험(입양)가능동물&currentPage=${currentPage}&pagePerRow=${pagePerRow}">체험(입양)가능동물</option>
			<option value="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=체험중인동물&currentPage=${currentPage}&pagePerRow=${pagePerRow}">체험중인동물</option>
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
		  	<div id="animalList">
		  		<c:forEach var="i" items="${AnimalList}">		
					<div class="col-lg-4">
						<div class="panel panel-default">
	                        <div class="panel-heading">
	                            ${i.animalIdCode}
	                        </div>
	                        <div class="panel-body">
								<c:set var="flag" value="${f:substring(i.animalImagePath,0,4)}"></c:set>
								<c:set var="path" value="${i.animalImagePath}"></c:set>
								<c:if test="${empty path}">
									<img src="https://unsplash.it/400/400/?random" style="width:200px; height:200px;" alt="">
								</c:if>
								<c:if test="${!empty path and flag eq 'http'}">
									<img src="${path}" style="width:200px; height:200px;" alt="">
								</c:if>
								<c:if test="${!empty path and flag ne 'http'}">
									<img src="${pageContext.request.contextPath}/resources/animalUpload/${path}" style="width:200px; height:200px;" alt="">
								</c:if>
								<p>품종 : ${i.animalBreed}</p>
								<p>동물 나이 : ${i.animalAge}</p>	
								<p>동물 체중 : ${i.animalWeight}</p>					
								<p>보호소 위치 : ${i.animalArea}</p>
								<p>보호소 명 : ${i.blShelterName}</p>									
								<p>동물 등록날짜 : ${i.animalEnrollDate}</p>
								<p>
									<a href="${pageContext.request.contextPath}/animal/animalUpdate?animalCode=${i.animalCode}"><button class="btn btn-outline btn-success">수정</button></a>&emsp;
									<c:if test="${!empty path and flag eq 'http'}">
										<button class="btn btn-outline btn-danger" value="${pageContext.request.contextPath}/animal/animalDelete?animalCode=${i.animalCode}" onclick="remove_animal(this)">삭제</button>&emsp;
									</c:if>
									<c:if test="${!empty path and flag ne 'http'}">
										<button class="btn btn-outline btn-danger" value="${pageContext.request.contextPath}/animal/animalDelete?animalCode=${i.animalCode}&animalImagePath=${i.animalImagePath}" onclick="remove_animal(this)">삭제</button>&emsp;
									</c:if>				
									<a href="${pageContext.request.contextPath}/jindan/animalJindan?animalCode=${i.animalCode}"><button class="btn btn-outline btn-warning">진단서 등록</button></a>								
								</p>							
							</div>
						</div>
					</div>
				</c:forEach>
			<!-- 메인화면 시작 -->
			</div>
		    
		    <!-- 페이징 시작 -->
		    <div id="pagingDiv" style="width:200px; height:70px; position: relative; bottom:30px; left:500px;">
				<ul class="pagination">
					<c:set var="cp" value="${currentPage+1}"></c:set>
					<c:set var="mp" value="${maxPage}"></c:set>
					<c:if test="${cp eq '1'}">
						<li>
							<a href="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=${boxSelect}&currentPage=${currentPage}&pagePerRow=${pagePerRow}">이전</a>
						</li>
					</c:if>
					<c:if test="${cp ne '1'}">
						<li>
							<a href="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=${boxSelect}&currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">이전</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="1" end="${maxPage}">
						<c:if test="${cp eq i}">
							<li class="active">
								<a href="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=${boxSelect}&currentPage=${i-1}&pagePerRow=${pagePerRow}">${i}</a>
							</li>
						</c:if>
						<c:if test="${cp ne i}">
							<li>
								<a href="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=${boxSelect}&currentPage=${i-1}&pagePerRow=${pagePerRow}">${i}</a>
							</li>
						</c:if>
					</c:forEach>
					<c:if test="${cp eq mp}">
						<li>
							<a href="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=${boxSelect}&currentPage=${currentPage}&pagePerRow=${pagePerRow}">다음</a>
						</li>
					</c:if>
					<c:if test="${cp ne mp}">
						<li>
							<a href="${pageContext.request.contextPath}/animal/animalList?osCodeAnimal=${boxSelect}&currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
			<!-- 페이징 끝 -->
		</div>
	</div>
	<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
