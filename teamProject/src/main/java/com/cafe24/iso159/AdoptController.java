package com.cafe24.iso159;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.iso159.adopt.service.AdoptRequest;
import com.cafe24.iso159.adopt.service.AdoptService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AdoptController {
	private static final Logger logger = LoggerFactory.getLogger(AdoptController.class);
	
	@Autowired
	private AdoptService adoptService;
	private AdoptRequest AdoptRequest;
	
	// 입양메뉴
	@RequestMapping(value="/adopt", method = RequestMethod.GET)
	public String addAdopt() {
		logger.debug("addAdopt(HttpSession session) 메서드 호출");
		return "/adopt/adopt";
	}
	
	// 입양신청 페이지
	@RequestMapping(value="/adopt/adoptRequest", method = RequestMethod.GET)
	public String addAdopt(HttpSession session) {
		logger.debug("addAdopt(HttpSession session) 메서드 호출");
		return "/adopt/adoptRequest";
	}
		
	// 입양신청 페이지 요청(1.입양이유)
	@RequestMapping(value="/adopt/adoptRequest", method = RequestMethod.POST)
	public String addAdopt(HttpSession session, AdoptRequest adoptRequest) {
		logger.debug("addAdopt(HttpSession session, AdoptRequest adoptRequest) 메서드 호출 adoptRequest is {}", adoptRequest);
		adoptService.addAdopt(adoptRequest);
		return "redirect:/adopt/adoptList";	//입양신청 완료 후 입양리스트로
		
	}
	
	// 입양신청 들어오면 확인
	@RequestMapping(value="/adopt/adoptCheck", method = RequestMethod.GET)
	public String UpdateOsCodeAdopt(@RequestParam(value="adoptRequestCode") String adoptRequestCode,
									@RequestParam(value="osCodeAdopt") String osCodeAdopt) {
		logger.debug("UpdateOsCodeAdopt() 메서드 호출");
		adoptService.ModifyOsCodeAdopt(adoptRequestCode,osCodeAdopt);
		return "redirect:/adopt/adoptList";
	}
	
	// 입양취소
	@RequestMapping(value="/adopt/adoptCancle", method = RequestMethod.GET)
	public String removeAdopt(@RequestParam(value="adoptRequestCode") String adoptRequestCode) {
		logger.debug("removeAdopt() 메소드 호출");
		adoptService.removeAdopt(adoptRequestCode);
		return "redirect:/adopt/adoptList";
	}
	
	// 입양리스트
	@RequestMapping(value="/adopt/adoptList")
	public String selectAdoptRequestList(HttpSession httpSession, Model model) {
		logger.debug("selectAdoptRequestList(HttpSession httpSession) 메서드 호출");
		List<AdoptRequest> list = adoptService.listAdoptRequest();
		model.addAttribute("list", list);
		return "/adopt/adoptList";
	}
	
}
