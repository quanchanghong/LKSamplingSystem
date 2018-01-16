package cn.com.lk.shiro;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

public class test extends ModularRealmAuthenticator{

	@Override
	protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> arg0, AuthenticationToken arg1) {
		// TODO Auto-generated method stub
		return super.doMultiRealmAuthentication(arg0, arg1);
	}

}
