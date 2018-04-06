package com.cafe24.iso159.jindan.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iso159.service.common.OverallStatus;

@Repository
public class JindanDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(JindanDAO.class);
	private final String nameSpace = "com.cafe24.iso159.jindan.service.JindanMapper.";
	
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
	public int selectJindanCodeMaxNum() {
		logger.debug("selectJindanCodeMaxNum() 메서드 호출");
		int result = sqlSessionTemplate.selectOne(nameSpace + "selectJindanCodeMaxNum");
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
}
