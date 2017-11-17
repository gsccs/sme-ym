package com.gsccs.sme.plat.rtable.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import com.gsccs.sme.plat.rtable.model.WallContent;
import com.gsccs.sme.plat.rtable.model.WallMain;
import com.gsccs.sme.plat.rtable.service.ReportService;
import com.gsccs.sme.plat.rtable.service.WallContentService;
import com.gsccs.sme.plat.rtable.service.WallMainService;
import com.gsccs.sme.plat.svg.model.CorpT;

/**
 * 玉门市新型墙材生产企业报表
 * 
 */
@Controller
@RequestMapping("/wallMain")
public class WallController extends BaseController{

	@Autowired
	private WallMainService wallMainService;

	@Autowired
	private WallContentService wallContentService;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private CorpService corpService;

	@RequestMapping(method = RequestMethod.GET)
	protected String getDkyyList(HttpServletRequest req, CorpT corpT, Model model) {
		List<CorpT> corpTList =corpService.find(corpT);
		model.addAttribute("corpTList", corpTList);
		return "rtable/wallMain-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid getDkyyList(WallMain wallMain, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows, @RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<WallMain> list = wallMainService.find(wallMain, orderstr, page, rows);
		int count = wallMainService.count(wallMain);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, Long id) {
		CorpT corp=getCurrCorp();
		model.addAttribute("corp", corp);
		Report report=reportService.getReport(id);
		model.addAttribute("report", report);
		WallMain wallMain = null;
		model.addAttribute("wallMain", wallMain);
		return "rtable/wallMain-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(WallMain wallMain, WallContent wallContent, String[] c_date, String[] c_a, String[] c_b,
			String[] c_c, String[] c_d, String[] c_e, String[] c_f, String[] c_g, String[] c_h, String[] c_i,
			String[] c_j, String[] c_k, String[] c_l, String[] c_m, String[] c_n, String[] c_o, String[] c_p,
			String[] c_q, String[] c_name, RedirectAttributes redirectAttributes, Model model,ReportItem reportItem) {
		String mainId = UUID.randomUUID().toString();
		if (null != wallMain) {
			wallMain.setMainid(mainId);
			wallMainService.addWallMain(wallMain);
		}
		// 表内容添加
		for (int i = 0; i < c_name.length; i++) {
			if(StringUtils.isNotEmpty(c_name[i])){
			wallContent.setMainid(mainId);
			wallContent.setName(c_name[i]);
			wallContent.setA(c_a[i]);
			wallContent.setB(c_b[i]);
			wallContent.setC(c_c[i]);
			wallContent.setD(c_d[i]);
			wallContent.setE(c_e[i]);
			wallContent.setF(c_f[i]);
			wallContent.setG(c_g[i]);
			wallContent.setH(c_h[i]);
			wallContent.setI(c_i[i]);
			wallContent.setJ(c_j[i]);
			wallContent.setK(c_k[i]);
			wallContent.setL(c_l[i]);
			wallContent.setM(c_m[i]);
			wallContent.setN(c_n[i]);
			wallContent.setO(c_o[i]);
			wallContent.setP(c_p[i]);
			wallContent.setQ(c_q[i]);
			wallContentService.addWallContent(wallContent);
		}
		}
		
		//添加ReportItem
				reportItem.setId(mainId);
				//reportItem.setReportid(wallMain.getReportid());
				reportItem.setSubmitdate(wallMain.getTbdate());
				reportItem.setAddtime(new Date());
				reportItem.setCorpid(getCurrCorp().getId());
				reportItem.setUserid(getCurrUser().getId());
				reportItem.setIsattach(wallMain.getIsattach());
				reportService.addReportItem(reportItem);
		
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		model.addAttribute("returnMsg", msg);
		return "rtable/wallMain-list";
	}

	// 查看详情
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String showUpdateForm(String mainid, Model model, WallContent wallContent) {
		if (null != mainid) {
			WallMain wallMain = wallMainService.getWallMain(mainid);
			model.addAttribute("wallMain", wallMain);
			wallContent.setMainid(mainid);
			List<WallContent> contentList = wallContentService.find(wallContent, "", 1, 15);
			model.addAttribute("contentList", contentList);
		}
		return "rtable/wallMain-info";
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(String mainid, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != mainid) {
			wallMainService.delWallMain(mainid);
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
