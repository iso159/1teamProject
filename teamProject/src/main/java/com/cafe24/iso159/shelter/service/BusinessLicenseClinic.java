package com.cafe24.iso159.shelter.service;

public class BusinessLicenseClinic {
	private String scCode;
	private String blCode;
	private String mShelterId;
	private String adoptCode;
	private String mId;
	private String osCodeClinicKind;
	private String osCodeClinicStatus;
	private String scDate;
	private String scReserveDate;

	public String getScCode() {
		return scCode;
	}

	public void setScCode(String scCode) {
		this.scCode = scCode;
	}

	public String getBlCode() {
		return blCode;
	}

	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}

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

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getOsCodeClinicKind() {
		return osCodeClinicKind;
	}

	public void setOsCodeClinicKind(String osCodeClinicKind) {
		this.osCodeClinicKind = osCodeClinicKind;
	}

	public String getOsCodeClinicStatus() {
		return osCodeClinicStatus;
	}

	public void setOsCodeClinicStatus(String osCodeClinicStatus) {
		this.osCodeClinicStatus = osCodeClinicStatus;
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
		return "BusinessLicenseClinic [scCode=" + scCode + ", blCode=" + blCode + ", mShelterId=" + mShelterId
				+ ", adoptCode=" + adoptCode + ", mId=" + mId + ", osCodeClinicKind=" + osCodeClinicKind
				+ ", osCodeClinicStatus=" + osCodeClinicStatus + ", scDate=" + scDate + ", scReserveDate="
				+ scReserveDate + "]";
	}

}
