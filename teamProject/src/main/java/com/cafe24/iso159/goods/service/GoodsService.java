package com.cafe24.iso159.goods.service;

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
		logger.debug("2.addMember(MemberInfo memberInfo) 메서드 mInfoCodeNumber is {}", mInfoCodeNumber);
		pointGoodsCode += mInfoCodeNumber;
		goods.setPointGoodsCode(pointGoodsCode);
		logger.debug("3.addGoods(Goods goods, String mAdminId) 메서드 memberInfo is {}", goods);
		goodsDao.insertGoods(goods);
	}
}