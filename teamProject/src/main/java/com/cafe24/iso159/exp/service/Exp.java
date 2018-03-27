package com.cafe24.iso159.exp.service;

public class Exp {
	private String expCode;
	private String animalCode;
	private String mExpId;
	private String mShelterId;
	private String blCode;
	private String expPeriodCode;
	private String osCodeExp;
	private String osCodeCostReturn;
	private int expJournalCount;
	private int expCost;
	private String expPurpose;
	private String expReserveRequestDate;
	private String expCheckDate;
	private String expStartDate;
	private String expEndDate;
	private String expModifiedDate;
	@Override
	public String toString() {
		return "Exp [expCode=" + expCode + ", animalCode=" + animalCode + ", mExpId=" + mExpId + ", mShelterId="
				+ mShelterId + ", blCode=" + blCode + ", expPeriodCode=" + expPeriodCode + ", osCodeExp=" + osCodeExp
				+ ", osCodeCostReturn=" + osCodeCostReturn + ", expJournalCount=" + expJournalCount + ", expCost="
				+ expCost + ", expPurpose=" + expPurpose + ", expReserveRequestDate=" + expReserveRequestDate
				+ ", expCheckDate=" + expCheckDate + ", expStartDate=" + expStartDate + ", expEndDate=" + expEndDate
				+ ", expModifiedDate=" + expModifiedDate + "]";
	}
	public String getExpCode() {
		return expCode;
	}
	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}
	public String getAnimalCode() {
		return animalCode;
	}
	public void setAnimalCode(String animalCode) {
		this.animalCode = animalCode;
	}
	public String getmExpId() {
		return mExpId;
	}
	public void setmExpId(String mExpId) {
		this.mExpId = mExpId;
	}
	public String getmShelterId() {
		return mShelterId;
	}
	public void setmShelterId(String mShelterId) {
		this.mShelterId = mShelterId;
	}
	public String getBlCode() {
		return blCode;
	}
	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}
	public String getExpPeriodCode() {
		return expPeriodCode;
	}
	public void setExpPeriodCode(String expPeriodCode) {
		this.expPeriodCode = expPeriodCode;
	}
	public String getOsCodeExp() {
		return osCodeExp;
	}
	public void setOsCodeExp(String osCodeExp) {
		this.osCodeExp = osCodeExp;
	}
	public String getOsCodeCostReturn() {
		return osCodeCostReturn;
	}
	public void setOsCodeCostReturn(String osCodeCostReturn) {
		this.osCodeCostReturn = osCodeCostReturn;
	}
	public int getExpJournalCount() {
		return expJournalCount;
	}
	public void setExpJournalCount(int expJournalCount) {
		this.expJournalCount = expJournalCount;
	}
	public int getExpCost() {
		return expCost;
	}
	public void setExpCost(int expCost) {
		this.expCost = expCost;
	}
	public String getExpPurpose() {
		return expPurpose;
	}
	public void setExpPurpose(String expPurpose) {
		this.expPurpose = expPurpose;
	}
	public String getExpReserveRequestDate() {
		return expReserveRequestDate;
	}
	public void setExpReserveRequestDate(String expReserveRequestDate) {
		this.expReserveRequestDate = expReserveRequestDate;
	}
	public String getExpCheckDate() {
		return expCheckDate;
	}
	public void setExpCheckDate(String expCheckDate) {
		this.expCheckDate = expCheckDate;
	}
	public String getExpStartDate() {
		return expStartDate;
	}
	public void setExpStartDate(String expStartDate) {
		this.expStartDate = expStartDate;
	}
	public String getExpEndDate() {
		return expEndDate;
	}
	public void setExpEndDate(String expEndDate) {
		this.expEndDate = expEndDate;
	}
	public String getExpModifiedDate() {
		return expModifiedDate;
	}
	public void setExpModifiedDate(String expModifiedDate) {
		this.expModifiedDate = expModifiedDate;
	}

}
