package com.cafe24.iso159.goods.service;

public class GoodsIo {
	private String pointGoodsIoCode;
	private String pointGoodsCode;
	private String osCodeGoodsIo;
	private String mAdminIo;
	private String mMemberIo;
	private String pointGoodsIoCount;
	private String pointGoodsIoDate;

	public String getPointGoodsIoCode() {
		return pointGoodsIoCode;
	}

	public void setPointGoodsIoCode(String pointGoodsIoCode) {
		this.pointGoodsIoCode = pointGoodsIoCode;
	}

	public String getPointGoodsCode() {
		return pointGoodsCode;
	}

	public void setPointGoodsCode(String pointGoodsCode) {
		this.pointGoodsCode = pointGoodsCode;
	}

	public String getOsCodeGoodsIo() {
		return osCodeGoodsIo;
	}

	public void setOsCodeGoodsIo(String osCodeGoodsIo) {
		this.osCodeGoodsIo = osCodeGoodsIo;
	}

	public String getmAdminIo() {
		return mAdminIo;
	}

	public void setmAdminIo(String mAdminIo) {
		this.mAdminIo = mAdminIo;
	}

	public String getmMemberIo() {
		return mMemberIo;
	}

	public void setmMemberIo(String mMemberIo) {
		this.mMemberIo = mMemberIo;
	}

	public String getPointGoodsIoCount() {
		return pointGoodsIoCount;
	}

	public void setPointGoodsIoCount(String pointGoodsIoCount) {
		this.pointGoodsIoCount = pointGoodsIoCount;
	}

	public String getPointGoodsIoDate() {
		return pointGoodsIoDate;
	}

	public void setPointGoodsIoDate(String pointGoodsIoDate) {
		this.pointGoodsIoDate = pointGoodsIoDate;
	}

	@Override
	public String toString() {
		return "PointGoodsIo [pointGoodsIoCode=" + pointGoodsIoCode + ", pointGoodsCode=" + pointGoodsCode
				+ ", osCodeGoodsIo=" + osCodeGoodsIo + ", mAdminIo=" + mAdminIo + ", mMemberIo=" + mMemberIo
				+ ", pointGoodsIoCount=" + pointGoodsIoCount + ", pointGoodsIoDate=" + pointGoodsIoDate + "]";
	}

}
