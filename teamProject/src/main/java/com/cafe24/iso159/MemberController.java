package com.cafe24.iso159;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.cxf.io.CachedOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String addMember(Member member, MemberInfo memberInfo, HttpServletResponse response) throws IOException {
		logger.debug("addmember(...) 메서드 member is {}", member);
		logger.debug("addmember(...) 메서드 memberInfo is {}", memberInfo);
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
		String loginId = memberLoginLevel.getmId();
		String loginBlCode = memberLoginLevel.getBlCode();
		String rightName = memberLoginLevel.getmRightName();
		String rightLevel = memberLoginLevel.getmRightLevel();
		logger.debug("login(Member member, HttpSession session) 메서드 loginId is {}", loginId);
		logger.debug("login(Member member, HttpSession session) 메서드 loginBlCode is {}", loginBlCode);
		logger.debug("login(Member member, HttpSession session) 메서드 rightName is {}", rightName);
		logger.debug("login(Member member, HttpSession session) 메서드 rightLevel is {}", rightLevel);
		session.setAttribute("loginId", loginId);
		session.setAttribute("loginBlCode", loginBlCode);
		session.setAttribute("rightName", rightName);
		session.setAttribute("rightLevel", rightLevel);
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

	// 유기동물품종 api
		@RequestMapping(value = "/member/addressList", method = RequestMethod.POST)
		public void shelterAddressList(HttpServletResponse response, HttpSession session){
			logger.debug("shelterAddressList(...) 메서드 호출");
			/*String blCode = (String)session.getAttribute("loginBlCode");
			if(blCode == null) {
				return;
			}*/
			response.setContentType("text/html; charset=utf-8");
			// 호출할 데이터가 있는 url을 addr변수에 입력
			String addr = "http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdService/retrieveNewAdressAreaCdService/getNewAddressListAreaCd?ServiceKey=";
			// 서비스키 입력
			String serviceKey = "7s3CsUFyR%2F1QMd5tktqM%2BnUw9gAEPUtI0GIsuGWxEUOJHwZP9NVTLOoMOKmVtZH0SmDPuv5Gg78SA94B%2BLMQsQ%3D%3D";
			// 요청메시지를 입력받을 parameter변수 선언 및 공백으로 초기화
			String parameter = "";
			
			URL url = null;
			CachedOutputStream bos = null;
			InputStream in = null;
			
			// 요청메세지 추가
			parameter = parameter + "&" + "searchSe";
			parameter = parameter + "&" + "srchwrd";
			parameter = parameter + "&" + "countPerPage";
			parameter = parameter + "&" + "currentPage";
			
			// 주소에 url + 서비스키 + 조건을 연결
			addr = addr + serviceKey + parameter;
			String data = null;
			PrintWriter out = null;
			
			// 예외처리
			try {
				// 데이터를 가져올 url 할당
				url = new URL(addr);
				// url주소와 연결한후 이 연결로부터 입력받을수있는 InputStream을 리턴받음
				in = url.openStream();
				// 출력을 받기위해 CachedOutputStream 객체 생성
				bos = new CachedOutputStream();
				// in에서 bos로 데이터 복사
				IOUtils.copy(in, bos);
				// 복사된 데이터를 String 형태로 data변수에 입력
				data = bos.getOut().toString();
				// 텍스트형식의 출력 스트림을 얻은후
				out = response.getWriter();
				// 얻어낸 스트림에 데이터 입력
				out.println(data);
				logger.debug("data is {}", data);
				logger.debug("addr is {}", addr);
				JSONObject json = new JSONObject();
				// json형태로 데이터를 넣음
				json.put("data", data);
				
				out.print(json);
				
				logger.debug("shelterAnimalBreed(...) 메서드 끝");
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {in.close();} catch (IOException e) {e.printStackTrace();}
				try {bos.close();} catch (IOException e) {e.printStackTrace();}
			}					
		}
		
		// 회원가입시 아이디 중복체크 매핑 컨트롤러
		@RequestMapping("/member/memberAdd")
		@ResponseBody
		public int duplication(HttpServletRequest request) {
			String duplicationId = request.getParameter("mId");
			List<Member> list = MemberService.duplication(duplicationId);
			if(list.size()==0) {
				return -1;
			}else {
				return 1;
			}
		}
}