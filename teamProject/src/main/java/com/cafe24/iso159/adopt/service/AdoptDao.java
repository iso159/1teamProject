package com.cafe24.iso159.adopt.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdoptDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(AdoptDao.class);
	private final String nameSpace = "com.cafe24.iso159.adopt.service.AdoptMapper."; 
	
	// 입양신청
	public void insertAdopt(AdoptRequest adoptRequest) {
		logger.debug("insertAdopt() 메서드 호출");
		sqlSessionTemplate.insert(nameSpace + "AdoptRequest", adoptRequest);
	}
	
	// 파일등록
	public int insertAdoptFile(AdoptRequestFile adoptRequestFile) {
		logger.debug("insertAdoptFile() 메서드 호출, adoptRequestFile is {}", adoptRequestFile);
		return sqlSessionTemplate.insert(nameSpace + "insertAdoptFile", adoptRequestFile);
	}
	
	// max코드값 조회
	public String selectLastCodeAr() {
		logger.debug("selectLastCodeAr() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastCodeAr");
	}
	public String selectLastCodeOf() {
		logger.debug("selectLastCodeOf() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastCodeOf");
	}
	
	
	// 입양신청조회
	public List<AdoptRequest> selectAdoptRequest(){
		logger.debug("List<AdoptRequest> selectAdoptRequest() 메서드 호출");
		List<AdoptRequest> list = sqlSessionTemplate.selectList(nameSpace + "selectAdoptRequest");
		logger.debug("list is {}", list);
		return list;
	}
	
	// 입양신청 확인
	public void updateOsCodeAdopt(String adoptRequestCode) {
		logger.debug("updateOsCodeAdopt() 메서드 호출");
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAdopt", adoptRequestCode);
	}
	
	// 입양취소 
	public void deleteAdopt(String adoptRequestCode) {
		logger.debug("deleteAdopt() 메서드 호출");
		sqlSessionTemplate.delete(nameSpace + "deleteAdopt", adoptRequestCode);
	}
}
