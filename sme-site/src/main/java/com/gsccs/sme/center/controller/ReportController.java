package com.gsccs.sme.center.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.domain.report.ReportItem;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.ReportServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 企业数据上报管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="ReportCtl")
@RequestMapping(value = "/cp/report")
public class ReportController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ReportServiceI reportAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 报表列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String reportlist(Model model, HttpServletResponse response) {
		return "report/report-list";
	}
	
	/**
	 * 报表列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String itemlist(Model model, HttpServletResponse response) {
		return "report/item-list";
	}
	
	
	/**
	 * 数据上报
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/item/form", method = RequestMethod.GET)
	public String form(Long reportid,String itemid, Model model, HttpServletResponse response) {
		ReportItem reportItem = null;
		Report report = null;
		try {
			if (StringUtils.isNotEmpty(itemid)){
				reportItem = reportAPI.getReportItem(itemid);
			}
			if(null==reportid && null!=reportItem){
				reportid = reportItem.getReportid();
			}
			
			report = reportAPI.getReport(reportid);
			model.addAttribute("report", report);
			model.addAttribute("reportItem", reportItem);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "report/item-form";
	}

	
	@ResponseBody
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public Datagrid reportlist(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, Model model,
			HttpServletResponse response) {
		Datagrid datagrid = new Datagrid();
		try {
			Report report = new Report();
			List<Report> reports = reportAPI.find(report, "", page, rows);
			datagrid.setRows(reports);
			datagrid.setTotal(30l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	
	@ResponseBody
	@RequestMapping(value = "/item/datagrid", method = RequestMethod.POST)
	public Datagrid itemlist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			ReportItem reportItem = new ReportItem();
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				reportItem.setCorpid(user.getOrgid());
			}
			List<ReportItem> reports = reportAPI.find(reportItem, "addtime desc", page, pagesize);
			datagrid.setRows(reports);
			datagrid.setTotal(30l);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	
	@ResponseBody
	@RequestMapping(value = "/item/add", method = RequestMethod.POST)
	public JsonMsg addItem(@RequestBody ReportItem reportItem,Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null == reportItem) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("报表保存失败，报表不存在。");
				return jsonMsg;
			}
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				reportItem.setCorpid(user.getOrgid());
			}
			reportItem.setAddtime(new Date());
			reportAPI.addReportItem(reportItem);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("报表保存成功。");
		} catch (ApiException e) {
			e.printStackTrace();
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("报表发布失败。");
		}
		return jsonMsg;
	}

	 
	/**
	 * 修改报表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/item/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg updateItem(@RequestBody ReportItem reportItem, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();

		try {
			Account user = accountAPI.getAccount(username);
			if (null == reportItem) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("报表修改保存失败，报表不存在。");
				return jsonMsg;
			}
			
			if (null != user) {
				reportItem.setCorpid(user.getOrgid());
			}
			reportItem.setAddtime(new Date());
			reportAPI.editReportItem(reportItem);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("报表修改保存成功！");
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("报表修改保存失败！");
		}
		return jsonMsg;
	}

}
