package com.cafe24.iso159.goods.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);

	//상품등록
	public void addGoods(Goods goods){
		logger.debug("addGoods(Goods goods) 메서드 호출");
		logger.debug("addGoods(Goods goods) 메서드 goods is {}",goods);
		String pointGoodsCode = "point_goods_code";
		logger.debug("addGoods(Goods goods) 메서드 goods is {}", pointGoodsCode);
		int mInfoCodeNumber = goodsDao.selectGoodsInfoCodeNumber(pointGoodsCode) + 1;
		logger.debug("addGoods(Goods goods) 메서드 mInfoCodeNumber is {}", mInfoCodeNumber);
		pointGoodsCode += mInfoCodeNumber;
		goods.setPointGoodsCode(pointGoodsCode);
		logger.debug("addGoods(Goods goods) 메서드 goodsInfo is {}", goods);
		logger.debug("addGoods(Goods goods) 메서드 끝");
		goodsDao.insertGoods(goods);
	}
	
	// 상품 리스트 전체 조회
	public List<Goods> getGoodsList() {
		logger.debug("getGoodsList() 메서드 호출");
		List<Goods> list = goodsDao.selectGoodsList();
		logger.debug("getGoodsList() 메서드 list is {}", list);
		logger.debug("getGoodsList() 메서드 끝");
		return list;
	}
		
	// 상품 정보 수정
	public void updateGoods(Goods goods) {
		logger.debug("updateGoods(Goods goods) 메서드 호출");
		logger.debug("updateGoods(Goods goods) 메서드 goods is {}", goods);
		logger.debug("updateGoods(Goods goods) 메서드 끝");
		goodsDao.updateGoods(goods);		
	}
	
	// 상품 1개 조회해서 업데이트에 사용
	public Goods getGoodsOne(Goods goods) {
		logger.debug("getGoodsOne(Goods goods) 메서드 호출");
		logger.debug("getGoodsOne(Goods goods) 메서드 goods", goods);
		Goods GoodsCode = goodsDao.selectGoodsOne(goods);
		logger.debug("getGoodsOne(Goods goods) 메서드 GoodsCode", GoodsCode);
		logger.debug("getGoodsOne(Goods goods) 메서드 끝");
		return GoodsCode;
	}
		
	// 상품 삭제
	public void removeGoods(String goodsCode) {
		logger.debug("removeGoods(String goodsCode) 메서드 호출");
		logger.debug("removeGoods(String goodsCode) 메서드 goodsCode is {}", goodsCode);
		logger.debug("removeGoods(String goodsCode) 메서드 끝");
		goodsDao.deleteGoods(goodsCode);
	}
	
	//상품 한개 상세 조회
	public Goods detailGoods(String goodsCode) {
		logger.debug("detailGoods(String goodsCode) 메서드 호출");
		logger.debug("detailGoods(String goodsCode) 메서드 goodsCode is {}", goodsCode);
		Goods goodsDetail = goodsDao.goodsDetail(goodsCode);
		logger.debug("detailGoods(String goodsCode) 메서드 goodsDetail is {}", goodsDetail);
		logger.debug("detailGoods(String goodsCode) 메서드 끝");
		return goodsDetail;
	}
	
	//장바구니 담기
	public void insertGoodsCart(GoodsCart goodsCart){
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 호출");
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 Goods is {}",goodsCart);
		String pointGoodsCartCode = "point_goods_cart_code";
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 pointGoodsCartCode is {}",pointGoodsCartCode);
		int goodsCartAdd = goodsDao.selectGoodsInfoCodeNumber(pointGoodsCartCode) + 1;
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 goodsCartAdd is {}", goodsCartAdd);
		pointGoodsCartCode += goodsCartAdd;
		goodsCart.setPointGoodsCode(pointGoodsCartCode);
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 goodsCart is {}", goodsCart);
		goodsDao.insertGoodsCart(goodsCart);
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 끝");
	}
}