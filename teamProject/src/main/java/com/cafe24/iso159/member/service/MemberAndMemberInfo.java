package com.cafe24.iso159.member.service;

public class MemberAndMemberInfo {

	private String mId;
	private MemberInfo memberInfo;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	@Override
	public String toString() {
		return "MemberAndMemberInfo [mId=" + mId + ", memberInfo=" + memberInfo + "]";
	}

}
