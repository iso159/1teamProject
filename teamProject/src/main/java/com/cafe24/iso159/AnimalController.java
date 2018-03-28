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

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.animal.service.AnimalCommand;
import com.cafe24.iso159.animal.service.AnimalService;

@Controller
public class AnimalController {
	
	@Autowired
	private AnimalService animalservice;
	private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
	//동물등록 페이지로 이동
	@RequestMapping(value="/animal/animalAdd", method=RequestMethod.GET)
	public String animalAdd(HttpSession session) {
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		return "animal/animalAdd";
	}
	
	//동물등록
	@RequestMapping(value="/animal/animalList", method=RequestMethod.POST)
	public String animalAdd(HttpSession session, Animal animal) {
		
		logger.debug("animalAdd()메서드 호출");
		//세션에서 로그인 아이디를 가져와서 mShelterId에 셋팅
		String mShelterId = (String)session.getAttribute("loginId");
		logger.debug("mShelterId is {}", mShelterId);
		//세션에서 로그인 blCode를 가져와서 blCode에 셋팅		
		String blCode = (String)session.getAttribute("loginBlCode");
		logger.debug("blcode is {}", blCode);
		
		animalservice.addAnimal(animal, mShelterId, blCode);
		return "redirect:/animal/animalList";
	}
	//동물리스트
	@RequestMapping(value="/animal/animalList", method=RequestMethod.GET)
	public String animal(HttpSession session, Model model) {
		logger.debug("animal()메서드 호출");
		List<AnimalCommand> AnimalList = animalservice.listAnimal();
		model.addAttribute("AnimalList", AnimalList);
		return "animal/animalList";
	}
	
	//동물리스트 삭제
	@RequestMapping(value="/animal/animalDelete", method=RequestMethod.GET)
	public String animalRemove(@RequestParam(value="animalCode")String animalCode) {
		animalservice.removeAnimal(animalCode);
		return "redirect:/animal/animalList";
	}
}
