package com.won.project.service.sample;

import java.util.List;
import java.util.Map;

public interface MemberService {
	
	 public List<Map<String,Object>> findAll(Map<String, Object> commandMap);
}
