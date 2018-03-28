package com.cafe24.iso159.animal.service;

public class AnimalCommand {
	private String osName;
	private String osNameAnimalKind;
	private String animalBreed;
	private String animalArea;
	private String animalIdCode;
	private int animalWeight;
	private int animalAge;
	private String blShelterName;
	private String animalEnrollDate;
	private String animalCode;
	
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getOsNameAnimalKind() {
		return osNameAnimalKind;
	}
	public void setOsNameAnimalKind(String osNameAnimalKind) {
		this.osNameAnimalKind = osNameAnimalKind;
	}
	public String getAnimalBreed() {
		return animalBreed;
	}
	public void setAnimalBreed(String animalBreed) {
		this.animalBreed = animalBreed;
	}
	public String getAnimalArea() {
		return animalArea;
	}
	public void setAnimalArea(String animalArea) {
		this.animalArea = animalArea;
	}
	public String getAnimalIdCode() {
		return animalIdCode;
	}
	public void setAnimalIdCode(String animalIdCode) {
		this.animalIdCode = animalIdCode;
	}
	public int getAnimalWeight() {
		return animalWeight;
	}
	public void setAnimalWeight(int animalWeight) {
		this.animalWeight = animalWeight;
	}
	public int getAnimalAge() {
		return animalAge;
	}
	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}
	public String getBlShelterName() {
		return blShelterName;
	}
	public void setBlShelterName(String blShelterName) {
		this.blShelterName = blShelterName;
	}
	public String getAnimalEnrollDate() {
		return animalEnrollDate;
	}
	public void setAnimalEnrollDate(String animalEnrollDate) {
		this.animalEnrollDate = animalEnrollDate;
	}
	public String getAnimalCode() {
		return animalCode;
	}
	public void setAnimalCode(String animalCode) {
		this.animalCode = animalCode;
	}
	@Override
	public String toString() {
		return "AnimalCommand [osName=" + osName + ", osNameAnimalKind=" + osNameAnimalKind + ", animalBreed="
				+ animalBreed + ", animalArea=" + animalArea + ", animalIdCode=" + animalIdCode + ", animalWeight="
				+ animalWeight + ", animalAge=" + animalAge + ", blShelterName=" + blShelterName + ", animalEnrollDate="
				+ animalEnrollDate + ", animalCode=" + animalCode + "]";
	}
}
