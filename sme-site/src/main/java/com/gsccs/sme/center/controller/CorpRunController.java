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
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.corp.CorpRun;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;

/**
 * 企业经营数据管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value = "CorpRunCtl")
@RequestMapping(value = "/cp/corprun")
public class CorpRunController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;

	/**
	 * 企业经营数据
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String corprun(Model model, HttpServletResponse response) {
		return "corp/run-list";
	}

	/**
	 * 企业经营数据
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid datagrid(CorpRun param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account user = accountAPI.getAccount(username);
			if (null == param) {
				param = new CorpRun();
				param.setCorpid(user.getOrgid());
			}
			List<CorpRun> corpRuns = corpAPI.find(param, "year desc", page,
					pagesize);
			Integer total = corpAPI.count(param);
			datagrid.setRows(corpRuns);
			datagrid.setTotal(Long.valueOf(total));
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 企业经营数据表单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String runForm(Long id, Model model, HttpServletResponse response) {
		CorpRun corpRun = null;
		if (null != id) {
			corpRun = corpAPI.getCorpRun(id);
		}
		model.addAttribute("corpRun", corpRun);
		return "corp/run-form";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg datagrid(CorpRun param,
			 Model model) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null==param){
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Account user;
		try {
			user = accountAPI.getAccount(username);
			param.setCorpid(user.getOrgid());
			corpAPI.saveCorpRun(param);
		} catch (Exception e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("未知错误");
		}
		return jsonMsg;
	}

}
