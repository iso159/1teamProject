package com.cafe24.iso159.exp.service;

public class CostIo {
	private String costIoCode;
	private String expCode;
	private String osCode;
	private int costIoCost;
	
	@Override
	public String toString() {
		return "CostIo [costIoCode=" + costIoCode + ", expCode=" + expCode + ", osCode=" + osCode + ", costIoCost="
				+ costIoCost + "]";
	}
	public String getCostIoCode() {
		return costIoCode;
	}
	public void setCostIoCode(String costIoCode) {
		this.costIoCode = costIoCode;
	}
	public String getExpCode() {
		return expCode;
	}
	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}
	public String getOsCode() {
		return osCode;
	}
	public void setOsCode(String osCode) {
		this.osCode = osCode;
	}
	public int getCostIoCost() {
		return costIoCost;
	}
	public void setCostIoCost(int costIoCost) {
		this.costIoCost = costIoCost;
	}
	
}
