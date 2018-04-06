<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
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
                    <h1 class="page-header">동물 진단서 등록</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<c:set var="i" value="${animalCommand}"></c:set>
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
			<p>식별 코드 : ${i.animalIdCode}</p>
			<p>종류 : ${i.osNameAnimalKind}</p> 
			<p>품종 : ${i.animalBreed}</p>
			<p>동물 나이 : ${i.animalAge}</p>					
			<p>보호소 위치 : ${i.animalArea}</p>
			<p>보호소 명 : ${i.blShelterName}</p>		
			<p>동물 체중 : ${i.animalWeight}</p>		
			<p>동물 등록날짜 : ${i.animalEnrollDate}</p>
			<div>
				<h2>동물 진단서 체크</h2>
			</div>
			<div style="border: 1px; padding: 10px; height: 500px; width: 500px;">
				<form 
					  action = "${pageContext.request.contextPath}/jindan/jindanAdd" 
					  method="post">
					<table border="1">
						<thead>
							<tr>
								<th>진단목록</th>
								<th>상태 이상 유무</th>
								<th>진단 부위</th>
								<th>진단 상태 선택</th>
							</tr>
						</thead>
						<tbody>
							<!-- 일반상태 진단 시작 -->
							<tr>
								<th rowspan="4">일반 상태</th>
								<td rowspan="4">
									<c:forEach var="is" items="${isang}">
										<input type="checkbox" name="osGeneralOddYumu" value="${is.osCode}">${is.osName}
									</c:forEach>					
								</td>
								<tr>
									<td>신체상태</td>	
									<td>
										<c:forEach var="g" items="${general}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '신체상태'}">
												<input type="checkbox" name="osBody" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
								<tr>
									<td>태도</td>
									<td>
										<c:forEach var="g" items="${general}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '태도'}">
												<input type="checkbox" name="osManner" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
								<tr>
									<td>점막</td>
									<td>
										<c:forEach var="g" items="${general}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '점막'}">
												<input type="checkbox" name="osRheum" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
							</tr>
							<!-- 일반 상태 진단 끝 -->
							
							<!-- 피부 상태 진단 시작 -->
							<tr>
								<th rowspan="3">피부 상태</th>
								<td rowspan="3">
									<c:forEach var="is" items="${isang}">
										<input type="checkbox" name="osSkinOddYumu" value="${is.osCode}">${is.osName}
									</c:forEach>					
								</td>
								<tr>
									<td>피모 상태</td>	
									<td>
										<c:forEach var="g" items="${skin}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '피모'}">
												<input type="checkbox" name="osCoat" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
								<tr>
									<td>피부 상태</td>	
									<td>
										<c:forEach var="g" items="${skin}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '피부'}">
												<input type="checkbox" name="osSkin" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
							</tr>
							<!-- 피부 상태 진단 끝 -->
							
							<!-- 눈 상태 진단 시작 -->
							<tr>
								<th rowspan="4">눈 상태</th>
								<td rowspan="4">
									<c:forEach var="is" items="${isang}">
										<input type="checkbox" name="osEyesOddYumu" value="${is.osCode}">${is.osName}
									</c:forEach>					
								</td>
								<tr>
									<td>각막</td>	
									<td>
										<c:forEach var="g" items="${eyes}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '각막'}">
												<input type="checkbox" name="osCornea" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
								<tr>
									<td>결막</td>	
									<td>
										<c:forEach var="g" items="${eyes}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '결막'}">
												<input type="checkbox" name="osConjunctiva" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
								<tr>
									<td>수정체</td>	
									<td>
										<c:forEach var="g" items="${eyes}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '수정체'}">
												<input type="checkbox" name="osCrystalline" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
							</tr>
							<!-- 눈 상태 진단 끝 -->
							
							<!-- 귀 상태 진단 시작 -->
							<tr>
								<th rowspan="4">귀 상태</th>
								<td rowspan="4">
									<c:forEach var="is" items="${isang}">
										<input type="checkbox" name="osEarsOddYumu" value="${is.osCode}">${is.osName}
									</c:forEach>					
								</td>
								<tr>
									<td>청각</td>	
									<td>
										<c:forEach var="g" items="${ears}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '청각'}">
												<input type="checkbox" name="osHearing" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
								<tr>
									<td>분비물</td>	
									<td>
										<c:forEach var="g" items="${ears}">
											<c:set var="gos" value="${g.osSmall}"></c:set>
											<c:set var="gol" value="${g.osLarge}"></c:set>
											<c:if test="${gos eq '분비물' and gol eq '귀'}">
												<input type="checkbox" name="osEarsSecrete" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
								<tr>
									<td>진드기</td>	
									<td>
										<c:forEach var="g" items="${ears}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:if test="${go eq '진드기'}">
												<input type="checkbox" name="osMite" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
							</tr>
							<!-- 귀 상태 진단 끝 -->
							
							<!-- 코 상태 진단 시작 -->
							<tr>
								<th rowspan="3">코 상태</th>
								<td rowspan="3">
									<c:forEach var="is" items="${isang}">
										<input type="checkbox" name="osNoseOddYumu" value="${is.osCode}">${is.osName}
									</c:forEach>					
								</td>
								<tr>
									<td>분비물</td>	
									<td>
										<c:forEach var="g" items="${nose}">
											<c:set var="go" value="${g.osSmall}"></c:set>
											<c:set var="gol" value="${g.osLarge}"></c:set>
											<c:if test="${go eq '분비물' and gol eq '코'}">
												<input type="checkbox" name="osNoseSecrete" value="${g.osCode}">${g.osName} 	
											</c:if>
										</c:forEach><br>
									</td>
								</tr>
							</tr>
							<!-- 코 상태 진단 끝 -->
						</tbody>
					</table>
				</form>
				<div style="border: 1px ; padding: 10px; height: auto; text-align: right; width: 460px;">
					<button type="button" style="align-content: center">진단서 등록</button>
				</div>
			</div>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<!-- foot 부분 끝 -->
</body>
</html>
