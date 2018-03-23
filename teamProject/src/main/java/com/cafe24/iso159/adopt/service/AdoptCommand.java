package com.cafe24.iso159.adopt.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class AdoptCommand {
	private String animalCode;
	private String blCode;
	private String mMemberId;
	private String mShelterId;
	private String osCodeAdopt;
	private String adoptRequestReason;
	private String adoptRequestDate;
	private int adoptPoint;
	private List<MultipartFile> file;
	
	
	public String getAnimalCode() {
		return animalCode;
	}
	public void setAnimalCode(String animalCode) {
		this.animalCode = animalCode;
	}
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
	public String getmShelterId() {
		return mShelterId;
	}
	public void setmShelterId(String mShelterId) {
		this.mShelterId = mShelterId;
	}
	public String getOsCodeAdopt() {
		return osCodeAdopt;
	}
	public void setOsCodeAdopt(String osCodeAdopt) {
		this.osCodeAdopt = osCodeAdopt;
	}
	public String getAdoptRequestReason() {
		return adoptRequestReason;
	}
	public void setAdoptRequestReason(String adoptRequestReason) {
		this.adoptRequestReason = adoptRequestReason;
	}
	public String getAdoptRequestDate() {
		return adoptRequestDate;
	}
	public void setAdoptRequestDate(String adoptRequestDate) {
		this.adoptRequestDate = adoptRequestDate;
	}
	public int getAdoptPoint() {
		return adoptPoint;
	}
	public void setAdoptPoint(int adoptPoint) {
		this.adoptPoint = adoptPoint;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "AdoptCommand [animalCode=" + animalCode + ", blCode=" + blCode + ", mMemberId=" + mMemberId
				+ ", mShelterId=" + mShelterId + ", osCodeAdopt=" + osCodeAdopt + ", adoptRequestReason="
				+ adoptRequestReason + ", adoptRequestDate=" + adoptRequestDate + ", adoptPoint=" + adoptPoint
				+ ", file=" + file + "]";
	}
	
	
}
