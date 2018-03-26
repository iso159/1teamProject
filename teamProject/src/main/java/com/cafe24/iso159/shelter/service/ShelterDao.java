package com.cafe24.iso159.shelter.service;

import java.util.List;
import java.util.Map;

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
	
	// 보호소 대표 신청 상태 거절로 수정 및 거절 사유 등록(수정)하는 쿼리문을 접근하는 메서드 
	public void updateBusinessLicenseDeny(Map<String,Object> map) {
		logger.debug("updateBusinessLicenseDeny(Map<String,Object> map) 메서드 호출");
		logger.debug("updateBusinessLicenseDeny(Map<String,Object> map) 메서드 map is {}",map);
		int result = sqlSessionTemplate.update(nameSpace + "updateBusinessLicenseDeny", map);
		logger.debug("updateBusinessLicenseDeny(Map<String,Object> map) 메서드 끝");
	}
	
	// 보호소 대표 신청 상태 신청확인으로 수정하는 쿼리문을 접근하는 메서드
	public void updateBusinessLicenseOsCodeLicenseStatus(Map<String,Object> map) {
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 호출");
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 map is {}", map);
		int result = sqlSessionTemplate.update(nameSpace + "updateBusinessLicenseOsCodeLicenseStatus", map);
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 result is {}", result);
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 끝");
	}
	
	// 개인 파일리스트 조회 쿼리문을 접근하는 메서드
	public MemberIdAndBusinessLicenseFile selectBusinessLicenseFileList(String blCode){
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 호출");
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 blCode is {}", blCode);
		MemberIdAndBusinessLicenseFile memberIdAndBusinessLicenseFile = sqlSessionTemplate.selectOne(nameSpace + "selectBusinessLicenseFileList", blCode);
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 memberIdAndBusinessLicenseFile is {}", memberIdAndBusinessLicenseFile);
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 끝");
		return memberIdAndBusinessLicenseFile;
	}
	
	// 보호소 대표 신청 전체 리스트 조회 쿼리문을 접근하는 메서드
	public List<BusinessLicense> selectAllBusinessLicense() {
		logger.debug("selectBusinessLicense() 메서드 호출");
		List<BusinessLicense> list = sqlSessionTemplate.selectList(nameSpace + "selectAllBusinessLicense");
		logger.debug("selectBusinessLicense() 메서드 list is {}",list);
		logger.debug("selectBusinessLicense() 메서드 끝");
		return list;
	}
	
	// t_overall_file 테이블의 of_code를 잘라서 가장 높은 숫자를 리턴하는 쿼리문을 접근하는 메서드
	public String selectOfCodeNum() {
		logger.debug("selectOfCodeNum() 메서드 호출");
		String result = sqlSessionTemplate.selectOne(nameSpace + "selectOfCodeNum");
		logger.debug("selectOfCodeNum() 메서드 result is {}", result);
		logger.debug("selectOfCodeNum() 메서드 끝");
		return result;
	}
	
	// MVC 규칙을 위한 businessLicense 메서드
	public void businessLicense() {
		logger.debug("businessLicense() 메서드 호출");
		logger.debug("businessLicense() 메서드 끝");
	}
	
	// 보호소 대표 신청 쿼리문 접근하는 메서드
	public void insertBusinessLicense(BusinessLicense businessLicense) {
		logger.debug("insertBusinessLicense(BusinessLicense businessLicense) 메서드 호출");
		logger.debug("insertBusinessLicense(BusinessLicense businessLicense) 메서드 businessLicense is {}",businessLicense);
		int result = sqlSessionTemplate.insert(nameSpace + "insertBusinessLicense", businessLicense);
		logger.debug("insertBusinessLicense(BusinessLicense businessLicense) 메서드 result is {}",result);
		logger.debug("insertBusinessLicense(BusinessLicense businessLicense) 메서드 끝");
	}
	
	// t_business_license테이블의 bl_code를 잘라서 가장 높은 숫자를 리턴하는 쿼리문을 접근하는 메서드
	public String selectBlCodeNum() {
		logger.debug("selectBlCodeNum() 메서드 호출");
		String result = sqlSessionTemplate.selectOne(nameSpace + "selectBlCodeNum");
		logger.debug("selectBlCodeNum() 메서드 result is {}",result);
		logger.debug("selectBlCodeNum() 메서드 끝");
		return result;
	}
	
	// 사업자 등록증 파일 등록 쿼리문 접근하는 메서드
	public void insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) {
		logger.debug("insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) 메서드 호출");
		logger.debug("insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) 메서드 businessLicenseFile is {}",businessLicenseFile);
		int result = sqlSessionTemplate.insert(nameSpace+"insertBusinessLicenseFile",businessLicenseFile);
		logger.debug("insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) 메서드 result is {}",result);
		logger.debug("insertBusinessLicenseFile(BusinessLicenseFile businessLicenseFile) 메서드 끝");
	}
}
