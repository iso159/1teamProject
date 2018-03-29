package com.cafe24.iso159.goods.service;

public class PointListCode {
	private String pointListCode;
	private String pointName;
	private String pointNameLevel;
	private String pointPlusMinus;
	private String pointPluminLevel;

	public String getPointListCode() {
		return pointListCode;
	}

	public void setPointListCode(String pointListCode) {
		this.pointListCode = pointListCode;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getPointNameLevel() {
		return pointNameLevel;
	}

	public void setPointNameLevel(String pointNameLevel) {
		this.pointNameLevel = pointNameLevel;
	}

	public String getPointPlusMinus() {
		return pointPlusMinus;
	}

	public void setPointPlusMinus(String pointPlusMinus) {
		this.pointPlusMinus = pointPlusMinus;
	}

	public String getPointPluminLevel() {
		return pointPluminLevel;
	}

	public void setPointPluminLevel(String pointPluminLevel) {
		this.pointPluminLevel = pointPluminLevel;
	}

	@Override
	public String toString() {
		return "PointListCode [pointListCode=" + pointListCode + ", pointName=" + pointName + ", pointNameLevel="
				+ pointNameLevel + ", pointPlusMinus=" + pointPlusMinus + ", pointPluminLevel=" + pointPluminLevel
				+ "]";
	}

}
