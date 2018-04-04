package com.cafe24.iso159.animal.service;

import org.springframework.web.multipart.MultipartFile;

public class AnimalAndFile {
	private String animalIdCode;
	private String animalAge;
	private String animalWeight;
	private String animalArea;
	private String animalBreed;
	private String osCodeAnimal;
	private String animalImagePath;
	private MultipartFile file;
	public String getAnimalIdCode() {
		return animalIdCode;
	}
	public void setAnimalIdCode(String animalIdCode) {
		this.animalIdCode = animalIdCode;
	}
	public String getAnimalAge() {
		return animalAge;
	}
	public void setAnimalAge(String animalAge) {
		this.animalAge = animalAge;
	}
	public String getAnimalWeight() {
		return animalWeight;
	}
	public void setAnimalWeight(String animalWeight) {
		this.animalWeight = animalWeight;
	}
	public String getAnimalArea() {
		return animalArea;
	}
	public void setAnimalArea(String animalArea) {
		this.animalArea = animalArea;
	}
	public String getAnimalBreed() {
		return animalBreed;
	}
	public void setAnimalBreed(String animalBreed) {
		this.animalBreed = animalBreed;
	}
	public String getOsCodeAnimal() {
		return osCodeAnimal;
	}
	public void setOsCodeAnimal(String osCodeAnimal) {
		this.osCodeAnimal = osCodeAnimal;
	}
	public String getAnimalImagePath() {
		return animalImagePath;
	}
	public void setAnimalImagePath(String animalImagePath) {
		this.animalImagePath = animalImagePath;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "AnimalAndFile [animalIdCode=" + animalIdCode + ", animalAge=" + animalAge + ", animalWeight="
				+ animalWeight + ", animalArea=" + animalArea + ", animalBreed=" + animalBreed + ", osCodeAnimal="
				+ osCodeAnimal + ", animalImagePath=" + animalImagePath + ", file=" + file + "]";
	}	
}
