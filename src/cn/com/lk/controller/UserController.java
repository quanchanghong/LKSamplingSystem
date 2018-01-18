package cn.com.lk.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xpath.internal.operations.Mod;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.User;
import cn.com.lk.service.UserService;
import cn.com.lk.shiro.QCHUsernamePasswordToken;
import cn.com.lk.utils.Encrypt;

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
			User authUser = (User) subject.getPrincipal();
			
			subject.getSession().setAttribute("user", authUser);
			
		}catch(Exception e){
			model.addAttribute("loginErrMsg", "用户名或者密码错误！");
			return "login";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/regist")
	public String regist(User user, Model model){
		
		if (user != null){
			user.setPassword(Encrypt.Md5Hash(user.getPassword()));
			user.setRole(RealmConstant.SYSTEM_ROLE_TYPE_USER);
			Integer save = userService.save(user);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/check")
	@ResponseBody
	public String checkUserIsExistByName(@RequestParam String userName) throws Exception{
		System.out.println("/////////////////////////");
		String msg = "0";//用户名可以使用
		User user = userService.getUserByName(userName);
		if (user != null){
			msg = "1";//用户名已经存在！
		}
		return msg;
	}

}
