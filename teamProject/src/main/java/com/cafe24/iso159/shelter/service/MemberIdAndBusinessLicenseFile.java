package com.cafe24.iso159.shelter.service;

import java.util.List;

public class MemberIdAndBusinessLicenseFile {
	private String mMemberId;
	private List<BusinessLicenseFile> businessLicenseFileList;
	public String getmMemberId() {
		return mMemberId;
	}
	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
	}
	public List<BusinessLicenseFile> getBusinessLicenseFileList() {
		return businessLicenseFileList;
	}
	public void setBusinessLicenseFileList(List<BusinessLicenseFile> businessLicenseFileList) {
		this.businessLicenseFileList = businessLicenseFileList;
	}
	@Override
	public String toString() {
		return "MemberIdAndBusinessLicenseFile [mMemberId=" + mMemberId + ", businessLicenseFileList="
				+ businessLicenseFileList + "]";
	}
	
}
