package com.cafe24.iso159.shelter.service;

public class BusinessLicenseFile {
	private String ofCode;
	private String blCode;
	private String ofPath;
	private String ofOriginName;
	private String ofSaveName;
	private String ofExt;
	private long ofSize;
	private String ofDate;
	public String getOfCode() {
		return ofCode;
	}
	public void setOfCode(String ofCode) {
		this.ofCode = ofCode;
	}
	public String getBlCode() {
		return blCode;
	}
	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}
	public String getOfPath() {
		return ofPath;
	}
	public void setOfPath(String ofPath) {
		this.ofPath = ofPath;
	}
	public String getOfOriginName() {
		return ofOriginName;
	}
	public void setOfOriginName(String ofOriginName) {
		this.ofOriginName = ofOriginName;
	}
	public String getOfSaveName() {
		return ofSaveName;
	}
	public void setOfSaveName(String ofSaveName) {
		this.ofSaveName = ofSaveName;
	}
	public String getOfExt() {
		return ofExt;
	}
	public void setOfExt(String ofExt) {
		this.ofExt = ofExt;
	}
	public long getOfSize() {
		return ofSize;
	}
	public void setOfSize(long ofSize) {
		this.ofSize = ofSize;
	}
	public String getOfDate() {
		return ofDate;
	}
	public void setOfDate(String ofDate) {
		this.ofDate = ofDate;
	}
	@Override
	public String toString() {
		return "BusinessLicenseFile [ofCode=" + ofCode + ", blCode=" + blCode + ", ofPath=" + ofPath + ", ofOriginName="
				+ ofOriginName + ", ofSaveName=" + ofSaveName + ", ofExt=" + ofExt + ", ofSize=" + ofSize + ", ofDate="
				+ ofDate + "]";
	}

	
}
