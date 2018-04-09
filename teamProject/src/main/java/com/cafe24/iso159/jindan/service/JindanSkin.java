package com.cafe24.iso159.jindan.service;

public class JindanSkin {
	private String jindanSkinCode;
	private String jindanCode;
	private String osCoat;
	private String osSkin;
	private String osSkinOddYumu;

	public String getJindanSkinCode() {
		return jindanSkinCode;
	}

	public void setJindanSkinCode(String jindanSkinCode) {
		this.jindanSkinCode = jindanSkinCode;
	}

	public String getJindanCode() {
		return jindanCode;
	}

	public void setJindanCode(String jindanCode) {
		this.jindanCode = jindanCode;
	}

	public String getOsCoat() {
		return osCoat;
	}

	public void setOsCoat(String osCoat) {
		this.osCoat = osCoat;
	}

	public String getOsSkin() {
		return osSkin;
	}

	public void setOsSkin(String osSkin) {
		this.osSkin = osSkin;
	}

	public String getOsSkinOddYumu() {
		return osSkinOddYumu;
	}

	public void setOsSkinOddYumu(String osSkinOddYumu) {
		this.osSkinOddYumu = osSkinOddYumu;
	}

	@Override
	public String toString() {
		return "jindanSkin [jindanSkinCode=" + jindanSkinCode + ", jindanCode=" + jindanCode + ", osCoat=" + osCoat
				+ ", osSkin=" + osSkin + ", osSkinOddYumu=" + osSkinOddYumu + "]";
	}
}
