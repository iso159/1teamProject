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
import com.cafe24.iso159.exp.service.ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo;
import com.cafe24.iso159.exp.service.ExpPeriod;
import com.cafe24.iso159.exp.service.ExpService;


@Controller
public class ExpController {
	@Autowired
	private ExpService expService;
	private static final Logger logger = LoggerFactory.getLogger(ExpController.class);
	
	// 보호소 체험진행,종료시 동물 상태 변경
	@RequestMapping(value = "/experience/animalUpdate", method = RequestMethod.GET)
	public String progressionAnimalUpdate(@RequestParam(value="animalCode") String animalCode,
										@RequestParam(value="expCode") String expCode,
										@RequestParam(value="osCodeAnimal") String osCodeAnimal,
										@RequestParam(value="osCodeExp") String osCodeExp) {
		logger.debug("ExpController 호출 {animalUpdate.get}.");
		logger.debug("animalUpdate().get 메서드 animalCode is {}",animalCode);
		logger.debug("animalUpdate().get 메서드 expCode is {}",expCode);
		logger.debug("animalUpdate().get 메서드 osCodeAnimal is {}",osCodeAnimal);
		logger.debug("animalUpdate().get 메서드 osCodeExp is {}",osCodeExp);
		// animalCode 가져와서 체험 진행,종료시 동물상태 변경
		Animal animal = new Animal();
		animal.setAnimalCode(animalCode);
		animal.setOsCodeAnimal(osCodeAnimal);
		// expCode 가져와서 체험 진행,종료시 체험상태 변경
		Exp exp = new Exp();
		exp.setExpCode(expCode);
		exp.setOsCodeExp(osCodeExp);
		// animal, exp 각각 map에 담아서 넘김
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("animal", animal);
		map.put("exp", exp);
		expService.progressionAnimalAndExpUpdate(map);
		return "redirect:/experience/expShelterList";
	}
	
	//해당 보호소 체험 예약 상태 진행
	@RequestMapping(value = "/experience/updateOsExp", method = RequestMethod.GET)
	public String checkOsExp(@RequestParam(value="osCodeExp") String osCodeExp,@RequestParam(value="expCode") String expCode,HttpSession session) {
		logger.debug("ExpController 호출 {checkOsExp.get}.");
		logger.debug("checkOsExp().get 메서드 osCodeExp is {}",osCodeExp);
		logger.debug("checkOsExp().get 메서드 expCode is {}",expCode);
		String loginId = (String)session.getAttribute("loginId");
		logger.debug("checkOsExp().get 메서드 loginId is {}",loginId);
		Exp exp = new Exp();
		exp.setmShelterIdAccept(loginId);
		exp.setExpCode(expCode);
		exp.setOsCodeExp(osCodeExp);
		expService.updateOsExp(exp);
		return "redirect:/experience/expShelterList";
	}
	
	//해당 보호소 체험자 정보
	@RequestMapping(value = "/experience/expShelterInfo", method = RequestMethod.GET)
	public String expShelterInfo(Model model,@RequestParam(value="expCode") String expCode,HttpSession session) {
		logger.debug("ExpController 호출 {expShelterInfo.get}.");
		logger.debug("expShelterInfo().get 메서드 expCode is {}",expCode);
		//체험 리스트에서 체험 코드 가져와서 정보 확인
		ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo selectExpOneInfo =  expService.selectExpShelterInfo(expCode);
		logger.debug("expShelterInfo().get 메서드 selectExpOneInfo is {}",selectExpOneInfo);
		model.addAttribute("ExpOneInfo", selectExpOneInfo);
		//해당 보호소 체험자 리스트 에서 정보 확인할때 확인자 아이디 ,체험 상태 등록
		Exp exp = new Exp();
		exp.setmShelterIdCheck((String)session.getAttribute("loginId"));
		logger.debug("expShelterInfo().get 메서드 loginId is {}",(String)session.getAttribute("loginId"));
		exp.setExpCode(expCode);
		expService.updateExpmShelterIdCheck(exp);
		return "/experience/expShelterInfo";
	}
	
	// 해당 보호소 체험자 리스트
	@RequestMapping(value = "/experience/expShelterList", method = RequestMethod.GET)
	public String expshelterList(Model model,HttpSession session) {
		logger.debug("ExpController 호출 {expshelterList.get}.");
		//blCode 값 확인
		String loginBlCode = (String)session.getAttribute("loginBlCode");
		logger.debug("expshelterList().get 메서드 blCode is {}",loginBlCode);
		List<Exp> exp = expService.selectExpShelterList(loginBlCode);
		logger.debug("expshelterList().get 메서드 exp is {}",exp);
		model.addAttribute("exp", exp);
		return "/experience/expShelterList";
	}
	
	// 체험신청자 체험 삭제
	@RequestMapping(value = "/experience/deleteExp", method = RequestMethod.GET)
	public String deleteExpOne(@RequestParam(value="expCode") String expCode) {
		logger.debug("ExpController 호출 {deleteExpOne.get}.");
		//넘어온 expCode 값 확인
		logger.debug("deleteExpOne().get 메서드 expCode is {}",expCode);
		expService.deleteExpOne(expCode);
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
