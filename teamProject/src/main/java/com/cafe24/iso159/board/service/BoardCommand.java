package com.cafe24.iso159.board.service;

import java.util.List;

public class BoardCommand {
	private String boardCode;
	private String boardName;
	private String boardContentCode;
	private int boardNumber;
	private String mMemberId;
	private String boardContentTitle;
	private String boardContentContent;
	private String boardContentDate;
	private List<BoardReply> boardReply;
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardContentCode() {
		return boardContentCode;
	}
	public void setBoardContentCode(String boardContentCode) {
		this.boardContentCode = boardContentCode;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
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
	public List<BoardReply> getBoardReply() {
		return boardReply;
	}
	public void setBoardReply(List<BoardReply> boardReply) {
		this.boardReply = boardReply;
	}
	@Override
	public String toString() {
		return "BoardCommand [boardCode=" + boardCode + ", boardName=" + boardName + ", boardContentCode="
				+ boardContentCode + ", boardNumber=" + boardNumber + ", mMemberId=" + mMemberId
				+ ", boardContentTitle=" + boardContentTitle + ", boardContentContent=" + boardContentContent
				+ ", boardContentDate=" + boardContentDate + ", boardReply=" + boardReply + "]";
	}
}
