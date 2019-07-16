package com.won.project.service.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.won.project.dao.board.BoardDao;
import com.won.project.domain.Board;
import com.won.project.domain.BoardReply;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
    private BoardDao boardDao;
 
	
    @Override
    public int regContent(Map<String, Object> paramMap) {
        //���̵� ������ �Է�
        if(paramMap.get("id")==null) {
            return boardDao.regContent(paramMap);
        }else {//���̵� ������ ����
            return boardDao.modifyContent(paramMap);
        }
    }
 
    @Override
    public int getContentCnt(Map<String, Object> paramMap) {
        return boardDao.getContentCnt(paramMap);
    }
 
    @Override
    public List<Board> getContentList(Map<String, Object> paramMap) {
        return boardDao.getContentList(paramMap);
    }
 
    @Override
    public Board getContentView(Map<String, Object> paramMap) {
        return boardDao.getContentView(paramMap);
    }
 
    @Override
    public int regReply(Map<String, Object> paramMap) {
        return boardDao.regReply(paramMap);
    }
 
    @Override
    public List<BoardReply> getReplyList(Map<String, Object> paramMap) {
 
        List<BoardReply> boardReplyList = boardDao.getReplyList(paramMap);
 
        //msyql ���� ������ ������ ������ ���⼭ �׳� �ذ�����
 
        //�θ�
        List<BoardReply> boardReplyListParent = new ArrayList<BoardReply>();
        //�ڽ�
        List<BoardReply> boardReplyListChild = new ArrayList<BoardReply>();
        //����
        List<BoardReply> newBoardReplyList = new ArrayList<BoardReply>();
 
        //1.�θ�� �ڽ� �и�
        for(BoardReply boardReply: boardReplyList){
            if(boardReply.getDepth().equals("0")){
                boardReplyListParent.add(boardReply);
            }else{
                boardReplyListChild.add(boardReply);
            }
        }
 
        //2.�θ� ������.
        for(BoardReply boardReplyParent: boardReplyListParent){
            //2-1. �θ�� ������ �ִ´�.
            newBoardReplyList.add(boardReplyParent);
            //3.�ڽ��� ������.
            for(BoardReply boardReplyChild: boardReplyListChild){
                //3-1. �θ��� �ڽ��� �͵鸸 �ִ´�.
                if(boardReplyParent.getReply_id().equals(boardReplyChild.getParent_id())){
                    newBoardReplyList.add(boardReplyChild);
                }
 
            }
 
        }
 
        //������ list return
        return newBoardReplyList;
    }
 
    @Override
    public int delReply(Map<String, Object> paramMap) {
        return boardDao.delReply(paramMap);
    }
 
    @Override
    public int getBoardCheck(Map<String, Object> paramMap) {
        return boardDao.getBoardCheck(paramMap);
    }
 
    @Override
    public int delBoard(Map<String, Object> paramMap) {
        return boardDao.delBoard(paramMap);
    }
 
    @Override
    public boolean checkReply(Map<String, Object> paramMap) {
        return boardDao.checkReply(paramMap);
    }
 
    @Override
    public boolean updateReply(Map<String, Object> paramMap) {
        return boardDao.updateReply(paramMap);
    }
 

}
