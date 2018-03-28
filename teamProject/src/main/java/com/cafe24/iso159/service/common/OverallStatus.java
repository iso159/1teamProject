package com.cafe24.iso159.service.common;

public class OverallStatus {
	private String osCode;
	private String osLarge;
	private String osLargeLevel;
	private String osSmall;
	private String osSmallLevel;
	private String osName;
	private String osNameLevel;
	
	@Override
	public String toString() {
		return "OverallStatus [osCode=" + osCode + ", osLarge=" + osLarge + ", osLargeLevel=" + osLargeLevel
				+ ", osSmall=" + osSmall + ", osSmallLevel=" + osSmallLevel + ", osName=" + osName + ", osNameLevel="
				+ osNameLevel + "]";
	}
	public String getOsCode() {
		return osCode;
	}
	public void setOsCode(String osCode) {
		this.osCode = osCode;
	}
	public String getOsLarge() {
		return osLarge;
	}
	public void setOsLarge(String osLarge) {
		this.osLarge = osLarge;
	}
	public String getOsLargeLevel() {
		return osLargeLevel;
	}
	public void setOsLargeLevel(String osLargeLevel) {
		this.osLargeLevel = osLargeLevel;
	}
	public String getOsSmall() {
		return osSmall;
	}
	public void setOsSmall(String osSmall) {
		this.osSmall = osSmall;
	}
	public String getOsSmallLevel() {
		return osSmallLevel;
	}
	public void setOsSmallLevel(String osSmallLevel) {
		this.osSmallLevel = osSmallLevel;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getOsNameLevel() {
		return osNameLevel;
	}
	public void setOsNameLevel(String osNameLevel) {
		this.osNameLevel = osNameLevel;
	}
	
}
