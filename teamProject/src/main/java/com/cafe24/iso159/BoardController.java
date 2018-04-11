package com.cafe24.iso159;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.iso159.board.service.Board;
import com.cafe24.iso159.board.service.BoardAndBoardContent;
import com.cafe24.iso159.board.service.BoardCommand;
import com.cafe24.iso159.board.service.BoardContent;
import com.cafe24.iso159.board.service.BoardContentFile;
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
	public String BoardAdd(HttpSession session, BoardCommand boardCommand
							, @RequestParam(value="file") MultipartFile file) {
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
	
		logger.debug("BoardAdd()메서드 호출");
		logger.debug("BoardAdd(...) 메서드 file is {}",file);
		
		String mId = (String)session.getAttribute("loginId");
		logger.debug("BoardAdd()메서드 mId is {}", mId);
		//resource 폴더경로
		String path = null;
		if(file != null) {
			path = session.getServletContext().getRealPath("/");
			path += "resources/boardUpload/";
		}
		logger.debug("BoardAdd() 메서드 0000000000000000000000000000000path is {}",path);
		boardservice.addBoard(boardCommand, mId, path, file);
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
	//게시글 삭제
	@RequestMapping(value="/board/boardContentDelete", method=RequestMethod.GET)
	public String boardContentRemove(HttpSession session
									, @RequestParam(value="boardContentCode")String boardContentCode) {
		boardservice.removeBoardContent(boardContentCode);
		return "redirect:/board/boardList";
	}
	//댓글 삭제
	@RequestMapping(value="/board/boardReplyDelete", method=RequestMethod.GET)
	public String boardReplyRemove(HttpSession session
									, @RequestParam(value="boardContentCode")String boardContentCode
									, @RequestParam(value="boardReplyCode")String boardReplyCode) {
		boardservice.removeBoardReply(boardReplyCode);
		session.setAttribute("boardContentCode", boardContentCode);
		logger.debug("BoardAdd()메서드 session에 있는 boardContentCode is {}", boardContentCode);
		return "redirect:/board/boardDetail";
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
	public String Board(Model model
						,@RequestParam(value="currentPage",defaultValue="1",required=false) int currentPage
						,@RequestParam(value="rowPerPage",defaultValue="10",required=false) int rowPerPage
						,@RequestParam(value="boardCategory",required=false) String boardCategory
						,@RequestParam(value="boardSearchWord",required=false) String boardSearchWord) {
		
		logger.debug("Board()메서드 currentPage is {}", currentPage);
		logger.debug("Board()메서드 rowPerPage is {}", rowPerPage);
		logger.debug("Board()메서드 boardCategory is {}", boardCategory);
		logger.debug("Board()메서드 boardSearchWord is {}", boardSearchWord);
		
		Map<String, Object> boardlist = boardservice.listBoardContent(currentPage, rowPerPage, boardCategory, boardSearchWord);
		
		logger.debug("Board()메서드 boardlist is {}", boardlist);
		model.addAttribute("map", boardlist);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		return "board/boardList";
	}
	
	//게시판 상세페이지 요청
	@RequestMapping(value="/board/boardDetail", method=RequestMethod.GET)
	public String BoardDetail(Model model
							, HttpSession session
							, @RequestParam(value="boardContentCode", defaultValue="", required=true)String boardContentCode) {
		logger.debug("BoardDetail()메서드 호출");
		logger.debug("BoardDetail(@RequestParam) boardContentCode is {}", boardContentCode);
		
		if(boardContentCode.equals("")) {
			logger.debug("if문 실행 확인");
		boardContentCode = (String)session.getAttribute("boardContentCode");
		}
		logger.debug("BoardDetail()메서드 boardContentCode is {}", boardContentCode);
		BoardAndBoardContent bc = boardservice.detailBoard(boardContentCode);
		model.addAttribute("bc", bc);
		List<BoardReply> br = boardservice.listBoardReply(boardContentCode);
		model.addAttribute("br", br);
		List<BoardContentFile> bcFile = boardservice.listBoardContentFile(boardContentCode);
		model.addAttribute("bcFile", bcFile);
		session.removeAttribute("boardContentCode");
		return "board/boardDetail";
	}
	//게시판 댓글 등록
	@RequestMapping(value="/board/boardReplyAdd", method=RequestMethod.POST)
	public String BoardReplyAdd(HttpSession session
								, BoardReply boardreply
								, @RequestParam(value="boardContentCode")String boardContentCode) {
		logger.debug("BoardReplyAdd()메서드 호출");
		logger.debug("BoardReplyAdd()메서드 boardContentCode is {}", boardContentCode);
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		String mId = (String)session.getAttribute("loginId");
		logger.debug("BoardAdd()메서드 mId is {}", mId);
		boardservice.addBoardReply(boardreply, mId, boardContentCode);
		session.setAttribute("boardContentCode", boardContentCode);
		logger.debug("BoardAdd()메서드 session에 있는 boardContentCode is {}", boardContentCode);
		return "redirect:/board/boardDetail";
	}
	//파일다운로드
	@RequestMapping(value="/board/boardFileDownload", method=RequestMethod.GET)
	public ModelAndView downloadBoardFile(HttpSession session
										, HttpServletRequest request
										, HttpServletResponse response
										, @RequestParam(value="ofSaveName") String ofSaveName
										, @RequestParam(value="ofOriginName") String ofOriginName
										, @RequestParam(value="ofExt") String ofExt) {
		
		logger.debug("downloadBoardFile() 메서드 호출");
		logger.debug("ofSaveName :{}",ofSaveName);
		logger.debug("ofOriginName :{}",ofOriginName);
		logger.debug("ofExt :{}",ofExt);
		// resource 폴더경로
		String path = session.getServletContext().getRealPath("/");
		path += "resources/boardUpload/";
		return boardservice.boardFileDownload(request, path, ofSaveName, ofExt, ofOriginName);
	}
}
