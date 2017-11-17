package com.gsccs.sme.shiro.client;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 类功能说明 TODO:自定义Token
 * 
 * @author x.d zhang
 * @version V2.0
 */

public class UserPwdSiteToken extends UsernamePasswordToken {
	private static final long serialVersionUID = -3217596468830869181L;
	private String captcha;
	private Long site;

	public Long getSite() {
		return site;
	}

	public void setSite(Long site) {
		this.site = site;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public UserPwdSiteToken(String username, String password,
			boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public UserPwdSiteToken() {
		super();
	}
}
