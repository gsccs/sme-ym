package com.gsccs.sme.center.controller;

import java.util.Date;

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
import com.gsccs.sme.api.domain.AppealItem;
import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AppealServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 企业行政诉求管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="AppealCtl")
@RequestMapping(value = "/cp/appeal")
public class AppealController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private AppealServiceI appealAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 诉求主题列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	public String appealTopiclist(Model model, HttpServletResponse response) {
		return "appeal/topic-list";
	}

	/**
	 * 进度列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/trace", method = RequestMethod.GET)
	public String appealTracelist(Long id, Model model,
			HttpServletResponse response) {
		model.addAttribute("id", id);
		return "appeal/item-trace";
	}

	/**
	 * 诉求列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String appealItemlist(Model model, HttpServletResponse response) {
		return "appeal/item-list";
	}

	/**
	 * 办理结果确认及评价
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/eval", method = RequestMethod.GET)
	public String appealItemEval(Long id, Model model,
			HttpServletResponse response) {
		try {
			AppealItem appealItem = appealAPI.getItem(id);
			model.addAttribute("appealItem", appealItem);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "appeal/item-eval";
	}
	
	@ResponseBody
	@RequestMapping(value = "/topic/datagrid", method = RequestMethod.POST)
	public Datagrid appealTopiclist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		try {
			datagrid = appealAPI.queryTopicList(null, "addtime desc", page,
					pagesize);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	

	@ResponseBody
	@RequestMapping(value = "/item/datagrid", method = RequestMethod.POST)
	public Datagrid appealItemlist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			AppealItem appeal = new AppealItem();
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				appeal.setCorpid(user.getOrgid());
			}
			datagrid = appealAPI.queryItemList(appeal, "addtime desc", page,
					pagesize);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 发布需求
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String appealform(Long topicid, Long itemid, Model model,
			HttpServletResponse response) {
		AppealTopic appealTopic = null;
		AppealItem appealItem = null;
		try {
			if (null != itemid) {
				appealItem = appealAPI.getItem(itemid);
				appealTopic = appealAPI.getTopic(appealItem.getTopicid());
			} else {
				appealTopic = appealAPI.getTopic(topicid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("appealItem", appealItem);
		model.addAttribute("appealTopic", appealTopic);
		return "appeal/item-form";
	}

	/**
	 * 提交诉求信息
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg postAppealItem(@RequestBody AppealItem appealItem,
			Model model, HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null == appealItem) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("保存失败，申请内容有误。");
				return jsonMsg;
			}
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				appealItem.setCorpid(user.getOrgid());
			}
			
			appealItem.setAddtime(new Date());
			appealAPI.addAppealItem(appealItem);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("需求提交成功。");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("需求提交失败，原因未知！");
		}
		return jsonMsg;
	}

	/**
	 * 修改诉求信息
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg updateAppeal(@RequestBody AppealItem appealitem,
			Model model, HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = accountAPI.getAccount(username);
			if (null == appealitem) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("需求提交失败，信息有误！");
				return jsonMsg;
			}
			if (null == user) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("需求提交失败，请先登录！");
				return jsonMsg;
			}
			appealitem.setCorpid(user.getOrgid());
			appealAPI.editAppealItem(appealitem);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("需求提交成功！");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("需求提交失败！未知原因。");
		}
		return jsonMsg;
	}

	/**
	 * 修改诉求信息
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg cancelAppeal(Long id, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = accountAPI.getAccount(username);
			if (null == id) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("取消失败，内容不存在！");
				return jsonMsg;
			}
			AppealItem appealItem = appealAPI.getItem(id);
			if (user.getOrgid() == appealItem.getCorpid()) {
				appealItem.setStatus("-2");
				appealAPI.editAppealItem(appealItem);
			}
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("取消成功！");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("取消失败！未知原因。");
		}
		return jsonMsg;
	}

	/**
	 * 办理结果评价信息
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/eval", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg evalAppeal(Long id, Integer score, String eval, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = accountAPI.getAccount(username);
			if (null == id) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("办理结果确认失败，内容不存在！");
				return jsonMsg;
			}
			AppealItem appealItem = appealAPI.getItem(id);
			if (user.getOrgid() == appealItem.getCorpid()) {
				//appealItem.setStatus("3");
				appealItem.setScore(score);
				appealItem.setEvalstr(eval);
				appealAPI.editAppealItem(appealItem);
			}
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("办理结果确认成功！");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("办理结果确认失败！未知原因。");
		}
		return jsonMsg;
	}

}
