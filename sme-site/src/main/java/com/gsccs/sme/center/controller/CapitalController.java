package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.CapitalAppl;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.SneedServiceI;

/**
 * 融资管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value = "CapitalCtl")
@RequestMapping(value = "/cp/capital")
public class CapitalController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private SneedServiceI sneedAPI;

	/**
	 * 融资需求列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String capitallist(Model model, HttpServletResponse response) {
		return "sneed/capital-list";
	}

	/**
	 * 需求表单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Long id, Model model, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Account user = null;
		CapitalAppl appl = null;
		Corp corp = null;
		try {
			user = accountAPI.getAccount(username);
			if (null != user) {
				corp = corpAPI.getCorp(user.getOrgid());
			}
			appl = sneedAPI.getCapitalAppl(id);
			if (null == appl) {
				appl = new CapitalAppl();
				appl.setLinker(user.getName());
				appl.setLinktel(user.getPhone());
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		model.addAttribute("corp", corp);
		model.addAttribute("capitalAppl", appl);
		model.addAttribute("user", user);
		return "sneed/capital-form";
	}

	@ResponseBody
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public Datagrid datagrid(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			CapitalAppl appl = new CapitalAppl();
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				appl.setCorpid(user.getOrgid());
			}
			List<CapitalAppl> applList = sneedAPI.find(appl, "addtime desc",
					page, pagesize);
			int count = sneedAPI.count(appl);
			datagrid.setRows(applList);
			datagrid.setTotal(Long.valueOf(count));
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg add(@RequestBody CapitalAppl appl, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null != appl) {
				Account user = accountAPI.getAccount(username);
				if (null != user) {
					appl.setCorpid(user.getOrgid());
				}
				sneedAPI.addCapitalAppl(appl);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("保存成功。");
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("保存失败。");
		}
		return jsonMsg;
	}

	/**
	 * 删除需求
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(Long id, Model model, HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null != id) {
			sneedAPI.delCapitalAppl(id);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("删除成功。");
		} else {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("删除失败。");
		}
		return jsonMsg;
	}

}
