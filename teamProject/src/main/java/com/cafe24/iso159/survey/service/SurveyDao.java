package com.cafe24.iso159.survey.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iso159.adopt.service.AdoptDao;

@Repository
public class SurveyDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(SurveyDao.class);
	private final String nameSpace = "com.cafe24.iso159.survey.service.SurveyMapper."; 
	
	
	// 상담질문조회
	public List<SurveyList> selectSurveyCounselList(){
		logger.debug("selectSurveyCounselList() 메서드 호출");
		List<SurveyList> list = sqlSessionTemplate.selectList(nameSpace + "selectSurveyCounselList");
		logger.debug("list is {}", list);
		return list;
	}
}
