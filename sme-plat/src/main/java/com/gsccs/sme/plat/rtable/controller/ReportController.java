package com.gsccs.sme.plat.rtable.controller;

import java.util.ArrayList;
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
import com.gsccs.sme.plat.bass.BaseController;
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
@RequestMapping("/report")
public class ReportController extends BaseController {

	@Autowired
	private ReportService reportService;

	@RequestMapping(method = RequestMethod.GET)
	protected String reportList(HttpServletRequest req) {
		return "rtable/report-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid reportList(Report report,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		report.setSvgid(getCurrUser().getOrgid());
		List<Report> list = reportService.find(report, orderstr, page, rows);
		int count = reportService.count(report);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showCreateForm(Long id, Model model) {
		Report report = null;
		if (null != id) {
			report = reportService.getReport(id);
		}
		model.addAttribute("report", report);
		return "rtable/report-form";
	}

	// 附件形式上报
	@RequestMapping(value = "/byattach", method = RequestMethod.GET)
	public String reportByAttach(Long id, Model model) {
		Report report = null;
		if (null!= id) {
			report = reportService.getReport(id);
		}
		model.addAttribute("report", report);

		ReportItem reportItemT = null;
		model.addAttribute("reportItemT", reportItemT);
		return "rtable/report-form-byattach";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(@RequestBody Report report, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == report) {
			msg.setSuccess(false);
			msg.setMsg("报表新增失败！");
			return msg;
		}
		try {
			report.setSvgid(getCurrSvg().getId());
			reportService.addReport(report);
			msg.setSuccess(true);
			msg.setMsg("添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("报表新增失败！");
		}
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody Report report, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == report) {
			msg.setSuccess(false);
			msg.setMsg("修改报表信息失败！");
			return msg;
		}
		try {
			reportService.update(report);
			msg.setSuccess(true);
			msg.setMsg("报表修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("报表修改失败！");
		}
		return msg;
	}

	// 查看报送情况
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	protected String list(Long id, HttpServletRequest req, Model model,
			ReportItem reportItem) {
		Report report = reportService.getReport(id);
		model.addAttribute("report", report);
		reportItem.setReportid(id);
		List<ReportItem> list = reportService.find(reportItem, "", 1, 15);
		model.addAttribute("list", list);
		return "rtable/reportitem-list";
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg del(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			reportService.delReport(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}

	// 附件删除
	@RequestMapping(value = "/attach/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg attachDelete(Long attachid) {
		JsonMsg msg = new JsonMsg();
		if (null == attachid) {
			msg.setSuccess(false);
			msg.setMsg("附件删除失败!");
			return msg;
		}
		try {
			List<Long> attachids = new ArrayList<>();
			attachids.add(attachid);
			reportService.delAttachs(attachids);
			msg.setSuccess(true);
			msg.setMsg("附件删除成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("附件删除失败,未知原因！");
		}
		return msg;
	}
}
