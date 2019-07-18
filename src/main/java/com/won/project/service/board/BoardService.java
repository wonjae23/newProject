package com.won.project.service.board;

import java.util.List;
import java.util.Map;

import com.won.project.domain.Board;
import com.won.project.domain.BoardReply;

public interface BoardService {
	
	//�����Է� (��� or ����)
	int regContent(Map<String, Object> paramMap);
    
	//��ü ������ �Ǽ��� �����´�.
    int getContentCnt(Map<String, Object> paramMap);
    
    //������ ����Ʈ ��������
    List<Board> getContentList(Map<String, Object> paramMap);
    
    //�Խñ� ������ �����´�
    Board getContentView(Map<String, Object> paramMap);
    
    //AJAX ȣ�� (��� ���)
    int regReply(Map<String, Object> paramMap);
    
    List<BoardReply> getReplyList(Map<String, Object> paramMap);
    
    //AJAX ȣ�� (��� ����)
    int delReply(Map<String, Object> paramMap);
    
    //AJAX ȣ�� (�Խñ� �н����� Ȯ��)
    int getBoardCheck(Map<String, Object> paramMap);
    
    //AJAX ȣ�� (�Խñ� ����)
    int delBoard(Map<String, Object> paramMap);
        
    boolean checkReply(Map<String, Object> paramMap);
    
    boolean updateReply(Map<String, Object> paramMap);
}
