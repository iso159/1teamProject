package com.cafe24.iso159.survey.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iso159.adopt.service.AdoptDao;
import com.cafe24.iso159.member.service.MemberSurvey;

@Repository
public class SurveyDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(SurveyDao.class);
	private final String nameSpace = "com.cafe24.iso159.survey.service.SurveyMapper."; 
	
	// 설문지등록
	public void insertSurvey(Survey survey) {
		logger.debug("insertSurvey() 메서드 호출");
		sqlSessionTemplate.insert(nameSpace + "insertSurvey",survey);
	}
	// 설문지 질문 등록
	public void insertSurveyList(SurveyList surveyList) {
		logger.debug("insertSurveyList() 메서드 호출");
		sqlSessionTemplate.insert(nameSpace + "insertSurveyList",surveyList);
	}
	// 회원 설문지 등록
	public void insertMemberSurvey(MemberSurvey memberSurvey) {
		logger.debug("insertMemberSurvey() 메서드 호출 memberSurvey is {}",memberSurvey);
		sqlSessionTemplate.insert(nameSpace + "insertMemberSurvey",memberSurvey);
	}
	
	// max코드값 조회
	public String selectLastSurveyCode() {
		logger.debug("selectLastSurveyCode() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastSurveyCode");
	}
	public String selectLastSurveyListCode() {
		logger.debug("selectLastSurveyListCode() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastSurveyListCode");
	}
	public String selectLastMemberSurveyCode() {
		logger.debug("selectLastMemberSurveyCode() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastMemberSurveyCode");
	}
	
	// 설문지 조회
	public List<Survey> selectSurveyList(){
		logger.debug("selectSurveyList() 메서드 호출");
		return sqlSessionTemplate.selectList(nameSpace + "selectSurveyList");
	}
	// 설문지 수정
	public void updateSurvey(Survey survey) {
		logger.debug("updateSurvey() 메서드 호출 survey is {}", survey);
		sqlSessionTemplate.selectOne(nameSpace + "updateSurvey", survey);
	}
	
	// 설문지코드로 질문조회
	public List<SurveyList> selectSurveyListListBySurveyCode(String surveyCode){
		logger.debug("selectSurveyListListBySurveyCode() 메서드 호출");
		return sqlSessionTemplate.selectList(nameSpace + "selectSurveyListListBySurveyCode", surveyCode);
	}
	// 설문지 질문 조회
	public List<SurveyList> selectSurveyListList(){
		logger.debug("selectSurveyListList() 메서드 호출");
		return sqlSessionTemplate.selectList(nameSpace + "selectSurveyListList");
	}
	// 설문지코드로 설문지 조회
	public Survey selectSurveyListBySurveyCode(String surveyCode) {
		logger.debug("selectSurveyListBySurveyCode() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectSurveyListBySurveyCode", surveyCode);
	}
	
	// 상담질문조회
	public List<SurveyList> selectSurveyCounselList(){
		logger.debug("selectSurveyCounselList() 메서드 호출");
		List<SurveyList> list = sqlSessionTemplate.selectList(nameSpace + "selectSurveyCounselList");
		logger.debug("list is {}", list);
		return list;
	}
	// 설문지 삭제
	public void deleteSurvey(String surveyCode) {
		logger.debug("deleteSurvey() 메서드 호출 surveyCode is {}",surveyCode);
		sqlSessionTemplate.delete(nameSpace + "deleteSurvey", surveyCode);
	}
	// 설문지 질문 삭제
	public void deleteSurveyList(String surveyListCode) {
		logger.debug("deleteSurveyList() 메서드 호출 surveyListCode is {}",surveyListCode);
		sqlSessionTemplate.delete(nameSpace + "deleteSurveyList", surveyListCode);
	}
	// 설문지질문삭제 설문지코드로
	public void deleteSurveyListBySurveyCode(String surveyCode) {
		logger.debug("deleteSurveyListBySurveyCode() 메서드 호출 surveyCode is {}",surveyCode);
		sqlSessionTemplate.delete(nameSpace + "deleteSurveyListBySurveyCode", surveyCode);
	}
}
