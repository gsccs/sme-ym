package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;

/**
 * 帐号管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="AccountCtl")
@RequestMapping(value = "/cp/account")
public class AccountController {

	@Autowired
	private AccountServiceI accountAPI;
	
	/**
	 * 企业帐号列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String corpaccount(Model model, HttpServletResponse response) {
		return "corp/account-list";
	}

	/**
	 * 企业帐号管理
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid datagrid(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account user = accountAPI.getAccount(username);
			List<Account> userlist = accountAPI
					.find(user.getOrgid(), page, pagesize);
			datagrid.setRows(userlist);
			datagrid.setTotal(0l);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 企业修改密码
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updatepwd", method = RequestMethod.GET)
	public String updatepwd(Long id, Model model, HttpServletResponse response) {
		try {
			Account user = accountAPI.getAccount(id);
			model.addAttribute("user", user);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "corp/account-pwd";
	}

}
