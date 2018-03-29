package com.cafe24.iso159.goods.service;

public class Goods {
	private String pointGoodsCode;
	private String mAdminId;
	private String pointGoodsName;
	private int pointGoodsPoint;
	private String pointGoodsDesc;
	private String pointGoodsDate;

	public String getPointGoodsCode() {
		return pointGoodsCode;
	}

	public void setPointGoodsCode(String pointGoodsCode) {
		this.pointGoodsCode = pointGoodsCode;
	}

	public String getmAdminId() {
		return mAdminId;
	}

	public void setmAdminId(String mAdminId) {
		this.mAdminId = mAdminId;
	}

	public String getPointGoodsName() {
		return pointGoodsName;
	}

	public void setPointGoodsName(String pointGoodsName) {
		this.pointGoodsName = pointGoodsName;
	}

	public int getPointGoodsPoint() {
		return pointGoodsPoint;
	}

	public void setPointGoodsPoint(int pointGoodsPoint) {
		this.pointGoodsPoint = pointGoodsPoint;
	}

	public String getPointGoodsDesc() {
		return pointGoodsDesc;
	}

	public void setPointGoodsDesc(String pointGoodsDesc) {
		this.pointGoodsDesc = pointGoodsDesc;
	}

	public String getPointGoodsDate() {
		return pointGoodsDate;
	}

	public void setPointGoodsDate(String pointGoodsDate) {
		this.pointGoodsDate = pointGoodsDate;
	}

	@Override
	public String toString() {
		return "Goods [pointGoodsCode=" + pointGoodsCode + ", mAdminId=" + mAdminId + ", pointGoodsName="
				+ pointGoodsName + ", pointGoodsPoint=" + pointGoodsPoint + ", pointGoodsDesc=" + pointGoodsDesc
				+ ", pointGoodsDate=" + pointGoodsDate + "]";
	}

}
