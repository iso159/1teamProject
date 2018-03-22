package com.cafe24.iso159;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.iso159.shelter.service.BusinessLicense;
import com.cafe24.iso159.shelter.service.BusinessLicenseCommand;
import com.cafe24.iso159.shelter.service.ShelterService;

@Controller
public class ShelterController {
	@Autowired
	private ShelterService shelterService;
	private static final Logger logger = LoggerFactory.getLogger(ShelterController.class);
	
	@RequestMapping(value="/shelter", method=RequestMethod.GET)
	public String BusinessLicense() {
		logger.debug("BusinessLicense() 메서드 호출");
		shelterService.businessLicense();
		logger.debug("BusinessLicense() 메서드 끝");
		return "/shelter/shelterMenu";
	}
	
	@RequestMapping(value="/shelter/businessLicenseRequest", method=RequestMethod.GET)
	public String addBusinessLicense() {
		logger.debug("addBusinessLicense() 메서드 호출");
		shelterService.businessLicense();
		logger.debug("addBusinessLicense() 메서드 끝");
		return "/shelter/businessLicenseRequest";
	}
	
	@RequestMapping(value="/shelter/businessLicenseRequest", method=RequestMethod.POST)
	public String addBusinessLicense(BusinessLicenseCommand businessLicenseCommand, HttpSession session
									, @RequestParam(value="multipartFile") MultipartFile file) {
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		logger.debug("addBusinessLicense(...) 메서드 businessLicense is {}",businessLicenseCommand);
		logger.debug("addBusinessLicense(...) 메서드 multipartFile is {}",file);
		String loginId = (String)session.getAttribute("loginId");
		businessLicenseCommand.setmMemberId(loginId);
		String path = session.getServletContext().getRealPath("/");
		path += "resources/shelterUpload/";
		logger.debug("addBusinessLicense(...) 메서드 path is {}",path);
		shelterService.addBusinessLicense(businessLicenseCommand, path, file);
		return "redirect:shelter/shelterMenu";
	}
}
