package com.cafe24.iso159.adopt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class AdoptService {
	private static final Logger logger = LoggerFactory.getLogger(AdoptService.class);
	@Autowired
	private AdoptDao adoptDao;
	
	// 입양신청 (입양신청파일)
		public void addAdopt(AdoptCommand adoptCommand, String path, MultipartFile ckfile) {
			logger.debug("addAdopt() 메소드 호출 adoptCommand is {}", adoptCommand);
			// 마지막코드 숫자값을 저장
			String lastArCode = adoptDao.selectLastCodeAr();
			logger.debug("lastCodeAr is {}", lastArCode);
			
			// 마지막 adopt_request_code 코드
			String ArCode = "adopt_request_code_";
			String adoptRequestCode = "adopt_request_code_1";
			int adoptRequestCodeNum = 1;
			
			if(lastArCode == null) {
				ArCode += adoptRequestCodeNum;
			}else {
				adoptRequestCodeNum += Integer.parseInt(lastArCode);
				ArCode += adoptRequestCodeNum;
			}
			logger.debug("ArCode is {}", ArCode);
			
			
			// command로 받은 값을 AdoptRequest에 담는다
			AdoptRequest adoptRequest = new AdoptRequest();
			adoptRequest.setAdoptRequestCode(ArCode);
			adoptRequest.setAnimalCode(adoptCommand.getAnimalCode());
			adoptRequest.setBlCode(adoptCommand.getBlCode());
			adoptRequest.setmMemberId(adoptCommand.getmMemberId());
			adoptRequest.setmShelterId(adoptCommand.getmShelterId());
			adoptRequest.setOsCodeAdopt(adoptCommand.getOsCodeAdopt());
			adoptRequest.setAdoptRequestReason(adoptCommand.getAdoptRequestReason());
			adoptRequest.setAdoptRequestDate(adoptCommand.getAdoptRequestDate());
			adoptRequest.setAdoptPoint(adoptCommand.getAdoptPoint());
			logger.debug("adoptRequest is {}", adoptRequest);
			adoptDao.insertAdopt(adoptRequest);
			
			if(!ckfile.isEmpty()) {
				for(MultipartFile file : adoptCommand.getFile()) {
					// 1. db에 입력
					UUID uuid = UUID.randomUUID();
					// 파일이름
					String ofSaveName = uuid.toString();	// 중복되지않은 이름
					// 원본파일이름
					String ofOriginName = file.getOriginalFilename();
					// 파일확장자
					int pos = ofOriginName.lastIndexOf(".");
					String ofExt = ofOriginName.substring(pos+1);
					// 파일크기
					long ofSize = file.getSize();
					
					// 마지막 of_code 코드
					String lastOfCode = adoptDao.selectLastCodeOf();
					logger.debug("lastCodeOf is {}", lastOfCode);
					String ofCode = "of_code_";
					String overallFileCode = "of_code_1";
					int ofCodeNum = 1;
					
					if(lastOfCode == null) {
						ofCode += ofCodeNum;
					}else {
						ofCodeNum += Integer.parseInt(lastOfCode);
						ofCode += ofCodeNum;
					}
					logger.debug("ofCode is {}", ofCode);
					
					// 값 셋팅후 메소드 실행
					AdoptRequestFile adoptRequestFile = new AdoptRequestFile();
					adoptRequestFile.setOfCode(ofCode);
					adoptRequestFile.setAdoptRequestCode(ArCode);
					adoptRequestFile.setOfPath(path);
					adoptRequestFile.setOfOriginName(ofOriginName);
					adoptRequestFile.setOfSaveName(ofSaveName);
					adoptRequestFile.setOfExt(ofExt);
					adoptRequestFile.setOfSize(ofSize);
					adoptDao.insertAdoptFile(adoptRequestFile);
					
					// 2. 하드디스크에 파일저장
					File temp = new File(path);
					if(!temp.exists()) {
						// 디렉토리가 없을경우 디렉토리 생성
						temp.mkdirs();
						logger.debug("addAdopt() 메서드 디렉토리 생성 성공");
					}
					File temp2 = new File(path+ofSaveName);
					logger.debug("addAdopt() 메서드 temp2 is {}",temp2);
					
					try {
						file.transferTo(temp2);
					} catch (IllegalStateException e) {
						e.printStackTrace();
							// temp 파일 삭제 및 콘솔창으로 확인
							if(temp.delete()) {
								logger.debug("addAdopt() 메서드 {} 파일 삭제 성공",temp);
							}else {
								logger.debug("addAdopt() 메서드 {} 파일 삭제 성공",temp);
							}
					} catch (IOException e) {
						e.printStackTrace();
							// temp 파일 삭제 및 콘솔창으로 확인
						if(temp.delete()) {
							logger.debug("addAdopt() 메서드 {} 파일 삭제 성공",temp);
						}else {
							logger.debug("addAdopt() 메서드 {} 파일 삭제 실패",temp);
						}
					}
				}
			}else {
				logger.debug("파일이 비어있습니다.");
			}
			
			logger.debug("addAdopt() 메서드 끝");
		}//메소드끝

		
		
	// 입양신청확인
		public void ModifyOsCodeAdopt(String adoptRequestCode) {
			logger.debug("updateOsCodeAdopt() 메소드 호출");
			adoptDao.updateOsCodeAdopt(adoptRequestCode);
		}
		
	// 입양취소
		public void removeAdopt(String adoptRequestCode) {
			logger.debug("removeAdopt() 메소드 호출");
			adoptDao.deleteAdopt(adoptRequestCode);
		}
		
	// 입양신청리스트
		public List<AdoptRequest> listAdoptRequest(){
			logger.debug("AdoptRequest<List> listAdoptRequest() 메소드 호출");
			List<AdoptRequest> list = adoptDao.selectAdoptRequest();
			return list;
		}
		
	// 상담내용입력
		public void ModifyAdoptRequestAdviceContents(AdoptRequest adoptRequest) {
			logger.debug("ModifyAdoptRequestAdviceContents() 메소드 호출");
			logger.debug("ModifyAdoptRequestAdviceContents() adoptRequest is {}", adoptRequest);
			adoptDao.updateAdoptRequestAdvice(adoptRequest);
		}
}
