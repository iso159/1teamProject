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

import com.cafe24.iso159.goods.service.Goods;
import com.cafe24.iso159.goods.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

	// Menu
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
		return "goods/goodsList";
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
		
	// update 요청
	@RequestMapping(value = "/goods/goodsModify", method = RequestMethod.POST)
	public String updateGoods(Goods goods) {
		goodsService.updateGoods(goods);
		logger.debug("updateGoods(Goods goods) 메서드 goods {}", goods);
		return "/goods/goodsModify";
	}
	
	// 상품 수정페이지 요청, 수정할 상품조회
	@RequestMapping(value = "/goods/goodsModify", method = RequestMethod.GET)
	public String goodsOneSelect(Model model, Goods goods, HttpSession session) {
		logger.debug("goodsOneSelect(Model model, Goods goods,HttpSession session) 메서드 goods is {}", goods);
		Goods goodsSelect = goodsService.getGoodsOne(goods);
		model.addAttribute("Goods", goodsSelect);
		return "/goods/goodsModify";
	}
	
	// 상품 삭제요청
	@RequestMapping(value="/goods/goodsRemove", method=RequestMethod.GET)
	public String goodsRemove(@RequestParam(value="pointGoodsCode")String goodsCode) {
		goodsService.removeGoods(goodsCode);
		return "redirect:/goods/goodsList";
	}
	//상품 한개 상세페이지요청
	@RequestMapping(value="/goods/goodsDetail", method=RequestMethod.GET)
	public String goodsDetail(HttpSession session, Model model, @RequestParam(value="pointGoodsCode",required=true)String goodsCode) {
			
		Goods goodsDetail =goodsService.detailGoods(goodsCode);
		model.addAttribute("goodsDetail", goodsDetail);
		return "goods/goodsDetail";
	}
}
