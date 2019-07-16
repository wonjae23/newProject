package com.won.project.service.sample;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.won.project.domain.MemberVO;

public interface MemberService {
	
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap);

	public boolean loginCheck(MemberVO vo, HttpSession session);
	
	public void logout(HttpSession session);
	
	public MemberVO viewMember(MemberVO vo);
}
