package com.gsccs.sme.plat.svg.controller;

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

import com.gsccs.sme.api.domain.CapitalAppl;
import com.gsccs.sme.api.domain.CapitalReply;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.plat.Constants;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.svg.model.CorpT;
import com.gsccs.sme.plat.svg.service.SneedService;

/**
 * 融资管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping(value = "/capital")
public class CapitalController extends BaseController {

	@Autowired
	private SneedService sneedService;
	@Autowired
	private CorpService corpService;

	/**
	 * 融资需求列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/appls", method = RequestMethod.GET)
	public String appllist(Model model, HttpServletResponse response) {
		return "capital/appl-list";
	}
	
	/**
	 * 融资需求响应列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/replys", method = RequestMethod.GET)
	public String replylist(Model model, HttpServletResponse response) {
		return "capital/reply-list";
	}

	/**
	 * 需求回复
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public String reply(Long id, Model model, HttpServletResponse response) {
		CorpT corpT = null;
		CapitalAppl appl = sneedService.getCapitalAppl(id);
		if(null !=appl && null != appl.getCorpid()){
			corpT = corpService.getCorp(appl.getCorpid());
		}
		model.addAttribute("corp", corpT);
		model.addAttribute("appl", appl);
		model.addAttribute("user", getCurrUser());
		return "capital/reply-form";
	}

	
	@ResponseBody
	@RequestMapping(value = "/appl/datagrid", method = RequestMethod.POST)
	public Datagrid datagrid(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		CapitalAppl appl = new CapitalAppl();
		List<CapitalAppl> applList = sneedService.find(appl, "addtime desc",
				page, pagesize);
		int count = sneedService.count(appl);
		datagrid.setRows(applList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
	
	@ResponseBody
	@RequestMapping(value = "/reply/datagrid", method = RequestMethod.POST)
	public Datagrid replydg(
			CapitalReply param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		Subject subject = SecurityUtils.getSubject();
		List<CapitalReply> list = null;
		if (subject.hasRole(Constants.ROLE_SYS_M)) {
			list = sneedService.find(param, "", page, rows);
		} else {
			param.setSvgid(getCurrUser().getOrgid());
			list = sneedService.find(param, "", page, rows);
		}
		int count = sneedService.count(param);
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
	
	/**
	 * 融资申请响应记录
	 * @param applid
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/applrp/dg", method = RequestMethod.POST)
	public Datagrid replyeddg(Long applid,
			Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		List<CapitalReply> applList = sneedService.find(applid, "addtime desc",
				1, Integer.MAX_VALUE);
		datagrid.setRows(applList);
		return datagrid;
	}

	@ResponseBody
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public JsonMsg reply(@RequestBody CapitalReply reply, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			if (null != reply) {
				reply.setSvgid(getCurrUser().getOrgid());
				sneedService.addCapitalReply(reply);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("保存成功。");
			}
		} catch (Exception e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("保存失败。");
		}
		return jsonMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/reply/delete", method = RequestMethod.POST)
	public JsonMsg delete(Long id, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			if (null != id) {
				sneedService.delCapitalReply(id);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("操作成功。");
			}
		} catch (Exception e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("操作失败。");
		}
		return jsonMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/appl/delete", method = RequestMethod.POST)
	public JsonMsg appldelete(Long id, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			if (null != id) {
				sneedService.delCapitalAppl(id);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("操作成功。");
			}
		} catch (Exception e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("操作失败。");
		}
		return jsonMsg;
	}

}
