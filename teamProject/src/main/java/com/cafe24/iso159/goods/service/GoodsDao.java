package com.cafe24.iso159.goods.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao {
	private static final Logger logger = LoggerFactory.getLogger(GoodsDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private final String nameSpace = "com.cafe24.iso159.goods.service.GoodsMapper.";

	// 상품 등록
	public int insertGoods(Goods goods) {
		logger.debug("insertGoods(Goods goods) 메서드 호출");
		logger.debug("insertGoods()메서드 goods is {}", goods);
		logger.debug("insertGoods(Goods goods) 메서드 끝");
		return sqlSessionTemplate.insert(nameSpace + "insertGoods", goods);
	}

	// 상품 등록 코드 만들기위해 호출
	public int selectGoodsInfoCodeNumber(String mAdminId) {
		logger.debug("selectGoodsInfoCodeNumber(String mAdminId) 메서드 호출");
		logger.debug("selectGoodsInfoCodeNumber(String mAdminId) 메서드 is  mAdminId", mAdminId);
		int result = sqlSessionTemplate.selectOne(nameSpace + "selectGoodsCodeNumber");
		logger.debug("selectGoodsInfoCodeNumber()(int goods) 메서드 result is {}", result);
		logger.debug("selectGoodsInfoCodeNumber(String mAdminId) 메서드 끝");
		return result;
	}

	// goods 테이블 전체 리스트 조회
	public List<Goods> selectGoodsList() {
		logger.debug("selectGoodsList() 메서드 호출");
		List<Goods> list = sqlSessionTemplate.selectList(nameSpace + "selectGoodsList");
		logger.debug("selectGoodsList() 메서드 list is {}", list);
		logger.debug("selectGoodsList() 메서드 끝");
		return list;
	}

	// 상품 수정 맵퍼 호출 메서드
	public void updateGoods(Goods goods) {
		logger.debug("updateGoods(Goods goods) 메서드 호출");
		logger.debug("updateGoods(Goods goods) 메서드 goods is {}", goods);
		sqlSessionTemplate.update(nameSpace + "updateGoods", goods);
		logger.debug("updateGoods(Goods goods) 메서드 끝");
	}

	// Goods 테이블 컬럼 하나만 조회 해서 업데이트에 사용
	public Goods selectGoodsOne(Goods goods2) {
		logger.debug("selectGoodsOne(Goods goods2) 메서드 호출");
		logger.debug("selectGoodsOne(Goods goods2) 메서드 goods2 is {}", goods2);
		Goods goods = sqlSessionTemplate.selectOne(nameSpace + "selectOneGoods", goods2);
		logger.debug("selectGoodsOne(Goods goods2) 메서드 끝");
		return goods;
	}

	// 상품 삭제하기
	public void deleteGoods(String goodsCode) {
		logger.debug("deleteGoods(String goodsCode) 메서드 호출");
		logger.debug("deleteGoods(String goodsCode)메서드 goodsCode is {}", goodsCode);
		sqlSessionTemplate.delete(nameSpace + "deleteGoods", goodsCode);
		logger.debug("deleteGoods(String goodsCode) 메서드 끝");
	}
	
	// 상품 한개 상세조회
	public Goods goodsDetail(String goodsCode) {
		logger.debug("goodsDetail(String goodsCode) 메서드 호출");
		logger.debug("goodsDetail()메서드 goodsCode is {}", goodsCode);
		logger.debug("goodsDetail(String goodsCode) 메서드 끝");
		return sqlSessionTemplate.selectOne(nameSpace+"selectGoodsDetail", goodsCode);
	}
	//장바구니 담기
	public int insertGoodsCart(GoodsCart goodsCart) {
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 호출");
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 goodsCart is {}", goodsCart);
		logger.debug("insertGoodsCart(GoodsCart goodsCart) 메서드 끝");
		return sqlSessionTemplate.insert(nameSpace + "insertGoodsCart", goodsCart);
	}
}