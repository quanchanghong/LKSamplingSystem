package cn.com.lk.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.lk.pojo.Admin;
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
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userPassword = (UsernamePasswordToken)token;
		try {
			Admin admin = adminService.getAdminByName(userPassword.getUsername());
			AuthenticationInfo info = new SimpleAuthenticationInfo(admin, admin.getAdminPWD(), this.getName());
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
