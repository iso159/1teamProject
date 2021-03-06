package com.cafe24.iso159.survey.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.iso159.member.service.MemberSurvey;

@Service
public class SurveyService {
	private static final Logger logger = LoggerFactory.getLogger(SurveyService.class);
	@Autowired
	private SurveyDao surveyDao;
	
	// 설문지등록
	public void addSurvey(Survey survey) {
		logger.debug("addSurvey() 메소드 호출");
		logger.debug("addSurvey() 메소드 호출 survey is {}", survey);
		
		// 마지막코드 숫자값을 저장
		String lastSurveyCode = surveyDao.selectLastSurveyCode();
		
		// 마지막 survey_code 코드
		String svCode = "survey_code_";
		String surveyCode = "survey_code_1";
		int surveyCodeNum = 1;
		
		if(lastSurveyCode == null) {
			svCode += surveyCodeNum;
		}else {
			surveyCodeNum += Integer.parseInt(lastSurveyCode);
			svCode += surveyCodeNum;
		}
		logger.debug("svCode is {}", svCode);
		
		// survey에 담은 후 입력 메소드 호출
		survey.setSurveyCode(svCode);
		survey.setmAdminId(survey.getmAdminId());
		survey.setSurveyName(survey.getSurveyName());
		survey.setSurveyPoint(survey.getSurveyPoint());
		logger.debug("survey is {}", survey);
		surveyDao.insertSurvey(survey);
		
	}
	
	// 질문등록
	public void addSurveyList(SurveyList surveyList) {
		logger.debug("addSurveyList() 메소드 호출");
		logger.debug("addSurveyList() 메소드 호출 surveyList is {}", surveyList);
		
		
			// 마지막코드 숫자값을 저장
			String lastSurveyListCode = surveyDao.selectLastSurveyListCode();
			
			// 마지막 survey_code 코드
			String svlCode = "survey_list_code_";
			String surveyCode = "survey_list_code_1";
			int surveyListCodeNum = 1;
			
			if(lastSurveyListCode == null) {
				svlCode += surveyListCodeNum;
			}else {
				surveyListCodeNum += Integer.parseInt(lastSurveyListCode);
				svlCode += surveyListCodeNum;
			}
			logger.debug("svlCode is {}", svlCode);
			
			// surveyList에 값 셋팅 후 메소드 호출
			surveyList.setSurveyListCode(svlCode);
			surveyList.setSurveyCode(surveyList.getSurveyCode());
			surveyList.setSurveyListQuestion(surveyList.getSurveyListQuestion());
			logger.debug("surveyList is {}", surveyList);
			surveyDao.insertSurveyList(surveyList);
		
	}
	
	// 회원설문지 등록
	public void addMemberSurvey(MemberSurvey memberSurvey) {
		logger.debug("addMemberSurvey() 메소드 호출 memberSurvey is {}", memberSurvey);
		
		// 마지막코드 숫자값을 저장
		String lastMemberSurveyCode = surveyDao.selectLastMemberSurveyCode();
		
		// 마지막 survey_code 코드
		String msCode = "m_survey_code_";
		String MemberSurveyCode = "m_survey_code_1";
		int surveyListCodeNum = 1;
		
		if(lastMemberSurveyCode == null) {
			msCode += surveyListCodeNum;
		}else {
			surveyListCodeNum += Integer.parseInt(lastMemberSurveyCode);
			msCode += surveyListCodeNum;
		}
		logger.debug("svlCode is {}", msCode);
		
		// MemberSurvey에 값 셋팅 후 메소드 호출
		memberSurvey.setmSurveyCode(msCode);
		memberSurvey.setSurveyListCode(memberSurvey.getSurveyListCode());
		memberSurvey.setExpCode(memberSurvey.getExpCode());
		memberSurvey.setmExpId(memberSurvey.getmExpId());
		memberSurvey.setSurveyRecordCode(memberSurvey.getSurveyRecordCode());
		surveyDao.insertMemberSurvey(memberSurvey);
	}
	
	// 설문지 리스트 조회
	public List<Survey> listSurvey(){
		logger.debug("listSurvey() 메소드 호출");
		List<Survey> list = surveyDao.selectSurveyList();
		logger.debug("listSurvey() 메소드 호출 list is {}", list);
		return list;
	}
	
	// 설문지 질문 리스트 조회
	public List<SurveyList> listSurveyList(){
		logger.debug("listSurveyList() 메소드 호출");
		List<SurveyList> list = surveyDao.selectSurveyListList();
		logger.debug("listSurveyList() 메소드 호출 list is {}", list);
		return list;
	}
	
	// 설문지 질문 상세조회 : 설문지코드
	public List<SurveyList> listSurveyListBySurveyCode(String SurveyCode){
		logger.debug("listSurveyListBySurveyCode() 메소드 호출");
		List<SurveyList> list = surveyDao.selectSurveyListListBySurveyCode(SurveyCode);
		logger.debug("listSurveyListBySurveyCode() list is {}", list);
		return list;
	}
	
	// 상담질문리스트 조회
	public List<SurveyList> listSurveyListCounsel(){
		logger.debug("listSurveyListCounsel() 메소드 호출");
		List<SurveyList> list = surveyDao.selectSurveyCounselList();
		logger.debug("listSurveyListCounsel() 메소드 호출 list is {}", list);
		return list;
	}
	
	// 설문지 수정
	public void ModifySurvey(Survey survey,String surveyCode) {
		logger.debug("ModifySurvey() 메소드 호출 survey is {}", survey);
		survey.setSurveyCode(surveyCode);
		surveyDao.updateSurvey(survey);
	}
	// 설문지코드로 설문지 조회
	public Survey listSurveyBySurveyCode(String surveyCode) {
		logger.debug("listSurveyBySurveyCode() 메소드 호출 surveyCode is {}", surveyCode);
		Survey survey = surveyDao.selectSurveyListBySurveyCode(surveyCode);
		return survey;
	}
	
	// 설문지 삭제 
	public void removeSurvey(String surveyCode) {
		logger.debug("removeSurvey() 메소드 호출 surveyCode is {}", surveyCode);
		// 1. 설문지코드로 설문지 질문삭제
		surveyDao.deleteSurveyListBySurveyCode(surveyCode);
		// 2. 설문지 삭제
		surveyDao.deleteSurvey(surveyCode);
	}
	
	// 설문지 질문 삭제
	public void removeSurveyList(String surveyListCode) {
		logger.debug("removeSurveyList() 메소드 호출 surveyListCode is {}", surveyListCode);
		surveyDao.deleteSurveyList(surveyListCode);
	}
}
