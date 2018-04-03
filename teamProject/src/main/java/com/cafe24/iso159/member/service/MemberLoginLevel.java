package com.cafe24.iso159.member.service;

public class MemberLoginLevel {

	private String mId;
	private String blCode;
	private String mRightName;
	private String mRightLevel;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getBlCode() {
		return blCode;
	}

	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}

	public String getmRightName() {
		return mRightName;
	}

	public void setmRightName(String mRightName) {
		this.mRightName = mRightName;
	}

	public String getmRightLevel() {
		return mRightLevel;
	}

	public void setmRightLevel(String mRightLevel) {
		this.mRightLevel = mRightLevel;
	}

	@Override
	public String toString() {
		return "MemberLoginLevel [mId=" + mId + ", blCode=" + blCode + ", mRightName=" + mRightName + ", mRightLevel="
				+ mRightLevel + "]";
	}

}
