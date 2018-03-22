<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<script>
	$(document).ready(function() {
		$.datepicker.regional['ko'] = {
				closeText: '닫기',
				prevText: '이전달',
				nextText: '다음달',
				currentText: '오늘',
				monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
				'7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
				monthNamesShort: ['1월','2월','3월','4월','5월','6월',
				'7월','8월','9월','10월','11월','12월'],
				dayNames: ['일','월','화','수','목','금','토'],
				dayNamesShort: ['일','월','화','수','목','금','토'],
				dayNamesMin: ['일','월','화','수','목','금','토'],
				weekHeader: 'Wk',
				dateFormat: 'yy-mm-dd',
				firstDay: 0,
				isRTL: false,
				showMonthAfterYear: true,
				yearSuffix: '',
				showOn: 'both',
				buttonText: "달력",
				changeMonth: true,
				changeYear: true,
				showButtonPanel: true,
				yearRange: 'c-99:c+99',
			};
		$.datepicker.setDefaults($.datepicker.regional['ko']);
		$('#sdate').datepicker({ minDate: 0});
		$('#expPeriodCode').click(function() {
			let expPeriodCode = $('#expPeriodCode').val();
			if (expPeriodCode === "exp_period_2_5_1") {
				$('#expPeriodCost').val('50000');
				$('#expPeriodJournalCount').val('1');
				$('#expPeriodLevel').val('2');
				$('#sdate').datepicker({ minDate: 0});
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					var date2 = $('#sdate').datepicker('getDate');
					var EndDate = new Date();
					EndDate.setDate(date2.getDate() + 1);
					var d = EndDate.getDate();
					var m =  EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					var y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
				});
			} else if (expPeriodCode === "exp_period_4_7_2") {
				$('#expPeriodCost').val('70000');
				$('#expPeriodJournalCount').val('2');
				$('#expPeriodLevel').val('4');
				$('#sdate').datepicker({ minDate: 0});
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					var date2 = $('#sdate').datepicker('getDate');
					var EndDate = new Date();
					EndDate.setDate(date2.getDate() + 3);
					var d = EndDate.getDate();
					var m =  EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					var y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
				});
			} else if (expPeriodCode === "exp_period_6_7_3") {
				$('#expPeriodCost').val('90000');
				$('#expPeriodJournalCount').val('3');
				$('#expPeriodLevel').val('6');
				$('#sdate').datepicker({ minDate: 0});
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					var date2 = $('#sdate').datepicker('getDate');
					var EndDate = new Date();
					EndDate.setDate(date2.getDate() + 5);
					var d = EndDate.getDate();
					var m =  EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					var y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
				});
			} else if (expPeriodCode === "exp_period_8_11_4") {
				$('#expPeriodCost').val('110000');
				$('#expPeriodJournalCount').val('4');
				$('#expPeriodLevel').val('7');
				$('#sdate').datepicker({ minDate: 0});
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					var date2 = $('#sdate').datepicker('getDate');
					var EndDate = new Date();
					EndDate.setDate(date2.getDate() + 6);
					var d = EndDate.getDate();
					var m =  EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					var y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
				});
			}
			$('#submit').click(function(){
				$("#expadd").submit();
			});
		});
	});
</script>
<head>
<title></title>
</head>
<body>
	<h1>추가</h1>
	<form id="expadd" name="expadd" action="${pageContext.request.contextPath}/experience/expAdd" method="post">
	<input type="hidden" name="animalCode" value="${animalCode}">
	<div>
		<select name="expPeriodCode" id="expPeriodCode">
			<option>---기간 및 가격---</option>
			<c:forEach var="e" items="${addAttribute}">
				<option value="${e.expPeriodCode}">기간:${e.expPeriodPeriod},가격:${e.expPeriodCost}</option>
			</c:forEach>
		</select>
	</div>
	<input type="hidden" name=expJournalCount id="expPeriodJournalCount">
	<input type="hidden" name="expCost" id="expPeriodCost">
	체험 이유 : <input type="text" id="expPurpose" name="expPurpose">
	
	시작일 : <input type="text" name="expStartDate" id="sdate" size="10" maxlength="10" value="" /> ~
	종료일 : <input type="text" name="expEndDate" id="edate" size="10" maxlength="10" value="" />
	<button type="submit" id="submit">입력</button>
	</form>
</body>
</html>