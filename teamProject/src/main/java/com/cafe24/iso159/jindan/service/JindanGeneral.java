package com.cafe24.iso159.jindan.service;

public class JindanGeneral {

	private String jindanGeneralCode;
	private String jindanCode;
	private String osBody;
	private String osManner;
	private String osRheum;
	private String osGeneralOddYumu;

	public String getJindanGeneralCode() {
		return jindanGeneralCode;
	}

	public void setJindanGeneralCode(String jindanGeneralCode) {
		this.jindanGeneralCode = jindanGeneralCode;
	}

	public String getJindanCode() {
		return jindanCode;
	}

	public void setJindanCode(String jindanCode) {
		this.jindanCode = jindanCode;
	}

	public String getOsBody() {
		return osBody;
	}

	public void setOsBody(String osBody) {
		this.osBody = osBody;
	}

	public String getOsManner() {
		return osManner;
	}

	public void setOsManner(String osManner) {
		this.osManner = osManner;
	}

	public String getOsRheum() {
		return osRheum;
	}

	public void setOsRheum(String osRheum) {
		this.osRheum = osRheum;
	}

	public String getOsGeneralOddYumu() {
		return osGeneralOddYumu;
	}

	public void setOsGeneralOddYumu(String osGeneralOddYumu) {
		this.osGeneralOddYumu = osGeneralOddYumu;
	}

	@Override
	public String toString() {
		return "jindanGeneral [jindanGeneralCode=" + jindanGeneralCode + ", jindanCode=" + jindanCode + ", osBody="
				+ osBody + ", osManner=" + osManner + ", osRheum=" + osRheum + ", osGeneralOddYumu=" + osGeneralOddYumu
				+ "]";
	}

}
