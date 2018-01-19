package cn.com.lk.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;

public class RoleUtils {
	
	public static void checkRole(String role){
		try {
			SecurityUtils.getSubject().checkRole(role);
		}catch(UnauthorizedException e){
		}
	}
}
