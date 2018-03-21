package com.cafe24.iso159.member.service;

public class MemberLoginLevel {

	private String mId;
	private String blCode;
	private String mRightGradeName;
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
	public String getmRightGradeName() {
		return mRightGradeName;
	}
	public void setmRightGradeName(String mRightGradeName) {
		this.mRightGradeName = mRightGradeName;
	}
	public String getmRightLevel() {
		return mRightLevel;
	}
	public void setmRightLevel(String mRightLevel) {
		this.mRightLevel = mRightLevel;
	}
	@Override
	public String toString() {
		return "MemberLoginLevel [mId=" + mId + ", blCode=" + blCode + ", mRightGradeName=" + mRightGradeName
				+ ", mRightLevel=" + mRightLevel + "]";
	}
	
	
}
