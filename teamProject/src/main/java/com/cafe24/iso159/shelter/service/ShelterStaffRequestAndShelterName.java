package com.cafe24.iso159.shelter.service;

public class ShelterStaffRequestAndShelterName {
	private String primaryCode;
	private String blShelterName;
	private ShelterStaffRequest shelterStaffRequest;
	public String getPrimaryCode() {
		return primaryCode;
	}
	public void setPrimaryCode(String primaryCode) {
		this.primaryCode = primaryCode;
	}
	public String getBlShelterName() {
		return blShelterName;
	}
	public void setBlShelterName(String blShelterName) {
		this.blShelterName = blShelterName;
	}
	public ShelterStaffRequest getShelterStaffRequest() {
		return shelterStaffRequest;
	}
	public void setShelterStaffRequest(ShelterStaffRequest shelterStaffRequest) {
		this.shelterStaffRequest = shelterStaffRequest;
	}
	@Override
	public String toString() {
		return "ShelterStaffRequestAndShelterName [primaryCode=" + primaryCode + ", blShelterName=" + blShelterName
				+ ", shelterStaffRequest=" + shelterStaffRequest + "]";
	}
	
}
