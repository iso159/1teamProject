package com.cafe24.iso159.shelter.service;

public class ShelterStaffRequest {
	private String ssrCode; 
	private String mId;
	private String blCode;
	private String osCodeStaffRequest;
	private String ssrRequestDate;
	private String ssrClearDate;
	public String getSsrCode() {
		return ssrCode;
	}
	public void setSsrCode(String ssrCode) {
		this.ssrCode = ssrCode;
	}
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
	public String getOsCodeStaffRequest() {
		return osCodeStaffRequest;
	}
	public void setOsCodeStaffRequest(String osCodeStaffRequest) {
		this.osCodeStaffRequest = osCodeStaffRequest;
	}
	public String getSsrRequestDate() {
		return ssrRequestDate;
	}
	public void setSsrRequestDate(String ssrRequestDate) {
		this.ssrRequestDate = ssrRequestDate;
	}
	public String getSsrClearDate() {
		return ssrClearDate;
	}
	public void setSsrClearDate(String ssrClearDate) {
		this.ssrClearDate = ssrClearDate;
	}
	@Override
	public String toString() {
		return "ShelterStaffRequest [ssrCode=" + ssrCode + ", mId=" + mId + ", blCode=" + blCode
				+ ", osCodeStaffRequest=" + osCodeStaffRequest + ", ssrRequestDate=" + ssrRequestDate
				+ ", ssrClearDate=" + ssrClearDate + "]";
	}
	
}
