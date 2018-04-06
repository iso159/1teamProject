package com.cafe24.iso159.jindan.service;

public class Jindan {
	private String jindanCode;
	private String animalCode;
	private String blCode;
	private String mShelterId;
	private String osCodeMedical;
	private String jindanExpostPoint;
	private String jindanOverallOpinion;
	private String jindanDate;
	public String getJindanCode() {
		return jindanCode;
	}
	public void setJindanCode(String jindanCode) {
		this.jindanCode = jindanCode;
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
	public String getmShelterId() {
		return mShelterId;
	}
	public void setmShelterId(String mShelterId) {
		this.mShelterId = mShelterId;
	}
	public String getOsCodeMedical() {
		return osCodeMedical;
	}
	public void setOsCodeMedical(String osCodeMedical) {
		this.osCodeMedical = osCodeMedical;
	}
	public String getJindanExpostPoint() {
		return jindanExpostPoint;
	}
	public void setJindanExpostPoint(String jindanExpostPoint) {
		this.jindanExpostPoint = jindanExpostPoint;
	}
	public String getJindanOverallOpinion() {
		return jindanOverallOpinion;
	}
	public void setJindanOverallOpinion(String jindanOverallOpinion) {
		this.jindanOverallOpinion = jindanOverallOpinion;
	}
	public String getJindanDate() {
		return jindanDate;
	}
	public void setJindanDate(String jindanDate) {
		this.jindanDate = jindanDate;
	}
	@Override
	public String toString() {
		return "Jindan [jindanCode=" + jindanCode + ", animalCode=" + animalCode + ", blCode=" + blCode
				+ ", mShelterId=" + mShelterId + ", osCodeMedical=" + osCodeMedical + ", jindanExpostPoint="
				+ jindanExpostPoint + ", jindanOverallOpinion=" + jindanOverallOpinion + ", jindanDate=" + jindanDate
				+ "]";
	}	
	
}
