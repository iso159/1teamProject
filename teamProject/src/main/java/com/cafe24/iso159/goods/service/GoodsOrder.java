package com.cafe24.iso159.goods.service;

public class GoodsOrder {
	private String pointGoodsOrderCode;
	private String mMemberId;
	private String pointGoodsOrderDate;

	public String getPointGoodsOrderCode() {
		return pointGoodsOrderCode;
	}

	public void setPointGoodsOrderCode(String pointGoodsOrderCode) {
		this.pointGoodsOrderCode = pointGoodsOrderCode;
	}

	public String getmMemberId() {
		return mMemberId;
	}

	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
	}

	public String getPointGoodsOrderDate() {
		return pointGoodsOrderDate;
	}

	public void setPointGoodsOrderDate(String pointGoodsOrderDate) {
		this.pointGoodsOrderDate = pointGoodsOrderDate;
	}

	@Override
	public String toString() {
		return "PointGoodsOrder [pointGoodsOrderCode=" + pointGoodsOrderCode + ", mMemberId=" + mMemberId
				+ ", pointGoodsOrderDate=" + pointGoodsOrderDate + "]";
	}

}
