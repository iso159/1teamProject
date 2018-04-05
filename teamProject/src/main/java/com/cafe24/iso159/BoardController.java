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
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.iso159.board.service.Board;
import com.cafe24.iso159.board.service.BoardAndBoardContent;
import com.cafe24.iso159.board.service.BoardContent;
import com.cafe24.iso159.board.service.BoardReply;
import com.cafe24.iso159.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시판 글 등록 페이지로 이동
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(HttpSession session, Model model) {
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		List<Board> board = boardservice.listBoard();
		model.addAttribute("board", board);
		return "board/boardAdd";
	}
	//게시판 수정 페이지로 이동
	@RequestMapping(value="/board/boardContentUpdate", method=RequestMethod.GET)
	public String boardContentModify(Model model, @RequestParam(value="boardContentCode",required=true)String boardContentCode) {
		
		BoardAndBoardContent bc = boardservice.detailBoard(boardContentCode);
		model.addAttribute("bc", bc);
		return "board/boardContentUpdate";
	}
	//게시판 글 등록
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
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
	//게시판 글 수정
	@RequestMapping(value="/board/boardUpdate", method=RequestMethod.POST)
	public String BoardcontentModifiy(BoardContent boardcontent, HttpSession session
									,@RequestParam(value="boardContentCode")String boardContentCode) {
		logger.debug("BoardcontentModifiy()메서드 호출");
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		logger.debug("BoardcontentModifiy()메서드 boardContentCode is {}", boardContentCode);
		boardservice.modifyBoardContent(boardcontent, boardContentCode);
		return "redirect:/board/boardList";
	}
	//게시판 그룹이름 삭제
	@RequestMapping(value="/board/boardDelete", method=RequestMethod.GET)
	public String boardRemove(HttpSession session
						, @RequestParam(value="boardCode")String boardCode) {
		boardservice.removeBoard(boardCode);
		return "redirect:/board/boardGroupList";
	}
	
	//게시판 그룹등록 페이지로 이동
	/*@RequestMapping(value="/board/boardGroupAdd", method=RequestMethod.GET)
	public String BoardAdd() {
		return "board/boardGroupAdd";
	}*/
	//게시판 그룹등록
	@RequestMapping(value="board/boardGroupAdd", method=RequestMethod.POST)
	public String BoardGroupAdd(Board board, HttpSession session) {
		logger.debug("BoardGroupAdd()메서드 호출");
		String mAdminId = (String)session.getAttribute("loginId");
		boardservice.addBoardGroup(board, mAdminId);
		return "redirect:/board/boardGroupList";
	}
	//게시판 그룹리스트
	@RequestMapping(value="board/boardGroupList", method=RequestMethod.GET)
	public String BoardGroupList(Model model) {
		logger.debug("BoardGroupList()메서드 호출");
		List<Board> board = boardservice.listBoard();
		model.addAttribute("board", board);
		return "board/boardGroupList";
	}
	//게시판리스트
	@RequestMapping(value="/board/boardList", method=RequestMethod.GET)
	public String Board(Model model) {
		logger.debug("Board()메서드 호출");
		List<BoardAndBoardContent> boardlist = boardservice.listBoardContent();
		logger.debug("Board()메서드 boardlist is {}", boardlist);
		model.addAttribute("boardlist", boardlist);
		return "board/boardList";
	}
	//게시판 상세페이지 요청
	@RequestMapping(value="/board/boardDetail", method=RequestMethod.GET)
	public String BoardDetail(Model model, @RequestParam(value="boardContentCode",required=true)String boardContentCode) {
		logger.debug("BoardDetail()메서드 호출");
		BoardAndBoardContent bc = boardservice.detailBoard(boardContentCode);
		model.addAttribute("bc", bc);
		return "board/boardDetail";
	}
	/*//게시판 댓글 등록
	@RequestMapping(value="/board/boardReplyAdd", method=RequestMethod.POST)
	public String BoardReplyAdd(HttpSession session, BoardReply boardreply) {
		logger.debug("BoardReplyAdd()메서드 호출");
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		String mId = (String)session.getAttribute("loginId");
		logger.debug("BoardAdd()메서드 mId is {}", mId);
		boardservice.addBoardReply(boardreply, mId);
		return "redirect:/board/boardDetail";
	}*/
	//댓글리스트 보여지게 하기
	
}
