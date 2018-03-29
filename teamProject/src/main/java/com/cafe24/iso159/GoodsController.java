package com.cafe24.iso159;

import java.util.List;

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
	public String goods() {
		return "goods/goodsMenu";
	}

	// 상품등록 페이지로 이동
	@RequestMapping(value = "/goods/goodsAdd", method = RequestMethod.GET)
	public String goodsAdd(HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "redirect:/goods/login";
		}
		return "goods/goodsAdd";
	}

	// 상품등록 요청
	@RequestMapping(value = "/goods/goodsAdd", method = RequestMethod.POST)
	public String goodsAdd(HttpSession session, Goods goods) {
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 호출", goods);
		String mAdminId = (String) session.getAttribute("loginId");
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 is mAdminId {}", mAdminId);
		goods.setmAdminId(mAdminId);
		goodsService.addGoods(goods);
		return "index";
	}

	// 리스트 요청
	@RequestMapping(value = "/goods/goodsList")
	public String goodsList(HttpSession session) {
		logger.debug("goodsList(Model model, HttpSession session) 메서드 호출");
		List<Goods> list = goodsService.getGoodsList();
		session.setAttribute("list", list);
		logger.debug("goodsList(HttpSession session) 메서드 list is {}", list);
		return "/goods/goodsList";
	}
}
