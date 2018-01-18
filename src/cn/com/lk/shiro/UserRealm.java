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

import cn.com.lk.pojo.User;
import cn.com.lk.service.UserService;
/**
 * �û���֤��
 * @author 1500000367-3
 *
 */
public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println(this.getClass().getName() + "�û���ʼ��Ȩ�ˣ�������������������");
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userPassword = (UsernamePasswordToken)token;
		try {
			User user = userService.getUserByName(userPassword.getUsername());
			if (user != null){
				AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
				return info;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
