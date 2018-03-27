package com.cafe24.iso159.exp.service;

import com.cafe24.iso159.animal.service.Animal;

public class ExpAndAnimal {
	private Exp exp;
	private Animal animal;
	private String osName;
	@Override
	public String toString() {
		return "ExpAndAnimal [exp=" + exp + ", animal=" + animal + ", osName=" + osName + "]";
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
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
}
