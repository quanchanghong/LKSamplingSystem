package cn.com.lk.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	@RequestMapping(value="/login")
	public String showUserLogin(Model model){
		
		return "login";
	}
	
	@RequestMapping(value="/regist")
	public String showUserRegist(Model model){
		
		return "regist";
	}
	
	@RequestMapping(value="/loginOut")
	public String userLOginOut(Model model){
		SecurityUtils.getSubject().logout();
		return "redirect:/";
	}
}
