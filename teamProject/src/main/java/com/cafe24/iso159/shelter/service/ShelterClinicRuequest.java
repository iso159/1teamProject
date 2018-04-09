package com.cafe24.iso159.shelter.service;

public class ShelterClinicRuequest {
	private String mShelterId;
	private String adoptCode;
	private String osCodeClinicKind;
	private String scDate;
	private String scReserveDate;

	public String getmShelterId() {
		return mShelterId;
	}

	public void setmShelterId(String mShelterId) {
		this.mShelterId = mShelterId;
	}

	public String getAdoptCode() {
		return adoptCode;
	}

	public void setAdoptCode(String adoptCode) {
		this.adoptCode = adoptCode;
	}

	public String getOsCodeClinicKind() {
		return osCodeClinicKind;
	}

	public void setOsCodeClinicKind(String osCodeClinicKind) {
		this.osCodeClinicKind = osCodeClinicKind;
	}

	public String getScDate() {
		return scDate;
	}

	public void setScDate(String scDate) {
		this.scDate = scDate;
	}

	public String getScReserveDate() {
		return scReserveDate;
	}

	public void setScReserveDate(String scReserveDate) {
		this.scReserveDate = scReserveDate;
	}

	@Override
	public String toString() {
		return "ShelterClinicRuequest [mShelterId=" + mShelterId + ", adoptCode=" + adoptCode + ", osCodeClinicKind="
				+ osCodeClinicKind + ", scDate=" + scDate + ", scReserveDate=" + scReserveDate + "]";
	}

}
