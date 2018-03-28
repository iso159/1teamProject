package com.cafe24.iso159.adopt.service;

public class AdoptRequestAndOsCodeAnimal {
	private String osCodeAnimal;
	private String adoptRequestCode;
	private AdoptRequest adoptRequest;
	public String getOsCodeAnimal() {
		return osCodeAnimal;
	}
	public void setOsCodeAnimal(String osCodeAnimal) {
		this.osCodeAnimal = osCodeAnimal;
	}
	public String getAdoptRequestCode() {
		return adoptRequestCode;
	}
	public void setAdoptRequestCode(String adoptRequestCode) {
		this.adoptRequestCode = adoptRequestCode;
	}
	public AdoptRequest getAdoptRequest() {
		return adoptRequest;
	}
	public void setAdoptRequest(AdoptRequest adoptRequest) {
		this.adoptRequest = adoptRequest;
	}
	@Override
	public String toString() {
		return "AdoptRequestAndOsCodeAnimal [osCodeAnimal=" + osCodeAnimal + ", adoptRequestCode=" + adoptRequestCode
				+ ", adoptRequest=" + adoptRequest + "]";
	}
	
	
	
}
