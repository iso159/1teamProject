package com.cafe24.iso159.board.service;

public class BoardReply {
	private String boardReplyCode;
	private String boardContentCode;
	private String mMemberId;
	private String boardReplyContent;
	private String boardReplyDate;
	
	public String getBoardReplyCode() {
		return boardReplyCode;
	}
	public void setBoardReplyCode(String boardReplyCode) {
		this.boardReplyCode = boardReplyCode;
	}
	public String getBoardContentCode() {
		return boardContentCode;
	}
	public void setBoardContentCode(String boardContentCode) {
		this.boardContentCode = boardContentCode;
	}
	public String getmMemberId() {
		return mMemberId;
	}
	public void setmMemberId(String mMemberId) {
		this.mMemberId = mMemberId;
	}
	public String getBoardReplyContent() {
		return boardReplyContent;
	}
	public void setBoardReplyContent(String boardReplyContent) {
		this.boardReplyContent = boardReplyContent;
	}
	public String getBoardReplyDate() {
		return boardReplyDate;
	}
	public void setBoardReplyDate(String boardReplyDate) {
		this.boardReplyDate = boardReplyDate;
	}
	@Override
	public String toString() {
		return "boardReply [boardReplyCode=" + boardReplyCode + ", boardContentCode=" + boardContentCode
				+ ", mMemberId=" + mMemberId + ", boardReplyContent=" + boardReplyContent + ", boardReplyDate="
				+ boardReplyDate + "]";
	}
}
