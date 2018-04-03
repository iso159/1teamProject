package com.cafe24.iso159;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.iso159.board.service.BoardContent;
import com.cafe24.iso159.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시판 글 등록 페이지로 이동
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(HttpSession session) {
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		return "board/boardAdd";
	}
	//게시판 글 등록
	@RequestMapping(value="/board/boardList", method=RequestMethod.POST)
	public String BoardAdd(HttpSession session, BoardContent boardcontent) {
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		logger.debug("BoardAdd()메서드 호출");
		String mId = (String)session.getAttribute("loginId");
		logger.debug("BoardAdd()메서드 mId is {}", mId);
		boardservice.addBoard(boardcontent, mId);
		return "redirect:/board/boardList";
	}
	//게시판리스트
	@RequestMapping(value="/board/boardList", method=RequestMethod.GET)
	public String Board(Model model) {
		logger.debug("Board()메서드 호출");
		List<BoardContent> boardContent = boardservice.listBoardContent();
		model.addAttribute("boardContent", boardContent);
		return "board/boardList";
	}
}
