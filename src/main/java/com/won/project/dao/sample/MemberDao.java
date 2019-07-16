package com.won.project.dao.sample;

import java.util.List;
import java.util.Map;

public interface MemberDao {
	
	public List<Map<String,Object>> findAll(Map<String, Object> commandMap);
}
