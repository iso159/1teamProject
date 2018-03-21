package com.cafe24.iso159.member.service;

public class Member {

	private String mId;
	private String mInfoCode;
	private String blCode;
	private String mRightCode;
	private String mPw;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmInfoCode() {
		return mInfoCode;
	}

	public void setmInfoCode(String mInfoCode) {
		this.mInfoCode = mInfoCode;
	}

	public String getBlCode() {
		return blCode;
	}

	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}

	public String getmRightCode() {
		return mRightCode;
	}

	public void setmRightCode(String mRightCode) {
		this.mRightCode = mRightCode;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mInfoCode=" + mInfoCode + ", blCode=" + blCode + ", mRightCode=" + mRightCode
				+ ", mPw=" + mPw + "]";
	}

}
