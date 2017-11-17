package com.gsccs.sme.plat.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.service.UserService;

/**
 * 系统用户登录
 * @author x.d zhang
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 判断当前登录用户
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/checkSession", method = RequestMethod.POST)
	@ResponseBody
	protected JsonMsg getCurrUser(HttpServletRequest req) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		if (null == username){
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("请登录。");
			return jsonMsg;
		}
		User user = userService.findByAccount(username);
		if (null==user){
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("用户不存在！");
			return jsonMsg;
		}
		if (user.getUsertype().equals("C")){
			jsonMsg.setMsg("请用服务机构帐号登录");
			jsonMsg.setSuccess(false);
			subject.logout();
			return jsonMsg;
		}
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected String doGet(HttpServletRequest req) {
		return "login";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showLoginForm(HttpServletRequest req, Model model) {
		String error = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		token.setRememberMe(true);
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "用户名不存在";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (AuthenticationException e) {
			error = "其他错误：" + e.getMessage();
		}

		if (error != null) {// 出错了，返回登录页面
			model.addAttribute("error", error);
		} else {// 登录成功
			return "redirect:/main";
		}
		return "login";
	}

}
