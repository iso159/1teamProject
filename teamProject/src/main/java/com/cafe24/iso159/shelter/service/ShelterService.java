package com.cafe24.iso159.shelter.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.iso159.member.service.Member;
import com.cafe24.iso159.member.service.MemberDao;
import com.cafe24.iso159.member.service.MemberInfo;

@Service
@Transactional
public class ShelterService {
	@Autowired
	ShelterDao shelterDao;
	@Autowired
	MemberDao memberDao;
	private static final Logger logger = LoggerFactory.getLogger(ShelterService.class);
	String osCodeLicenseStatus = null;
	
	// 직원 신청 상태코드를 요청거부로 수정쿼리문을 접근하는 updateShelterStaffRequestOsCodeBySsrCode DAO 메서드 호출
	public void modifyShelterStaffRequestOsCodeDenyBySsrCode(String ssrCode) {
		logger.debug("modifyShelterStaffRequestOsCodeDenyBySsrCode(String ssrCode) 메서드 호출");
		logger.debug("modifyShelterStaffRequestOsCodeDenyBySsrCode(String ssrCode) 메서드 ssrCode is {}", ssrCode);
		final String osCodeStaffRequest = "os_shelter_23_1_4";
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ssrCode", ssrCode);
		map.put("osCodeStaffRequest", osCodeStaffRequest);
		logger.debug("modifyShelterStaffRequestOsCodeDenyBySsrCode(String ssrCode) 메서드 map is {}", map);
		shelterDao.updateShelterStaffRequestOsCodeBySsrCode(map);
		logger.debug("modifyShelterStaffRequestOsCodeDenyBySsrCode(String ssrCode) 메서드 끝");
	}
	
	// 직원 신청 상태코드를 결정완료로 수정(updateShelterStaffRequestOsCodeBySsrCode) 및 회원 권한 수정(updateMemberRight) DAO 메서드 호출
	public void modifyShelterStaffRequestOsCodeAllowBySsrCode(String ssrCode,String mId) {
		logger.debug("modifyShelterStaffRequestOsCodeAllowBySsrCode(String ssrCode,String mId) 메서드 호출");
		logger.debug("modifyShelterStaffRequestOsCodeAllowBySsrCode(String ssrCode,String mId) 메서드 ssrCode is {}", ssrCode);
		logger.debug("modifyShelterStaffRequestOsCodeAllowBySsrCode(String ssrCode,String mId) 메서드 mId is {}", mId);
		final String osCodeStaffRequest = "os_shelter_23_1_3";
		final String memberRight = "mr_2_1";
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ssrCode", ssrCode);
		map.put("osCodeStaffRequest", osCodeStaffRequest);
		// 결정완료 수정 확인후 동적쿼리로 날짜 업데이트를 위한 매핑
		map.put("allowStaffRequest","success");
		map.put("mRightCode", memberRight);
		map.put("mId", mId);
		logger.debug("modifyShelterStaffRequestOsCodeAllowBySsrCode(String ssrCode,String mId) 메서드 map is {}", map);
		shelterDao.updateShelterStaffRequestOsCodeBySsrCode(map);
		memberDao.updateMemberRight(map);	
		logger.debug("modifyShelterStaffRequestOsCodeAllowBySsrCode(String ssrCode,String mId) 메서드 끝");
	}
	
	
	
	// 직원신청 상태코드가 수정되는 쿼리문을 접근하는 updateShelterStaffRequestOsCodeBySsrCode DAO 메서드 호출
	public MemberInfo modifyShelterStaffRequestOsCodeBySsrCode(String ssrCode,String mId, String osCodeStaffRequest) {
		logger.debug("modifyShelterStaffRequestOsCodeBySsrCode(...) 메서드 호출");
		logger.debug("modifyShelterStaffRequestOsCodeBySsrCode(...) 메서드 ssrCode is {}",ssrCode);
		logger.debug("modifyShelterStaffRequestOsCodeBySsrCode(...) 메서드 mId is {}",mId);
		logger.debug("modifyShelterStaffRequestOsCodeBySsrCode(...) 메서드 osCodeStaffRequest is {}",osCodeStaffRequest);
		Map<String,Object> map = new HashMap<String, Object>();
		if(osCodeStaffRequest.equals("요청중")) {
			osCodeStaffRequest = "os_shelter_23_1_2";
			map.put("ssrCode", ssrCode);
			map.put("osCodeStaffRequest", osCodeStaffRequest);
			shelterDao.updateShelterStaffRequestOsCodeBySsrCode(map);
		}
		String memberInfoCode = memberDao.selectMemberOneId(mId);
		MemberInfo memberInfo = memberDao.selectMemberOne(memberInfoCode);
		logger.debug("modifyShelterStaffRequestOsCodeBySsrCode(...) 메서드 끝");
		return memberInfo;
	}
	
	// 직원 신청 리스트를 회원 아이디로 조회하는 쿼리문을 접근하는 selectShelterStaffRequestAndShelterNameByMId DAO 메서드 호출
	public List<ShelterStaffRequestAndShelterName> getShelterStaffRequestAndShelterNameByMId(String mId){
		logger.debug("getShelterStaffRequestAndShelterNameByMId(String mId) 메서드 호출");
		logger.debug("getShelterStaffRequestAndShelterNameByMId(String mId) 메서드 mId is {}", mId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("mId", mId);
		List<ShelterStaffRequestAndShelterName> list = shelterDao.selectShelterStaffRequestAndShelterNameByMId(map);
		logger.debug("getShelterStaffRequestAndShelterNameByMId(String mId) 메서드 list is {}", list);
		logger.debug("getShelterStaffRequestAndShelterNameByMId(String mId) 메서드 끝");
		return list;
	}
	
	// 직원 신청 리스트를 보호소 코드로 조회하는 쿼리문을 접근하는 selectShelterStaffRequestByBlCode DAO 메서드 호출
	public List<ShelterStaffRequestAndShelterName> getselectShelterStaffRequestAndShelterNameByBlCode(String blCode){
		logger.debug("getselectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 호출");
		logger.debug("getselectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 blCode is {}", blCode);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("blCode", blCode);
		List<ShelterStaffRequestAndShelterName> list = shelterDao.selectShelterStaffRequestAndShelterNameByBlCode(map);
		logger.debug("getselectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 list is {}", list);
		logger.debug("getselectShelterStaffRequestAndShelterNameByBlCode(String blCode) 메서드 끝");
		return list;
	}
	
	// 보호소 직원 신청 등록 쿼리문을 접근하는 insertShelterStaffRequest DAO 메서드 호출
	public void addShelterStaffRequest(String blCode,String loginId) {
		logger.debug("addShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 호출");
		logger.debug("addShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 loginId is {}", loginId);
		logger.debug("addShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 blCode is {}", blCode);
		String ssrCode = "ssr_code_";
		String ssrCodeNum = shelterDao.selectSsrCodeNum();
		int ssrCodePlus = 1;
		final String osCodeStaffRequest = "os_shelter_23_1_1";
		if(ssrCodeNum == null) {
			ssrCode += 1;
		}else {
			ssrCodePlus += Integer.parseInt(ssrCodeNum);
			ssrCode += ssrCodePlus;
		}
		ShelterStaffRequest shelterStaffRequest = new ShelterStaffRequest();
		shelterStaffRequest.setBlCode(blCode);
		shelterStaffRequest.setSsrCode(ssrCode);
		shelterStaffRequest.setmId(loginId);
		shelterStaffRequest.setOsCodeStaffRequest(osCodeStaffRequest);
		logger.debug("addShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 shelterStaffRequest is {}", shelterStaffRequest);
		shelterDao.insertShelterStaffRequest(shelterStaffRequest);
		logger.debug("addShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) 메서드 끝");
	}
	
	// 등록된 보호소 리스트를 조회하는 쿼리문을 접근하는 selectShelterList DAO 메서드 호출
	public List<BusinessLicense> getShelterList(){
		logger.debug("getShelterList() 메서드 호출");
		osCodeLicenseStatus = "os_business_1_1_3";
		List<BusinessLicense> list = shelterDao.selectShelterList(osCodeLicenseStatus);
		logger.debug("getShelterList() 메서드 list is {}", list);
		logger.debug("getShelterList() 메서드 끝");
		return list;
	}
	
	
	// 체험자권한을 보호소 대표로 변경 및 보호소 대표 신청 상태 코드를 결정 완료로 수정하는 쿼리문을 접근하는 DAO 메서드 호출
	public void modifyShelterRight(String blCode, String mMemberId) {
		logger.debug("modifyShelterRight(String blCode, String mMemberId) 메서드 호출");
		logger.debug("modifyShelterRight(String blCode, String mMemberId) 메서드 blCode is {}",blCode);
		logger.debug("modifyShelterRight(String blCode, String mMemberId) 메서드 mMemberId is {}",mMemberId);
		// 보호소 대표 코드 상수로 입력
		final String mRightCode = "mr_2_2";
		// 보호소 대표 신청 코드 결정 완료로 입력
		final String OsCodeLicenseStatus = "os_business_1_1_3";
		Map<String,Object> rightMap = new HashMap<String, Object>();
		// 권한 관련 변수 매핑
		rightMap.put("mMemberId", mMemberId);
		rightMap.put("mRightCode", mRightCode);
		logger.debug("modifyShelterRight(String blCode, String mMemberId) 메서드 rightMap is {}",rightMap);
		Map<String,Object> osCodeMap = new HashMap<String,Object>();
		// 상태코드 관련 변수 매핑
		osCodeMap.put("blCode", blCode);
		osCodeMap.put("OsCodeLicenseStatus", OsCodeLicenseStatus);
		logger.debug("modifyShelterRight(String blCode, String mMemberId) 메서드 osCodeMap is {}",osCodeMap);
		shelterDao.updateShelterRight(rightMap);
		shelterDao.updateBusinessLicenseOsCodeLicenseStatus(osCodeMap);
		logger.debug("modifyShelterRight(String blCode, String mMemberId) 메서드 끝");		
	}
	
	// 보호소 대표 신청 업로드 파일 다운로드
	public ModelAndView businessLicenseFileDownload(String path, String fileName
													, HttpServletRequest request, String fileExt, String ofOriginName) {
		logger.debug("businessLicenseFileDownload(...) 메서드 호출");
		logger.debug("businessLicenseFileDownload(...) 메서드 path is {}", path);
		logger.debug("businessLicenseFileDownload(...) 메서드 fileName is {}", fileName);
		logger.debug("businessLicenseFileDownload(...) 메서드 fileExt is {}", fileExt);
		shelterDao.businessLicense();
		// 경로 + 다운받을 파일이름을 file에 입력
		File file = new File(path+fileName);
		logger.debug("businessLicenseFileDownload(...) 메서드 file is {}", file);
		// 파일을 읽을수 없으면 if 블록 실행
		if(!file.canRead()) {
			logger.debug("파일이 존재하지 않습니다.");
			return new ModelAndView("fileDownloadView","file",file);
		}
		request.setAttribute("fileExt", fileExt);
		// 파일명을 request에 매핑
		request.setAttribute("fileName", fileName);
		// 원본 파일명을 request에 매핑
		request.setAttribute("ofOriginName", ofOriginName);
		// 경로 + 파일명 + 확장자명을 refile에 세팅
		File reFile = new File(path + fileName + "." + fileExt);
		logger.debug("businessLicenseFileDownload(...) 메서드 reFile is {}", reFile);
		// 파일이 존재한다면 if 블록 실행
		if(file.exists()) {
			// 확장자명을 더한 파일로 수정
			file.renameTo(reFile);
			// request에 확장자명을 더한 파일인 reFile 매핑
			request.setAttribute("reFile", reFile);
		}
		logger.debug("businessLicenseFileDownload(...) 메서드 끝");
		return new ModelAndView("fileDownloadView","file",reFile);
	}
	
	// 보호소 대표 신청 상태 거절로 수정 및 거절 사유 등록(수정)하는 쿼리문을 접근하는 DAO 메서드 호출 
	public void modifyBusinessLicenseDeny(String blCode,String blShelterDenyReason) {
		logger.debug("modifyBusinessLicenseDeny(String blCode) 메서드 호출");
		logger.debug("modifyBusinessLicenseDeny(String blCode) 메서드 blCode is {}",blCode);
		final String osCodeLicenseStatus = "os_business_1_1_4";
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("osCodeLicenseStatus", osCodeLicenseStatus);
		map.put("blCode", blCode);
		map.put("blShelterDenyReason", blShelterDenyReason);
		logger.debug("modifyBusinessLicenseDeny(String blCode) 메서드 map is {}",map);
		shelterDao.updateBusinessLicenseDeny(map);
		logger.debug("modifyBusinessLicenseDeny(String blCode) 메서드 끝");
	}
	
	// 보호소 대표 신청 파일리스트 조회 및 상태코드를 수정하는 쿼리문을 접근하는 DAO 메서드 호출
	public MemberIdAndBusinessLicenseFile getBusinessLicenseFileList(String blCode){
		logger.debug("getBusinessLicenseFileList(String blCode) 메서드 호출");
		logger.debug("getBusinessLicenseFileList(String blCode) 메서드 blCode is {}", blCode);
		Map<String,Object> map = new HashMap<String,Object>();
		final String OsCodeLicenseStatus = "os_business_1_1_2";
		// map에 blCode,OsCodeLicenseStatus를 매핑 한다.
		map.put("blCode", blCode);
		map.put("OsCodeLicenseStatus", OsCodeLicenseStatus);
		// map 세팅값 확인
		logger.debug("getBusinessLicenseFileList(String blCode) 메서드 map is {}",map);
		// 보호소 대표 신청 상태 코드를 수정하는 쿼리문을 접근하는 DAO 호출
		shelterDao.updateBusinessLicenseOsCodeLicenseStatus(map);
		// 보호소 대표 신청 파일 리스트를 조회하는 쿼리문을 접근하는 DAO 호출
		MemberIdAndBusinessLicenseFile memberIdAndBusinessLicenseFile = shelterDao.selectBusinessLicenseFileList(blCode);
		logger.debug("getBusinessLicenseFileList(String blCode) 메서드 list is {}", memberIdAndBusinessLicenseFile);
		logger.debug("getBusinessLicenseFileList(String blCode) 메서드 끝");
		return memberIdAndBusinessLicenseFile;
	}
	
	// mMemberId와 같은 보호소 대표 신청 조회 쿼리문을 접근하는 DAO 메서드 호출
	public List<BusinessLicense> getBusinessLicenseOne(String mMemberId){
		logger.debug("getBusinessLicenseOne(String mMemberId) 메서드 호출");
		logger.debug("getBusinessLicenseOne(String mMemberId) 메서드 mMemberId is {}", mMemberId);
		List<BusinessLicense> list = shelterDao.selectBusinessLicense(mMemberId);
		logger.debug("getBusinessLicenseOne(String mMemberId) 메서드 list is {}", list);
		logger.debug("getBusinessLicenseOne(String mMemberId) 메서드 끝");
		return list;
	}
	
	// 보호소 신청 전체 쿼리문을 접근하는 DAO 메서드 호출
	public List<BusinessLicense> getBusinessLicense(){
		logger.debug("getBusinessLicense() 메서드 호출");
		String mMemberId = null;
		List<BusinessLicense> list = shelterDao.selectBusinessLicense(mMemberId);
		logger.debug("getBusinessLicense() 메서드 list is {}", list);
		logger.debug("getBusinessLicense() 메서드 끝");
		return list;
	}
	
	// MVC 규칙을 위한 businessLicense 메서드
	public void businessLicense() {
		logger.debug("businessLicense() 메서드 호출");
		shelterDao.businessLicense();
		logger.debug("businessLicense() 메서드 끝");
	}
	
	// 보호소 대표 신청 메서드 호출
	public void addBusinessLicense(BusinessLicenseCommand businessLicenseCommand, String path, MultipartFile file) {
		logger.debug("addBusinessLicense(...) 메서드 호출");
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
				String fullFileName = multipartFile.getOriginalFilename();
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
				long size = multipartFile.getSize();
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
		
		logger.debug("addBusinessLicense(...) 메서드 끝");
	}
}
