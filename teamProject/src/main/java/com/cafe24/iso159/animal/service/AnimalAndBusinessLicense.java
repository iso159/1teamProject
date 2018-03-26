package com.cafe24.iso159.animal.service;

public class AnimalAndBusinessLicense {
	private String osCodeAnimal;
	private String osCodeKind;
	private String animalBreed;
	private String animalArea;
	private String animalIdCode;
	private int animalWeight;
	private int animalAge;
	private String blShelterName;
	private String animalEnrollDate;
	public String getOsCodeAnimal() {
		return osCodeAnimal;
	}
	public void setOsCodeAnimal(String osCodeAnimal) {
		this.osCodeAnimal = osCodeAnimal;
	}
	public String getOsCodeKind() {
		return osCodeKind;
	}
	public void setOsCodeKind(String osCodeKind) {
		this.osCodeKind = osCodeKind;
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
	@Override
	public String toString() {
		return "AnimalCommand [osCodeAnimal=" + osCodeAnimal + ", osCodeKind=" + osCodeKind + ", animalBreed="
				+ animalBreed + ", animalArea=" + animalArea + ", animalIdCode=" + animalIdCode + ", animalWeight="
				+ animalWeight + ", animalAge=" + animalAge + ", blShelterName=" + blShelterName + ", animalEnrollDate="
				+ animalEnrollDate + "]";
	}
}
