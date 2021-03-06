<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html> 
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-ui.css" rel="stylesheet">
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
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
				showOtherMonths: true,
				yearRange: 'c-99:c+99',
			};
		$.datepicker.setDefaults($.datepicker.regional['ko']);
		$('#expPeriodCode').click(function() {
			let expPeriodCode = $('#expPeriodCode').val();
			$("#edate").val('');
			$("#sdate").val('');
			$('#sdate').datepicker({ minDate: 0});
			let date1 = new Date();
			let todayM = date1.getMonth();
			if (expPeriodCode === "exp_period_2_5_1") {
				$('#expPeriodCost').val('50000');
				$('#expPeriodJournalCount').val('1');
				$('#expPeriodLevel').val('2');
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					if($('#sdate').val() != ''){
					let date2 = $('#sdate').datepicker('getDate');
					let EndDate = new Date();
					EndDate.setYear(date2.getFullYear());
					EndDate.setMonth(date2.getMonth());
					EndDate.setDate(date2.getDate() + 1);
					let d = EndDate.getDate();
					let m = EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					let y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
					}
				});
			} else if (expPeriodCode === "exp_period_4_7_2") {
				$('#expPeriodCost').val('70000');
				$('#expPeriodJournalCount').val('2');
				$('#expPeriodLevel').val('4');
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					if($('#sdate').val() != ''){
					let date2 = $('#sdate').datepicker('getDate');
					let EndDate = new Date();
					EndDate.setYear(date2.getFullYear());
					EndDate.setMonth(date2.getMonth());
					EndDate.setDate(date2.getDate() + 3);
					let d = EndDate.getDate();
					let m = EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					let y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
					}
				});
			} else if (expPeriodCode === "exp_period_6_9_3") {
				$('#expPeriodCost').val('90000');
				$('#expPeriodJournalCount').val('3');
				$('#expPeriodLevel').val('6');
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					if($('#sdate').val() != ''){
					let date2 = $('#sdate').datepicker('getDate');
					let EndDate = new Date();
					EndDate.setYear(date2.getFullYear());
					EndDate.setMonth(date2.getMonth());
					EndDate.setDate(date2.getDate() + 5);
					let d = EndDate.getDate();
					let m = EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					let y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
					}
				});
			} else if (expPeriodCode === "exp_period_7_11_4") {
				$('#expPeriodCost').val('110000');
				$('#expPeriodJournalCount').val('4');
				$('#expPeriodLevel').val('7');
				$('#sdate').datepicker("option", "onClose", function (selectedDate) {
					if($('#sdate').val() != ''){
					let date2 = $('#sdate').datepicker('getDate');
					let EndDate = new Date();
					EndDate.setYear(date2.getFullYear());
					EndDate.setMonth(date2.getMonth());
					EndDate.setDate(date2.getDate() + 6);
					let d = EndDate.getDate();
					let m = EndDate.getMonth();
					m += 1;  // JavaScript months are 0-11
					let y = EndDate.getFullYear();
					$("#edate").val(y + "-" + m + "-" + d);
					}
				});
			}
			$('#insertForm').click(function(){
				if($('#expPurpose').val() != ''){
					$("#expadd").submit();
				}
			});
		});
	});
</script>
<head>
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
                    <h1 class="page-header">체험신청</h1>
                </div>
            </div>
          	<!-- h태그제목 끝 -->
			<!-- 내용 부분 시작-->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            체험 신청
                        </div>
                        <!-- .panel-heading -->
                        <div class="panel-body">
                      	  <form id="expadd" name="expadd" action="${pageContext.request.contextPath}/experience/expAdd" method="post">
                      	  	<input type="hidden" name="animalCode" value="${animalCode}">
							<input type="hidden" name="blCode" value="${blCode}">
							<input type="hidden" name=expJournalCount id="expPeriodJournalCount">
							<input type="hidden" name="expCost" id="expPeriodCost">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">1. 기간 및 책임비 선택</a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                        	기간 및 책임비를 선택해주세요.<br>
                                        	<select name="expPeriodCode" id="expPeriodCode">
												<option>---기간 및 가격---</option>
												<c:forEach var="e" items="${addAttribute}">
													<option value="${e.expPeriodCode}">기간:${e.expPeriodPeriod},가격:${e.expPeriodCost}</option>
												</c:forEach>
											</select>
											<br><br>
											시작일 : <input type="text" name="expStartDate" id="sdate" size="10" maxlength="10" value="" readonly="readonly"/><br>
											시작일은 기간 및 가격을 선택하게 되면 선택이 가능합니다.<br><br>
											종료일 : <input type="text" name="expEndDate" id="edate" size="10" maxlength="10" value="" readonly="readonly"/><br>
											종료일은 자동으로 선택됩니다.<br>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">2. 체험 신청하게된 이유</a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                        	체험 신청하게된 이유를 작성해주세요. <br><br>
                                        	체험 이유 : <input type="text" id="expPurpose" name="expPurpose">
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">3. 체험 신청</a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse">
                                        <div class="panel-body">
                                        동물 체험 신청을 해주셔서 감사합니다 ! <br>
                                        <br><button type="button" id="insertForm">체험 신청하기</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </form>
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            	</div>
			</div>
			<!-- 내용 부분 끝-->
	<!-- foot 부분 시작 -->
	<jsp:include page="/WEB-INF/views/module/foot.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-ui.js"></script>
	<!-- foot 부분 끝 -->
</body>
</html>
