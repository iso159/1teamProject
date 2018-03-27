package com.cafe24.iso159.adopt.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.javafx.collections.MappingChange.Map;

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
	public void updateOsCodeAdoptRequest(String adoptRequestCode) {
		logger.debug("updateOsCodeAdopt() 메서드 호출");
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAdopt412", adoptRequestCode);
	}
	
	// 입양신청 파일조회
	public List<AdoptRequestFile> selectAdoptFileList(String adoptRequestCode){
		logger.debug("selectAdoptFileList() 메서드 호출 adoptRequestCode is {}", adoptRequestCode);
		List<AdoptRequestFile> list = sqlSessionTemplate.selectList(nameSpace + "selectAdoptFileList", adoptRequestCode);
		return list;
	}
	
	// 상담등록확인
	public void updateOsCodeAdoptCounsel(String adoptRequestCode) {
		logger.debug("updateOsCodeAdoptCounsel() 메서드 호출");
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAdopt415", adoptRequestCode);
	}
	
	// 입양결정완료
	public void updateOsCodeAdoptDecide(String adoptRequestCode) {
		logger.debug("updateOsCodeAdoptDecide() 메서드 호출");
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAdopt417", adoptRequestCode);
	}
	
	// 입양취소 
	public void deleteAdopt(String adoptRequestCode) {
		logger.debug("deleteAdopt() 메서드 호출");
		sqlSessionTemplate.delete(nameSpace + "deleteAdopt", adoptRequestCode);
	}
	
	// 상담내용입력
	public void updateAdoptRequestAdvice(AdoptRequest adoptRequest) {
		logger.debug("updateAdoptRequestAdvice() 메서드 호출");
		logger.debug("updateAdoptRequestAdvice() 메서드 adoptRequest is {}", adoptRequest);
		sqlSessionTemplate.update(nameSpace + "updateAdoptRequestAdvice", adoptRequest);
	}
	// 상담내용조회
	public AdoptRequest selectAdoptCounselList(String adoptRequestCode) {
		logger.debug("selectAdoptCounselList() 메서드 호출");
		logger.debug("selectAdoptCounselList() 메서드 adoptRequestCode is {}", adoptRequestCode);
		return sqlSessionTemplate.selectOne(nameSpace + "selectAdoptCounselList", adoptRequestCode);
	}
}
