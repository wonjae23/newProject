package com.won.project.controller.sample;

import java.security.MessageDigest;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.won.project.config.EpkMap;
import com.won.project.domain.MemberVO;
import com.won.project.service.sample.MemberService;

@Controller
@RequestMapping("/main")
public class MainController {
 
	@Resource(name="memberService")
	private MemberService memberService;
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//로그인 화면으로 이동
    @RequestMapping(value = "/login")
    public String boardView(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, Model model) {
    	String msg = request.getParameter("msg");
    	if(msg != null) {
    		if(msg.equals("failure")) {
    			model.addAttribute("msg","failure");
    		}		
    	}
    	
    	return "/main/login";
    }
    
    @RequestMapping("/loginCheck")
    public String loginCheck(@ModelAttribute MemberVO vo, HttpSession session, RedirectAttributes redirect) {
    	boolean result = memberService.loginCheck(vo, session);
    	
    	if(result == true) {
    		redirect.addAttribute("msg", "success"); 
    		return "redirect:/board/list";
    	}else {
    		redirect.addAttribute("msg", "failure");
    		return "redirect:/main/login";
    	}
  
    }
	
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
    	memberService.logout(session);
    	ModelAndView mav = new ModelAndView();
    	
    	mav.setViewName("/main/login");
    	mav.addObject("msg","logout");
    	
    	return mav;
    }
    
    @RequestMapping("/signUp")
    public ModelAndView signUp() {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("/main/signUp");
    	
    	return mav;
     }
    
    //AJAX 호출 (회원가입)
    @RequestMapping("/insertMember")
    public String insertMember(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
    	
    	//패스워드 암호화
        String password = "";
        try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(paramMap.get("userPw").toString().getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
 
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            password = hexString.toString();
     	}catch(Exception ex){
            throw new RuntimeException(ex);
        }
        
        paramMap.put("userPw", password);
 
        //정보입력
        try {
        	memberService.insertMember(paramMap);
        	return "redirect:/main/login";
        }catch(Exception ex){
        	throw new RuntimeException(ex);
        }
        
     }
    
    
    @RequestMapping(value="/insertMember", method=RequestMethod.POST)
    @ResponseBody
    public Object boardSave(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
    	
    	//리턴값
        Map<String, Object> retVal = new HashMap<String, Object>();
 
        
 
        return retVal;
 
    }
}