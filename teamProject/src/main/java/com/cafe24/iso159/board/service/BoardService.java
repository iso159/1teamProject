package com.cafe24.iso159.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iso159.BoardController;

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
		String boardCode = "board_content_code_";
		int lastBoardNum = 1;
		if(lastNumber == null) {
			boardCode += lastBoardNum;  
		}else {
			lastBoardNum += Integer.parseInt(lastNumber);
			boardCode += lastBoardNum;
		}
		logger.debug("boardCode is {}", boardCode);

		//boardCode 셋팅
		boardcontent.setBoardContentCode(boardCode);
		
		//mMemberId 셋팅
		boardcontent.setmMemberId(mId);
		boardDao.insertboardCount(boardcontent);
	}
	//게시판리스트
	public List<BoardContent> listBoardContent(){
		logger.debug("listBoardContent()메서드 호출");
		List<BoardContent> boardContent = boardDao.selectBoardContent();
		return boardContent;
	}
}
