package com.won.project.controller.sample;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.won.project.config.EpkMap;
import com.won.project.service.sample.MemberService;

/*@RestController*/
@Controller
public class MainController {
 
	@Resource(name="memberService")
	private MemberService memberService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/index.do")
    public ModelAndView calendar(HttpServletRequest request, HttpServletResponse response,  EpkMap commandMap) {
		ModelAndView mv = new ModelAndView();
		String kk = (String) commandMap.get("name");
		
		List<Map<String,Object>> members = memberService.findAll(commandMap.getMap());
		System.out.println("2222222222222:"+members);
	    System.out.println("######:" + kk);
	    mv.addObject("name",kk);
	    mv.setViewName("/main/workCalendar");
	    
	    return mv;
    }
	
	
	
 
}