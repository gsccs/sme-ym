package com.gsccs.sme.shiro.client;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.gsccs.sme.api.service.AccountServiceI;

/**
 * 单点登录
 */
public class ClientCasRealm extends CasRealm {

	private AccountServiceI accountAPI;
	private String appKey;

	public void setAppKey(String appKey) {
		System.out.println("APPKEY:" + appKey);
		this.appKey = appKey;
	}

	public String getAppKey() {
		return appKey;
	}

	public AccountServiceI getAccountAPI() {
		return accountAPI;
	}

	public void setAccountAPI(AccountServiceI accountAPI) {
		this.accountAPI = accountAPI;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		System.out.println("*******************");
		System.out.println("**  " + username + " **");
		System.out.println("*******************");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// authorizationInfo.setRoles(userService.findRoles(username));
		// authorizationInfo.setStringPermissions(userService.findPermissions(username));
		return authorizationInfo;
	}

}
