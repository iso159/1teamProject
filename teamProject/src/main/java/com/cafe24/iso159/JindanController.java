package com.cafe24.iso159;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.iso159.shelter.service.BusinessLicense;
import com.cafe24.iso159.shelter.service.ShelterService;

@Controller
public class JindanController {
	@Autowired
	private ShelterService shelterService;
	private static final Logger logger = LoggerFactory.getLogger(JindanController.class);	
	
	@RequestMapping(value="/shelterListJindan")
	public String jindanShelterList(Model model) {
		logger.debug("jindanShelterList() 메서드 호출");
		List<BusinessLicense> list = shelterService.getBusinessLicense();
		logger.debug("jindanShelterList() 메서드 list is {}", list);
		model.addAttribute("list",list);
		logger.debug("jindanShelterList() 메서드 끝");
		return "jindan/jindanShelterList";
	}
}
