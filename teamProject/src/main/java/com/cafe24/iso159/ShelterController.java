package com.cafe24.iso159;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.iso159.member.service.MemberInfo;
import com.cafe24.iso159.shelter.service.BusinessLicense;
import com.cafe24.iso159.shelter.service.BusinessLicenseClinic;
import com.cafe24.iso159.shelter.service.BusinessLicenseCommand;
import com.cafe24.iso159.shelter.service.MemberIdAndBusinessLicenseFile;
import com.cafe24.iso159.shelter.service.ShelterService;
import com.cafe24.iso159.shelter.service.ShelterStaffRequestAndShelterName;

@Controller
public class ShelterController {
	@Autowired
	private ShelterService shelterService;
	private static final Logger logger = LoggerFactory.getLogger(ShelterController.class);
	
	// 직원 신청 회원의 상태를 수정해 shelterRequestList.jsp로 리다이렉트 해주는 서블릿
	@RequestMapping(value="/shelter/shelterStaffDeny")
	public String denyShelterStaff(HttpSession session
								 , @RequestParam(value="ssrCode") String ssrCode) {
		logger.debug("denyShelterStaff(...) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		String rightLevel = (String)session.getAttribute("rightLevel");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("보호소")){
			return "redirect:/";
		}else if(!rightLevel.equals("2")) {
			return "redirect:/";
		}
		logger.debug("denyShelterStaff(...) 메서드 ssrCode is {}", ssrCode);
		shelterService.modifyShelterStaffRequestOsCodeDenyBySsrCode(ssrCode);
		logger.debug("denyShelterStaff(...) 메서드 끝");
		return "redirect:/shelter/requestShelterStaffList";
	}
	
	// 직원 신청 회원의 상태와 권한을 수정해 shelterRequestList.jsp로 리다이렉트 해주는 서블릿
	@RequestMapping(value="/shelter/shelterStaffAllow")
	public String allowShelterStaff(HttpSession session
									, @RequestParam(value="mId") String mId
									, @RequestParam(value="ssrCode") String ssrCode) {
		logger.debug("allowShelterStaff(...) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		String rightLevel = (String)session.getAttribute("rightLevel");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("보호소")){
			return "redirect:/";
		}else if(!rightLevel.equals("2")) {
			return "redirect:/";
		}
		logger.debug("allowShelterStaff(...) 메서드 mId is {}", mId);
		logger.debug("allowShelterStaff(...) 메서드 ssrCode is {}", ssrCode);
		shelterService.modifyShelterStaffRequestOsCodeAllowBySsrCode(ssrCode, mId);
		logger.debug("allowShelterStaff(...) 메서드 끝");
		return "redirect:/shelter/requestShelterStaffList";
	}
	
	// 직원 신청 회원의 상세정보와 아이디를 model에 담아 shelterStaffRequestInfo.jsp로 포워딩해주는 서블릿
	@RequestMapping(value="/shelter/requestShelterStaffInfo")
	public String shelterStaffRequestInfo(HttpSession session, Model model
										, @RequestParam(value="ssrCode") String ssrCode
										, @RequestParam(value="mId") String mId
										, @RequestParam(value="osCodeStaffRequest") String osCodeStaffRequest) {
		logger.debug("shelterStaffRequestInfo(...) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		String rightLevel = (String)session.getAttribute("rightLevel");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("보호소")){
			return "redirect:/";
		}else if(!rightLevel.equals("2")) {
			return "redirect:/";
		}
		logger.debug("shelterStaffRequestInfo(...) 메서드 ssrCode is {}", ssrCode);
		logger.debug("shelterStaffRequestInfo(...) 메서드 mId is {}", mId);
		logger.debug("shelterStaffRequestInfo(...) 메서드 osCodeStaffRequest is {}", osCodeStaffRequest);
		MemberInfo memberInfo = shelterService.modifyShelterStaffRequestOsCodeBySsrCode(ssrCode, mId, osCodeStaffRequest);
		logger.debug("shelterStaffRequestInfo(...) 메서드 memberInfo is {}", memberInfo);
		model.addAttribute("memberInfo",memberInfo);
		model.addAttribute("mId", mId);
		logger.debug("shelterStaffRequestInfo(...) 메서드 끝");
		return "shelter/shelterStaffRequestInfo";
	}
	
	// 직원 신청 개인 조회 리스트를 model에 담아 personalShelterRequestList.jsp로 포워딩해주는 서블릿
	@RequestMapping(value="/shelter/requestShelterStaffPersonal")
	public String personalRequestShelterStaff(Model model, HttpSession session) {
		logger.debug("personalRequestShelterStaff(...) 메서드 호출");
		String mId = (String)session.getAttribute("loginId");
		logger.debug("personalRequestShelterStaff(...) 메서드 mId is {}", mId);
		if(mId==null) {
			return "redirect:/member/login";
		}
		List<ShelterStaffRequestAndShelterName> list = shelterService.getShelterStaffRequestAndShelterNameByMId(mId);
		model.addAttribute("list", list);
		logger.debug("personalRequestShelterStaff(...) 메서드 끝");
		return "shelter/personalShelterRequestList";
	}
	
	// 직원 등록 신청 보호소 대표별 리스트를 model에 담아 businessLicenseRequestList.jsp로 포워딩해주는 서블릿
	@RequestMapping(value="/shelter/requestShelterStaffList")
	public String shelterStaffRequestList(Model model, HttpSession session) {
		logger.debug("shelterStaffRequestList(...) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		String rightLevel = (String)session.getAttribute("rightLevel");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("보호소")){
			return "redirect:/";
		}else if(!rightLevel.equals("2")) {
			return "redirect:/";
		}
		String blCode = (String)session.getAttribute("loginBlCode");
		List<ShelterStaffRequestAndShelterName> list = shelterService.getselectShelterStaffRequestAndShelterNameByBlCode(blCode);
		model.addAttribute("list",list);
		logger.debug("shelterStaffRequestList(...) 메서드 끝");
		return "shelter/shelterRequestList";
	}
	
	// 직원 등록 신청 요청을 받아 처리후 requestShelterStaffList.jsp로 리다이렉트해주는 서블릿
	@RequestMapping(value="/shelter/requestShelterStaff")
	public String shelterStaffRequest(HttpSession session
									 , @RequestParam(value="blCode") String blCode) {
		logger.debug("shelterStaffRequest(...) 메서드 호출");
		logger.debug("shelterStaffRequest(...) 메서드 blCode is {}", blCode);
		String loginId = (String)session.getAttribute("loginId");
		logger.debug("shelterStaffRequest(...) 메서드 loginId is {}", loginId);
		if(loginId==null) {
			return "redirect:/member/login";
		}		
		shelterService.addShelterStaffRequest(blCode, loginId);
		logger.debug("shelterStaffRequest(...) 메서드 끝");
		return "redirect:/shelter/requestShelterStaffPersonal";
	}
	
	// 등록 결정된 보호소 리스트를 model에 담아 staffBusinessLicenseList.jsp로 이동되는 서블릿
	@RequestMapping(value="/shelter/staffBusinessLicenseGet")
	public String getStaffBusinessLicense(HttpSession session, Model model){
		logger.debug("getStaffBusinessLicense() 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		if(loginId==null) {
			return "redirect:/member/login";
		}
		List<BusinessLicense> list = shelterService.getShelterList();
		model.addAttribute("list", list);
		logger.debug("getStaffBusinessLicense() 메서드 끝");
		return "shelter/staffBusinessLicenseList";
	}	
	
	@RequestMapping(value="/shelter/businessLicenseSet")
	public String setBusinessLicense(HttpSession session
									, @RequestParam(value="blCode") String blCode
									, @RequestParam(value="mMemberId") String mMemberId) {
		logger.debug("setBusinessLicense(...) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("관리자")){
			return "redirect:/";
		}
		logger.debug("setBusinessLicense(...) 메서드 blCode is {}", blCode);
		logger.debug("setBusinessLicense(...) 메서드 mMemberId is {}", mMemberId);
		shelterService.modifyShelterRight(blCode, mMemberId);
		logger.debug("setBusinessLicense(...) 메서드 끝");
		return "redirect:/businessLicenseRequestList";
	}
	
	@RequestMapping(value="/shelter/businessLicenseFileDownload", method=RequestMethod.GET)
	public ModelAndView downloadBusinessLicense(HttpServletRequest request, HttpServletResponse response
												, HttpSession session
												, @RequestParam(value="fileName") String fileName
												, @RequestParam(value="fileExt") String fileExt
												, @RequestParam(value="ofOriginName") String ofOriginName) {
		logger.debug("downloadBusinessLicense(...) 메서드 호출");
		logger.debug("downloadBusinessLicense(...) 메서드 fileName is {}", fileName);
		logger.debug("downloadBusinessLicense(...) 메서드 fileExt is {}", fileExt);
		logger.debug("downloadBusinessLicense(...) 메서드 fileExt is {}", ofOriginName);
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/shelterUpload/";
		logger.debug("downloadBusinessLicense(...) 메서드 realPath is {}", realPath);
		logger.debug("downloadBusinessLicense(...) 메서드 끝");
		return shelterService.businessLicenseFileDownload(realPath, fileName, request, fileExt, ofOriginName);
	}
	
	@RequestMapping(value="/shelter/businessLicenseDeny", method=RequestMethod.POST)
	public String denyBusinessLicense(HttpSession session
									, @RequestParam(value="blCode") String blCode
									, @RequestParam(value="blShelterDenyReason") String blShelterDenyReason) {
		logger.debug("denyBusinessLicense(...) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("관리자")){
			return "redirect:/";
		}
		logger.debug("denyBusinessLicense(...) 메서드 blCode is {}",blCode);
		logger.debug("denyBusinessLicense(...) 메서드 blShelterDenyReason is {}",blShelterDenyReason);
		shelterService.modifyBusinessLicenseDeny(blCode, blShelterDenyReason);
		logger.debug("denyBusinessLicense(...) 메서드 끝");
		return "redirect:/businessLicenseRequestList";
	}
	
	@RequestMapping(value="/shelter/businessLicenseDeny")
	public String denyBusinessLicense(HttpSession session, Model model
									, @RequestParam(value="blCode") String blCode) {
		logger.debug("denyBusinessLicense() 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("관리자")){
			return "redirect:/";
		}
		shelterService.businessLicense();
		model.addAttribute("blCode", blCode);
		logger.debug("denyBusinessLicense() 메서드 끝");
		return "shelter/businessLicenseDeny";
	}
	
	// 보호소 대표 등록시 업로드한 파일리스트를 담아 businessLicenseFileList.jsp로 이동되는 서블릿 
	@RequestMapping(value="/shelter/fileList")
	public String getBusinessLicenseFileList(HttpSession session, Model model
											, @RequestParam(value="blCode") String blCode) {
		logger.debug("getBusinessLicenseFileList(...) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("관리자")){
			return "redirect:/";
		}
		logger.debug("getBusinessLicenseFileList(...) 메서드 blCode is {}", blCode);
		MemberIdAndBusinessLicenseFile memberIdAndBusinessLicenseFile = shelterService.getBusinessLicenseFileList(blCode);
		logger.debug("getBusinessLicenseFileList(...) 메서드 memberIdAndBusinessLicenseFile is {}", memberIdAndBusinessLicenseFile);
		model.addAttribute("memberIdAndBusinessLicenseFile", memberIdAndBusinessLicenseFile);		
		logger.debug("getBusinessLicenseFileList(...) 메서드 끝");
		return "shelter/businessLicenseFileList";
	}
	
	// 보호소 대표 등록 신청을한 개인 조회 리스트를 담아 personalBusinessLicenseList.jsp로 이동되는 서블릿
	@RequestMapping(value="/businessLicenseListPersonal")
	public String getPersonalBusinessLicense(Model model, HttpSession session) {
		logger.debug("getPersonalBusinessLicense() 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		if(loginId==null) {
			return "redirect:/member/login";
		}
		String mMemberId = (String)session.getAttribute("loginId");
		logger.debug("getPersonalBusinessLicense() 메서드 mMemberId is {}", mMemberId);
		List<BusinessLicense> list = shelterService.getBusinessLicenseOne(mMemberId);
		logger.debug("getPersonalBusinessLicense() 메서드 list is {}", list);
		model.addAttribute("list", list);		
		logger.debug("getPersonalBusinessLicense() 메서드 끝");
		return "shelter/personalBusinessLicenseList";
	}
	
	// 보호소 대표 등록 신청을한 리스트를 담아 businessLicenseRequestList.jsp로 이동되는 서블릿
	@RequestMapping(value="/businessLicenseRequestList")
	public String getBusinessLicense(Model model, HttpSession session) {
		logger.debug("getBusinessLicense() 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		String rightName = (String)session.getAttribute("rightName");
		if(loginId==null) {
			return "redirect:/member/login";
		}else if(!rightName.equals("관리자")){
			return "redirect:/";
		}
		List<BusinessLicense> list = shelterService.getBusinessLicense();
		model.addAttribute("list", list);
		logger.debug("getBusinessLicense() 메서드 끝");
		return "shelter/businessLicenseRequestList";
	}
	
	// 보호소 메뉴로 이동되는 서블릿
	@RequestMapping(value="/shelter", method=RequestMethod.GET)
	public String BusinessLicense() {
		logger.debug("BusinessLicense() 메서드 호출");
		shelterService.businessLicense();
		logger.debug("BusinessLicense() 메서드 끝");
		return "shelter/shelterMenu";
	}
	
	// 보호소 대표 신청 등록폼으로 이동되는 서블릿
	@RequestMapping(value="/shelter/businessLicenseRequest", method=RequestMethod.GET)
	public String addBusinessLicense(HttpSession session) {
		logger.debug("addBusinessLicense() 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		logger.debug("addBusinessLicense() 메서드 loginId is {}", loginId);
		if(loginId==null) {
			return "redirect:/member/login";
		}
		shelterService.businessLicense();
		logger.debug("addBusinessLicense() 메서드 끝");
		return "shelter/businessLicenseRequest";
	}
	
	// 보호소 대표 신청 등록 폼 데이터 입력후 매핑된 서블릿
	@RequestMapping(value="/shelter/businessLicenseRequest", method=RequestMethod.POST)
	public String addBusinessLicense(BusinessLicenseCommand businessLicenseCommand, HttpSession session
									, @RequestParam(value="multipartFile") MultipartFile file) {
		String loginId = (String)session.getAttribute("loginId");
		if(loginId==null) {
			return "redirect:/member/login";
		}
		logger.debug("addBusinessLicense(...) 메서드 businessLicense is {}",businessLicenseCommand);
		logger.debug("addBusinessLicense(...) 메서드 multipartFile is {}",file);
		businessLicenseCommand.setmMemberId(loginId);
		String path = session.getServletContext().getRealPath("/");
		path += "resources/shelterUpload/";
		logger.debug("addBusinessLicense(...) 메서드 path is {}",path);
		shelterService.addBusinessLicense(businessLicenseCommand, path, file);
		return "redirect:/businessLicenseRequestList";
	}
	
	// 사후진료 신청 폼으로 매핑하는 컨트롤러
	@RequestMapping(value="/shelter/shelterClinicRequest", method=RequestMethod.GET)
	public String addClinicRequest(BusinessLicenseClinic businessLicenseClinic, HttpSession session) {
		logger.debug("addClinicRequest(BusinessLicenseClinic businessLicenseClinic) 메서드 호출");
		String loginId = (String)session.getAttribute("loginId");
		logger.debug("addClinicRequest(BusinessLicenseClinic businessLicenseClinic 메서드 loginId is {}", loginId);
		if(loginId==null) {
			return "redirect:/member/login";
		}
		shelterService.addClinicRequest(loginId, loginId);
		logger.debug("addClinicRequest(BusinessLicenseClinic businessLicenseClinic) 메서드 끝");
		return "shelter/shelterClinicRequest";
	}
	
	// 전체 리스트 요청
	@RequestMapping(value = "/shelter/shelterClinicRequestList")
	public String shelterClinicRequestList(HttpSession session) {
		logger.debug("shelterClinicRequestList() 메서드 호출");
		List<BusinessLicenseClinic> list = shelterService.getShelterClinicRequestList();
		session.setAttribute("list", list);
		logger.debug("shelterClinicRequestList() 메서드 list is {}", list);
		logger.debug("shelterClinicRequestList() 메서드 끝");
		return "/shelter/shelterClinicRequestList";
	}
}