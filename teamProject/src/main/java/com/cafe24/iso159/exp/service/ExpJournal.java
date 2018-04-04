package com.cafe24.iso159.exp.service;

public class ExpJournal {
	private String expJournalCode;
	private String expCode;
	private String mExpId;
	private String expJournal;
	private int expJournalPoint;
	private String expJournalAnimalChar;
	private String expJournalDate;
	
	@Override
	public String toString() {
		return "ExpJournal [expJournalCode=" + expJournalCode + ", expCode=" + expCode + ", mExpId=" + mExpId
				+ ", expJournal=" + expJournal + ", expJournalPoint=" + expJournalPoint + ", expJournalAnimalChar="
				+ expJournalAnimalChar + ", expJournalDate=" + expJournalDate + "]";
	}
	public String getExpJournalCode() {
		return expJournalCode;
	}
	public void setExpJournalCode(String expJournalCode) {
		this.expJournalCode = expJournalCode;
	}
	public String getExpCode() {
		return expCode;
	}
	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}
	public String getmExpId() {
		return mExpId;
	}
	public void setmExpId(String mExpId) {
		this.mExpId = mExpId;
	}
	public String getExpJournal() {
		return expJournal;
	}
	public void setExpJournal(String expJournal) {
		this.expJournal = expJournal;
	}
	public int getExpJournalPoint() {
		return expJournalPoint;
	}
	public void setExpJournalPoint(int expJournalPoint) {
		this.expJournalPoint = expJournalPoint;
	}
	public String getExpJournalAnimalChar() {
		return expJournalAnimalChar;
	}
	public void setExpJournalAnimalChar(String expJournalAnimalChar) {
		this.expJournalAnimalChar = expJournalAnimalChar;
	}
	public String getExpJournalDate() {
		return expJournalDate;
	}
	public void setExpJournalDate(String expJournalDate) {
		this.expJournalDate = expJournalDate;
	}
	
	
}
