package com.gsccs.sme.plat.rtable.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.domain.report.ReportItem;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.rtable.service.ReportService;

/**
 * 报表控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/reportitem")
public class ReportItemController {

	@Autowired
	private ReportService reportService;

	@RequestMapping(method = RequestMethod.GET)
	protected String reportList(HttpServletRequest req) {
		return "rtable/reportitem-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid reportList(ReportItem reportItem,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<ReportItem> list = reportService.find(reportItem, orderstr, page, rows);
		int count = reportService.count(reportItem);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showCreateForm(String id, Model model) {
		ReportItem report = null;
		if (StringUtils.isNotEmpty(id)) {
			report = reportService.getReportItem(id);
		}
		model.addAttribute("report", report);
		return "rtable/reportitem-form";
	}
	
	// 附件形式上传
	@RequestMapping(value = "/addbyattach", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addbyattach(@RequestBody ReportItem reportItem, String submitdate) {
		JsonMsg msg = new JsonMsg();
		if (null != reportItem) {
			reportService.addReportItem(reportItem);
			msg.setSuccess(true);
			msg.setMsg("记录上报成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录上报失败!");
		}
		return msg;
	}
	
	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(String id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			reportService.delReportItem(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
	
	//查看附件形式报表报送情况
	@RequestMapping(value="/list", method = RequestMethod.GET)
	protected String reportItemList(Long  reportid, Model model) {
		Report report = null;
		if (null != reportid) {
			report = reportService.getReport(reportid);
		}
		model.addAttribute("report", report);
		return "rtable/reportitem-list";
	}
	
	@RequestMapping(value = "/list/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid reportItemList(ReportItem reportItem,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map, String reportid) {
		Datagrid grid = new Datagrid();
		List<ReportItem> list = reportService.find(reportItem, orderstr, page, rows);
		int count = reportService.count(reportItem);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	//查看附件形式报表报送详情
	@RequestMapping(value="/info", method = RequestMethod.GET)
	protected String reportIteminfo(String  id, Model model) {
		ReportItem reportItem = null;
		if (StringUtils.isNotEmpty(id)) {
			reportItem = reportService.getReportItem(id);
		}
		model.addAttribute("reportItem", reportItem);
		return "rtable/reportitem-info";
	}

}
