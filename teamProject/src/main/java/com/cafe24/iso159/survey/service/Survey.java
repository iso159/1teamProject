package com.cafe24.iso159.survey.service;

public class Survey {
	private String surveyCode;
	private String mAdminId;
	private String surveyEnrollDate;
	private String surveyName;
	private int surveyPoint;
	
	
	public String getSurveyCode() {
		return surveyCode;
	}
	public void setSurveyCode(String surveyCode) {
		this.surveyCode = surveyCode;
	}
	public String getmAdminId() {
		return mAdminId;
	}
	public void setmAdminId(String mAdminId) {
		this.mAdminId = mAdminId;
	}
	public String getSurveyEnrollDate() {
		return surveyEnrollDate;
	}
	public void setSurveyEnrollDate(String surveyEnrollDate) {
		this.surveyEnrollDate = surveyEnrollDate;
	}
	public String getSurveyName() {
		return surveyName;
	}
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	public int getSurveyPoint() {
		return surveyPoint;
	}
	public void setSurveyPoint(int surveyPoint) {
		this.surveyPoint = surveyPoint;
	}
	@Override
	public String toString() {
		return "Survey [surveyCode=" + surveyCode + ", mAdminId=" + mAdminId + ", surveyEnrollDate=" + surveyEnrollDate
				+ ", surveyName=" + surveyName + ", surveyPoint=" + surveyPoint + "]";
	}
	
	
}
