package com.cafe24.iso159;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.iso159.adopt.service.AdoptCommand;
import com.cafe24.iso159.adopt.service.AdoptRequest;
import com.cafe24.iso159.adopt.service.AdoptRequestFile;
import com.cafe24.iso159.adopt.service.AdoptService;
import com.cafe24.iso159.survey.service.SurveyList;
import com.cafe24.iso159.survey.service.SurveyService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AdoptController {
	private static final Logger logger = LoggerFactory.getLogger(AdoptController.class);
	
	@Autowired
	private AdoptService adoptService;
	private AdoptCommand adoptCommand;
	private AdoptRequest adoptRequest;
	private SurveyList surveyList;
	@Autowired
	private SurveyService surveyService;
	
	// 입양메뉴
	@RequestMapping(value="/adopt", method = RequestMethod.GET)
	public String addAdopt() {
		logger.debug("addAdopt() 메서드 호출");
		return "/adopt/adoptMenu";
	}
	
	// 입양신청 페이지요청
	@RequestMapping(value="/adopt/adoptRequest", method = RequestMethod.GET)
	public String addAdopt(HttpSession session) {
		logger.debug("addAdopt(HttpSession session) 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		return "/adopt/adoptRequest";
	}
		
	// 입양신청 페이지 
	@RequestMapping(value="/adopt/adoptRequest", method = RequestMethod.POST)
	public String addAdopt(HttpSession session, AdoptCommand adoptCommand,
							@RequestParam(value="file") MultipartFile ckfile) {
		logger.debug("addAdopt() 메서드 호출 adoptCommand is {}", adoptCommand);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		// resource 폴더경로
		String path = session.getServletContext().getRealPath("/");
		path += "resources/adoptUpload/";
				
		logger.debug("addAdopt() 메서드 path is {}",path);
		//logger.debug("fileName :{}",adoptCommand);
		//logger.debug("filesize :{}",adoptCommand.getFile().size());
		
		adoptService.addAdopt(adoptCommand, path, ckfile);
		return "redirect:/adopt/adoptList";	//입양신청 완료 후 입양리스트로
		
	}
	
	// 파일확인페이지 요청
	@RequestMapping(value="/adopt/adoptFileCheck", method = RequestMethod.GET)
	public String UpdateOsCodeAdopt(HttpSession session,Model model,
				@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("UpdateOsCodeAdopt() 메서드 호출");
		logger.debug("adoptRequestCode is {}", adoptRequestCode);
		//파일확인클릭시 상태코드 변경
		adoptService.ModifyOsCodeAdoptRequest(adoptRequestCode);
		//파일리스트조회
		List<AdoptRequestFile> list = adoptService.listAdoptFileList(adoptRequestCode);
		logger.debug("list is {}", list);
		model.addAttribute("list", list);
		return "/adopt/adoptFileList";
	}

	// 상담입력페이지 요청
	@RequestMapping(value="/adopt/adoptCounsel", method = RequestMethod.GET)
	public String addAdoptCounsel(HttpSession session, Model model,
			@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("addAdoptCounsel() 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		
		List<SurveyList> list = surveyService.listSurveyListCounsel();
		logger.debug("list is {}", list);
		model.addAttribute("list", list);
		model.addAttribute("adoptRequestCode",adoptRequestCode);
		return "/adopt/adoptCounsel";
	}
	
	// 상담완료 후 리스트로
	@RequestMapping(value="/adopt/adoptCounsel", method = RequestMethod.POST)
	public String ModifyAdoptRequestAdviceContents(HttpSession session, AdoptRequest adoptRequest,
							@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("selectList() 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		adoptService.ModifyAdoptRequestAdviceContents(adoptRequest);
		adoptService.ModifyOsCodeAdoptCounsel(adoptRequest.getAdoptRequestCode());
		logger.debug("ModifyAdoptRequestAdviceContents() 메서드 호출 adoptRequest is {}",adoptRequest);
		return "redirect:/adopt/adoptList";
	}
	// 상담내용 리스트
	@RequestMapping(value="/adopt/adoptCounselList", method = RequestMethod.GET)
	public String selectAdoptCounselList(HttpSession session,Model model,
					@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("selectAdoptCounselList() 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		
		AdoptRequest adoptRequest = adoptService.listAdoptCounsel(adoptRequestCode);
		adoptRequest.setAdoptRequestCode(adoptRequestCode);
		logger.debug("selectAdoptCounselList() adoptRequest is {}", adoptRequest);
		model.addAttribute("adoptRequest", adoptRequest); 
		return "/adopt/adoptCountselList";
	}
	
	// 입양결정
	@RequestMapping(value="/adopt/adoptDecide", method = RequestMethod.GET)
	public String ModifyAdoptDecide(HttpSession session, 
										@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("ModifyAdoptDecide() 메서드 호출");
		logger.debug("ModifyAdoptDecide() 메서드 호출 adoptRequestCode is {}", adoptRequestCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		adoptService.ModifyOsCodeAdoptDecide(adoptRequestCode);
		return "redirect:/adopt/adoptList";
	}
	
	// 입양취소
	@RequestMapping(value="/adopt/adoptCancle", method = RequestMethod.GET)
	public String removeAdopt(HttpSession session,
				@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("removeAdopt() 메소드 호출");
		adoptService.removeAdopt(adoptRequestCode);
		return "redirect:/adopt/adoptList";
	}
	
	// 입양리스트
	@RequestMapping(value="/adopt/adoptList", method = RequestMethod.GET)
	public String selectAdoptRequestList(HttpSession session, Model model) {
		logger.debug("selectAdoptRequestList(HttpSession httpSession) 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		List<AdoptRequest> list = adoptService.listAdoptRequest();
		model.addAttribute("list", list);
		return "/adopt/adoptList";
	}
	
}
