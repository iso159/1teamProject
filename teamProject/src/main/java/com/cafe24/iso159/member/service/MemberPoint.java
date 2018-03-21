package com.cafe24.iso159.member.service;

public class MemberPoint {

	private String mPointCode;
	private String pointListCode;
	private String mMemberId;
	private String mShelterId;
	private int mPointFluidPoint;
	private String mPointFluidDate;

	public String getmPointCode() {
		return mPointCode;
	}

	public void setmPointCode(String mPointCode) {
		this.mPointCode = mPointCode;
	}

	public String getPointListCode() {
		return pointListCode;
	}

	public void setPointListCode(String pointListCode) {
		this.pointListCode = pointListCode;
	}

	public String getmMemberId() {
		return mMemberId;
	}

	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
	}

	public String getmShelterId() {
		return mShelterId;
	}

	public void setmShelterId(String mShelterId) {
		this.mShelterId = mShelterId;
	}

	public int getmPointFluidPoint() {
		return mPointFluidPoint;
	}

	public void setmPointFluidPoint(int mPointFluidPoint) {
		this.mPointFluidPoint = mPointFluidPoint;
	}

	public String getmPointFluidDate() {
		return mPointFluidDate;
	}

	public void setmPointFluidDate(String mPointFluidDate) {
		this.mPointFluidDate = mPointFluidDate;
	}

	@Override
	public String toString() {
		return "MemberPoint [mPointCode=" + mPointCode + ", pointListCode=" + pointListCode + ", mMemberId=" + mMemberId
				+ ", mShelterId=" + mShelterId + ", mPointFluidPoint=" + mPointFluidPoint + ", mPointFluidDate="
				+ mPointFluidDate + "]";
	}

}
