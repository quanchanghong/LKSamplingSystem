package cn.com.lk.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import cn.com.lk.utils.Encrypt;

public class UserCredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		
		QCHUsernamePasswordToken qchToken = (QCHUsernamePasswordToken) token;
		
		String frontPWD = Encrypt.Md5Hash(new String(qchToken.getPassword()));
		
		String dbPWD = info.getCredentials().toString();
		
		return this.equals(frontPWD, dbPWD);
	}

}
