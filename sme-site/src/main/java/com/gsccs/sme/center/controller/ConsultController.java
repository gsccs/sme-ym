package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.ConsultServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;

/**
 * 服务咨询管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="ConsultCtl")
@RequestMapping("/cp/consult")
public class ConsultController {

	@Autowired
	private SvorgServiceI svorgAPI;
	@Autowired
	private SclassServiceI sclassAPI;
	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private ConsultServiceI consultAPI;
	
	/**
	 * 我的咨询列表
	 * 
	 * @param model
	 * @param response
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String consults(Model model, HttpServletResponse response) {
		List<Svorg> svorglist = null;
		Svorg param = new Svorg();
		param.setSvgtype("G");
		try {
			svorglist = svorgAPI.querySvgList(param, "", 1, Integer.MAX_VALUE);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		model.addAttribute("svorglist", svorglist);
		return "consult/consult-list";
	}
	
	
	/**
	 * 咨询回复列表
	 * 
	 * @param model
	 * @param response
	 */
	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String view(Long id,Model model) {
		return "consult/consult-view";
	}
	
	/**
	 * 咨询页面
	 * 
	 * @param model
	 * @param response
	 */
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(Model model, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Account user = null;
		List<Svorg> svorglist = null;
		List<Itemtype> sclasslist = null;
		Svorg param = new Svorg();
		param.setSvgtype("G");
		try {
			user = accountAPI.getAccount(username);
			svorglist = svorgAPI.querySvgList(param, "", 1, Integer.MAX_VALUE);
			sclasslist = sclassAPI.getRootClass("G");
		} catch (ApiException e) {
			e.printStackTrace();
		}
		model.addAttribute("user", user);
		model.addAttribute("svorglist", svorglist);
		model.addAttribute("sclasslist", sclasslist);
		return "consult/consult-form";
	}
	
	
	/**
	 * 保存咨询记录
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg addConsult(@RequestBody Consult consult, Model model) {
		JsonMsg jsonmsg = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			if (null == consult) {
				jsonmsg.setCode("noitem");
				jsonmsg.setSuccess(false);
				jsonmsg.setMsg("数据提交失败!");
				return jsonmsg;
			}
			Account user = accountAPI.getAccount(username);
			if (null == user) {
				jsonmsg.setCode("nolog");
				jsonmsg.setSuccess(false);
				jsonmsg.setMsg("用户未登录!");
				return jsonmsg;
			}
			consult.setUserid(user.getId());
			consult.setCorpid(user.getOrgid());
			consultAPI.addConsult(consult);
			
			jsonmsg.setSuccess(true);
			jsonmsg.setCode("ok");
			jsonmsg.setMsg("未知错误");
		} catch (Exception e) {
			jsonmsg.setSuccess(false);
			jsonmsg.setMsg("未知错误");
			e.printStackTrace();
		}
		return jsonmsg;
	}

	

	/**
	 * 分页查询咨询列表
	 * 
	 * @param page
	 * @param pagesize
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public Datagrid datagrid(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, String state,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			Account user = accountAPI.getAccount(username);
			Consult param = new Consult();
			param.setCorpid(user.getOrgid());
			datagrid = consultAPI.datagrid(param, "addtime desc", page,
					pagesize);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}
	
	
	/**
	 * 分页查询咨询回复列表
	 * 
	 * @param page
	 * @param pagesize
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/reply/datagrid", method = RequestMethod.POST)
	public Datagrid datagrid(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Long id,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			
			Account user = accountAPI.getAccount(username);
			Consult param = new Consult();
			param.setUserid(user.getId());
			datagrid = consultAPI.getReplyList(id, "", 1, Integer.MAX_VALUE);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}
	
	/**
	 * 咨询删除
	 * 
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(Long id, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		try {
			if (null == id) {
				json.setSuccess(false);
				json.setMsg("删除失败，记录不存在。");
				return json;
			}
			consultAPI.delete(id);
			json.setSuccess(true);
			json.setMsg("删除成功！");
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg("删除失败，未知错误");
		}
		return json;
	}

}
