package com.cafe24.iso159.exp.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ExpDao {
	@Autowired
	//생성해서 사용할 객체를 bean을 통해 생성해서 가져옴
	private SqlSessionTemplate sqlSessionTemplate;
	//디버그용 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(ExpDao.class);
	//맵퍼 id를 가져올때 사용할 맵퍼 생성
	private final String nameSpace = "com.cafe24.iso159.exp.service.ExpMapper.";
	
	//체험 수정
	public void updateExpOen(Exp exp) {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {updateExpOen}.");
		logger.debug("updateExpOen() 메서드 실행 exp is {}", exp);
		sqlSessionTemplate.update(nameSpace + "updateExpOen", exp);
	}
	
	//체험 수정 띄워주는 부분
	public Exp selectUpdateExpOne(String expCode) {
		Exp exp = sqlSessionTemplate.selectOne(nameSpace + "selectUpdateExpOne", expCode);
		return exp;
	}
	
	//사용자가 자기가신청한 체험 리스트 보는 코드
	public List<ExpAndAnimal> selectExpOneList(String mExpId) {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpOneList}.");
		List<ExpAndAnimal> expAndAnimal = sqlSessionTemplate.selectList(nameSpace + "selectExpOneList", mExpId);
		logger.debug("selectExpOneList() 메서드 실행 expAndAnimal is {}", expAndAnimal);
		return expAndAnimal;
	}
	
	
	//사용자가 자기가신청한 체험정보 보는 코드
	public ExpAndAnimalAndBusinessLicense selectExpOneInfo(String expCode){
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpOne}.");
		ExpAndAnimalAndBusinessLicense expAndAnimalAndBusinessLicense = sqlSessionTemplate.selectOne(nameSpace + "selectExpAndAnimalAndBusinessLicenseOneInfo", expCode);
		logger.debug("selectExpOneInfo() 메서드 실행 expAndAnimalAndBusinessLicense is {}", expAndAnimalAndBusinessLicense);
		return expAndAnimalAndBusinessLicense;
	}
	
	//expPeriod 목록 띄워주는 코드
	public List<ExpPeriod> selectExpPeriod() {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpPeriod}.");
		List<ExpPeriod> expPeriod = sqlSessionTemplate.selectList(nameSpace+"selectExpPeriod");
		logger.debug("selectExpPeriod() 메서드 실행 expPeriod is {}", expPeriod);
		return expPeriod;
	}
	
	//expCode 생성 코드
	public int selectExpCode() {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpCode}.");
		//expCode 생성
		int expCode = sqlSessionTemplate.selectOne(nameSpace+"selectExpCode");
		logger.debug("selectExpCode() 메서드 실행 expCode is {}", expCode+1);
		return expCode+1;
	}
	
	//exp 입력 코드
	public void addExp(Exp exp) {
		logger.debug("ExpDao.java 호출 {addExp}.");
		logger.debug("addExp() 메서드 실행 exp is {}", exp);
		sqlSessionTemplate.insert(nameSpace+"addExp", exp);
	}
}
