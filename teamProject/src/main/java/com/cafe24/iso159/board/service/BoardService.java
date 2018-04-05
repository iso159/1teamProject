package com.cafe24.iso159.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	//게시판 글 등록
	public void addBoard(BoardContent boardcontent, String mId) {
		logger.debug("addBoard()메서드", mId);
		
		//마지막코드 숫자값을 저장
		String lastNumber = boardDao.selectLastCode();
		logger.debug("lastNumber is {}", lastNumber);
		
		//마지막 board_content_code 코드
		String boardContentCode = "board_content_code_";
		int lastBoardNum = 1;
		if(lastNumber == null) {
			boardContentCode += lastBoardNum;  
		}else {
			lastBoardNum += Integer.parseInt(lastNumber);
			boardContentCode += lastBoardNum;
		}
		logger.debug("boardCode is {}", boardContentCode);

		//boardContentCode 셋팅
		boardcontent.setBoardContentCode(boardContentCode);
		
		//mMemberId 셋팅
		boardcontent.setmMemberId(mId);
		boardDao.insertboardContent(boardcontent);
	}
	//게시판 그룹등록
	public void addBoardGroup(Board board, String mAdminId) {
		logger.debug("addBoard()메서드", mAdminId);
		//마지막코드 숫자값을 저장
		String lastNumber = boardDao.selectLastBoardNum();
		logger.debug("lastNumber is {}", lastNumber);
		
		//마지막 board_content_code 코드
		String boardCode = "board_code_";
		int lastBoardNum = 1;
		if(lastNumber == null) {
			boardCode += lastBoardNum;  
		}else {
			lastBoardNum += Integer.parseInt(lastNumber);
			boardCode += lastBoardNum;
		}
		logger.debug("boardCode is {}", boardCode);
		board.setBoardCode(boardCode);
		
		//mAdminId 셋팅
		board.setmAdminId(mAdminId);
		boardDao.insertBoard(board);
	}
	//게시판리스트
	public List<BoardAndBoardContent> listBoardContent(){
		logger.debug("listBoardContent()메서드 호출");
		List<BoardAndBoardContent> boardContent = boardDao.selectBoardContent();
		logger.debug("listBoardContent()메서드 boardContent is {}", boardContent);
		return boardContent;
	}
	//게시판 글 조회
	public BoardAndBoardContent detailBoard(String boardContentCode) {
		logger.debug("detailBoard()메서드 호출");
		BoardAndBoardContent boardcontent = boardDao.boardDetail(boardContentCode);
		logger.debug("detailBoard()메서드 boardcontent is {}", boardcontent);
		return boardcontent;
	}
	//게시판 그룹리스트
	public List<Board> listBoard(){
		logger.debug("listBoard()메서드 호출");
		List<Board> board = boardDao.selectBoard(); 
		return board;
	}
	//게시글 수정
	public void modifyBoardContent(BoardContent boardcontent, String boardContentCode) {
		logger.debug("modifyBoardContent(...)메서드 animal 호출");
		logger.debug("modifyBoardContent(...)메서드 boardContentCode is {}", boardContentCode);
		
		//게시글 정보 변수에 입력
		String mMemberId = boardcontent.getmMemberId();
		String boardContentTitle = boardcontent.getBoardContentTitle();
		String boardContentContent = boardcontent.getBoardContentContent();
		String boardContentDate = boardcontent.getBoardContentDate();
		
		//변수를 객체의 필드에 셋팅
		BoardContent boardContent = new BoardContent();
		boardContent.setBoardContentCode(boardContentCode);
		boardContent.setmMemberId(mMemberId);
		boardContent.setBoardContentTitle(boardContentTitle);
		boardContent.setBoardContentContent(boardContentContent);
		boardContent.setBoardContentDate(boardContentDate);
		
		boardDao.updateBoardContent(boardContent);
	}
	//게시판 그룹이름 삭제
	public void removeBoard(String boardCode) {
		logger.debug("removeBoard()메서드 boardCode is {}", boardCode);
		boardDao.deleteBoard(boardCode);
	}
}
