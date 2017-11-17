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
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.corp.CorpTech;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;

/**
 * 企业工艺管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value = "CorpTechCtl")
@RequestMapping(value = "/cp/corptech")
public class CorpTechController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;

	/**
	 * 企业工艺数据
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String corptech(Model model, HttpServletResponse response) {
		return "corp/tech-list";
	}

	/**
	 * 企业生产工艺
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
			
			CorpTech param = new CorpTech();
			param.setCorpid(user.getOrgid());
			List<CorpTech> corpTechList = corpAPI.find(param, "", page,pagesize);
			Integer count = corpAPI.count(param);
			datagrid.setRows(corpTechList);
			datagrid.setTotal(Long.valueOf(count));
			
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 工艺表单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String techForm(Long id, Model model, HttpServletResponse response) {
		CorpTech corpTech = null;
		if (null != id) {
			corpTech = corpAPI.getCorpTech(id);
		}
		model.addAttribute("corpTech", corpTech);
		return "corp/tech-form";
	}

	/**
	 * 工艺表单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg techSave(@RequestBody CorpTech param, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == param) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			System.out.println(param.getTitle());
			System.out.println(param.getRemark());
			Account user = accountAPI.getAccount(username);
			param.setCorpid(user.getOrgid());
			corpAPI.saveTech(param);
			jsonMsg.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("未知错误");
		}
		return jsonMsg;
	}

}
