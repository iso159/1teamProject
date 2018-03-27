package com.cafe24.iso159.exp.service;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.shelter.service.BusinessLicense;

public class ExpAndAnimalAndBusinessLicense {
	private Exp exp;
	private Animal animal;
	private BusinessLicense businessLicense;
	private String osName;
	
	@Override
	public String toString() {
		return "ExpAndAnimalAndBusinessLicense [exp=" + exp + ", animal=" + animal + ", businessLicense="
				+ businessLicense + ", osName=" + osName + "]";
	}
	
	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public BusinessLicense getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(BusinessLicense businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	
}
