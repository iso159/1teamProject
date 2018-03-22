package com.cafe24.iso159.shelter.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShelterDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(ShelterDao.class);
	private final String nameSpace = "com.cafe24.iso159.shelter.service.ShelterMapper.";
	
	// 보호소 대표 신청 쿼리문 호출하는 메서드
	public void insertBusinessLicense(BusinessLicense businessLicense) {
		logger.debug("insertBusinessLicense 메서드 businessLicense is {}",businessLicense);
		int result = sqlSessionTemplate.insert(nameSpace + "insertBusinessLicense", businessLicense);
		logger.debug("insertBusinessLicense 메서드 result is {}",result);
	}
	
	// t_business_license테이블의 bl코드를 잘라서 가장 높은 숫자를 리턴하는 쿼리문을 호출하는 메서드
	public String selectBlCodeNum() {
		logger.debug("selectBlCodeNum() 메서드");
		String result = sqlSessionTemplate.selectOne(nameSpace + "selectBlCodeNum");
		logger.debug("selectBlCodeNum() 메서드 result is {}",result);
		return result;
	}
	
	// 마지막으로 insert한 테이블의 기본키를 조회하는 쿼리문을 호출하는 메서드
	public String selectLastInsertCode() {
		logger.debug("selectLastInsertCode() 메서드");
		String blCode = sqlSessionTemplate.selectOne(nameSpace+"selectLastInsertCode");
		logger.debug("selectLastInsertCode() 메서드 blCode is {}",blCode);
		return blCode;
	}
	
	// 사업자 등록증 파일 등록 쿼리문 호출하는 메서드
	public void insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) {
		logger.debug("insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) 메서드 businessLicenseFile is {}",businessLicenseFile);
		int result = sqlSessionTemplate.insert(nameSpace+"insertBusinessLicenseFile",businessLicenseFile);
		logger.debug("insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) 메서드 result is {}",result);
	}
}
