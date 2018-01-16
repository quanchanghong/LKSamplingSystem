package cn.com.lk.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.Admin;
import cn.com.lk.service.AdminService;
import cn.com.lk.shiro.QCHUsernamePasswordToken;

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
		
		QCHUsernamePasswordToken token = new QCHUsernamePasswordToken(admin.getAdminName(), admin.getAdminPWD(), RealmConstant.LOGIN_TYPE_ADMIN);
		
		Subject subject = SecurityUtils.getSubject();
		try{
			subject.login(token);
		}catch(Exception e){
			System.out.println("登录失败");
			return "";
		}
		
		//目前跳到ais页面
		return "redirect:/admin/ais";
	}

}
