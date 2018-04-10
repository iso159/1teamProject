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
import com.cafe24.iso159.goods.service.GoodsCart;
import com.cafe24.iso159.goods.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

	// 상품 카테고리 메뉴 목록
	@RequestMapping(value = "/goods/goodsMenu", method = RequestMethod.GET)
	public String goods() {
		logger.debug("goods() 메서드 호출");
		logger.debug("goods() 메서드 끝");
		return "goods/goodsMenu";
	}

	// 상품등록 페이지로 이동
	@RequestMapping(value = "/goods/goodsAdd", method = RequestMethod.GET)
	public String goodsAdd(HttpSession session) {
		logger.debug("goodsAdd(HttpSession session) 메서드 호출");
		if (session.getAttribute("loginId") == null) {
			return "redirect:/goods/login";
		}
		logger.debug("goodsAdd(HttpSession session) 메서드 끝");
		return "goods/goodsAdd";
	}

	// 상품등록 요청
	@RequestMapping(value = "/goods/goodsAdd", method = RequestMethod.POST)
	public String goodsAdd(HttpSession session, Goods goods) {
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 호출");
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 is goods {}", goods);
		String mAdminId = (String) session.getAttribute("loginId");
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 is mAdminId {}", mAdminId);
		goods.setmAdminId(mAdminId);
		goodsService.addGoods(goods);
		logger.debug("goodsAdd(HttpSession session, Goods goods) 메서드 끝");
		return "goods/goodsList";
	}

	// 전체 리스트 요청
	@RequestMapping(value = "/goods/goodsList")
	public String goodsList(HttpSession session) {
		logger.debug("goodsList(HttpSession session) 메서드 호출");
		List<Goods> list = goodsService.getGoodsList();
		session.setAttribute("list", list);
		logger.debug("goodsList(HttpSession session) 메서드 list is {}", list);
		logger.debug("goodsList(HttpSession session) 메서드 끝");
		return "/goods/goodsList";
	}

	// 상품 수정 요청
	@RequestMapping(value = "/goods/goodsModify", method = RequestMethod.POST)
	public String updateGoods(Goods goods) {
		logger.debug("updateGoods(Goods goods) 메서드 시작");
		goodsService.updateGoods(goods);
		logger.debug("updateGoods(Goods goods) 메서드 goods is {}", goods);
		logger.debug("updateGoods(Goods goods) 메서드 끝");
		return "/goods/goodsModify";
	}

	// 상품 수정페이지 요청, 수정할 상품조회
	@RequestMapping(value = "/goods/goodsModify", method = RequestMethod.GET)
	public String goodsOneSelect(Model model, Goods goods, HttpSession session) {
		logger.debug("goodsOneSelect(Model model, Goods goods, HttpSession session) 메서드 호출");
		logger.debug("goodsOneSelect(Model model, Goods goods, HttpSession session) 메서드 goods is {}", goods);
		Goods goodsSelect = goodsService.getGoodsOne(goods);
		logger.debug("goodsOneSelect(Model model, Goods goods, HttpSession session) 메서드 goodsSelect is {}", goodsSelect);
		model.addAttribute("Goods", goodsSelect);
		logger.debug("goodsOneSelect(Model model, Goods goods, HttpSession session) 메서드 끝");
		return "/goods/goodsModify";
	}

	// 상품 삭제요청
	@RequestMapping(value = "/goods/goodsRemove", method = RequestMethod.GET)
	public String goodsRemove(@RequestParam(value = "pointGoodsCode") String goodsCode) {
		logger.debug("goodsRemove(@RequestParam(value = \"pointGoodsCode\") String goodsCode) 메서드 호출");
		logger.debug("goodsRemove(@RequestParam(value = \"pointGoodsCode\") String goodsCode) 메서드 goodsCode is {}", goodsCode);
		goodsService.removeGoods(goodsCode);
		logger.debug("goodsRemove(@RequestParam(value = \"pointGoodsCode\") String goodsCode) 메서드 끝");
		return "redirect:/goods/goodsList";
	}

	// 상품 한개 상세페이지요청
	@RequestMapping(value = "/goods/goodsDetail", method = RequestMethod.GET)
	public String goodsDetail(HttpSession session, Model model,
			@RequestParam(value = "pointGoodsCode", required = true) String goodsCode) {
		logger.debug("goodsDetail(HttpSession session, Model model,\r\n" + 
				"			@RequestParam(value = \"pointGoodsCode\", required = true) String goodsCode) 메서드 호출");
		logger.debug("goodsDetail(HttpSession session, Model model,\r\n" + 
				"			@RequestParam(value = \"pointGoodsCode\", required = true) String goodsCode) 메서드 goodsCode is {}", goodsCode);
		Goods goodsDetail = goodsService.detailGoods(goodsCode);
		logger.debug("goodsDetail(HttpSession session, Model model,\r\n" + 
				"			@RequestParam(value = \"pointGoodsCode\", required = true) String goodsDetail) 메서드 goodsDetail is {}", goodsDetail);
		model.addAttribute("goodsDetail", goodsDetail);
		logger.debug("goodsDetail(HttpSession session, Model model,\r\n" + 
				"			@RequestParam(value = \"pointGoodsCode\", required = true) String goodsCode) 메서드 끝");
		return "goods/goodsDetail";
	}
}