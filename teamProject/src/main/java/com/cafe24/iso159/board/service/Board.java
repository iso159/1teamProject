package com.cafe24.iso159.board.service;

public class Board {
	private String boardCode;
	private String mAdminId;
	private String boardName;
	private String boardDate;
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getmAdminId() {
		return mAdminId;
	}
	public void setmAdminId(String mAdminId) {
		this.mAdminId = mAdminId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "Board [boardCode=" + boardCode + ", mAdminId=" + mAdminId + ", boardName=" + boardName + ", boardDate="
				+ boardDate + "]";
	}
}
