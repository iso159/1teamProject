package com.cafe24.iso159.adopt.service;

public class AdoptRequestFile {
	private String ofCode;
	private String adoptRequestCode;
	private String ofPath;
	private String ofOriginName;
	private String ofSaveName;
	private String ofExt;
	private long ofSize;
	private String ofDownDate;
	
	
	public String getOfCode() {
		return ofCode;
	}
	public void setOfCode(String ofCode) {
		this.ofCode = ofCode;
	}
	public String getAdoptRequestCode() {
		return adoptRequestCode;
	}
	public void setAdoptRequestCode(String adoptRequestCode) {
		this.adoptRequestCode = adoptRequestCode;
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
	public String getOfDownDate() {
		return ofDownDate;
	}
	public void setOfDownDate(String ofDownDate) {
		this.ofDownDate = ofDownDate;
	}
	@Override
	public String toString() {
		return "AdoptRequestFile [ofCode=" + ofCode + ", adoptRequestCode=" + adoptRequestCode + ", ofPath=" + ofPath
				+ ", ofOriginName=" + ofOriginName + ", ofSaveName=" + ofSaveName + ", ofExt=" + ofExt + ", ofSize="
				+ ofSize + ", ofDownDate=" + ofDownDate + "]";
	}
	
	
	
	
	
	
}
