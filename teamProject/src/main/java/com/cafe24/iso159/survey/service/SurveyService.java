package com.cafe24.iso159.survey.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	private static final Logger logger = LoggerFactory.getLogger(SurveyService.class);
	@Autowired
	private SurveyDao surveyDao;
	
	// 상담질문리스트
	public List<SurveyList> listSurveyListCounsel(){
		logger.debug("listSurveyListCounsel() 메소드 호출");
		List<SurveyList> list = surveyDao.selectSurveyCounselList();
		logger.debug("listSurveyListCounsel() 메소드 호출 list is {}", list);
		return list;
	}
	
	
	
}
