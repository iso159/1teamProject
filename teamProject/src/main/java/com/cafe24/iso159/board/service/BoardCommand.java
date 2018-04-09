package com.cafe24.iso159.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardCommand {
	private String boardContentCode;
	private String boardCode;
	private int boardNumber;
	private String mMemberId;
	private String boardContentTitle;
	private String boardContentContent;
	private String boardContentDate;
	private List<MultipartFile> file;
		
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
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
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "BoardCommand [boardContentCode=" + boardContentCode + ", boardCode=" + boardCode + ", boardNumber="
				+ boardNumber + ", mMemberId=" + mMemberId + ", boardContentTitle=" + boardContentTitle
				+ ", boardContentContent=" + boardContentContent + ", boardContentDate=" + boardContentDate + ", file="
				+ file + "]";
	}
}
