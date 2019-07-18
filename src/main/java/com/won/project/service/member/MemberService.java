package com.won.project.service.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.won.project.domain.MemberVO;

public interface MemberService {
	
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap);

	//�α��� üũ
	public boolean loginCheck(MemberVO vo, HttpSession session);
	
	//�α׾ƿ�
	public void logout(HttpSession session);
	
	//ȸ������ ��������
	public MemberVO viewMember(MemberVO vo);
	
	//ȸ������
	public void insertMember(Map<String, Object> commandMap);
	
	//�ߺ� ���̵� üũ
	public int doubleCheck(Map<String, Object> commandMap);
}
