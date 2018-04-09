package com.cafe24.iso159.jindan.service;

public class JindanNose {
	private String jindanNoseCode;
	private String jindanCode;
	private String osNoseSecrete;
	private String osNoseOddYumu;

	public String getJindanNoseCode() {
		return jindanNoseCode;
	}

	public void setJindanNoseCode(String jindanNoseCode) {
		this.jindanNoseCode = jindanNoseCode;
	}

	public String getJindanCode() {
		return jindanCode;
	}

	public void setJindanCode(String jindanCode) {
		this.jindanCode = jindanCode;
	}

	public String getOsNoseSecrete() {
		return osNoseSecrete;
	}

	public void setOsNoseSecrete(String osNoseSecrete) {
		this.osNoseSecrete = osNoseSecrete;
	}

	public String getOsNoseOddYumu() {
		return osNoseOddYumu;
	}

	public void setOsNoseOddYumu(String osNoseOddYumu) {
		this.osNoseOddYumu = osNoseOddYumu;
	}

	@Override
	public String toString() {
		return "jindanNose [jindanNoseCode=" + jindanNoseCode + ", jindanCode=" + jindanCode + ", osNoseSecrete="
				+ osNoseSecrete + ", osNoseOddYumu=" + osNoseOddYumu + "]";
	}

}
