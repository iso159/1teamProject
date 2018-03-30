package com.cafe24.iso159.exp.service;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.member.service.MemberInfo;
import com.cafe24.iso159.service.common.OverallStatus;

public class ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo {
	private Exp exp;
	private Animal animal;
	private OverallStatus overallStatus;
	private ExpPeriod expPeriod;
	private MemberInfo memberInfo;
	@Override
	public String toString() {
		return "ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo [exp=" + exp + ", animal=" + animal
				+ ", overallStatus=" + overallStatus + ", expPeriod=" + expPeriod + ", memberInfo=" + memberInfo + "]";
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
	public OverallStatus getOverallStatus() {
		return overallStatus;
	}
	public void setOverallStatus(OverallStatus overallStatus) {
		this.overallStatus = overallStatus;
	}
	public ExpPeriod getExpPeriod() {
		return expPeriod;
	}
	public void setExpPeriod(ExpPeriod expPeriod) {
		this.expPeriod = expPeriod;
	}
	public MemberInfo getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	
}
