package com.gsccs.sme.plat.rtable.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.domain.report.ReportItem;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.rtable.model.SolidContent;
import com.gsccs.sme.plat.rtable.model.SolidMain;
import com.gsccs.sme.plat.rtable.service.ReportService;
import com.gsccs.sme.plat.rtable.service.SolidContentService;
import com.gsccs.sme.plat.rtable.service.SolidMainService;
import com.gsccs.sme.plat.svg.model.CorpT;

/**
 * 酒泉市工业固体废物综合利用情况表
 * 
 */
@Controller
@RequestMapping("/solidMain")
public class SolidController extends BaseController {

	@Autowired
	private SolidMainService solidMainService;

	@Autowired
	private SolidContentService solidContentService;

	@Autowired
	private ReportService reportService;

	@Autowired
	private CorpService corpService;

	@RequestMapping(method = RequestMethod.GET)
	protected String getDkyyList(HttpServletRequest req, CorpT corpT,
			Model model) {
		List<CorpT> corpTList = corpService.find(corpT);
		model.addAttribute("corpTList", corpTList);
		return "rtable/solidMain-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid getDkyyList(SolidMain solidMain,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<SolidMain> list = solidMainService.find(solidMain, orderstr, page,
				rows);
		int count = solidMainService.count(solidMain);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, Long id) {
		CorpT corp = getCurrCorp();
		model.addAttribute("corp", corp);
		Report report = reportService.getReport(id);
		model.addAttribute("report", report);
		SolidMain solidMain = null;
		model.addAttribute("solidMain", solidMain);
		return "rtable/solidMain-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(SolidMain solidMain, SolidContent solidContent,
			String[] c_date, String[] c_a, String[] c_b, String[] c_c,
			String[] c_d, String[] c_e, String[] c_f, String[] c_g,
			String[] c_h, String[] c_i, String[] c_j,
			RedirectAttributes redirectAttributes, Model model,
			ReportItem reportItem) {
		String mainId = UUID.randomUUID().toString();
		if (null != solidMain) {
			solidMain.setMainid(mainId);
			solidMainService.addSolidMain(solidMain);
		}
		// 表内容添加
		for (int i = 0; i < 9; i++) {
			solidContent.setMainid(mainId);
			solidContent.setDate(c_date[i]);
			solidContent.setA(c_a[i]);
			solidContent.setB(c_b[i]);
			solidContent.setC(c_c[i]);
			solidContent.setD(c_d[i]);
			solidContent.setE(c_e[i]);
			solidContent.setF(c_f[i]);
			solidContent.setG(c_g[i]);
			solidContent.setH(c_h[i]);
			solidContent.setI(c_i[i]);
			solidContent.setJ(c_j[i]);
			solidContentService.addSolidContent(solidContent);
		}

		// 添加ReportItem
		reportItem.setId(mainId);
		// reportItem.setReportid(solidMain.getReportid());
		reportItem.setSubmitdate(solidMain.getTbtime());
		reportItem.setAddtime(new Date());
		reportItem.setCorpid(getCurrCorp().getId());
		reportItem.setUserid(getCurrUser().getId());
		reportItem.setIsattach(solidMain.getIsattach());
		reportService.addReportItem(reportItem);

		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		model.addAttribute("returnMsg", msg);
		return "rtable/solidMain-list";
	}

	// 查看详情
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String showUpdateForm(String mainid, Model model,
			SolidContent solidContent) {
		if (null != mainid) {
			SolidMain solidMain = solidMainService.getSolidMain(mainid);
			model.addAttribute("solidMain", solidMain);
			solidContent.setMainid(mainid);
			List<SolidContent> contentList = solidContentService.find(
					solidContent, "", 1, 15);
			model.addAttribute("contentList", contentList);
		}
		return "rtable/solidMain-info";
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(String mainid, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != mainid) {
			solidMainService.delSolidMain(mainid);
			reportService.delReportItem(mainid);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
}
