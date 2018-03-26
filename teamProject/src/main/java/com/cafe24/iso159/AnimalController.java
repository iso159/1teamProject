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

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.animal.service.AnimalAndBusinessLicense;
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
		animalservice.addAnimal(animal, session);
		return "redirect:/animal/animalList";
	}
	//동물리스트
	@RequestMapping(value="/animal/animalList", method=RequestMethod.GET)
	public String animal(HttpSession session, Model model) {
		logger.debug("animal()메서드 호출");
		List<Animal> AnimalList = animalservice.listAnimal();
		model.addAttribute("AnimalList", AnimalList);
		return "animal/animalList";
	}
}
