package com.won.project.controller.sample;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.won.project.config.EpkMap;
import com.won.project.domain.MemberVO;
import com.won.project.service.sample.MemberService;

/*@RestController*/
@Controller
public class MainController {
 
	@Resource(name="memberService")
	private MemberService memberService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/index")
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
	
	
	//로그인 화면으로 이동
    @RequestMapping(value = "/main/login")
    public String boardView(@RequestParam Map<String, Object> paramMap, Model model) {
        return "/main/login";
    }
    
    @RequestMapping("/main/loginCheck")
    public String loginCheck(@ModelAttribute MemberVO vo, HttpSession session, HttpServletRequest request, Model model) {
    	boolean result = memberService.loginCheck(vo, session);
    	
    	if(result == true) {
    		model.addAttribute("msg", "success");
    		return "redirect:/board/list";
    	}else {
    		model.addAttribute("msg", "failure");
    		return "redirect:/main/login";
    	}
  
    }
	
    @RequestMapping("/main/logout")
    public ModelAndView logout(HttpSession session) {
    	memberService.logout(session);
    	ModelAndView mav = new ModelAndView();
    	
    	mav.setViewName("/main/login");
    	mav.addObject("msg","logout");
    	
    	return mav;
    }
}