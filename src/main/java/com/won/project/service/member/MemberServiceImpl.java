package com.won.project.service.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.won.project.dao.member.MemberDao;
import com.won.project.domain.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
    MemberDao memberDao;
	
	@Override
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap) {
		return memberDao.findAll(commandMap);
	}

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		boolean result = memberDao.loginCheck(vo);
		if(result) {
			MemberVO vo2 = viewMember(vo);		
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());	
			}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		return memberDao.viewMember(vo);
	}

	@Override
	public void insertMember(Map<String, Object> commandMap) {
		memberDao.insertMember(commandMap);
	}

	@Override
	public int doubleCheck(Map<String, Object> commandMap) {
		return memberDao.doubleCheck(commandMap);
	}

}
