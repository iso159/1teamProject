package com.cafe24.iso159;

import java.util.List;

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
									@RequestParam(value="surveyCode", required=false) String surveyCode) {
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
									@RequestParam(value="surveyCode", required=false) String surveyCode) {
		logger.debug("addSurveyQuestion() 메서드 호출 surveyCode is {}", surveyCode);
		// 세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		String mAdminId = (String) session.getAttribute("loginId");
		// 설문지코드 입력
		surveyList.setmAdminId(mAdminId);
		surveyService.addSurveyList(surveyList);
		return "redirect:/survey/surveyAdd";
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
	
}
