package com.cafe24.iso159.adopt.service;

public class Adopt {
	private String adoptCode;
	private String blCode;
	private String animalCode;
	private String adoptRequestCode;
	private String mMemberId;
	private String mAdminId;
	
	
	public String getAdoptCode() {
		return adoptCode;
	}
	public void setAdoptCode(String adoptCode) {
		this.adoptCode = adoptCode;
	}
	public String getBlCode() {
		return blCode;
	}
	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}
	public String getAnimalCode() {
		return animalCode;
	}
	public void setAnimalCode(String animalCode) {
		this.animalCode = animalCode;
	}
	public String getAdoptRequestCode() {
		return adoptRequestCode;
	}
	public void setAdoptRequestCode(String adoptRequestCode) {
		this.adoptRequestCode = adoptRequestCode;
	}
	public String getmMemberId() {
		return mMemberId;
	}
	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
	}
	public String getmAdminId() {
		return mAdminId;
	}
	public void setmAdminId(String mAdminId) {
		this.mAdminId = mAdminId;
	}
	@Override
	public String toString() {
		return "Adopt [adoptCode=" + adoptCode + ", blCode=" + blCode + ", animalCode=" + animalCode
				+ ", adoptRequestCode=" + adoptRequestCode + ", mMemberId=" + mMemberId + ", mAdminId=" + mAdminId
				+ "]";
	}
	
	
}
