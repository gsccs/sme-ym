package com.gsccs.sme.auth.shiro.client;

import java.util.Set;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.plat.auth.service.AuthService;
import com.gsccs.sme.plat.auth.service.UserService;

/**
 * 单点登录
 */
public class ClientCasRealm extends CasRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;

	private String appKey = "645ba616-370a-43a8-a8e0-993e7a590cf0";

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppKey() {
		return appKey;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> rolelist = authService.findRoles(appKey,username);
		/*Iterator<String> its = rolelist.iterator();
		while(its.hasNext()){
			System.out.println(its.next());
		}*/
		authorizationInfo.setRoles(rolelist);
		authorizationInfo.setStringPermissions(authService
				.findPermissions(appKey,username));
		return authorizationInfo;
	}

}
