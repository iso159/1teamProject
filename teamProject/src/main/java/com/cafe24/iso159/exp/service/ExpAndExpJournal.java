package com.cafe24.iso159.exp.service;

public class ExpAndExpJournal {
	private Exp exp;
	private ExpJournal expJournal;
	
	@Override
	public String toString() {
		return "ExpAndExpJournal [exp=" + exp + ", expJourmal=" + expJournal + "]";
	}
	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}
	public ExpJournal getExpJourmal() {
		return expJournal;
	}
	public void setExpJourmal(ExpJournal expJourmal) {
		this.expJournal = expJourmal;
	}
	
}
