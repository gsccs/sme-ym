package com.gsccs.sme.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.app.core.Const;
import com.gsccs.sme.mail.service.MailService;
import com.gsccs.sme.web.api.service.RedisService;
import com.gsccs.sme.web.util.DES;

/**
 * 帐号注册
 * 
 * @author x.d zhang
 * @Date: 16-2-15
 * @version 1.0
 */
@Controller
public class RegistController {

	private static String domain = "http://www.smeym.org";

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/reg.html", method = RequestMethod.GET)
	public String regist(Model model, HttpServletResponse response) {
		return "regist";
	}

	/**
	 * 找回密码
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pwdback.html", method = RequestMethod.GET)
	public String getpwd(Model model, HttpServletResponse response) {
		return "pwdback";
	}

	/**
	 * 找回密码
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pwdback", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg findpwd(String account, String email, Model model,
			HttpServletResponse response) {
		JsonMsg msg = new JsonMsg();
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(email)) {
			msg.setSuccess(false);
			msg.setMsg("帐号和邮箱地址不能为空。");
			return msg;
		}
		String subject = "账号密码找回";
		String content = getMailRegist(account, email);
		mailService.send(email, subject, content);
		msg.setSuccess(true);
		msg.setMsg("密码找回邮件已发送，请登录【" + email + "】查看。");
		return msg;
	}

	/**
	 * 通过邮件认证帐号
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pwdvalid.html", method = RequestMethod.GET)
	public String accountValid(String account, String email, String vcode,
			Model model, HttpServletResponse response) {
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(email)
				|| StringUtils.isEmpty(vcode)) {
			model.addAttribute("result",false);
			model.addAttribute("msg","链接已失效");
		}
		String validcode = getValidCode(account, email);
		if(!vcode.equals(validcode)){
			model.addAttribute("result",false);
			model.addAttribute("msg","链接无效");
		}
		model.addAttribute("result",true);
		model.addAttribute("msg", "帐号认证成功");
		model.addAttribute("account", account);
		return "pwdvalid";
	}
	
	
	/**
	 * 修改密码
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pwdupdate", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg pwdupdate(String account, String pwd, Model model,
			HttpServletResponse response) {
		JsonMsg msg = new JsonMsg();
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(pwd)) {
			msg.setSuccess(false);
			msg.setMsg("帐号和密码不能为空。");
			return msg;
		}
		try {
			Account user = accountAPI.getAccount(account);
			if (null != user){
				user.setPassword(pwd);
				accountAPI.updateAccount(user);
			}
			msg.setSuccess(true);
			msg.setMsg("密码已修改，请重新登录。");
		} catch (ApiException e) {
			e.printStackTrace();
			msg.setSuccess(true);
			msg.setMsg("密码修改失败。");
		}
		return msg;
	}

	
	/**
	 * 通过邮件修改密码
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pwdupdate.html", method = RequestMethod.GET)
	public String changepwd(String account, String email, String vcode,
			Model model, HttpServletResponse response) {
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(email)
				|| StringUtils.isEmpty(vcode)) {
			model.addAttribute("result",false);
			model.addAttribute("msg","链接无效");
			return "pwdupdate";
		}
		
		try {
			String decode = new DES(Const.DES_KEY).decrypt(vcode);
			if(StringUtils.isEmpty(decode)){
				model.addAttribute("result",false);
				model.addAttribute("msg","链接无效");
				return "changepwd";
			}
			String params[] = decode.split("\\|");
			if(params.length<3){
				model.addAttribute("result",false);
				model.addAttribute("msg","链接无效");
				return "changepwd";
			}
			String datestr = params[2];
			long diff = new Date().getTime()-Long.valueOf(datestr);
			long hours = diff / (60 * 60 * 1000) % 24;
			if (hours>48){
				model.addAttribute("result",false);
				model.addAttribute("msg","链接已失效");
				return "changepwd";
			}
		} catch (Exception e) {
			model.addAttribute("result",false);
			model.addAttribute("msg","链接已失效");
			return "changepwd";
		}
		
		model.addAttribute("result",true);
		model.addAttribute("account", account);
		return "pwdupdate";
	}

	
	/**
	 * 注册提交
	 * 
	 * @param user
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg regist(@RequestBody Account user, HttpServletRequest req,
			Model model) {
		JsonMsg json = new JsonMsg();
		if (null == user) {
			json.setSuccess(false);
			json.setMsg("注册失败，注册信息不完整！");
			return json;
		}

		if (StringUtils.isBlank(user.getAccount())) {
			json.setSuccess(false);
			json.setMsg("注册失败，登录账号不能为空！");
			return json;
		}

		if (StringUtils.isBlank(user.getPassword())) {
			json.setSuccess(false);
			json.setMsg("注册失败，登录密码不能为空！");
			return json;
		}

		try {
			accountAPI.registAccount(user);
			json.setSuccess(true);
			json.setMsg(user.getAccount() + " 帐号注册成功！");
			json.setData(user);
			if (StringUtils.isNotEmpty(user.getEmail())) {
				String subject = "账号激活邮件";
				String content = getMailRegist(user.getAccount(),user.getEmail());
				//mailService.send(user.getEmail(), subject, content);
			}
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg(" 帐号注册失败,未知错误！");
		}

		return json;
	}

	/**
	 * ajax检查用户名称是否存在
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAccount", method = RequestMethod.POST)
	public JsonMsg checkAccountExist(String account) {
		JsonMsg msg = new JsonMsg();
		if (StringUtils.isBlank(account)) {
			msg.setSuccess(false);
			msg.setMsg("登录帐号不能为空!");
			return msg;
		} else {
			try {
				Account user = accountAPI.getAccount(account);
				if (null != user) {
					msg.setSuccess(false);
					msg.setMsg("用户名已存在！");
				} else {
					msg.setSuccess(true);
					msg.setMsg("用户名不存在！");
				}
			} catch (ApiException e1) {
				msg.setSuccess(false);
				msg.setMsg("未知错误！");
			}
		}
		return msg;
	}

	/**
	 * 注册验证邮件内容
	 * 
	 * @param account
	 * @param email
	 * @return
	 */
	public String getMailRegist(String account, String email) {
		String validcode = getValidCode(account, email);
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎注册玉门市中小企业服务平台。<br>");
		sb.append("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
		sb.append("<a href=\"" + domain + "/pwdvalid.html?account=" + account
				+ "&email=");
		sb.append(email);
		sb.append("&vcode=");
		sb.append(validcode);
		sb.append("\">");
		sb.append(domain + "/pwdvalid.html?account=" + account + "&email="
				+ email);
		sb.append("&vcode=");
		sb.append(validcode);
		sb.append("</a>");
		return sb.toString();
	}

	/**
	 * 密码找回邮件内容
	 * 
	 * @param account
	 * @param email
	 * @return
	 */
	public String getMailFindpwd(String account, String email) {

		String validcode = getValidCode(account, email);
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎访问玉门市中小企业服务平台。<br>");
		sb.append("点击下面链接修改密码，48小时生效，请尽快修改密码！</br>");
		sb.append("<a href=\"" + domain + "/pwdupdate.html?account=" + account
				+ "&email=");
		sb.append(email);
		sb.append("&vcode=");
		sb.append(validcode);
		sb.append("\">");
		sb.append(domain + "/pwdupdate.html?account=" + account + "&email=" + email);
		sb.append("&vcode=");
		sb.append(validcode);
		sb.append("</a>");
		return sb.toString();
	}

	public String getValidCode(String account, String email) {
		String validateCode = null;
		try {
			validateCode = new DES(Const.DES_KEY)
					.encrypt(account + "|" + email+"|"+new Date().getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validateCode;
	}
	
	

}
