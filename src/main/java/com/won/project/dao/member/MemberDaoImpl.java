package com.won.project.dao.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.won.project.domain.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap) {	
		return sqlSession.selectList("home.selectMember",commandMap);
	}

	@Override
	public boolean loginCheck(MemberVO vo) {
		String name = sqlSession.selectOne("home.loginCheck",vo);
		return (name == null) ? false : true;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		return sqlSession.selectOne("home.viewMember", vo);
	}

	@Override
	public void logout(HttpSession session) {}

	@Override
	public void insertMember(Map<String, Object> commandMap) {
		sqlSession.insert("home.insertMember", commandMap);
	}

	@Override
	public int doubleCheck(Map<String, Object> commandMap) {
		return sqlSession.selectOne("home.doubleCheck",commandMap);
	}

}
