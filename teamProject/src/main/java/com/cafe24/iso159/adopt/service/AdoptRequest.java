package com.cafe24.iso159.adopt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdoptRequest {
	private static final Logger logger = LoggerFactory.getLogger(AdoptRequest.class);
	private String adoptRequestCode;
	private String animalCode;
	private String blCode;
	private String mMemberId;
	private String mShelterId;
	private String osCodeAdopt;
	private String adoptRequestReason;
	private String adoptRequestAdviceContents;
	private String adoptRequestDate;
	private String adoptRequestAdviceDate;
	private String adoptDecideDate;
	private String adoptRefusedReason;
	private int adoptPoint;
	
	
	public String getAdoptRequestCode() {
		return adoptRequestCode;
	}
	public void setAdoptRequestCode(String adoptRequestCode) {
		this.adoptRequestCode = adoptRequestCode;
	}
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
	public String getAdoptRequestAdviceContents() {
		return adoptRequestAdviceContents;
	}
	public void setAdoptRequestAdviceContents(String adoptRequestAdviceContents) {
		this.adoptRequestAdviceContents = adoptRequestAdviceContents;
	}
	public String getAdoptRequestDate() {
		return adoptRequestDate;
	}
	public void setAdoptRequestDate(String adoptRequestDate) {
		this.adoptRequestDate = adoptRequestDate;
	}
	public String getAdoptRequestAdviceDate() {
		return adoptRequestAdviceDate;
	}
	public void setAdoptRequestAdviceDate(String adoptRequestAdviceDate) {
		this.adoptRequestAdviceDate = adoptRequestAdviceDate;
	}
	public String getAdoptDecideDate() {
		return adoptDecideDate;
	}
	public void setAdoptDecideDate(String adoptDecideDate) {
		this.adoptDecideDate = adoptDecideDate;
	}
	public String getAdoptRefusedReason() {
		return adoptRefusedReason;
	}
	public void setAdoptRefusedReason(String adoptRefusedReason) {
		this.adoptRefusedReason = adoptRefusedReason;
	}
	public int getAdoptPoint() {
		return adoptPoint;
	}
	public void setAdoptPoint(int adoptPoint) {
		this.adoptPoint = adoptPoint;
	}
	public static Logger getLogger() {
		return logger;
	}
	@Override
	public String toString() {
		return "AdoptRequest [adoptRequestCode=" + adoptRequestCode + ", animalCode=" + animalCode + ", blCode="
				+ blCode + ", mMemberId=" + mMemberId + ", mShelterId=" + mShelterId + ", osCodeAdopt=" + osCodeAdopt
				+ ", adoptRequestReason=" + adoptRequestReason + ", adoptRequestAdviceContents="
				+ adoptRequestAdviceContents + ", adoptRequestDate=" + adoptRequestDate + ", adoptRequestAdviceDate="
				+ adoptRequestAdviceDate + ", adoptDecideDate=" + adoptDecideDate + ", adoptRefusedReason="
				+ adoptRefusedReason + ", adoptPoint=" + adoptPoint + "]";
	}
	
	
	
}
