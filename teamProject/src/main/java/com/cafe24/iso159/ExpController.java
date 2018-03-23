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

import com.cafe24.iso159.exp.service.Exp;
import com.cafe24.iso159.exp.service.ExpPeriod;
import com.cafe24.iso159.exp.service.ExpService;


@Controller
public class ExpController {
	@Autowired
	private ExpService expService;
	private static final Logger logger = LoggerFactory.getLogger(ExpController.class);
	
	// /experience/expAdd 을 get 방식으로 호출할때 실행
	@RequestMapping(value = "/exp", method = RequestMethod.GET)
	public String exp() {
		logger.debug("ExpController 호출 {exp.get}.");
		return "/experience/exp";
	}
	
	// /experience/expAdd 을 get 방식으로 호출할때 실행
	@RequestMapping(value = "/experience/expAdd", method = RequestMethod.GET)
	public String expAdd(Model model,@RequestParam(value="animalCode") String animalCode) {
		logger.debug("ExpController 호출 {expAdd.get}.");
		//넘어온 animalCode 값 확인
		logger.debug("expAdd().get 메서드 animalCode is {}",animalCode);
		//model에 animalCode 담아 넘김
		model.addAttribute("animalCode", animalCode);
		//expPerido /기간선택 가능하도록 보여줌
		List<ExpPeriod> expPerido = expService.expPeriod(); // 뷰부분하는중
		model.addAttribute("addAttribute", expPerido);
		return "/experience/expAdd";
	}

	// /experience/expAdd 을 post 방식으로 호출할때 실행
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
