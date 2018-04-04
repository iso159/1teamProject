package com.cafe24.iso159.adopt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
					// 원본 파일명의 마지막 . 위치 앞의 원본 파일명을 변수에 입력
					String originalFileName = ofOriginName.substring(0, pos);
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
					adoptRequestFile.setOfOriginName(originalFileName);
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
		public void ModifyOsCodeAdoptRequest(String adoptRequestCode) {
			logger.debug("ModifyOsCodeAdoptRequest() 메소드 호출");
			adoptDao.updateOsCodeAdoptRequest(adoptRequestCode);
		}
		
	// 입양상태코드 검색
		public List<AdoptCommand> CategoryAdopt(String OsCategory){
			logger.debug("CategoryAdopt() 메소드 호출 OsCategory is {}",OsCategory);
			Map map = new HashMap();
			map.put("OsCategory", OsCategory);
			List<AdoptCommand> list = adoptDao.selectAdoptCategory(map);
			logger.debug("CategoryAdopt()메서드 list is {}", list);
			return list;
		}
		
	// 상담내용확인
		public void ModifyOsCodeAdoptCounsel(String adoptRequestCode) {
			logger.debug("ModifyOsCodeAdoptCounsel() 메소드 호출");
			adoptDao.updateOsCodeAdoptCounsel(adoptRequestCode);
			
		}
		
	// 입양결정 완료
		public void ModifyOsCodeAdoptDecide(String adoptRequestCode, String animalCode) {
			logger.debug("ModifyOsCodeAdoptDecide() 메소드 호출");
			// 입양결정 상태코드
			adoptDao.updateOsCodeAdoptDecide(adoptRequestCode);
			// 입양동물 상태코드 
			adoptDao.updateOsCodeAnimal(animalCode);
		}
		
	// 입양취소
		public void removeAdopt(String adoptRequestCode, String animalCode) {
			logger.debug("removeAdopt() 메소드 호출");
			// 1. 파일삭제
			adoptDao.deleteAdoptFile(adoptRequestCode);
			// 2. 동물상태 : 체험동물
			adoptDao.updateOsCodeAnimal312(animalCode);
			// 3. 입양취소 
			adoptDao.deleteAdopt(adoptRequestCode);
		}
		
	// 입양신청리스트
		public List<AdoptRequestAndOsCodeAnimal> listAdoptRequest(){
			logger.debug("List<AdoptRequest> listAdoptRequest() 메소드 호출");
			List<AdoptRequestAndOsCodeAnimal> list = adoptDao.selectAdoptRequest();
			return list;
		}
	// 입양신청 개인 리스트
		public List<AdoptRequestAndOsCodeAnimal> listAdoptRequestMember(String mMemberId){
			logger.debug("listAdoptRequestMember() 메소드 호출 mMemberId is {}", mMemberId);
			List<AdoptRequestAndOsCodeAnimal> list = adoptDao.selectAdoptRequestByMemberId(mMemberId);
			logger.debug("listAdoptRequestMember() 메소드 호출 list is {}", list);
			return list;
		}
		
	// 입양신청파일 조회
		public List<AdoptRequestFile> listAdoptFileList(String adoptRequestCode){
			logger.debug("listAdoptFileList() 메소드 호출 adoptRequestCode is {}", adoptRequestCode);
			List<AdoptRequestFile> list = adoptDao.selectAdoptFileList(adoptRequestCode);
			return list;
		}
		
	// 입양파일 다운로드
		public ModelAndView downloadFile(HttpServletRequest request, String path, String ofSaveName, String ofExt, String ofOriginName) {
			logger.debug("downloadFile() 메소드 호출");
			logger.debug("downloadFile() 메서드 실행 paht is {}", path);
			logger.debug("downloadFile() 메서드 실행 fileName is {}", ofSaveName);
			logger.debug("downloadFile() 메서드 실행 fileName is {}", ofOriginName);
			
			// 경로 + 다운받을 파일이름을 file에 입력
			File file = new File(path+ofSaveName);
			logger.debug("downloadFile() 메서드 실행 file is {}", file);
			// 입력한 파일을 읽을수 없다면 if블록실행
			if(!file.canRead()) {
				logger.debug("{} 파일을 찾지 못했습니다.",file);
				return new ModelAndView("fileDownloadView", "file",file);
			}
			// 확장자 request에 셋팅
			request.setAttribute("fileExt", ofExt);
			// 저장 파일명 request에 셋팅
			request.setAttribute("fileName", ofSaveName);
			// 원본 파일명을 request에 매핑
			request.setAttribute("ofOriginName", ofOriginName);
			// 확장자명을 더해서 파일 셋팅
			File reFile = new File(path+ofSaveName+"."+ofExt);
			logger.debug("downloadFile() 메서드 실행 reFile is {}", reFile);

			try {
				// 파일이 있다면 if블록실행
				if(file.exists()) {
					// 확장자명을 더한 파일명으로 수정
					file.renameTo(reFile);
					// 확장자명을 더한 파일을 request에 셋팅
					request.setAttribute("reFile", reFile);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return new ModelAndView("fileDownloadView", "file",reFile);
			
		}
		
	// 상담내용입력
		public void ModifyAdoptRequestAdviceContents(AdoptRequest adoptRequest) {
			logger.debug("ModifyAdoptRequestAdviceContents() 메소드 호출");
			logger.debug("ModifyAdoptRequestAdviceContents() adoptRequest is {}", adoptRequest);
			adoptDao.updateAdoptRequestAdvice(adoptRequest);
		}
		
	// 상담내용조회
		public AdoptRequest listAdoptCounsel(String adoptRequestCode) {
			logger.debug("listAdoptCounsel() 메소드 호출");
			logger.debug("listAdoptCounsel() adoptRequestCode is {}", adoptRequestCode);
	
			AdoptRequest adoptRequest = new AdoptRequest();
			AdoptRequest contents = adoptDao.selectAdoptCounselList(adoptRequestCode);
			adoptRequest.setAdoptRequestAdviceContents(contents.getAdoptRequestAdviceContents());
			logger.debug("listAdoptCounsel() adoptRequest is {}", adoptRequest);
			
			return adoptRequest;
		
		}
		
}
