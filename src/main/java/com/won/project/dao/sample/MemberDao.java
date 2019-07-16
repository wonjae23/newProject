package com.won.project.dao.sample;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.won.project.domain.MemberVO;

public interface MemberDao {
	
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap);

	public boolean loginCheck(MemberVO vo);

	public MemberVO viewMember(MemberVO vo);
	
	public void logout(HttpSession session);
}
