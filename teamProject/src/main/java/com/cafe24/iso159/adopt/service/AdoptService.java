package com.cafe24.iso159.adopt.service;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdoptService {
	private static final Logger logger = LoggerFactory.getLogger(AdoptService.class);
	@Autowired
	private AdoptDao adoptDao;
	
	// 입양신청 
		public void addAdopt(AdoptRequest adoptRequest) {
			logger.debug("addAdopt() 메소드 호출 adoptRequestReason is {}", adoptRequest);
			int lastCode = adoptDao.selectLastCode();
			//logger.debug("lastCode is {}", lastCode);
			
			// 마지막 adopt_request_code 코드
			String tempCode = "adopt_request_code_";
			String adoptRequestCode = "adopt_request_code_1";
			
			lastCode += 1;
			adoptRequestCode = tempCode + lastCode;
			logger.debug("adoptRequestCode is {}", adoptRequestCode);
			adoptRequest.setAdoptRequestCode(adoptRequestCode);
			logger.debug("adoptRequest is {}", adoptRequest);
			
			
			adoptDao.insertAdopt(adoptRequest);
		}
	// 입양신청확인
		public void ModifyOsCodeAdopt(String adoptRequestCode, String osCodeAdopt) {
			logger.debug("updateOsCodeAdopt() 메소드 호출");
			adoptDao.updateOsCodeAdopt(adoptRequestCode, osCodeAdopt);
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
}
