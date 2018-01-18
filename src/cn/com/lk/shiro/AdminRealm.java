package cn.com.lk.shiro;

import java.util.Collection;
import java.util.Iterator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.lk.constant.RealmConstant;
import cn.com.lk.pojo.Admin;
import cn.com.lk.pojo.User;
import cn.com.lk.service.AdminService;
/**
 * shiro认证授权域     一般继承AuthorizingRealm比直接实现realm接口好用
 * 后台认证域
 * @author 1500000367-3
 *
 */
public class AdminRealm extends AuthorizingRealm{
	
	@Autowired
	private AdminService adminService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		
		System.out.println(this.getClass().getName() + "开始授权了！。。。。。。。。。");
		Object obj = null;
		SimpleAuthorizationInfo info = null;
		
		if (pc.fromRealm(this.getName()).iterator().hasNext()){
			obj = pc.fromRealm(this.getName()).iterator().next();
			if (obj instanceof Admin){
				Admin admin = (Admin)obj;
				if (admin.getRole().equals(RealmConstant.SYSTEM_ROLE_TYPE_ADMIN)){
					info = new SimpleAuthorizationInfo();
					info.addRole(RealmConstant.SYSTEM_ROLE_TYPE_ADMIN);
				}
			}
		}
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		System.out.println(this.getClass().getName() + "开始认证！。。。。。。。。。");
		
		UsernamePasswordToken userPassword = (UsernamePasswordToken)token;
		try {
			Admin admin = adminService.getAdminByName(userPassword.getUsername());
			if (admin != null){
				AuthenticationInfo info = new SimpleAuthenticationInfo(admin, admin.getAdminPWD(), this.getName());
				return info;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
