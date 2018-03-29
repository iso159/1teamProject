package com.cafe24.iso159;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.iso159.goods.service.Goods;
import com.cafe24.iso159.goods.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

	// GET 방식 컨트롤러
	@RequestMapping(value = "/goods/goodsMenu", method = RequestMethod.GET)
	public String member() {
		return "goods/goodsMenu";
	}

	//상품등록 페이지로 이동
	@RequestMapping(value="/goods/goodsAdd", method=RequestMethod.GET)
	public String goodsAdd(HttpSession session) {
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		return "goods/goodsAdd";
	}
	
	//상품등록 요청
	@RequestMapping(value="/goods/goodsAdd",method = RequestMethod.POST)
	public String goodsAdd(HttpSession session, Goods goods) {
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 호출",goods);
		//세션에서 로그인 아이디를 가져와서 mShelterId에 셋팅
		String mAdminId = (String)session.getAttribute("loginId");
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 is mAdminId {}", mAdminId);
		//세션에서 로그인 blCode를 가져와서 blCode에 셋팅
		/*String blCode = (String)session.getAttribute("loginBlCode");*/
		goods.setmAdminId(mAdminId);
		goodsService.addGoods(goods);
		return "index";
	}
}
