package com.won.project.dao.sample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap) {	
		return sqlSession.selectList("home.selectMember",commandMap);
	}

}
