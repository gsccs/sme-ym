package com.gsccs.sme.center.controller;

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
import com.gsccs.sme.api.domain.DeclareItem;
import com.gsccs.sme.api.domain.DeclareTopic;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.DeclareServiceI;

/**
 * 项目申报管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="DeclareCtl")
@RequestMapping(value = "/cp/declare")
public class DeclareController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private DeclareServiceI declareAPI;

	/**
	 * 项目申报主题列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/topics", method = RequestMethod.GET)
	public String topics(Model model, HttpServletResponse response) {
		return "declare/topic-list";
	}
	
	
	/**
	 * 项目申报列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String items(Model model, HttpServletResponse response) {
		return "declare/item-list";
	}


	/**
	 * 项目申报主题
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/topic/view", method = RequestMethod.GET)
	public String topicView(Long id, Model model, HttpServletResponse response) {
		if (null != id) {
			try {
				DeclareTopic declareTopic = declareAPI.getTopic(id);
				model.addAttribute("declareTopic", declareTopic);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		return "declare/topic-view";
	}
	
	
	/**
	 * 项目申报详情
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/item/view", method = RequestMethod.GET)
	public String itemView(Long id, Model model, HttpServletResponse response) {
		DeclareItem declareItem = null;
		DeclareTopic declareTopic = null;
		if (null != id) {
			try {
				declareItem = declareAPI.getItem(id);
				Long topicid = declareItem.getTopicid();
				declareTopic = declareAPI.getTopic(topicid);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("declareItem", declareItem);
		model.addAttribute("declareTopic", declareTopic);
		return "declare/item-view";
	}

	
	/**
	 * 项目申报列表数据
	 * 
	 * @param page
	 * @param pagesize
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/item/datagrid", method = RequestMethod.POST)
	public Datagrid datagrid(DeclareItem declareItem,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			if (null == declareItem) {
				declareItem = new DeclareItem();
			}
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				declareItem.setCorpid(user.getOrgid());
			}
			datagrid = declareAPI
					.queryItemList(declareItem, "", page, pagesize);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 项目申报主题数据
	 * 
	 * @param page
	 * @param pagesize
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/topic/datagrid", method = RequestMethod.POST)
	public Datagrid declareTopiclist(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		try {
			return declareAPI.queryTopicList(null, "", page, pagesize);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 请求申报页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String declareItemAdd(Long id,Long topicid, Model model,
			HttpServletResponse response) {
		DeclareTopic declareTopic = null;
		DeclareItem declareItem = null;
		try {
			if (null != id) {
				declareItem = declareAPI.getItem(id);
			}
			if (null != declareItem){
				topicid = declareItem.getTopicid();
			}
			declareTopic = declareAPI.getTopic(topicid);
			model.addAttribute("declareItem", declareItem);
			model.addAttribute("declareTopic", declareTopic);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "declare/item-form";
	}

	/**
	 * 提交申报表单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg postDeclare(@RequestBody DeclareItem declareItem, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null == declareItem) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("项目申报信息提交失败。");
				return jsonMsg;
			}
				
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				declareItem.setCorpid(user.getOrgid());
			}
			declareAPI.addDeclareItem(declareItem);
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("项目申报信息提交失败，未知错误！");
		}
		return jsonMsg;
	}
	
	
	/**
	 * 提交申报表单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public JsonMsg update(@RequestBody DeclareItem declareItem, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null == declareItem) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("项目申报信息提交失败。");
				return jsonMsg;
			}
				
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				declareItem.setCorpid(user.getOrgid());
			}
			declareAPI.editDeclareItem(declareItem);
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("项目申报信息提交成功。");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("项目申报信息提交失败，未知错误！");
		}
		return jsonMsg;
	}
	
	/**
	 * 取消项目申报
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg cancelDeclare(Long id, Model model,
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
			DeclareItem declareItem = declareAPI.getItem(id);
			if (user.getOrgid() == declareItem.getCorpid()){
				declareItem.setStatus("-2");
				declareAPI.editDeclareItem(declareItem);
			}
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("取消成功！");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("取消失败！未知原因。");
		}
		return jsonMsg;
	}


}
