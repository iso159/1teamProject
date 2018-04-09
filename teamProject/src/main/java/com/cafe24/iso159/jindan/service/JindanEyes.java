package com.cafe24.iso159.jindan.service;

public class JindanEyes {
	private String jindanEyesCode;
	private String jindanCode;
	private String osCornea;
	private String osConjunctiva;
	private String osCrystalline;
	private String osEyesOddYumu;
	public String getJindanEyesCode() {
		return jindanEyesCode;
	}
	public void setJindanEyesCode(String jindanEyesCode) {
		this.jindanEyesCode = jindanEyesCode;
	}
	public String getJindanCode() {
		return jindanCode;
	}
	public void setJindanCode(String jindanCode) {
		this.jindanCode = jindanCode;
	}
	public String getOsCornea() {
		return osCornea;
	}
	public void setOsCornea(String osCornea) {
		this.osCornea = osCornea;
	}
	public String getOsConjunctiva() {
		return osConjunctiva;
	}
	public void setOsConjunctiva(String osConjunctiva) {
		this.osConjunctiva = osConjunctiva;
	}
	public String getOsCrystalline() {
		return osCrystalline;
	}
	public void setOsCrystalline(String osCrystalline) {
		this.osCrystalline = osCrystalline;
	}
	public String getOsEyesOddYumu() {
		return osEyesOddYumu;
	}
	public void setOsEyesOddYumu(String osEyesOddYumu) {
		this.osEyesOddYumu = osEyesOddYumu;
	}
	@Override
	public String toString() {
		return "JindanEyes [jindanEyesCode=" + jindanEyesCode + ", jindanCode=" + jindanCode + ", osCornea=" + osCornea
				+ ", osConjunctiva=" + osConjunctiva + ", osCrystalline=" + osCrystalline + ", osEyesOddYumu="
				+ osEyesOddYumu + "]";
	}	
}
