package com.cafe24.iso159.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	//게시판 글 등록
	public void addBoard(BoardCommand boardCommand, String mId, String path, MultipartFile multiPartFile) {
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

		//command로 받은 값을 BoardContent에 담는다.
		BoardContent boardContent = new BoardContent();
		boardContent.setBoardContentCode(boardContentCode);
		boardContent.setmMemberId(mId);
		boardContent.setBoardCode(boardCommand.getBoardCode());
		boardContent.setBoardNumber(boardCommand.getBoardNumber());
		boardContent.setBoardContentTitle(boardCommand.getBoardContentTitle());
		boardContent.setBoardContentContent(boardCommand.getBoardContentContent());
		boardContent.setBoardContentDate(boardCommand.getBoardContentDate());
		
		boardDao.insertboardContent(boardContent);
		
		if(!multiPartFile.isEmpty()) {
			for(MultipartFile file : boardCommand.getFile()) {
				// 1. db에 입력
				UUID uuid = UUID.randomUUID();
				// 파일이름
				String ofSaveName = uuid.toString(); // 중복되지않은 이름
				// 원본파일이름
				String ofOriginName = file.getOriginalFilename();
				// 파일확장자
				int pos = ofOriginName.lastIndexOf(".");
				// 원본 파일명의 마지막 . 위치 앞의 원본 파일명을 변수에 입력
				//String originalFileName = ofOriginName.substring(0, pos);
				String ofExt = ofOriginName.substring(pos+1);
				// 파일크기
				long ofSize = file.getSize();
				
				// 마지막 of_code 코드
				String lastOfCode = boardDao.selectLastCodeOf();
				logger.debug("lastCodeOf is {}", lastOfCode);
				String ofCode = "of_code_";
				//String overallFileCode = "of_code_1";
				int ofCodeNum = 1;
				
				if(lastOfCode == null) {
					ofCode += ofCodeNum;
				}else {
					ofCodeNum += Integer.parseInt(lastOfCode);
					ofCode += ofCodeNum;
				}
				logger.debug("ofCode is {}", ofCode);
				//값셋팅후 메서드 실행
				BoardContentFile boardContentFile = new BoardContentFile();
				boardContentFile.setOfCode(ofCode);
				boardContentFile.setBoardContentCode(boardContentCode);
				boardContentFile.setOfPath(path);
				boardContentFile.setOfOriginName(ofOriginName);
				boardContentFile.setOfSaveName(ofSaveName);
				boardContentFile.setOfExt(ofExt);
				boardContentFile.setOfSize(ofSize);
				boardDao.insertBoardFile(boardContentFile);
				File temp = new File(path);
				if(!temp.exists()) {
					// 디렉토리가 없을경우 디렉토리 생성
					temp.mkdirs();
					logger.debug("addBoard() 메서드 디렉토리 생성 성공");
				}
				File temp2 = new File(path+ofSaveName);
				logger.debug("addBoard() 메서드 temp2 is {}",temp2);
				
				try {
					file.transferTo(temp2);
				} catch (IllegalStateException e) {
					e.printStackTrace();
						// temp 파일 삭제 및 콘솔창으로 확인
						if(temp.delete()) {
							logger.debug("addBoard() 메서드 {} 파일 삭제 성공",temp);
						}else {
							logger.debug("addBoard() 메서드 {} 파일 삭제 성공",temp);
						}
				} catch (IOException e) {
					e.printStackTrace();
						// temp 파일 삭제 및 콘솔창으로 확인
					if(temp.delete()) {
						logger.debug("addBoard() 메서드 {} 파일 삭제 성공",temp);
					}else {
						logger.debug("addBoard() 메서드 {} 파일 삭제 실패",temp);
					}
				}
			}
		}else {
			logger.debug("파일이 비어있습니다.");
		}
		
		logger.debug("addBoard() 메서드 끝");
	}
	
	//게시판 댓글등록
	public void addBoardReply(BoardReply boardreply, String mId, String boardContentCode) {
		logger.debug("addBoard()메서드", mId);
		
		//마지막코드 숫자값을 저장
		String lastNumber = boardDao.selectLastReplyNum();
		logger.debug("lastNumber is {}", lastNumber);
		
		//마지막 board_reply_code 코드
		String boardReplyCode = "board_reply_code_";
		int lastReplyNum = 1;
		if(lastNumber == null) {
			boardReplyCode += lastReplyNum;  
		}else {
			lastReplyNum += Integer.parseInt(lastNumber);
			boardReplyCode += lastReplyNum;
		}
		logger.debug("boardCode is {}", boardReplyCode);
		//board_reply_code 셋팅
		boardreply.setBoardReplyCode(boardReplyCode);
		//m_member_id 셋팅
		boardreply.setmMemberId(mId);
		//board_content_code 셋팅
		boardreply.setBoardContentCode(boardContentCode);
		boardDao.insertBoardReply(boardreply);
	}
	//게시판 그룹등록
	public void addBoardGroup(Board board, String mAdminId) {
		logger.debug("addBoard()메서드", mAdminId);
		//마지막코드 숫자값을 저장
		String lastNumber = boardDao.selectLastBoardNum();
		logger.debug("lastNumber is {}", lastNumber);
		
		//마지막 board_code 코드
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
	//게시판 댓글조회
	public List<BoardReply> listBoardReply(String boardContentCode){
		logger.debug("listBoardReply()메서드 호출");
		List<BoardReply> boardReply = boardDao.selectBoardReply(boardContentCode);
		logger.debug("listBoardReply()메서드 boardReply is {}", boardReply);
		return boardReply;
	}
	//게시판 그룹리스트
	public List<Board> listBoard(){
		logger.debug("listBoard()메서드 호출");
		List<Board> board = boardDao.selectBoard(); 
		return board;
	}
	//게시글 수정
	public void modifyBoardContent(BoardContent boardcontent, String boardContentCode) {
		logger.debug("modifyBoardContent(...)메서드 호출");
		logger.debug("modifyBoardContent(...)메서드 boardContentCode is {}", boardContentCode);
				
		//게시글 정보 변수에 입력
		String boardContentTitle = boardcontent.getBoardContentTitle();
		String boardContentContent = boardcontent.getBoardContentContent();
		String boardContentDate = boardcontent.getBoardContentDate();
				
		//변수를 객체의 필드에 셋팅
		BoardContent boardContent = new BoardContent();
		
		boardContent.setBoardContentCode(boardContentCode);
		boardContent.setBoardContentTitle(boardContentTitle);
		boardContent.setBoardContentContent(boardContentContent);
		boardContent.setBoardContentDate(boardContentDate);
		
		boardDao.updateBoardContent(boardContent);
	}
	//게시글 삭제
	public void removeBoardContent(String boardContentCode) {
		logger.debug("removeBoardContent()메서드 boardContentCode is {}", boardContentCode);
		boardDao.deleteBoardContent(boardContentCode);
	}
	
	//댓글삭제
	public void removeBoardReply(String boardReplyCode) {
		logger.debug("removeBoardReply()메서드 boardReplyCode is {}", boardReplyCode);
		boardDao.deleteBoardReply(boardReplyCode);
	}
	
	//게시판 그룹이름 삭제
	public void removeBoard(String boardCode) {
		logger.debug("removeBoard()메서드 boardCode is {}", boardCode);
		boardDao.deleteBoard(boardCode);
	}
}
