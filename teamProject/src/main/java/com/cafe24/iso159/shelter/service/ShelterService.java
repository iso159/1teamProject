package com.cafe24.iso159.shelter.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ShelterService {
	@Autowired
	ShelterDao shelterDao;
	private static final Logger logger = LoggerFactory.getLogger(ShelterService.class);
	
	// MVC 규칙을 위한 businessLicense 메서드
	public void businessLicense() {
		logger.debug("businessLicense() 메서드 호출");
		shelterDao.businessLicense();
		logger.debug("businessLicense() 메서드 끝");
	}
	
	// 보호소 대표 신청 메서드 호출
	public void addBusinessLicense(BusinessLicenseCommand businessLicenseCommand, String path, MultipartFile file) {
		logger.debug("addBusinessLicense(...) 메서드 businessLicenseCommand is {}", businessLicenseCommand);
		logger.debug("addBusinessLicense(...) 메서드 path is {}", path);
		
		BusinessLicense businessLicense = new BusinessLicense();
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
			blCodeNumPlus += Integer.parseInt(blCodeNum);
			blCode += blCodeNumPlus;
		}
		
		// businessLicenseCommand 값을 businessLicense에 세팅
		String mMemberId = businessLicenseCommand.getmMemberId();
		String blShelterName = businessLicenseCommand.getBlShelterName();
		String blShelterNumber = businessLicenseCommand.getBlShelterNumber();
		String blShelterPostcode = businessLicenseCommand.getBlShelterPostcode();
		String blShelterAddress = businessLicenseCommand.getBlShelterAddress();
		
		businessLicense.setmMemberId(mMemberId);
		businessLicense.setBlShelterName(blShelterName);
		businessLicense.setBlShelterNumber(blShelterNumber);
		businessLicense.setBlShelterPostcode(blShelterPostcode);
		businessLicense.setBlShelterAddress(blShelterAddress);
		// 초기 상태 세팅
		businessLicense.setOsCodeLicenseStatus(osCodeLicenseStatus);
		// 기본키 셋팅
		businessLicense.setBlCode(blCode);
		// 마지막으로 모든 필드를 setting한 객체 디버그로 확인
		logger.debug("addBusinessLicense(...) 메서드 businessLicense 세팅값 is {}",businessLicense);
		// insert 쿼리문 호출
		shelterDao.insertBusinessLicense(businessLicense);
		
		if(!file.isEmpty()) {
			for(MultipartFile multipartFile : businessLicenseCommand.getMultipartFile()) {
				// 랜덤으로 uuid 생성
				UUID uuid = UUID.randomUUID();
				// 저장파일명을 toString 메서드로 문자열형태로 입력
				String storeFileName = uuid.toString();
				// 확장자까지 포함된 원본 파일명
				String fullFileName = file.getOriginalFilename();
				logger.debug("addBusinessLicense(...) 메서드 fullFileName is {}",fullFileName);
				// 마지막 .의 위치 값을 입력
				int pos = fullFileName.indexOf(".");
				logger.debug("addBusinessLicense(...) 메서드 pos is {}",pos);
				// 원본 파일명의 마지막 . 위치 앞의 원본 파일명을 변수에 입력
				String originalFileName = fullFileName.substring(0, pos);
				logger.debug("addBusinessLicense(...) 메서드 originalFileName is {}",originalFileName);
				// 원본 파일명의 마지막 . 위치 뒤의 확장자를 ext 변수에 입력
				String ext = fullFileName.substring(pos+1);
				logger.debug("addBusinessLicense(...) 메서드 ext is {}",ext);
				// file 사이즈를 저장
				long size = file.getSize();
				logger.debug("addBusinessLicense(...) 메서드 size is {}",size);
				
				String ofCode = "of_code_";
				String ofCodeNum = shelterDao.selectOfCodeNum();
				int ofCodeNumPlus = 1;
				
				if(ofCodeNum == null) {
					ofCode += ofCodeNumPlus;
				}else {
					ofCodeNumPlus += Integer.parseInt(ofCodeNum);
					ofCode += ofCodeNumPlus;
				}
				// 파일 정보를 businessLicenseFile에 세팅해준후 insert 쿼리문을 호출하는 메서드 실행
				BusinessLicenseFile businessLicenseFile = new BusinessLicenseFile();
				businessLicenseFile.setOfCode(ofCode);
				businessLicenseFile.setBlCode(blCode);
				businessLicenseFile.setOfPath(path);
				businessLicenseFile.setOfOriginName(originalFileName);
				businessLicenseFile.setOfSaveName(storeFileName);
				businessLicenseFile.setOfExt(ext);
				businessLicenseFile.setOfSize(size);
				
				shelterDao.insertBusinessLicenseFile(businessLicenseFile);
				
				// 하드디스크에 파일 저장 경로 설정
				File temp = new File(path);
				if(!temp.exists()) {
					// 디렉토리가 없을경우 디렉토리 생성
					temp.mkdirs();
					logger.debug("addBusinessLicense(...) 메서드 디렉토리 생성 성공");
				}
				
				File temp2 = new File(path+storeFileName);
				logger.debug("addBusinessLicense(...) 메서드 temp2 is {}",temp2);
				
				try {
					// 원본 파일을 빈 파일에 복사
					multipartFile.transferTo(temp2);
				} catch (IllegalStateException e) {
					// IllegalStateException 예외 발생시 처리
					e.printStackTrace();
					if(temp.delete()) {
						logger.debug("addBusinessLicense(...) 메서드 {} 파일 삭제 성공",temp);
					}else {
						logger.debug("addBusinessLicense(...) 메서드 {} 파일 삭제 실패",temp);
					}
				} catch (IOException e) {
					// IOException 예외 발생시 처리
					e.printStackTrace();
					if(temp.delete()) {
						logger.debug("addBusinessLicense(...) 메서드 {} 파일 삭제 성공",temp);
					}else {
						logger.debug("addBusinessLicense(...) 메서드 {} 파일 삭제 실패",temp);
					}
				}
				
			}
		}else {
			logger.debug("파일이 비어있습니다.");
		}
		
		logger.debug("addBusinessLicense 메서드 끝");
	}
}
