<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>입양신청</title>
</head>
<body>
	<h2>입양신청</h2>
		<form action="${pageContext.request.contextPath}/adopt/adoptRequest" method="post">
			동물코드 <input type="text" name="animalCode" value="animal_code_01"><br>
			보호소 <input type="text" name="blCode" value="bl_code_01"><br>
			입양이유 <input type="text" name="adoptRequestReason"><br>
			회원아이디<input type="text" name="mMemberId" value="m_04"><br>
			보호소직원<input type="text" name="mShelterId" value="m_02"><br>
			입양상태<input type="text" name="osCodeAdopt" value="os_adopt_4_1_1"><br>
			포인트<input type="text" name="adoptPoint" value="500"><br>
			<button type="submit" class="btn btn-info">입양신청하기</button>
		</form>
	
</body>
</html>