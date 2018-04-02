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
	
	//게시판리스트
	public List<BoardContent> listBoardContent(){
		logger.debug("listBoardContent()메서드 호출");
		List<BoardContent> boardContent = boardDao.selectBoardContent();
		
		return boardContent;
	}
}
