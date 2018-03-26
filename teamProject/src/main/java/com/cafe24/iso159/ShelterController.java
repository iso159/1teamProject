package com.cafe24.iso159;

import java.util.List;

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
import com.cafe24.iso159.shelter.service.MemberIdAndBusinessLicenseFile;
import com.cafe24.iso159.shelter.service.ShelterService;

@Controller
public class ShelterController {
	@Autowired
	private ShelterService shelterService;
	private static final Logger logger = LoggerFactory.getLogger(ShelterController.class);
	
	@RequestMapping(value="/shelter/BusinessLicenseDeny", method=RequestMethod.POST)
	public String denyBusinessLicense(@RequestParam(value="blCode") String blCode
									, @RequestParam(value="blShelterDenyReason") String blShelterDenyReason) {
		logger.debug("denyBusinessLicense(...) 메서드 호출");
		logger.debug("denyBusinessLicense(...) 메서드 blCode is {}",blCode);
		logger.debug("denyBusinessLicense(...) 메서드 blShelterDenyReason is {}",blShelterDenyReason);
		shelterService.modifyBusinessLicenseDeny(blCode, blShelterDenyReason);
		logger.debug("denyBusinessLicense(...) 메서드 끝");
		return "redirect:/businessLicenseList";
	}
	
	@RequestMapping(value="/shelter/BusinessLicenseDeny")
	public String denyBusinessLicense(@RequestParam(value="blCode") String blCode
									, HttpSession session) {
		logger.debug("denyBusinessLicense() 메서드 호출");
		shelterService.businessLicense();
		session.setAttribute("blCode", blCode);
		logger.debug("denyBusinessLicense() 메서드 끝");
		return "/shelter/businessLicenseDeny";
	}
	
	@RequestMapping(value="/shelter/fileList")
	public String getBusinessLicenseFileList(@RequestParam(value="blCode") String blCode,
											HttpSession session) {
		logger.debug("getBusinessLicenseFileList(...) 메서드 호출");
		logger.debug("getBusinessLicenseFileList(...) 메서드 blCode is {}", blCode);
		MemberIdAndBusinessLicenseFile memberIdAndBusinessLicenseFile = shelterService.getBusinessLicenseFileList(blCode);
		logger.debug("getBusinessLicenseFileList(...) 메서드 memberIdAndBusinessLicenseFile is {}", memberIdAndBusinessLicenseFile);
		session.setAttribute("memberIdAndBusinessLicenseFile", memberIdAndBusinessLicenseFile);		
		logger.debug("getBusinessLicenseFileList(...) 메서드 끝");
		return "/shelter/businessLicenseFileList";
	}
	
	@RequestMapping(value="/businessLicenseList")
	public String getBusinessLicense(HttpSession session) {
		logger.debug("getBusinessLicense() 메서드 호출");
		List<BusinessLicense> list = shelterService.getBusinessLicense();
		session.setAttribute("list", list);
		logger.debug("getBusinessLicense() 메서드 끝");
		return "/shelter/businessLicenseList";
	}
	
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
		return "redirect:/businessLicenseList";
	}
}
