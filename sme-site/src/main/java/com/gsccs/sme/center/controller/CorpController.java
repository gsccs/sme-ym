package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.Industry;
import com.gsccs.sme.api.domain.Park;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.Dict;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.DictServiceI;
import com.gsccs.sme.api.service.IndustryServiceI;
import com.gsccs.sme.api.service.ParkServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 企业管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="CorpCtl")
@RequestMapping(value = "/cp/corp")
public class CorpController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ParkServiceI parkAPI;
	@Autowired
	private DictServiceI dictAPI;
	@Autowired
	private IndustryServiceI industryAPI;
	

	/**
	 * 企业基础信息
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String corpinfo(Model model, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		List<Industry> rootindlist = industryAPI.getRootList();
		List<Industry> subindlist = null;
		try {
			Account user = accountAPI.getAccount(username);
			Corp corp = corpAPI.getCorp(user.getOrgid());
			if (null != corp && null != corp.getHycode()){
				subindlist = industryAPI.getSubList(corp.getHycode());
			}
			List<Park> parklist = parkAPI.queryParkList(null, "", 1, Integer.MAX_VALUE);
			List<Dict> stakelist = dictAPI.queryDictList("STAKE", true);
			model.addAttribute("corp", corp);
			model.addAttribute("parklist", parklist);
			model.addAttribute("stakelist", stakelist);
			model.addAttribute("rootindlist", rootindlist);
			model.addAttribute("subindlist", subindlist);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "corp/corp-info";
	}
	
	/**
	 * 更新企业信息
	 * @param corp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg corpinfo(Corp corp,Model model) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String account = (String) subject.getPrincipal();
		try {
			if(null == corp){
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("保存失败，企业信息有误！");
				return jsonMsg;
			}
			Account user = accountAPI.getAccount(account);
			if (null==user){
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("保存失败，无权限执行此操作！");
				return jsonMsg;
			}
			corpAPI.updateCorp(corp);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("保存成功！");
		} catch (ApiException e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("保存失败，未知的错误原因！");
		}
		return jsonMsg;
	}

	/**
	 * 企业类型树
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/typetree", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray typetree(Model model) {
		return corpAPI.findCorpTypeTree();
	}

}
