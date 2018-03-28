package com.cafe24.iso159.exp.service;

import java.util.List;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.service.common.OverallStatus;

public class ExpAndAnimal {
	private Exp exp;
	private Animal animal;
	private OverallStatus overallStatus;
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
	public OverallStatus getOverallStatus() {
		return overallStatus;
	}
	public void setOverallStatus(OverallStatus overallStatus) {
		this.overallStatus = overallStatus;
	}
	@Override
	public String toString() {
		return "ExpAndAnimal [exp=" + exp + ", animal=" + animal + ", overallStatus=" + overallStatus + "]";
	}
	
	
}
