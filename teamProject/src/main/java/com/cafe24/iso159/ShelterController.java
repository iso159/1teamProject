package com.cafe24.iso159;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cafe24.iso159.shelter.service.BusinessLicense;
import com.cafe24.iso159.shelter.service.ShelterService;

@Controller
public class ShelterController {
	@Autowired
	private ShelterService shelterService;
	private static final Logger logger = LoggerFactory.getLogger(ShelterController.class);
	
	@RequestMapping(value="/shelter", method=RequestMethod.GET)
	public String BusinessLicense() {
		logger.debug("BusinessLicense() 메서드");
		return "/shelter/shelterMenu";
	}
	
	@RequestMapping(value="/shelter/businessLicenseRequest", method=RequestMethod.GET)
	public String addBusinessLicense() {
		logger.debug("addBusinessLicense() 메서드");
		return "/shelter/businessLicenseRequest";
	}
	
	@RequestMapping(value="/shelter/businessLicenseRequest", method=RequestMethod.POST)
	public String addBusinessLicense(BusinessLicense businessLicense, HttpSession session) {
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		logger.debug("addBusinessLicense(BusinessLicense businessLicense) 메서드 businessLicense is {}",businessLicense);
		String loginId = (String)session.getAttribute("loginId");
		businessLicense.setmMemberId(loginId);
		shelterService.addBusinessLicense(businessLicense);		
		return "redirect:shelter/shelterMenu";
	}
}
