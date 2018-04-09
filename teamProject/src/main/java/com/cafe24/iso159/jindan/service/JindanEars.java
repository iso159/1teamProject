package com.cafe24.iso159.jindan.service;

public class JindanEars {
	private String jindanEarsCode;
	private String jindanCode;
	private String osHearing;
	private String osEarsSecrete;
	private String osMite;
	private String osEarsOddYumu;
	public String getJindanEarsCode() {
		return jindanEarsCode;
	}
	public void setJindanEarsCode(String jindanEarsCode) {
		this.jindanEarsCode = jindanEarsCode;
	}
	public String getJindanCode() {
		return jindanCode;
	}
	public void setJindanCode(String jindanCode) {
		this.jindanCode = jindanCode;
	}
	public String getOsHearing() {
		return osHearing;
	}
	public void setOsHearing(String osHearing) {
		this.osHearing = osHearing;
	}
	public String getOsEarsSecrete() {
		return osEarsSecrete;
	}
	public void setOsEarsSecrete(String osEarsSecrete) {
		this.osEarsSecrete = osEarsSecrete;
	}
	public String getOsMite() {
		return osMite;
	}
	public void setOsMite(String osMite) {
		this.osMite = osMite;
	}
	public String getOsEarsOddYumu() {
		return osEarsOddYumu;
	}
	public void setOsEarsOddYumu(String osEarsOddYumu) {
		this.osEarsOddYumu = osEarsOddYumu;
	}
	@Override
	public String toString() {
		return "JindanEars [jindanEarsCode=" + jindanEarsCode + ", jindanCode=" + jindanCode + ", osHearing="
				+ osHearing + ", osEarsSecrete=" + osEarsSecrete + ", osMite=" + osMite + ", osEarsOddYumu="
				+ osEarsOddYumu + "]";
	}
	
}
