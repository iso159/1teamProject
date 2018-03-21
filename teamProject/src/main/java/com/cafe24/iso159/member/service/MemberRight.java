package com.cafe24.iso159.member.service;

public class MemberRight {

	private String mRightCode;
	private String mRightName;
	private String mRightLevel;
	private String mRightGradeName;
	private String mRightGradeLevel;

	public String getmRightCode() {
		return mRightCode;
	}

	public void setmRightCode(String mRightCode) {
		this.mRightCode = mRightCode;
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

	public String getmRightGradeName() {
		return mRightGradeName;
	}

	public void setmRightGradeName(String mRightGradeName) {
		this.mRightGradeName = mRightGradeName;
	}

	public String getmRightGradeLevel() {
		return mRightGradeLevel;
	}

	public void setmRightGradeLevel(String mRightGradeLevel) {
		this.mRightGradeLevel = mRightGradeLevel;
	}

	@Override
	public String toString() {
		return "MemberRight [mRightCode=" + mRightCode + ", mRightName=" + mRightName + ", mRightLevel=" + mRightLevel
				+ ", mRightGradeName=" + mRightGradeName + ", mRightGradeLevel=" + mRightGradeLevel + "]";
	}

}
