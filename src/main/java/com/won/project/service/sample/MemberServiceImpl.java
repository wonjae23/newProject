package com.won.project.service.sample;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.won.project.dao.sample.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
    MemberDao memberDao;
	
	@Override
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap) {
		return memberDao.findAll(commandMap);
	}

}
