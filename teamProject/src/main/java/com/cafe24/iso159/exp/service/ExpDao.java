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
	
	//expPeriod 목록 띄워주는 코드
	public List<ExpPeriod> selectExpPeriod() {
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
	
	//AnimalCode를 사용해서 BlCode 구하는 코드
	public String selectAnimalCodeBlCode(String animalCode) {
		logger.debug("ExpDao.java 호출 {selectAnimalCodeBlCode}.");
		String blCode = sqlSessionTemplate.selectOne(nameSpace+"selectAnimalCodeBlCode", animalCode);
		return blCode;
	}
	
	//exp 입력 코드
	public void addExp(Exp exp) {
		logger.debug("ExpDao.java 호출 {addExp}.");
		logger.debug("addExp() 메서드 실행 exp is {}", exp);
		sqlSessionTemplate.insert(nameSpace+"addExp", exp);
	}
}
