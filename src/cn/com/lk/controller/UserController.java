package cn.com.lk.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.User;
import cn.com.lk.service.UserService;
import cn.com.lk.shiro.QCHUsernamePasswordToken;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String login(User user, Model model){
		QCHUsernamePasswordToken token = new QCHUsernamePasswordToken(user.getUserName(), user.getPassword(), RealmConstant.LOGIN_TYPE_USER);
		Subject subject = SecurityUtils.getSubject();
		try{
			subject.login(token);
		}catch(Exception e){
			System.out.println("user login failed!");
			return "redirect:/login";
		}
		return "redirect:/";
	}

}
