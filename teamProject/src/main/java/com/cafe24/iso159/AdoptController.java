package com.cafe24.iso159;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.iso159.adopt.service.Adopt;
import com.cafe24.iso159.adopt.service.AdoptCommand;
import com.cafe24.iso159.adopt.service.AdoptRequest;
import com.cafe24.iso159.adopt.service.AdoptRequestAndOsCodeAnimal;
import com.cafe24.iso159.adopt.service.AdoptRequestFile;
import com.cafe24.iso159.adopt.service.AdoptService;
import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.animal.service.AnimalCommand;
import com.cafe24.iso159.survey.service.SurveyList;
import com.cafe24.iso159.survey.service.SurveyService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AdoptController {
	private static final Logger logger = LoggerFactory.getLogger(AdoptController.class);
	
	@Autowired
	private AdoptService adoptService;
	@Autowired
	private SurveyService surveyService;
	
	
	// 입양신청 페이지요청
	@RequestMapping(value="/adopt/adoptRequest", method = RequestMethod.GET)
	public String addAdopt(	HttpSession session, Model model, 
							@RequestParam(value="animalCode") String animalCode,
							@RequestParam(value="blCode") String blCode,
							@RequestParam(value="mShelterId") String mShelterId) {
		logger.debug("addAdopt(HttpSession session) 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		logger.debug("addAdopt() 메서드 호출 animalCode is {}",animalCode);
		logger.debug("addAdopt() 메서드 호출 blCode is {}",blCode);
		logger.debug("addAdopt() 메서드 호출 mShelterId is {}",mShelterId);
		String mMemberId = (String) session.getAttribute("loginId");
		model.addAttribute("mMemberId",mMemberId);
		model.addAttribute("animalCode",animalCode);
		model.addAttribute("blCode",blCode);
		model.addAttribute("mShelterId",mShelterId);
		logger.debug("addAdopt() 메서드 호출 mMemberId is {}", mMemberId);
		return "/adopt/adoptRequest";
	}
		
	// 입양신청 페이지 
	@RequestMapping(value="/adopt/adoptRequest", method = RequestMethod.POST)
	public String addAdopt(HttpSession session, AdoptCommand adoptCommand, Model model,
							@RequestParam(value="file") MultipartFile ckfile) {
		logger.debug("addAdopt() 메서드 호출 adoptCommand is {}", adoptCommand);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		//세션에 저장된 Id값을 adoptCommand에 담음
		String mMemberId = (String) session.getAttribute("loginId");
		adoptCommand.setmMemberId(mMemberId);
		model.addAttribute("mMemberId",mMemberId);
		// resource 폴더경로
		String path = session.getServletContext().getRealPath("/");
		path += "resources/adoptUpload/";
		logger.debug("addAdopt() 메서드 path is {}",path);
		
		adoptService.addAdopt(adoptCommand, path, ckfile);
		return "redirect:/adopt/adoptMyList";	//입양신청 완료 후 나의입양리스트화면으로
		
	}
	
	// 입양신청메뉴, 입양가능한 동물리스트화면 요청
	@RequestMapping(value="/adopt/adoptAnimalList",method = RequestMethod.GET)
	public String listAdoptAnimalList(Model model) {
		logger.debug("listAdoptAnimalList() 메서드 호출");
		List<Animal> list = adoptService.listAdoptAnimal();
		logger.debug("listAdoptAnimalList() 메서드 호출 list is {}",list);
		model.addAttribute("animal", list);
		return "/adopt/adoptAnimalList";
	}
	
	
	// 나의 입양신청 리스트 화면 요청 
	@RequestMapping(value="/adopt/adoptMyList", method = RequestMethod.GET)
	public String listAdoptMyList(HttpSession session, Model model) {
		logger.debug("listAdoptMyList() 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		String mMemberId = (String) session.getAttribute("loginId");
		List<AdoptRequestAndOsCodeAnimal> list = adoptService.listAdoptRequestMember(mMemberId);
		logger.debug("listAdoptMyList메서드 list is {}",list);
		model.addAttribute("list", list);
		
		return "/adopt/adoptMyList";
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
	
	// 파일다운로드 요청
	@RequestMapping(value="/adopt/adoptFileDownload", method = RequestMethod.GET)
	public ModelAndView downloadAdoptFile(	HttpSession session, HttpServletRequest request, 
											HttpServletResponse response,								
											@RequestParam(value="ofSaveName") String ofSaveName, 
											@RequestParam(value="ofOriginName") String ofOriginName,
											@RequestParam(value="ofExt") String ofExt) {
		logger.debug("downloadAdoptFile() 메서드 호출");
		logger.debug("ofSaveName :{}",ofSaveName);
		logger.debug("ofOriginName :{}",ofOriginName);
		logger.debug("ofExt :{}",ofExt);
		// resource 폴더경로
		String path = session.getServletContext().getRealPath("/");
		path += "resources/adoptUpload/";
		return adoptService.downloadFile(request,path,ofSaveName,ofExt,ofOriginName);
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
		String surveyCode = "survey_code_1";
		List<SurveyList> list = surveyService.listSurveyListBySurveyCode(surveyCode);
		logger.debug("list is {}", list);
		model.addAttribute("list", list);
		model.addAttribute("adoptRequestCode",adoptRequestCode);
		return "/adopt/adoptCounsel";
	}
	
	// 상담완료 후 입양리스트로
	@RequestMapping(value="/adopt/adoptCounsel", method = RequestMethod.POST)
	public String ModifyAdoptRequestAdviceContents(HttpSession session, AdoptRequest adoptRequest,
							@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("selectList() 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		// 상담내용입력
		adoptService.ModifyAdoptRequestAdviceContents(adoptRequest);
		// 입양신청확인 상태코드 -> 상담완료
		adoptService.ModifyOsCodeAdoptCounsel(adoptRequest.getAdoptRequestCode());
		logger.debug("ModifyAdoptRequestAdviceContents() 메서드 호출 adoptRequest is {}",adoptRequest);
		return "redirect:/adopt/adoptList";
	}
	// 상담내용 조회
	@RequestMapping(value="/adopt/adoptCounselList", method = RequestMethod.GET)
	public String selectAdoptCounselList(HttpSession session,Model model,
					@RequestParam(value="adoptRequestCode") String adoptRequestCode,
					@RequestParam(value="animalCode") String animalCode) {
		logger.debug("selectAdoptCounselList() 메서드 호출");
		logger.debug("selectAdoptCounselList() 메서드 호출 animalCode is {}", animalCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		// 상담내용조회
		AdoptRequest adoptRequest = adoptService.listAdoptCounsel(adoptRequestCode);
		// 입양코드와 동물코드를 담는다
		adoptRequest.setAdoptRequestCode(adoptRequestCode);
		adoptRequest.setAnimalCode(animalCode);
		logger.debug("selectAdoptCounselList() adoptRequest is {}", adoptRequest);
		model.addAttribute("adoptRequest", adoptRequest); 
		return "/adopt/adoptCountselList";
	}
	
	// 입양결정
	@RequestMapping(value="/adopt/adoptDecide", method = RequestMethod.GET)
	public String ModifyAdoptDecide(HttpSession session, 
										@RequestParam(value="adoptRequestCode") String adoptRequestCode,
										@RequestParam(value="animalCode") String animalCode) {
		logger.debug("ModifyAdoptDecide() 메서드 호출");
		logger.debug("ModifyAdoptDecide() 메서드 호출 adoptRequestCode is {}", adoptRequestCode);
		logger.debug("ModifyAdoptDecide() 메서드 호출 animalCode is {}", animalCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		// 상담진행중 -> 입양완료로 상태코드 업데이트
		// 체험동물 -> 입양동물로 상태코드 업데이트
		adoptService.ModifyOsCodeAdoptDecide(adoptRequestCode, animalCode);
		
		return "redirect:/adopt/adoptList";
	}
	
	// 입양취소
	@RequestMapping(value="/adopt/adoptCancle", method = RequestMethod.GET)
	public String removeAdopt(HttpSession session,
				@RequestParam(value="adoptRequestCode") String adoptRequestCode,
				@RequestParam(value="animalCode") String animalCode) {
		logger.debug("removeAdopt() 메소드 호출");
		logger.debug("removeAdopt() 메소드 호출 adoptRequestCode is {}", adoptRequestCode);
		logger.debug("removeAdopt() 메소드 호출 animalCode is {}", animalCode);
		adoptService.removeAdopt(adoptRequestCode, animalCode);
		return "redirect:/adopt/adoptList";
	}
	
	//입양신청 상태코드 조건검색
	@RequestMapping(value="/adopt/adoptlCategory", method=RequestMethod.POST)
	public String adoptCategory(Model model
								,@RequestParam(value="OsCategory",required=false) String OsCategory) {
		logger.debug("adoptCategory()메서드 OsCategory is {}", OsCategory);
		List<AdoptCommand> list = adoptService.CategoryAdopt(OsCategory);
		logger.debug("옵션선택 list is {}", list);
		model.addAttribute("list", list);
		return "/adopt/adoptList";
	}
	
	// 입양리스트
	@RequestMapping(value="/adopt/adoptList", method = RequestMethod.GET)
	public String selectAdoptRequestList(HttpSession session, Model model) {
		logger.debug("selectAdoptRequestList(HttpSession httpSession) 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		List<AdoptRequestAndOsCodeAnimal> list = adoptService.listAdoptRequest();
		logger.debug("selectAdoptRequestList(HttpSession httpSession) 메서드 list count is {}",list.size());
		model.addAttribute("list", list);
		return "/adopt/adoptList";
	}
	// 입양자 등록 페이지 요청
	@RequestMapping(value="/adopt/adoptAdd", method = RequestMethod.GET)
	public String insertAdopt(	HttpSession session, Model model,
								@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("insertAdopt() get 메서드 호출 adoptRequestCode is {}",adoptRequestCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		String mAdminId = (String) session.getAttribute("loginId");
		Adopt adopt = adoptService.selectAdoptRequestByAdoptRequestCode(adoptRequestCode);
		adopt.setmAdminId(mAdminId);
		adopt.setAdoptRequestCode(adoptRequestCode);
		logger.debug("insertAdopt() get 메서드 호출 adopt is {}",adopt);
		model.addAttribute("adopt", adopt);
		return "/adopt/adoptAdd";
	}
	
	@RequestMapping(value="/adopt/adoptAdd", method = RequestMethod.POST)
	public String insertAdopt(	HttpSession session, Model model, Adopt adopt) {
		logger.debug("insertAdopt() POST 메서드 호출");
		
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		// 받은 값들을 adopt에 셋팅
		adoptService.addAdopter(adopt);
		
		return "redirect:/adopt/adoptList";
	}
	
	// 입양자리스트 페이지 요청
	@RequestMapping(value="/adopt/adopterList", method = RequestMethod.GET)
	public String selectAdopterList(HttpSession session, Model model, Adopt adopt) {
		logger.debug("selectAdopterList(HttpSession httpSession) 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		List<Adopt> list = adoptService.selectAdopt();
		logger.debug("list is {}",list);
		model.addAttribute("list", list);
		return "/adopt/adopterList";
	}
	
}
