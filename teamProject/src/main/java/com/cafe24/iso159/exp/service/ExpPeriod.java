package com.cafe24.iso159.exp.service;

public class ExpPeriod {
	private String expPeriodCode;
	private String expPeriodPeriod;
	private String expPeriodLevel;
	private int expPeriodCost;
	private String expPeriodCostLevel;
	private int expPeriodCostMinus;
	private int expPeriodJournalCount;
	
	@Override
	public String toString() {
		return "ExpPeriod [expPeriodCode=" + expPeriodCode + ", expPeriodPeriod=" + expPeriodPeriod
				+ ", expPeriodLevel=" + expPeriodLevel + ", expPeriodCost=" + expPeriodCost + ", expPeriodCostLevel="
				+ expPeriodCostLevel + ", expPeriodCostMinus=" + expPeriodCostMinus + ", expPeriodJournalCount="
				+ expPeriodJournalCount + "]";
	}
	
	public String getExpPeriodCode() {
		return expPeriodCode;
	}
	public void setExpPeriodCode(String expPeriodCode) {
		this.expPeriodCode = expPeriodCode;
	}
	public String getExpPeriodPeriod() {
		return expPeriodPeriod;
	}
	public void setExpPeriodPeriod(String expPeriodPeriod) {
		this.expPeriodPeriod = expPeriodPeriod;
	}
	public String getExpPeriodLevel() {
		return expPeriodLevel;
	}
	public void setExpPeriodLevel(String expPeriodLevel) {
		this.expPeriodLevel = expPeriodLevel;
	}
	public int getExpPeriodCost() {
		return expPeriodCost;
	}
	public void setExpPeriodCost(int expPeriodCost) {
		this.expPeriodCost = expPeriodCost;
	}
	public String getExpPeriodCostLevel() {
		return expPeriodCostLevel;
	}
	public void setExpPeriodCostLevel(String expPeriodCostLevel) {
		this.expPeriodCostLevel = expPeriodCostLevel;
	}
	public int getExpPeriodCostMinus() {
		return expPeriodCostMinus;
	}
	public void setExpPeriodCostMinus(int expPeriodCostMinus) {
		this.expPeriodCostMinus = expPeriodCostMinus;
	}
	public int getExpPeriodJournalCount() {
		return expPeriodJournalCount;
	}
	public void setExpPeriodJournalCount(int expPeriodJournalCount) {
		this.expPeriodJournalCount = expPeriodJournalCount;
	}
}
