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

import com.cafe24.iso159.member.service.Member;
import com.cafe24.iso159.member.service.MemberAndMemberInfo;
import com.cafe24.iso159.member.service.MemberInfo;
import com.cafe24.iso159.member.service.MemberLoginLevel;
import com.cafe24.iso159.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService MemberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	// GET 방식 컨트롤러
	@RequestMapping(value = "/member/memberMenu", method = RequestMethod.GET)
	public String member() {
		return "member/memberMenu";
	}

	// POST 방식 회원가입
	@RequestMapping(value = "/member/memberAdd", method = RequestMethod.POST)
	public String addMember(Member member, MemberInfo memberInfo) {
		logger.debug("addmember(Member member, MemberInfo memberInfo) 메서드 member is {}", member);
		logger.debug("addmember(Member member, MemberInfo memberInfo) 메서드 member is {}", memberInfo);
		MemberService.addMember(member, memberInfo);
		return "index";
	}

	// GET 방식 회원가입
	@RequestMapping(value = "/member/memberAdd", method = RequestMethod.GET)
	public String addMember() {
		logger.debug("addmember() 메서드 member is {}");
		return "member/memberAdd";
	}

	// 로그인요청메서드
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		logger.debug("login(Member member, HttpSession session) 메서드 member is {}", member);
		MemberLoginLevel memberLoginLevel = MemberService.loginCheck(member);
		if (memberLoginLevel == null) {
			return "redirect:/member/login";
		}
		session.setAttribute("loginId", memberLoginLevel.getmId());
		session.setAttribute("loginBlCode", memberLoginLevel.getBlCode());
		session.setAttribute("rightName", memberLoginLevel.getmRightGradeName());
		session.setAttribute("rightLevel", memberLoginLevel.getmRightLevel());
		return "redirect:/";
	}
 
	// 로그인페이지요청
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		logger.debug("로그인페이지 요청확인");
		return "/member/login";
	}

	// 리스트 요청
	@RequestMapping(value = "/member/memberList")
	public String memberList(HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "redirect:/goods/login";
		}
		List<MemberAndMemberInfo> list = MemberService.getMemberList();
		session.setAttribute("list", list);
		logger.debug("memberList(HttpSession session) 메서드 list is {}", list);
		return "/member/memberList";
	}
	
/*	
	// 회원 한명 상세정보 조회
	@RequestMapping(value="/member/memberDetail", method=RequestMethod.GET)
	public String memberDetail(HttpSession session, Model model, String memberCode) {	
		Member memberDetail =MemberService.detailMember(memberCode);
		model.addAttribute("memberDetail", memberDetail);
		return "member/memberDetail";
	}
*/

	// update 요청
	@RequestMapping(value = "/member/memberModify", method = RequestMethod.POST)
	public String updateMember(Member member, MemberInfo memberInfo) {
		MemberService.updateMemberInfo(member, memberInfo);
		logger.debug("updateMember(Member member, MemberInfo memberInfo) 메서드 member is {}", member);
		logger.debug("updateMember(Member member, MemberInfo memberInfo) 메서드 memberInfo is {}", memberInfo);
		return "redirect:/";
	}
	 
	// 회원 수정페이지 요청, 수정할 하나 회원조회
	@RequestMapping(value = "/member/memberModify", method = RequestMethod.GET)
	public String memberOneSelect(Model model, HttpSession session, String memberId) {
		String mLoginId = (String)session.getAttribute("loginId");
		logger.debug("memberOneSelect(Model model, MemberInfo memberInfo, HttpSession session) 메서드 mLoginId is {}", mLoginId);
		MemberInfo memberInfoSelect = MemberService.getMemberOne(mLoginId);
		model.addAttribute("MemberInfo", memberInfoSelect);
		return "/member/memberModify";
	}
	
	// /member/memberRemove get방식으로 요청시 memberRemove(Member member) 메소드 호출됨
	@RequestMapping(value="/member/memberRemove", method = RequestMethod.GET)
	public String memberRemove(HttpSession session) {
		logger.debug("memberRemove(HttpSession session) 메서드 호출");
		String mLoginId = (String)session.getAttribute("loginId");
		logger.debug("memberRemove(HttpSession session) 메서드 mLoginId is {}", mLoginId);
		MemberService.removeMember(mLoginId);
		return "redirect:/";
	}
	// 로그아웃 요청
	@RequestMapping(value = "/member/memberLogout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("로그아웃 확인");
		session.invalidate();
		return "redirect:/";
	}
}