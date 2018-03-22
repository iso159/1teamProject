package com.cafe24.iso159.shelter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShelterService {
	@Autowired
	ShelterDao shelterDao;
	private static final Logger logger = LoggerFactory.getLogger(ShelterService.class);
	
	// 보호소 대표 신청 메서드 호출
	public void addBusinessLicense(BusinessLicense businessLicense) {
		logger.debug("addBusinessLicense 메서드 businessLicense is {}", businessLicense);
		// 초기상태를 신청중으로 고정되게 상수화시킴
		final String osCodeLicenseStatus = "os_business_1_1_1";
		// 기본키를 잘라 가장큰 숫자를 가져와 중복되지 않는 기본키 값을 만듬
		String blCode = "bl_code_";
		// 기본키를 잘라 가장큰 숫자를 가져오는 Dao 메서드 호출
		String blCodeNum = shelterDao.selectBlCodeNum();
		int blCodeNumPlus = 1;
		if(blCodeNum==null) {
			// 기본키가 하나도 없을 경우 1로 시작
			blCode += blCodeNumPlus;
		}else {
			// 기본키가 있다면 기본키의 최대값을 구해 1을 더해줌
			blCodeNumPlus = Integer.parseInt(blCodeNum)+1;
			blCode += blCodeNumPlus;
		}
		// 초기 상태 세팅
		businessLicense.setOsCodeLicenseStatus(osCodeLicenseStatus);
		// 기본키 셋팅
		businessLicense.setBlCode(blCode);
		// 마지막으로 모든 필드를 setting한 객체 디버그로 확인
		logger.debug("addBusinessLicense 메서드 businessLicense 세팅값 is {}",businessLicense);
		// insert 쿼리문 호출
		shelterDao.insertBusinessLicense(businessLicense);
		logger.debug("addBusinessLicense 메서드 끝");
	}
}
