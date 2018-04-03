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
	public int insertboardCount(BoardContent boardcontent) {
		logger.debug("insertBoardCotent()메서드 boardcontent is {}", boardcontent);
		return sqlSessionTemplate.insert(nameSpace+"insertBoard", boardcontent);
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
