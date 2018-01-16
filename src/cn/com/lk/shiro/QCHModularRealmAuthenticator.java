package cn.com.lk.shiro;

import java.util.Collection;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import cn.com.lk.constant.RealmConstant;

public class QCHModularRealmAuthenticator extends ModularRealmAuthenticator {
	
	private Map<String, Object> myRealms;

	public Map<String, Object> getMyRealms() {
		return myRealms;
	}

	public void setMyRealms(Map<String, Object> myRealms) {
		this.myRealms = myRealms;
	}

	@Override
	protected void assertRealmsConfigured() throws IllegalStateException {
		super.assertRealmsConfigured();
	}

	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)throws AuthenticationException {
		
		this.assertRealmsConfigured();
		
		Realm realm = null;
		
		QCHUsernamePasswordToken token = (QCHUsernamePasswordToken) authenticationToken;
		
		if (token.getLoginType().equals(RealmConstant.LOGIN_TYPE_ADMIN)){
			realm = (Realm) this.myRealms.get(RealmConstant.LOGIN_TYPE_ADMIN);
		}else{
			realm = (Realm) this.myRealms.get(RealmConstant.LOGIN_TYPE_USER);
		}
		
		return this.doSingleRealmAuthentication(realm, token);
	}

	@Override
	protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> arg0, AuthenticationToken arg1) {
		return super.doMultiRealmAuthentication(arg0, arg1);
	}

	@Override
	protected AuthenticationInfo doSingleRealmAuthentication(Realm arg0, AuthenticationToken arg1) {
		return super.doSingleRealmAuthentication(arg0, arg1);
	}

}
