package com.gsccs.sme.center.controller;

import java.util.Date;
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
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.SneedServiceI;

/**
 * 企业需求管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="NeedCtl")
@RequestMapping(value = "/cp/sneed")
public class NeedController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private SneedServiceI sneedAPI;

	/**
	 * 需求列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String sneedlist(Model model, HttpServletResponse response) {
		return "sneed/sneed-list";
	}
	
	
	/**
	 * 需求详情
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(Long id,Model model, HttpServletResponse response) {
		Sneed sneed = null;
		try {
			sneed = sneedAPI.getSneed(id);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		model.addAttribute("sneed", sneed);
		return "sneed/sneed-view";
	}
	
	
	
	/**
	 * 需求表单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Long id,Model model, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Account user = null;
		Sneed sneed = null;
		try {
			user = accountAPI.getAccount(username);
			sneed = sneedAPI.getSneed(id);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		model.addAttribute("sneed",sneed);
		model.addAttribute("user", user);
		return "sneed/sneed-form";
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
			Sneed sneed = new Sneed();

			Account user = accountAPI.getAccount(username);
			if (null != user) {
				sneed.setCorpid(user.getOrgid());
			}
			List<Sneed> sneedList = sneedAPI.querySneedList(sneed,
					"addtime desc", page, pagesize);
			datagrid.setRows(sneedList);
			datagrid.setTotal(30l);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/bid/datagrid", method = RequestMethod.POST)
	public Datagrid datagrid(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, 
			Long id,
			Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		try {
			datagrid = sneedAPI.queryBidList(id, "addtime desc", page, pagesize);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg add(@RequestBody Sneed sneed, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null != sneed) {
				Account user = accountAPI.getAccount(username);
				if (null != user) {
					sneed.setCorpid(user.getOrgid());
				}
				sneed.setAddtime(new Date());
				sneedAPI.addSneed(sneed);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("需求发布成功。");
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("需求发布失败。");
		}
		return jsonMsg;
	}

	/**
	 * 修改需求
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg edit(@RequestBody Sneed sneed, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null != sneed) {
				Account user = accountAPI.getAccount(username);
				if (null != user) {
					sneed.setCorpid(user.getOrgid());
				}
				sneed.setAddtime(new Date());
				sneedAPI.updateSneed(sneed);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("需求信息保存成功。");
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("需求信息保存失败。");
		}
		return jsonMsg;
	}

	/**
	 * 参与竞标
	 * 
	 * @param sneedid
	 * @param remark
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bid", method = RequestMethod.POST)
	public JsonMsg SneedBid(Long sneedid, String remark, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null == sneedid) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("竞标失败，需求不存在！");
				return jsonMsg;
			}
			Account user = accountAPI.getAccount(username);
			Sneed sneed = sneedAPI.getSneed(sneedid);
			if (null == sneed || !sneed.getStatus().equals("0")) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("竞标失败，需求已关闭");
			}
			sneedAPI.addSneedBid(sneedid, user.getOrgid(), remark);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("竞标成功。");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("竞标失败。");
		}
		return jsonMsg;
	}

	
	/**
	 * 指定中标单位
	 * @param sneedid
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stoned", method = RequestMethod.POST)
	public JsonMsg SneedBidStoned(Long id, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try{
			if (null == id){
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("选择失败！数据不存在");
				return jsonMsg;
			}
			
			sneedAPI.setSneedBidStone(id);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("保存成功！");
		}catch(Exception e){
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("选择失败！数据不存在");
		}
		return jsonMsg;
	}
	
}
