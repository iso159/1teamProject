package com.cafe24.iso159;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.iso159.member.service.Member;
import com.cafe24.iso159.member.service.MemberInfo;
import com.cafe24.iso159.member.service.MemberLoginLevel;
import com.cafe24.iso159.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	// GET 방식 컨트롤러
	@RequestMapping(value = "/member/memberAdd", method = RequestMethod.GET)
	public String addMember() {
		return "member/memberAdd";
	}

	// POST 방식 컨트롤러
	@RequestMapping(value = "/member/memberAdd", method = RequestMethod.POST)
	public String addMember(Member member, MemberInfo memberInfo) {
		logger.debug("addmember(Member member, MemberInfo memberInfo) 메서드 member is {}", member);
		logger.debug("addmember(Member member, MemberInfo memberInfo) 메서드 member is {}", memberInfo);
		memberService.addMember(member, memberInfo);
		return "redirect:/member/login";
	}

	// 로그인요청메서드
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		logger.debug("login(Member member, HttpSession session) 메서드 member is {}", member);
		MemberLoginLevel memberLoginLevel = memberService.loginCheck(member);
		if (memberLoginLevel == null) { 
			return "redirect:/member/login";
		}
		session.setAttribute("loginId", memberLoginLevel.getmId());
		session.setAttribute("loginBlCode", memberLoginLevel.getBlCode());
		session.setAttribute("rightName", memberLoginLevel.getmRightGradeName());
		session.setAttribute("rightLevel", memberLoginLevel.getmRightLevel());
		return "redirect:/";
	}

	// 로그인페이지요청 메서드
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		logger.debug("로그인페이지 요청확인");
		return "/member/login";
	}
	
	// 회원 맵핑
	@RequestMapping(value = "/member/memberMenu", method = RequestMethod.GET)
	public String pass() {
		logger.debug("회원 이동함");
		return "/member/memberMenu";
	}
	
}