package cn.com.lk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.lk.pojo.Admin;
import cn.com.lk.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@RequestMapping(value="")
	public String showAdminLogin(){
		
		return "admin/login";
	}
	
	@RequestMapping(value="/login")
	public String login(Admin admin, Model model){
		Admin a = adminService.login(1);
		//目前跳到ais页面
		return "redirect:/admin/ais";
	}

}
