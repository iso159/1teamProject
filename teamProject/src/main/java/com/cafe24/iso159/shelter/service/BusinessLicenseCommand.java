package com.cafe24.iso159.shelter.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BusinessLicenseCommand {
	private String mMemberId;
	private String blShelterName;
	private String blShelterNumber;
	private String blShelterPostcode;
	private String blShelterAddress;
	private List<MultipartFile> multipartFile;
	public String getmMemberId() {
		return mMemberId;
	}
	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
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
	public String getBlShelterPostcode() {
		return blShelterPostcode;
	}
	public void setBlShelterPostcode(String blShelterPostcode) {
		this.blShelterPostcode = blShelterPostcode;
	}
	public String getBlShelterAddress() {
		return blShelterAddress;
	}
	public void setBlShelterAddress(String blShelterAddress) {
		this.blShelterAddress = blShelterAddress;
	}
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "BusinessLicenseCommand [mMemberId=" + mMemberId + ", blShelterName=" + blShelterName
				+ ", blShelterNumber=" + blShelterNumber + ", blShelterPostcode=" + blShelterPostcode
				+ ", blShelterAddress=" + blShelterAddress + ", multipartFile=" + multipartFile + "]";
	}

	
}
