package com.cafe24.iso159.survey.service;

public class SurveyList {
	private String surveyListCode;
	private String surveyCode;
	private String mAdminId;
	private String surveyListQuestion;
	private String surveyListDate;
	
	
	public String getSurveyListCode() {
		return surveyListCode;
	}
	public void setSurveyListCode(String surveyListCode) {
		this.surveyListCode = surveyListCode;
	}
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
	public String getSurveyListQuestion() {
		return surveyListQuestion;
	}
	public void setSurveyListQuestion(String surveyListQuestion) {
		this.surveyListQuestion = surveyListQuestion;
	}
	public String getSurveyListDate() {
		return surveyListDate;
	}
	public void setSurveyListDate(String surveyListDate) {
		this.surveyListDate = surveyListDate;
	}
	@Override
	public String toString() {
		return "SurveyList [surveyListCode=" + surveyListCode + ", surveyCode=" + surveyCode + ", mAdminId=" + mAdminId
				+ ", surveyListQuestion=" + surveyListQuestion + ", surveyListDate=" + surveyListDate + "]";
	}
	
}
