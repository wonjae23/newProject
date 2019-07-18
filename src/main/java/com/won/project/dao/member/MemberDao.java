package com.won.project.dao.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.won.project.domain.MemberVO;

public interface MemberDao {
	
	//�׽�Ʈ�� ȸ������ ��������
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap);

	//�α��� üũ
	public boolean loginCheck(MemberVO vo);

	//ȸ������ ��������
	public MemberVO viewMember(MemberVO vo);
	
	//�α׾ƿ�
	public void logout(HttpSession session);

	//ȸ������
	public void insertMember(Map<String, Object> commandMap);

	//�ߺ� ���̵� üũ
	public int doubleCheck(Map<String, Object> commandMap);
}
