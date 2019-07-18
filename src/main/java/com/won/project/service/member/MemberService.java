package com.won.project.service.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.won.project.domain.MemberVO;

public interface MemberService {
	
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap);

	//로그인 체크
	public boolean loginCheck(MemberVO vo, HttpSession session);
	
	//로그아웃
	public void logout(HttpSession session);
	
	//회원정보 가져오기
	public MemberVO viewMember(MemberVO vo);
	
	//회원가입
	public void insertMember(Map<String, Object> commandMap);
	
	//중복 아이디 체크
	public int doubleCheck(Map<String, Object> commandMap);
}
