package com.cafe24.iso159.board.service;

public class BoardAndBoardContent {
	private String boardName;

	private BoardContent boardcontent;

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public BoardContent getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(BoardContent boardcontent) {
		this.boardcontent = boardcontent;
	}

	@Override
	public String toString() {
		return "BoardAndBoardContent [boardName=" + boardName + ", boardcontent=" + boardcontent + "]";
	}
}
