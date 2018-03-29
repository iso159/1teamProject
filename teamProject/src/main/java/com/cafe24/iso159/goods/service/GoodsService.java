package com.cafe24.iso159.goods.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iso159.goods.service.Goods;



@Service
@Transactional
public class GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);

	//상품등록
	public void addGoods(Goods goods){
		logger.debug("1.addGoods()메서드 Goods is {}",goods);
		String pointGoodsCode = "point_goods_code";
		/*goods.setmAdminId(pointGoodsCode);*/
		int mInfoCodeNumber = goodsDao.selectGoodsInfoCodeNumber(pointGoodsCode) + 1;
		logger.debug("2.addGoods(GoodsInfo goodsInfo) 메서드 mInfoCodeNumber is {}", mInfoCodeNumber);
		pointGoodsCode += mInfoCodeNumber;
		goods.setPointGoodsCode(pointGoodsCode);
		logger.debug("3.addGoods(Goods goods, String mAdminId) 메서드 goodsInfo is {}", goods);
		goodsDao.insertGoods(goods);
	}
	
	// 상품 리스트 전체 리스트 조회
	public List<Goods> getGoodsList() {
		logger.debug("getGoodsList() 메서드 호출");
		List<Goods> list = goodsDao.selectGoodsList();
		logger.debug("getGoodsList() 메서드 list is {}", list);
		return list;
	}
}