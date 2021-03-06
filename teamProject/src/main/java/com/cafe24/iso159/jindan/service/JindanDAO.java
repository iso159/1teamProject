package com.cafe24.iso159.jindan.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iso159.service.common.OverallStatus;
import com.cafe24.iso159.shelter.service.BusinessLicense;

@Repository
public class JindanDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(JindanDAO.class);
	private final String nameSpace = "com.cafe24.iso159.jindan.service.JindanMapper.";
	
	// t_jindan_nose 테이블 입력 쿼리문 insertJindanNose를 접근하는 DAO 메서드
	public void insertJindanNose(JindanNose jindanNose) {
		logger.debug("insertJindanNose(JindanNose jindanNose) 메서드 호출");
		logger.debug("insertJindanNose(JindanNose jindanNose) 메서드 jindanNose is {}", jindanNose);
		int result = sqlSessionTemplate.insert(nameSpace + "insertJindanNose", jindanNose);
		logger.debug("insertJindanNose(JindanNose jindanNose) 메서드 result is {}", result);
		logger.debug("insertJindanNose(JindanNose jindanNose) 메서드 끝");
	}
	
	// t_jindan_skin 테이블 입력 쿼리문 insertJindanSkin을 접근하는 DAO 메서드
	public void insertJindanSkin(JindanSkin jindanSkin) {
		logger.debug("insertJindanSkin(JindanSkin jindanSkin) 메서드 호출");
		logger.debug("insertJindanSkin(JindanSkin jindanSkin) 메서드 jindanSkin is {}", jindanSkin);
		int result = sqlSessionTemplate.insert(nameSpace + "insertJindanSkin", jindanSkin);
		logger.debug("insertJindanSkin(JindanSkin jindanSkin) 메서드 result is {}", result);
		logger.debug("insertJindanSkin(JindanSkin jindanSkin) 메서드 끝");
	}
	
	// t_jindan_general 테이블 입력 쿼리문 insertJindanGeneral을 접근하는 DAO 메서드
	public void insertJindanGeneral(JindanGeneral jindanGeneral) {
		logger.debug("insertJindanGeneral(JindanGeneral jindanGeneral) 메서드 호출");
		logger.debug("insertJindanGeneral(JindanGeneral jindanGeneral) 메서드 jindanGeneral is {}", jindanGeneral);
		int result = sqlSessionTemplate.insert(nameSpace + "insertJindanGeneral", jindanGeneral);
		logger.debug("insertJindanGeneral(JindanGeneral jindanGeneral) 메서드 result is {}", result);
		logger.debug("insertJindanGeneral(JindanGeneral jindanGeneral) 메서드 끝");
	}
	
	// t_jindan_eyes 테이블 입력 쿼리문 insertJindanEyes을 접근하는 DAO 메서드
	public void insertJindanEyes(JindanEyes jindanEyes) {
		logger.debug("insertJindanEyes(JindanEyes jindanEyes) 메서드 호출");
		logger.debug("insertJindanEyes(JindanEyes jindanEyes) 메서드 jindanEyes is {}", jindanEyes);
		int result = sqlSessionTemplate.insert(nameSpace + "insertJindanEyes", jindanEyes);
		logger.debug("insertJindanEyes(JindanEyes jindanEyes) 메서드 result is {}", result);
		logger.debug("insertJindanEyes(JindanEyes jindanEyes) 메서드 끝");
	}
	
	// t_jindan_ears 테이블 입력 쿼리문 insertJindanEars을 접근하는 DAO 메서드
	public void insertJindanEars(JindanEars jindanEars) {
		logger.debug("insertJindanEars(JindanEars jindanEars) 메서드 호출");
		logger.debug("insertJindanEars(JindanEars jindanEars) 메서드 jindanEars is {}", jindanEars);
		int result = sqlSessionTemplate.insert(nameSpace + "insertJindanEars", jindanEars);
		logger.debug("insertJindanEars(JindanEars jindanEars) 메서드 result is {}", result);
		logger.debug("insertJindanEars(JindanEars jindanEars) 메서드 끝");
	}
	
	// 진단 테이블 입력 쿼리문 insertJindan을 접근하는 DAO 메서드
	public void insertJindan(Jindan jindan) {
		logger.debug("insertJindan(Jindan jindan) 메서드 호출");
		logger.debug("insertJindan(Jindan jindan) 메서드 jindan is {}", jindan);
		// 결과 확인을 위해 result 변수에 리턴값 입력
		int result = sqlSessionTemplate.insert(nameSpace + "insertJindan", jindan);
		// 결과값 디버그
		logger.debug("insertJindan(Jindan jindan) 메서드 result is {}", result);
		logger.debug("insertJindan(Jindan jindan) 메서드 끝");
	}
	
	// 진단 테이블의 기본키 최대값 조회 쿼리문 selectJindanCodeMaxNum을 접근하는 DAO 메서드
	public String selectJindanCodeMaxNum() {
		logger.debug("selectJindanCodeMaxNum() 메서드 호출");
		String result = sqlSessionTemplate.selectOne(nameSpace + "selectJindanCodeMaxNum");
		logger.debug("selectJindanCodeMaxNum() 메서드 result is {}", result);
		logger.debug("selectJindanCodeMaxNum() 메서드 끝");
		return result;	
	}
	
	// 진단 테이블을 종합 상태별 코드로 조회하는 동적쿼리문 selectJindanOs을 접근하는 DAO 메서드
	public List<OverallStatus> selectJindanOs(String osLarge){
		logger.debug("selectJindanOs(String osLarge) 메서드 호출");
		logger.debug("selectJindanOs(String osLarge) 메서드 osLarge is {}", osLarge);
		List<OverallStatus> list = sqlSessionTemplate.selectList(nameSpace + "selectJindanOs", osLarge);
		logger.debug("selectJindanOs(String osLarge) 메서드 list is {}", list);
		logger.debug("selectJindanOs(String osLarge) 메서드 끝");
		return list;
	}
	
	//보호소 테이블 전체 리스트 조회 Dao
	public List<BusinessLicense> selectBusinessLicenseList() {
		List<BusinessLicense> list = sqlSessionTemplate.selectList(nameSpace + "BusinessLicenseList");
		logger.debug("selectBusinessLicenseList() 메서드 list is {}", list);
		return list;
	}
}
