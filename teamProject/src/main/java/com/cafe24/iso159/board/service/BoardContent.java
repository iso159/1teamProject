package com.cafe24.iso159.board.service;

public class BoardContent {
	private String boardContentCode;
	private int boardNumber;
	private String boardCode;
	private String mMemberId;
	private String boardContentTitle;
	private String boardContentContent;
	private String boardContentDate;
	
	public String getBoardContentCode() {
		return boardContentCode;
	}
	
	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public void setBoardContentCode(String boardContentCode) {
		this.boardContentCode = boardContentCode;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getmMemberId() {
		return mMemberId;
	}
	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
	}
	public String getBoardContentTitle() {
		return boardContentTitle;
	}
	public void setBoardContentTitle(String boardContentTitle) {
		this.boardContentTitle = boardContentTitle;
	}
	public String getBoardContentContent() {
		return boardContentContent;
	}
	public void setBoardContentContent(String boardContentContent) {
		this.boardContentContent = boardContentContent;
	}
	public String getBoardContentDate() {
		return boardContentDate;
	}
	public void setBoardContentDate(String boardContentDate) {
		this.boardContentDate = boardContentDate;
	}

	@Override
	public String toString() {
		return "BoardContent [boardContentCode=" + boardContentCode + ", boardNumber=" + boardNumber + ", boardCode="
				+ boardCode + ", mMemberId=" + mMemberId + ", boardContentTitle=" + boardContentTitle
				+ ", boardContentContent=" + boardContentContent + ", boardContentDate=" + boardContentDate + "]";
	}
}
