package com.cafe24.iso159.member.service;

public class MemberSurvey {

	private String mSurveyCode;
	private String surveyListCode;
	private String expCode;
	private String mExpId;
	private String adoptRequestCode;
	private String surveyRecordCode;
	public String getmSurveyCode() {
		return mSurveyCode;
	}
	public void setmSurveyCode(String mSurveyCode) {
		this.mSurveyCode = mSurveyCode;
	}
	public String getSurveyListCode() {
		return surveyListCode;
	}
	public void setSurveyListCode(String surveyListCode) {
		this.surveyListCode = surveyListCode;
	}
	public String getExpCode() {
		return expCode;
	}
	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}
	public String getmExpId() {
		return mExpId;
	}
	public void setmExpId(String mExpId) {
		this.mExpId = mExpId;
	}
	public String getAdoptRequestCode() {
		return adoptRequestCode;
	}
	public void setAdoptRequestCode(String adoptRequestCode) {
		this.adoptRequestCode = adoptRequestCode;
	}
	public String getSurveyRecordCode() {
		return surveyRecordCode;
	}
	public void setSurveyRecordCode(String surveyRecordCode) {
		this.surveyRecordCode = surveyRecordCode;
	}
	@Override
	public String toString() {
		return "MemberSurvey [mSurveyCode=" + mSurveyCode + ", surveyListCode=" + surveyListCode + ", expCode="
				+ expCode + ", mExpId=" + mExpId + ", adoptRequestCode=" + adoptRequestCode + ", surveyRecordCode="
				+ surveyRecordCode + "]";
	}

	

}
