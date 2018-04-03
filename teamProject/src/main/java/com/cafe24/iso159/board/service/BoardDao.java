package com.cafe24.iso159.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	private final String nameSpace = "com.cafe24.iso159.board.service.BoardMapper.";
	//게시판 글 등록
	public int insertboardContent(BoardContent boardcontent) {
		logger.debug("insertBoardCotent()메서드 boardcontent is {}", boardcontent);
		return sqlSessionTemplate.insert(nameSpace+"insertBoardContent", boardcontent);
	}
	//게시판 그룹 등록
	public int insertBoard(Board board) {
		logger.debug("insertBoard()메서드 board is {}", board);
		return sqlSessionTemplate.insert(nameSpace+"insertBoard", board);
	}
	//게시판 그룹리스트 조회
	public List<Board> selectBoard(){
		logger.debug("selectBoard()메서드 호출");
		List<Board> board = sqlSessionTemplate.selectList(nameSpace+"selectBoard");
		logger.debug("selectBoardContent()메서드 Board is {}", board);
		return board;
	}
	//Board max코드값 조회
	public String selectLastBoardNum() {
		return sqlSessionTemplate.selectOne(nameSpace+"selectLastBoardNum");
	}
	//max코드값 조회
	public String selectLastCode() {
		return sqlSessionTemplate.selectOne(nameSpace+"selectLastCode");
	}
	//게시판 리스트 조회
	public List<BoardContent> selectBoardContent(){
		logger.debug("selectBoardContent()메서드 호출");
		List<BoardContent> BoardContent = sqlSessionTemplate.selectList(nameSpace+"selectBoardContent");
		logger.debug("selectBoardContent()메서드 BoardContent is {}", BoardContent);
		return BoardContent;
	}
}
