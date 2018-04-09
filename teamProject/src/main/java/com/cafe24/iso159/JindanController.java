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
import com.cafe24.iso159.animal.service.AnimalCommand;
import com.cafe24.iso159.animal.service.AnimalService;
import com.cafe24.iso159.jindan.service.AllJindanInfo;
import com.cafe24.iso159.jindan.service.JindanService;
import com.cafe24.iso159.shelter.service.BusinessLicense;
import com.cafe24.iso159.shelter.service.ShelterService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class JindanController {
	@Autowired
	private ShelterService shelterService;
	@Autowired
	private JindanService jindanService;
	@Autowired
	private AnimalService animalService;
	private static final Logger logger = LoggerFactory.getLogger(JindanController.class);	
	
	// /jindan/animalJindan 요청을 받아 진단 정보를 등록하는 service 호출후 /jindan/jindanAnimal로 포워딩해주는 컨트롤러 메서드
	@RequestMapping(value="/jindan/animalJindan", method=RequestMethod.POST)
	public String addJindan(AllJindanInfo allJindanInfo, HttpSession session
						, @RequestParam(value="animalCode") String animalCode) {
		logger.debug("addJindan(...) 메서드 호출");
		logger.debug("addJindan(...) 메서드 allJindanInfo is {}", allJindanInfo);
		logger.debug("addJindan(...) 메서드 animalCode is {}", animalCode);
		String mShelterId = (String)session.getAttribute("loginId");
		String blCode = (String)session.getAttribute("loginBlCode");
		if(mShelterId==null) {
			return "/member/login";
		}else if(blCode==null) {
			return "redirect:/";
		}
		jindanService.addJindan(allJindanInfo, animalCode, blCode, mShelterId);
		logger.debug("addJindan(...) 메서드 끝");
		return "/jindan/jindanAnimal";
	}
	
	// /jindan/animalJindan 요청을 받아 동물정보와 진단서 종합 상태 정보를 담아 /jindan/jindanAnimal 포워딩해주는 컨트롤러 메서드
	@RequestMapping(value="/jindan/animalJindan", method=RequestMethod.GET)
	public String jindanAnimal(Model model, HttpSession session
							 , @RequestParam(value="animalCode") String animalCode) {
		logger.debug("jindanAnimal(get) 메서드 호출");
		String mShelterId = (String)session.getAttribute("loginId");
		String blCode = (String)session.getAttribute("loginBlCode");
		if(mShelterId==null) {
			return "/member/login";
		}else if(blCode==null) {
			return "redirect:/";
		}
		logger.debug("jindanAnimal(get) 메서드 animalCode is {}", animalCode);
		// 동물 상세 정보를 변수에 입력
		AnimalCommand animalCommand = animalService.detailAnimal(animalCode);
		logger.debug("jindanAnimal(get) 메서드 animalCommand is {}", animalCommand);
		// 동물 상세 정보를 모델에 매핑
		model.addAttribute("animalCommand", animalCommand);
		// map에 진단서의 종합 상태 정보들을 입력
		Map<String, Object> map = jindanService.getJindanOs();
		logger.debug("jindanAnimal(get) 메서드 map is {}", map);
		// 종합 상태 정보를 종류별로 매핑 
		model.addAttribute("general", map.get("general"));
		model.addAttribute("skin", map.get("skin"));
		model.addAttribute("eyes", map.get("eyes"));
		model.addAttribute("ears", map.get("ears"));
		model.addAttribute("nose", map.get("nose"));
		model.addAttribute("isang", map.get("isang"));
		model.addAttribute("jindanKind", map.get("jindanKind"));
		logger.debug("jindanAnimal(get) 메서드 끝");		
		return "/jindan/jindanAnimal";
	}
}
