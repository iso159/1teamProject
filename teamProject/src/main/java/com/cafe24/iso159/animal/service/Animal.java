package com.cafe24.iso159.animal.service;

public class Animal {
	private String animalCode;
	private String osCodeAnimal;
	private String blCode;
	private String mShelterId;
	private String osCodeKind;
	private String animalBreed;
	private String animalArea;
	private String animalIdCode;
	private int animalWeight;
	private int animalAge;
	private int animalEnrollDate;
	public String getAnimalCode() {
		return animalCode;
	}
	public void setAnimalCode(String animalCode) {
		this.animalCode = animalCode;
	}
	public String getOsCodeAnimal() {
		return osCodeAnimal;
	}
	public void setOsCodeAnimal(String osCodeAnimal) {
		this.osCodeAnimal = osCodeAnimal;
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
	public int getAnimalEnrollDate() {
		return animalEnrollDate;
	}
	public void setAnimalEnrollDate(int animalEnrollDate) {
		this.animalEnrollDate = animalEnrollDate;
	}
	@Override
	public String toString() {
		return "Animal [animalCode=" + animalCode + ", osCodeAnimal=" + osCodeAnimal + ", blCode=" + blCode
				+ ", mShelterId=" + mShelterId + ", osCodeKind=" + osCodeKind + ", animalBreed=" + animalBreed
				+ ", animalArea=" + animalArea + ", animalIdCode=" + animalIdCode + ", animalWeight=" + animalWeight
				+ ", animalAge=" + animalAge + ", animalEnrollDate=" + animalEnrollDate + "]";
	}
}