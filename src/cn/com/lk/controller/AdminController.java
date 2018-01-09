package cn.com.lk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin")
	public String showAdminIndex(){
		System.out.println("admin");
		return "admin/index";
	}

}
