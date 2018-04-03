package com.cafe24.iso159.shelter.service;

public class BusinessLicense {
	private String blCode;
	private String mMemberId;
	private String osCodeLicenseStatus;
	private String blShelterName;
	private String blShelterNumber;
	private String blShelterRegNumber;
	private String blShelterAddress;
	private String blShelterDenyReason;
	private String blShelterDate;
	public String getBlCode() {
		return blCode;
	}
	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}
	public String getmMemberId() {
		return mMemberId;
	}
	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
	}
	public String getOsCodeLicenseStatus() {
		return osCodeLicenseStatus;
	}
	public void setOsCodeLicenseStatus(String osCodeLicenseStatus) {
		this.osCodeLicenseStatus = osCodeLicenseStatus;
	}
	public String getBlShelterName() {
		return blShelterName;
	}
	public void setBlShelterName(String blShelterName) {
		this.blShelterName = blShelterName;
	}
	public String getBlShelterNumber() {
		return blShelterNumber;
	}
	public void setBlShelterNumber(String blShelterNumber) {
		this.blShelterNumber = blShelterNumber;
	}
	public String getBlShelterRegNumber() {
		return blShelterRegNumber;
	}
	public void setBlShelterRegNumber(String blShelterRegNumber) {
		this.blShelterRegNumber = blShelterRegNumber;
	}
	public String getBlShelterAddress() {
		return blShelterAddress;
	}
	public void setBlShelterAddress(String blShelterAddress) {
		this.blShelterAddress = blShelterAddress;
	}
	public String getBlShelterDenyReason() {
		return blShelterDenyReason;
	}
	public void setBlShelterDenyReason(String blShelterDenyReason) {
		this.blShelterDenyReason = blShelterDenyReason;
	}
	public String getBlShelterDate() {
		return blShelterDate;
	}
	public void setBlShelterDate(String blShelterDate) {
		this.blShelterDate = blShelterDate;
	}
	@Override
	public String toString() {
		return "BusinessLicense [blCode=" + blCode + ", mMemberId=" + mMemberId + ", osCodeLicenseStatus="
				+ osCodeLicenseStatus + ", blShelterName=" + blShelterName + ", blShelterNumber=" + blShelterNumber
				+ ", blShelterRegNumber=" + blShelterRegNumber + ", blShelterAddress=" + blShelterAddress
				+ ", blShelterDenyReason=" + blShelterDenyReason + ", blShelterDate=" + blShelterDate + "]";
	}
	
}
