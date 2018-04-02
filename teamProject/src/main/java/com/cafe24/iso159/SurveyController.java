package com.cafe24.iso159;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.iso159.survey.service.Survey;
import com.cafe24.iso159.survey.service.SurveyList;
import com.cafe24.iso159.survey.service.SurveyService;

@Controller
public class SurveyController {
	private static final Logger logger = LoggerFactory.getLogger(SurveyController.class);
	@Autowired
	private SurveyService surveyService;
	
	// 설문지 질문 리스트 화면 요청
	@RequestMapping(value="/survey/surveyQuestionAdd", method = RequestMethod.GET)
	public String selectSurveyList(	HttpSession session,  Model model,
									@RequestParam(value="surveyCode") String surveyCode) {
		logger.debug("selectSurveyList() 메서드 호출 surveyCode is {}", surveyCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		// 설문지질문 조회
		List<SurveyList> list = surveyService.listSurveyListBySurveyCode(surveyCode);
		logger.debug("selectSurveyList() 메서드 호출 list is {}", list);
		model.addAttribute("surveyCode", surveyCode);
		model.addAttribute("list", list);
		
		return "/survey/surveyQuestionAdd";
	}
	
	// 설문지 질문 등록
	@RequestMapping(value="/survey/surveyQuestionAdd", method = RequestMethod.POST)
	public String addSurveyQuestion(HttpSession session,SurveyList surveyList, Model model,
									@RequestParam(value="surveyCode") String surveyCode) {
		logger.debug("addSurveyQuestion() 메서드 호출 surveyCode is {}", surveyCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		String mAdminId = (String) session.getAttribute("loginId");
		// 설문지코드 입력
		surveyList.setmAdminId(mAdminId);
		surveyList.setSurveyCode(surveyCode);
		surveyService.addSurveyList(surveyList);
		model.addAttribute("surveyCode",surveyCode);
		return "redirect:/survey/surveyQuestionAdd";
	}
	
	// 설문지 질문 조회
	@RequestMapping(value="/survey/surveyQuestionList", method = RequestMethod.GET)
	public String selectSurveyQuestionList(	HttpSession session, Model model) {
		logger.debug("selectSurveyQuestionList() GET 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		List<SurveyList> list = surveyService.listSurveyList();
		model.addAttribute("list", list);
		return "/survey/surveyQuestionList";
	}
	
	
	// 설문지등록화면 요청
	@RequestMapping(value="/survey/surveyAdd", method = RequestMethod.GET)
	public String addSurvey(HttpSession session, Model model) {
		logger.debug("addSurvey() GET 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		// 설문지조회
		List<Survey> list = surveyService.listSurvey();
		model.addAttribute("list", list);
		return "/survey/surveyAdd";
	}
	
	// 설문지 등록
	@RequestMapping(value="/survey/surveyAdd", method = RequestMethod.POST)
	public String addSurvey(HttpSession session, Survey survey) {
		logger.debug("addSurvey() POST 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		String mAdminId = (String) session.getAttribute("loginId");
		survey.setmAdminId(mAdminId);
		surveyService.addSurvey(survey);
		return "redirect:/survey/surveyAdd";
	}
	
	// 설문지 조회
	@RequestMapping(value="/survey/surveyList", method = RequestMethod.GET)
	public String selectSurveyList(HttpSession session, Model model) {
		logger.debug("selectSurveyList() GET 메서드 호출");
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		List<Survey> list = surveyService.listSurvey();
		model.addAttribute("list", list);
		return "/survey/surveyList";
	}
	
	// 설문지 수정 get
	@RequestMapping(value="/survey/surveyModify", method = RequestMethod.GET)
	public String ModifySurvey(	HttpSession session,  Model model,
								@RequestParam(value="surveyCode") String surveyCode) {
		logger.debug("ModifySurvey() GET 메서드 호출 surveyCode is {}",surveyCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		Survey survey = surveyService.listSurveyBySurveyCode(surveyCode);
		logger.debug("ModifySurvey() GET 메서드 호출 survey is {}",survey);
		model.addAttribute("survey", survey);
		return "/survey/surveyModify";
	}
	// 설문지 수정 post
	@RequestMapping(value="/survey/surveyModify", method = RequestMethod.POST)
	public String ModifySurvey(	HttpSession session, Survey survey,
								@RequestParam(value="surveyCode") String surveyCode) {
		logger.debug("ModifySurvey() POST 메서드 호출 surveyCode is {}",surveyCode);
		surveyService.ModifySurvey(survey,surveyCode);
		return "redirect:/survey/surveyList";
	}
	
	// 설문지 삭제
	@RequestMapping(value="/survey/surveyDelete", method = RequestMethod.GET)
	public String DeleteSurvey(	HttpSession session,	
								@RequestParam(value="surveyCode") String surveyCode) {
		logger.debug("DeleteSurvey() GET 메서드 호출 surveyCode is {}",surveyCode);
		surveyService.removeSurvey(surveyCode);
		return "redirect:/survey/surveyList";
	}
	
	//설문지 질문 삭제
	@RequestMapping(value="/survey/surveyQuestionDelete", method = RequestMethod.GET)
	public String DeleteSurveyQuestion(	@RequestParam(value="surveyListCode") String surveyListCode,
										@RequestParam(value="surveyCode") String surveyCode) {
		logger.debug("DeleteSurveyQuestion() GET 메서드 호출 surveyListCode is {}",surveyListCode);
		logger.debug("DeleteSurveyQuestion() GET 메서드 호출 surveyCode is {}",surveyCode);
		surveyService.removeSurveyList(surveyListCode);
		return "redirect:/survey/surveyList";
	}
	
}
