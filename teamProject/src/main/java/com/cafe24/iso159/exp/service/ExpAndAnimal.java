package com.cafe24.iso159.exp.service;

import java.util.List;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.service.common.OverallStatus;

public class ExpAndAnimal {
	private List<Exp> exp;
	private List<Animal> animal;
	private List<OverallStatus> overallStatus;
	
	@Override
	public String toString() {
		return "ExpAndAnimal [exp=" + exp + ", animal=" + animal + ", overallStatus=" + overallStatus + "]";
	}
	public List<Exp> getExp() {
		return exp;
	}
	public void setExp(List<Exp> exp) {
		this.exp = exp;
	}
	public List<Animal> getAnimal() {
		return animal;
	}
	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}
	public List<OverallStatus> getOverallStatus() {
		return overallStatus;
	}
	public void setOverallStatus(List<OverallStatus> overallStatus) {
		this.overallStatus = overallStatus;
	}
	
}
