package com.won.project.controller.main;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.won.project.common.MessageViewer;
import com.won.project.domain.MemberVO;
import com.won.project.service.member.MemberService;

@Controller
@RequestMapping("/main")
public class MainController {
 
	@Resource(name="memberService")
	private MemberService memberService;
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//�α��� ȭ������ �̵�
    @RequestMapping(value = "/login")
    public String boardView(HttpServletRequest request, Model model) {
    	String msg = request.getParameter("msg");
    	if(msg != null) {
    		if(msg.equals("failure")) {
    			model.addAttribute("msg","failure");
    		}		
    	}
    	
    	return "/main/login";
    }
    
    //�α��� üũ
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
	
    //�α׾ƿ�
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
    	memberService.logout(session);
    	ModelAndView mav = new ModelAndView();	
    	mav.setViewName("/main/login");
    	mav.addObject("msg","logout");
    	
    	return mav;
    }
    
    //ȸ������
    @RequestMapping("/signUp")
    public ModelAndView signUp() {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("/main/signUp");
    	
    	return mav;
     }
    
    //ȸ������
    @RequestMapping("/insertMember")
    public String insertMember(HttpServletResponse response, @RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
    	
    	//�н����� ��ȣȭ
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
 
        try {
        	//ȸ������
        	memberService.insertMember(paramMap);
        	MessageViewer.alert(response, "�������̵�", "������ �Ϸ�Ǿ����ϴ�. �α��� �������� �̵��մϴ�.", "/main/login", false, false, false, "");
        	return null;
        }catch(Exception ex){
        	throw new RuntimeException(ex);
        }  
     }
    
    //AJAX ȣ�� (�ߺ����̵� üũ)
    @RequestMapping(value="/doubleCheck", method=RequestMethod.POST)
    @ResponseBody
    public Object doubleCheck(@RequestParam Map<String, Object> paramMap) {
 
        //���ϰ�
        Map<String, Object> retVal = new HashMap<String, Object>();
 
        int result = memberService.doubleCheck(paramMap);
 
        if(result==0){
            retVal.put("code", "OK");
        }else{
            retVal.put("code", "FAIL");
        }
 
        return retVal;
 
    }
}