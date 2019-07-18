package com.won.project.service.board;

import java.util.List;
import java.util.Map;

import com.won.project.domain.Board;
import com.won.project.domain.BoardReply;

public interface BoardService {
	
	//정보입력 (등록 or 수정)
	int regContent(Map<String, Object> paramMap);
    
	//전체 데이터 건수를 가져온다.
    int getContentCnt(Map<String, Object> paramMap);
    
    //데이터 리스트 가져오기
    List<Board> getContentList(Map<String, Object> paramMap);
    
    //게시글 정보를 가져온다
    Board getContentView(Map<String, Object> paramMap);
    
    //AJAX 호출 (댓글 등록)
    int regReply(Map<String, Object> paramMap);
    
    List<BoardReply> getReplyList(Map<String, Object> paramMap);
    
    //AJAX 호출 (댓글 삭제)
    int delReply(Map<String, Object> paramMap);
    
    //AJAX 호출 (게시글 패스워드 확인)
    int getBoardCheck(Map<String, Object> paramMap);
    
    //AJAX 호출 (게시글 삭제)
    int delBoard(Map<String, Object> paramMap);
        
    boolean checkReply(Map<String, Object> paramMap);
    
    boolean updateReply(Map<String, Object> paramMap);
}
