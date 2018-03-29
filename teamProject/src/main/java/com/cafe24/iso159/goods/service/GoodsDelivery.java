package com.cafe24.iso159.goods.service;

public class GoodsDelivery {
	private String pointGoodsDeliveryCode;
	private String pointGoodsOrderCode;
	private String osCodeDelivery;
	private String pointGoodsDeliveryName;
	private String pointGoodsDeliveryAddress;
	private String pointGoodsDeliveryPhone;
	private String pointGoodsDeliveryOrderDate;
	private String pointGoodsDeliveryStartDate;

	public String getPointGoodsDeliveryCode() {
		return pointGoodsDeliveryCode;
	}

	public void setPointGoodsDeliveryCode(String pointGoodsDeliveryCode) {
		this.pointGoodsDeliveryCode = pointGoodsDeliveryCode;
	}

	public String getPointGoodsOrderCode() {
		return pointGoodsOrderCode;
	}

	public void setPointGoodsOrderCode(String pointGoodsOrderCode) {
		this.pointGoodsOrderCode = pointGoodsOrderCode;
	}

	public String getOsCodeDelivery() {
		return osCodeDelivery;
	}

	public void setOsCodeDelivery(String osCodeDelivery) {
		this.osCodeDelivery = osCodeDelivery;
	}

	public String getPointGoodsDeliveryName() {
		return pointGoodsDeliveryName;
	}

	public void setPointGoodsDeliveryName(String pointGoodsDeliveryName) {
		this.pointGoodsDeliveryName = pointGoodsDeliveryName;
	}

	public String getPointGoodsDeliveryAddress() {
		return pointGoodsDeliveryAddress;
	}

	public void setPointGoodsDeliveryAddress(String pointGoodsDeliveryAddress) {
		this.pointGoodsDeliveryAddress = pointGoodsDeliveryAddress;
	}

	public String getPointGoodsDeliveryPhone() {
		return pointGoodsDeliveryPhone;
	}

	public void setPointGoodsDeliveryPhone(String pointGoodsDeliveryPhone) {
		this.pointGoodsDeliveryPhone = pointGoodsDeliveryPhone;
	}

	public String getPointGoodsDeliveryOrderDate() {
		return pointGoodsDeliveryOrderDate;
	}

	public void setPointGoodsDeliveryOrderDate(String pointGoodsDeliveryOrderDate) {
		this.pointGoodsDeliveryOrderDate = pointGoodsDeliveryOrderDate;
	}

	public String getPointGoodsDeliveryStartDate() {
		return pointGoodsDeliveryStartDate;
	}

	public void setPointGoodsDeliveryStartDate(String pointGoodsDeliveryStartDate) {
		this.pointGoodsDeliveryStartDate = pointGoodsDeliveryStartDate;
	}

	@Override
	public String toString() {
		return "pointGoodsDelivery [pointGoodsDeliveryCode=" + pointGoodsDeliveryCode + ", pointGoodsOrderCode="
				+ pointGoodsOrderCode + ", osCodeDelivery=" + osCodeDelivery + ", pointGoodsDeliveryName="
				+ pointGoodsDeliveryName + ", pointGoodsDeliveryAddress=" + pointGoodsDeliveryAddress
				+ ", pointGoodsDeliveryPhone=" + pointGoodsDeliveryPhone + ", pointGoodsDeliveryOrderDate="
				+ pointGoodsDeliveryOrderDate + ", pointGoodsDeliveryStartDate=" + pointGoodsDeliveryStartDate + "]";
	}

}
