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
	public int insertboardContent(BoardContent boardContent) {
		logger.debug("insertBoardCotent()메서드 boardcontent is {}", boardContent);
		return sqlSessionTemplate.insert(nameSpace+"insertBoardContent", boardContent);
	}
	//파일등록
	public int insertBoardFile(BoardContentFile boardContentFile) {
		logger.debug("insertBoardFile()메서드 boardContentFile is {}", boardContentFile);
		return sqlSessionTemplate.insert(nameSpace+"insertBoardFile", boardContentFile);
	}
	//게시판 그룹 등록
	public int insertBoard(Board board) {
		logger.debug("insertBoard()메서드 board is {}", board);
		return sqlSessionTemplate.insert(nameSpace+"insertBoard", board);
	}
	//댓글 등록
	public int insertBoardReply(BoardReply boardreply) {
		logger.debug("insertBoard()메서드 board is {}", boardreply);
		return sqlSessionTemplate.insert(nameSpace+"insertBoardReply", boardreply);
	}
	//게시판 그룹리스트 조회
	public List<Board> selectBoard(){
		logger.debug("selectBoard()메서드 호출");
		List<Board> board = sqlSessionTemplate.selectList(nameSpace+"selectBoard");
		logger.debug("selectBoardContent()메서드 Board is {}", board);
		return board;
	}
	//selectLastCodeOf
	public String selectLastCodeOf() {
		logger.debug("selectLastCodeOf() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastCodeOf");
	}
	
	//Board max코드값 조회
	public String selectLastBoardNum() {
		return sqlSessionTemplate.selectOne(nameSpace+"selectLastBoardNum");
	}
	//max코드값 조회
	public String selectLastCode() {
		return sqlSessionTemplate.selectOne(nameSpace+"selectLastCode");
	}
	//Board Reply max코드값 조회
	public String selectLastReplyNum() {
		return sqlSessionTemplate.selectOne(nameSpace+"selectLastReplyNum");
	}
	//게시판 리스트 조회
	public List<BoardAndBoardContent> selectBoardContent(){
		logger.debug("selectBoardContent()메서드 호출");
		List<BoardAndBoardContent> BoardContent = sqlSessionTemplate.selectList(nameSpace+"selectBoardContent");
		logger.debug("selectBoardContent()메서드 BoardContent is {}", BoardContent);
		return BoardContent;
	}
	//게시판 글 조회
	public BoardAndBoardContent boardDetail(String boardContentCode) {
		//매개변수 확인
		logger.debug("boardDetail()메서드 boardContentCode is {}", boardContentCode);
		BoardAndBoardContent boardcontent = sqlSessionTemplate.selectOne(nameSpace+"boardDetail", boardContentCode);
		return boardcontent;
	}
	//게시판 댓글리스트 조회
	public List<BoardReply> selectBoardReply(String boardContentCode) {
		
		logger.debug("selectBoardReply()메서드 boardContentCode is {}", boardContentCode);
		List<BoardReply> boardreply = sqlSessionTemplate.selectList(nameSpace+"selectBoardReply", boardContentCode);
		logger.debug("selectBoardReply()메서드 boardreply is {}", boardreply);
		return boardreply;
	}
	
	//게시판 글 수정
	public void updateBoardContent(BoardContent boardcontent) {
		//boardcontent 확인
		logger.debug("boardDetail()메서드 boardContent is {}", boardcontent);
		sqlSessionTemplate.update(nameSpace+"updateBoardContent", boardcontent);
	}
	//게시판 그룹이름 삭제
	public void deleteBoard(String boardCode) {
		//String값 받아오는지 확인
		logger.debug("deleteBoard()메서드 boardCode is {}", boardCode);
		sqlSessionTemplate.delete(nameSpace+"deleteBoard", boardCode);
	}
	//게시글 삭제
	public void deleteBoardContent(String boardContentCode) {
		//String값 받아오는지 확인
		logger.debug("deleteBoardContent()메서드 boardContentCode is {}", boardContentCode);
		sqlSessionTemplate.delete(nameSpace+"deleteBoardContent", boardContentCode);
	}
	//댓글 삭제
	public void deleteBoardReply(String boardReplyCode) {
		//String값 받아오는지 확인
		logger.debug("deleteBoardReply()메서드 boardReplyCode is {}", boardReplyCode);
		sqlSessionTemplate.delete(nameSpace+"deleteBoardReply", boardReplyCode);
	}
}
