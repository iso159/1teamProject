package com.cafe24.iso159.member.service;

public class MemberInfo {

	private String mInfoCode;
	private String mInfoName;
	private String mInfoNickname;
	private String mInfoGender;
	private String mInfoBirth;
	private String mInfoPostcode;
	private String mInfoAddress;
	private String mInfoEmail;
	private String mInfoPhone;
	private String mInfoJoindate;
	public String getmInfoCode() {
		return mInfoCode;
	}
	public void setmInfoCode(String mInfoCode) {
		this.mInfoCode = mInfoCode;
	}
	public String getmInfoName() {
		return mInfoName;
	}
	public void setmInfoName(String mInfoName) {
		this.mInfoName = mInfoName;
	}
	public String getmInfoNickname() {
		return mInfoNickname;
	}
	public void setmInfoNickname(String mInfoNickname) {
		this.mInfoNickname = mInfoNickname;
	}
	public String getmInfoGender() {
		return mInfoGender;
	}
	public void setmInfoGender(String mInfoGender) {
		this.mInfoGender = mInfoGender;
	}
	public String getmInfoBirth() {
		return mInfoBirth;
	}
	public void setmInfoBirth(String mInfoBirth) {
		this.mInfoBirth = mInfoBirth;
	}
	public String getmInfoPostcode() {
		return mInfoPostcode;
	}
	public void setmInfoPostcode(String mInfoPostcode) {
		this.mInfoPostcode = mInfoPostcode;
	}
	public String getmInfoAddress() {
		return mInfoAddress;
	}
	public void setmInfoAddress(String mInfoAddress) {
		this.mInfoAddress = mInfoAddress;
	}
	public String getmInfoEmail() {
		return mInfoEmail;
	}
	public void setmInfoEmail(String mInfoEmail) {
		this.mInfoEmail = mInfoEmail;
	}
	public String getmInfoPhone() {
		return mInfoPhone;
	}
	public void setmInfoPhone(String mInfoPhone) {
		this.mInfoPhone = mInfoPhone;
	}
	public String getmInfoJoindate() {
		return mInfoJoindate;
	}
	public void setmInfoJoindate(String mInfoJoindate) {
		this.mInfoJoindate = mInfoJoindate;
	}
	@Override
	public String toString() {
		return "MemberInfo [mInfoCode=" + mInfoCode + ", mInfoName=" + mInfoName + ", mInfoNickname=" + mInfoNickname
				+ ", mInfoGender=" + mInfoGender + ", mInfoBirth=" + mInfoBirth + ", mInfoPostcode=" + mInfoPostcode
				+ ", mInfoAddress=" + mInfoAddress + ", mInfoEmail=" + mInfoEmail + ", mInfoPhone=" + mInfoPhone
				+ ", mInfoJoindate=" + mInfoJoindate + "]";
	}
}
