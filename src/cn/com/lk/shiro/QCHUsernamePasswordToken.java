package cn.com.lk.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class QCHUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	
	private String loginType;

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public QCHUsernamePasswordToken(String username,String password, String loginType) {
		super(username, password);
		this.loginType = loginType;
	}
}
