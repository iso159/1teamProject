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
	
	// 대표 보호소 정보 조회 쿼리문 selectOneBusinessLicense을 접근하는 DAO 메서드
	public BusinessLicense selectOneBusinessLicense(String blCode) {
		logger.debug("selectOneBusinessLicense(String blCode) 메서드 호출");
		logger.debug("selectOneBusinessLicense(String blCode) 메서드 blCode is {}", blCode);
		BusinessLicense businessLicense = sqlSessionTemplate.selectOne(nameSpace + "selectOneBusinessLicense", blCode);
		logger.debug("selectOneBusinessLicense(String blCode) 메서드 businessLicense is {}", businessLicense);
		logger.debug("selectOneBusinessLicense(String blCode) 메서드 끝");
		return businessLicense;
	}
	
	// 직원신청 상태코드가 수정되는 쿼리문 updateShelterStaffRequestOsCodeBySsrCode을 접근하는 DAO 메서드
	public void updateShelterStaffRequestOsCodeBySsrCode(Map<String,Object> map) {
		logger.debug("updateShelterStaffRequestOsCodeBySsrCode(Map<String,Object> map) 메서드 호출");
		logger.debug("updateShelterStaffRequestOsCodeBySsrCode(Map<String,Object> map) 메서드 map is {}", map);
		int result = sqlSessionTemplate.update(nameSpace + "updateShelterStaffRequestOsCodeBySsrCode", map);
		logger.debug("updateShelterStaffRequestOsCodeBySsrCode(Map<String,Object> map) 메서드 result is {}", result);
		logger.debug("updateShelterStaffRequestOsCodeBySsrCode(Map<String,Object> map) 메서드 끝");
	}
	
	// 직원 신청 리스트를 회원 아이디로 조회 쿼리문 selectShelterStaffRequestAndShelterNameByMId을 접근하는 DAO 메서드
	public List<ShelterStaffRequestAndShelterName> selectShelterStaffRequestAndShelterNameByMId(Map<String,Object> map){
		logger.debug("selectShelterStaffRequestAndShelterNameByMId(String blCode) 메서드 호출");
		logger.debug("selectShelterStaffRequestAndShelterNameByMId(String blCode) 메서드 map is {}", map);
		List<ShelterStaffRequestAndShelterName> list = sqlSessionTemplate.selectList(nameSpace + "selectShelterStaffRequestAndShelterName", map);
		logger.debug("selectShelterStaffRequestAndShelterNameByMId(String blCode) 메서드 list is {}", list);
		logger.debug("selectShelterStaffRequestAndShelterNameByMId(String blCode) 메서드 끝");
		return list;
	}
	
	// 직원 신청 리스트를 보호소 코드로 조회 쿼리문 selectShelterStaffRequestAndShelterNameByBlCode을 접근하는 DAO 메서드
	public List<ShelterStaffRequestAndShelterName> selectShelterStaffRequestAndShelterNameByBlCode(Map<String,Object> map) {
		logger.debug("selectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 호출");
		logger.debug("selectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 map is {}", map);
		List<ShelterStaffRequestAndShelterName> list = sqlSessionTemplate.selectList(nameSpace + "selectShelterStaffRequestAndShelterName", map);
		logger.debug("selectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 list is {}", list);
		logger.debug("selectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 끝");
		return list;
	}
	
	// t_shelter_staff_request테이블의 ssr_code를 잘라서 가장 높은 숫자를 리턴하는 쿼리문을 접근하는 DAO 메서드
	public String selectSsrCodeNum() {
		logger.debug("selectSsrCodeNum() 메서드 호출");
		String ssrCodeNum = sqlSessionTemplate.selectOne(nameSpace + "selectSsrCodeNum");
		logger.debug("selectSsrCodeNum() 메서드 ssrCodeNum is {}", ssrCodeNum);
		logger.debug("selectSsrCodeNum() 메서드 끝");
		return ssrCodeNum;
	}
	
	// 보호소 직원 신청 쿼리문 insertShelterStaffRequest을 접근하는 DAO 메서드
	public void insertShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) {
		logger.debug("insertShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 호출");
		logger.debug("insertShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 shelterStaffRequest is {}", shelterStaffRequest);
		int result = sqlSessionTemplate.insert(nameSpace + "insertShelterStaffRequest", shelterStaffRequest);
		logger.debug("insertShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 result is {}", result);
		logger.debug("insertShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 끝");
	}
	
	// 상태코드별 보호소 등록 신청 조회 쿼리문 selectShelterList를 접근하는 DAO 메서드
	public List<BusinessLicense> selectShelterList(String osCodeLicenseStatus){
		logger.debug("selectShelterList(String osCodeLicenseStatus) 메서드 호출");
		logger.debug("selectShelterList(String osCodeLicenseStatus) 메서드 osCodeLicenseStatus is {}", osCodeLicenseStatus);
		List<BusinessLicense> list = sqlSessionTemplate.selectList(nameSpace + "selectShelterList", osCodeLicenseStatus);
		logger.debug("selectShelterList(String osCodeLicenseStatus) 메서드 list is {}", list);
		logger.debug("selectShelterList(String osCodeLicenseStatus) 메서드 끝");
		return list;
	}
	
	// 체험자 권한 보호소로 수정하는 쿼리문을 접근하는 DAO 메서드
	public void updateShelterRight(Map<String,Object> map) {
		logger.debug("updateShelterRight(Map<String,Object> map) 메서드 호출");
		logger.debug("updateShelterRight(Map<String,Object> map) 메서드 map is {}", map);
		@SuppressWarnings("unused")
		int result = sqlSessionTemplate.update(nameSpace + "updateShelterRight", map);
		logger.debug("updateShelterRight(Map<String,Object> map) 메서드 끝");
	}
	
	// 보호소 대표 신청 상태 거절로 수정 및 거절 사유 등록(수정)하는 쿼리문을 접근하는 DAO 메서드 
	public void updateBusinessLicenseDeny(Map<String,Object> map) {
		logger.debug("updateBusinessLicenseDeny(Map<String,Object> map) 메서드 호출");
		logger.debug("updateBusinessLicenseDeny(Map<String,Object> map) 메서드 map is {}",map);
		@SuppressWarnings("unused")
		int result = sqlSessionTemplate.update(nameSpace + "updateBusinessLicenseDeny", map);
		logger.debug("updateBusinessLicenseDeny(Map<String,Object> map) 메서드 끝");
	}
	
	// 보호소 대표 신청 상태를 수정하는 쿼리문을 접근하는 DAO 메서드
	public void updateBusinessLicenseOsCodeLicenseStatus(Map<String,Object> map) {
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 호출");
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 map is {}", map);
		int result = sqlSessionTemplate.update(nameSpace + "updateBusinessLicenseOsCodeLicenseStatus", map);
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 result is {}", result);
		logger.debug("updateBusinessLicense(Map<String,Object> map) 메서드 끝");
	}
	
	// 개인 파일리스트 조회 쿼리문을 접근하는 DAO 메서드
	public MemberIdAndBusinessLicenseFile selectBusinessLicenseFileList(String blCode){
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 호출");
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 blCode is {}", blCode);
		MemberIdAndBusinessLicenseFile memberIdAndBusinessLicenseFile = sqlSessionTemplate.selectOne(nameSpace + "selectBusinessLicenseFileList", blCode);
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 memberIdAndBusinessLicenseFile is {}", memberIdAndBusinessLicenseFile);
		logger.debug("selectBusinessLicenseFileList(String blCode) 메서드 끝");
		return memberIdAndBusinessLicenseFile;
	}
	
	// 보호소 대표 신청 전체 리스트 조회 쿼리문을 접근하는 DAO 메서드
	public List<BusinessLicense> selectBusinessLicense(String mMemberId) {
		logger.debug("selectBusinessLicense() 메서드 호출");
		List<BusinessLicense> list = sqlSessionTemplate.selectList(nameSpace + "selectBusinessLicense",mMemberId);
		logger.debug("selectBusinessLicense() 메서드 list is {}",list);
		logger.debug("selectBusinessLicense() 메서드 끝");
		return list;
	}
	
	// t_overall_file 테이블의 of_code를 잘라서 가장 높은 숫자를 리턴하는 쿼리문을 접근하는 DAO 메서드
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

	// 사후관리 보호소 신청 쿼리문을 사용하는 Dao 메서드
	public void insertClinicRequest(BusinessLicenseClinic businessLicenseClinic) {
		logger.debug("insertClinicRequest(BusinessLicenseClinic businessLicenseClinic) 메서드 호출");
		logger.debug("insertClinicRequest(BusinessLicenseClinic businessLicenseClinic) 메서드 businessLicenseClinic is {}", businessLicenseClinic);
		int result = sqlSessionTemplate.insert(nameSpace + "insertClinicRequest", businessLicenseClinic);
		logger.debug("insertClinicRequest(BusinessLicenseClinic businessLicenseClinic) 메서드 result is {}", result);
		logger.debug("insertClinicRequest(BusinessLicenseClinic businessLicenseClinic) 메서드 끝");
	}
	
	// t_shelter_clinic 테이블의 sc_code의 숫자 조회 Dao 메서드
	public String selectScCodeNum() {
		logger.debug("selectScCodeNum 메서드 호출");
		String result = sqlSessionTemplate.selectOne(nameSpace + "selectScCodeNum");
		logger.debug("selectScCodeNum 메서드 result is {}",result);
		logger.debug("selectScCodeNum 메서드 끝");
		return result;
	}
	
	// 보호소에 사후 진료 전체 신청리스트 Dao
		public List<BusinessLicenseClinic> selectShelterClinicRequestList() {
			logger.debug("selectShelterClinicRequestList() 메서드 호출");
			List<BusinessLicenseClinic> list = sqlSessionTemplate.selectList(nameSpace + "selectShelterClinicRequestList");
			logger.debug("selectShelterClinicRequestList() 메서드 list is {}",list);
			logger.debug("selectShelterClinicRequestList() 메서드 끝");
			return list;
		}
}