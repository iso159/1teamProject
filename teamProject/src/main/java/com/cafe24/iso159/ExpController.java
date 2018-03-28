package com.cafe24.iso159;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.exp.service.Exp;
import com.cafe24.iso159.exp.service.ExpAndAnimal;
import com.cafe24.iso159.exp.service.ExpAndAnimalAndBusinessLicense;
import com.cafe24.iso159.exp.service.ExpPeriod;
import com.cafe24.iso159.exp.service.ExpService;


@Controller
public class ExpController {
	@Autowired
	private ExpService expService;
	private static final Logger logger = LoggerFactory.getLogger(ExpController.class);
	
	//체험 수정 띄우는 부분 /experience/expModify 을 get 방식으로 호출할때 발생
	@RequestMapping(value = "/experience/expModify", method = RequestMethod.GET)
	public String ModifyExpOneinfo(Model model,@RequestParam(value="expCode") String expCode) {
		logger.debug("ExpController 호출 {ModifyExpOneinfo.GET}.");
		//expCode 확인
		logger.debug("ModifyExpOneinfo.GET 메서드 expCode is {}",expCode);
		//expPerido /기간선택 가능하도록 보여줌
		List<ExpPeriod> expPerido = expService.expPeriod();
		logger.debug("ModifyExpOneinfo.GET 메서드 expPerido is {}",expPerido);
		model.addAttribute("addAttribute", expPerido);
		//전에 입력했던 자료를 보여줌
		Exp exp = expService.selectUpdateExpOne(expCode);
		logger.debug("ModifyExpOneinfo.GET 메서드 exp is {}",exp);
		model.addAttribute("exp", exp);
		return "/experience/expModify";
	}
	
	// 체험 수정 /experience/expModify 을 POST 방식으로 호출할때 발생
	@RequestMapping(value = "/experience/expModify", method = RequestMethod.POST)
	public String ModifyExpOen(Exp exp) {
		logger.debug("ExpController 호출 {ModifyExpOen.POST}.");
		logger.debug("ModifyExpOen.POST 메서드 exp is {}",exp);
		expService.updateExpOen(exp);
		return "redirect:/experience/expList";
	}
	
	// 체험 개인 리스트 /experience/expList 을 get 방식으로 호출할때 발생
	@RequestMapping(value = "/experience/expList", method = RequestMethod.GET)
	public String ExpOneList(Model model,HttpSession session) {
		logger.debug("ExpController 호출 {ExpOneList.get}.");
		String loginId = (String)session.getAttribute("loginId");
		//넘어온 loginId 값 확인
		logger.debug("ExpOneList().get 메서드 loginId is {}",loginId);
		//loginId값으로 해당 체험 리스트 가져옴
		List<ExpAndAnimal> expAndAnimal = expService.selectExpOneList(loginId);
		//리스트 확인
		logger.debug("ExpOneList().get 메서드 expAndAnimal is {}",expAndAnimal);
		model.addAttribute("loginId", loginId);
		model.addAttribute("expAndAnimal", expAndAnimal);
		
		return "/experience/expList";
	}
	
	// 체험 개인 정보 /experience/expInfo 을 get 방식으로 호출할때 발생
	@RequestMapping(value = "/experience/expInfo", method = RequestMethod.GET)
	public String ExpOne(Model model,@RequestParam(value="expCode") String expCode) {
		logger.debug("ExpController 호출 {ExpOne.get}.");
		//넘어온 expCode 값 확인
		logger.debug("ExpOne().get 메서드 expCode is {}",expCode);
		//expCode으로 체험 상세정보 받아옴
		ExpAndAnimalAndBusinessLicense expAndAnimalAndBusinessLicense = expService.selectExpOneInfo(expCode);
		logger.debug("ExpOne().get 메서드 expAndAnimalAndBusinessLicense is {}",expAndAnimalAndBusinessLicense);
		model.addAttribute("selectExpOneInfo", expAndAnimalAndBusinessLicense);
		return "/experience/expInfo";
	}
	
	// 체험 홈 /experience/expAdd 을 get 방식으로 호출할때 실행
	@RequestMapping(value = "/exp", method = RequestMethod.GET)
	public String exp() {
		logger.debug("ExpController 호출 {exp.get}.");
		return "/experience/exp";
	}
	
	// 체험 등록 뷰 /experience/expAdd 을 get 방식으로 호출할때 실행
	@RequestMapping(value = "/experience/expAdd", method = RequestMethod.GET)
	public String expAdd(Model model,@RequestParam(value="animalCode") String animalCode,
						@RequestParam(value="blCode") String blCode) {
		logger.debug("ExpController 호출 {expAdd.get}.");
		//넘어온 animalCode 값 확인
		logger.debug("expAdd().get 메서드 animalCode is {}",animalCode);
		//model에 animalCode 담아 넘김
		model.addAttribute("animalCode", animalCode);
		//model에 blCode 담아 넘김
		logger.debug("expAdd().get 메서드 blCode is {}",blCode);
		model.addAttribute("blCode", blCode);
		//expPerido /기간선택 가능하도록 보여줌
		List<ExpPeriod> expPerido = expService.expPeriod();
		model.addAttribute("addAttribute", expPerido);
		return "/experience/expAdd";
	}

	// 체험 등록 /experience/expAdd 을 post 방식으로 호출할때 실행
	@RequestMapping(value = "/experience/expAdd", method = RequestMethod.POST)
	public String expAdd(Exp exp,HttpSession session) {
		logger.debug("ExpController 호출 {expAdd.post}.");
		logger.debug("expAdd().post 메서드 exp is {}",exp);
		String loginId = (String)session.getAttribute("loginId");
		logger.debug("expAdd().post 메서드 loginId is {}",loginId);
		exp.setmExpId(loginId);
		expService.addExp(exp);
		return "redirect:/";
	}
	
}
