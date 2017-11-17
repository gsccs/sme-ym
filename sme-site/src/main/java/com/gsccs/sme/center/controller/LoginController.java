package com.gsccs.sme.center.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.shiro.client.UserPwdSiteToken;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 会员登录管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class LoginController {

	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String doGet(Model model, HttpServletResponse response) {
		String tempPath = "html/login.html";
		Corp corp = null;
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account user = accountAPI.getAccount(username);
			corp = corpAPI.getCorp(user.getId());
			if (null == corp) {
				tempPath = "shop/shop404.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg showLoginForm(HttpServletRequest req, Model model) {

		JsonMsg json = new JsonMsg();
		String error = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Subject subject = SecurityUtils.getSubject();
		UserPwdSiteToken token = new UserPwdSiteToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());
		token.setRememberMe(true);
		try {
			subject.login(token);
			json.setSuccess(true);
			return json;
		} catch (UnknownAccountException e) {
			error = "用户名不存在";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			error = "其他错误：" + e.getMessage();
		}
		json.setSuccess(false);
		json.setMsg(error);
		return json;

	}

	@RequestMapping(value = "/checkSession", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg checkSession(HttpServletRequest req, Model model) {

		JsonMsg json = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String account = (String) subject.getPrincipal();
		if (StringUtils.isEmpty(account)) {
			json.setSuccess(false);
		} else {
			try {
				Account user = accountAPI.getAccount(account);
				if (null != user) {
					json.setSuccess(true);
					json.setData(user);
				}
			} catch (ApiException e) {
				json.setSuccess(false);
			}
		}
		return json;

	}

	@RequestMapping(value = "/updatepwd", method = RequestMethod.GET)
	public String updatepwd(Model model, HttpServletResponse response) {
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account user = accountAPI.getAccount(username);
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "corp/updatepwd";
	}

	@ResponseBody
	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	public JsonMsg updatepwdPost(Long userid, String pwd, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account account = accountAPI.getAccount(username);
			if (account.getId() == userid && StringUtils.isNotEmpty(pwd)) {
				account.setPassword(pwd);
				accountAPI.updateAccount(account);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("密码更新成功！");
			} else {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("密码更新失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonMsg;
	}

	/**
	 * 用户注销
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public JSONObject logout() {
		// 清除用户session
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return null;
	}

}
