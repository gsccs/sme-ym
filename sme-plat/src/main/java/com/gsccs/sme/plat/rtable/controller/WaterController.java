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
import com.gsccs.sme.plat.rtable.model.WaterMain;
import com.gsccs.sme.plat.rtable.model.WaterQuota;
import com.gsccs.sme.plat.rtable.model.WaterTake;
import com.gsccs.sme.plat.rtable.model.WaterUse;
import com.gsccs.sme.plat.rtable.service.ReportService;
import com.gsccs.sme.plat.rtable.service.WaterMainService;
import com.gsccs.sme.plat.rtable.service.WaterQuotaService;
import com.gsccs.sme.plat.rtable.service.WaterTakeService;
import com.gsccs.sme.plat.rtable.service.WaterUseService;
import com.gsccs.sme.plat.svg.model.CorpT;

/**
 * 重点用水工业企业用水状况基本信息月报表
 * 
 */
@Controller
@RequestMapping("/waterMain")
public class WaterController extends BaseController{

	@Autowired
	private WaterMainService waterMainService;

	@Autowired
	private WaterTakeService waterTakeService;

	@Autowired
	private WaterUseService waterUseService;

	@Autowired
	private WaterQuotaService waterQuotaService;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private CorpService corpService;

	@RequestMapping(method = RequestMethod.GET)
	protected String getDkyyList(HttpServletRequest req, CorpT corpT, Model model) {
		List<CorpT> corpTList =corpService.find(corpT);
		model.addAttribute("corpTList", corpTList);
		return "rtable/waterMain-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid getDkyyList(WaterMain waterMain, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows, @RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<WaterMain> list = waterMainService.find(waterMain, orderstr, page, rows);
		int count = waterMainService.count(waterMain);
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
		WaterMain waterMain = null;
		model.addAttribute("waterMain", waterMain);
		return "rtable/waterMain-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(WaterMain waterMain, WaterTake waterTake, WaterUse waterUse, WaterQuota waterQuota,
			String[] t_date, String[] t_waterDb, String[] t_waterDx, String[] t_waterZl, String[] t_waterQt,
			String[] t_waterAll, String[] u_date, String[] u_a, String[] u_b, String[] u_c, String[] u_d, String[] u_e,
			String[] u_f, String[] u_g, String[] u_h, String[] u_i, String[] u_j, String[] q_name, String[] q_dw,
			String[] q_a, String[] q_b, String[] q_c, RedirectAttributes redirectAttributes, Model model,ReportItem reportItem) {
		String mainId = UUID.randomUUID().toString();
		if (null != waterMain) {
			waterMain.setMainid(mainId);
			waterMain.setTjdate(new Date());
			waterMainService.addWaterMain(waterMain);
		}
		// 单位指标表添加
		for (int i = 0; i < q_name.length; i++) {
			if (StringUtils.isNotEmpty(q_name[i])) {
				waterQuota.setMainid(mainId);
				waterQuota.setName(q_name[i]);
				waterQuota.setDw(q_dw[i]);
				waterQuota.setA(q_a[i]);
				waterQuota.setB(q_b[i]);
				waterQuota.setC(q_c[i]);
				waterQuotaService.addWaterQuota(waterQuota);
			}
		}
		// 取水类型表添加
		for (int i = 0; i < 3; i++) {
			waterTake.setMainid(mainId);
			waterTake.setDate(t_date[i]);
			waterTake.setWaterdb(t_waterDb[i]);
			waterTake.setWaterdx(t_waterDx[i]);
			waterTake.setWaterzl(t_waterZl[i]);
			waterTake.setWaterqt(t_waterQt[i]);
			waterTake.setWaterall(t_waterAll[i]);
			waterTakeService.addWaterTake(waterTake);
		}
		// 用水类型表添加
		for (int i = 0; i < 3; i++) {
			waterUse.setMainid(mainId);
			waterUse.setDate(u_date[i]);
			waterUse.setA(u_a[i]);
			waterUse.setB(u_b[i]);
			waterUse.setC(u_c[i]);
			waterUse.setD(u_d[i]);
			waterUse.setE(u_e[i]);
			waterUse.setF(u_f[i]);
			waterUse.setG(u_g[i]);
			waterUse.setH(u_h[i]);
			waterUse.setI(u_i[i]);
			waterUse.setJ(u_j[i]);
			waterUseService.addWaterUse(waterUse);
		}
		
		//添加ReportItem
		reportItem.setId(mainId);
		//reportItem.setReportid(waterMain.getReportid());
		reportItem.setSubmitdate(waterMain.getTjdate());
		reportItem.setAddtime(new Date());
		reportItem.setCorpid(getCurrCorp().getId());
		reportItem.setUserid(getCurrUser().getId());
		reportItem.setIsattach(waterMain.getIsattach());
		reportService.addReportItem(reportItem);
		
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		model.addAttribute("returnMsg", msg);
		return "rtable/waterMain-list";
	}

	// 查看详情
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String showUpdateForm(String mainId, Model model, WaterTake waterTake, WaterUse waterUse,
			WaterQuota waterQuota) {
		if (null != mainId) {
			WaterMain waterMain = waterMainService.getWaterMain(mainId);
			//附表数据获取
			waterTake.setMainid(mainId);
			List<WaterTake> takeList = waterTakeService.find(waterTake, "", 1, 15);
			waterUse.setMainid(mainId);
			List<WaterUse> useList = waterUseService.find(waterUse, "", 1, 15);
			waterQuota.setMainid(mainId);
			List<WaterQuota> quotaList = waterQuotaService.find(waterQuota, "", 1, 15);
			model.addAttribute("takeList", takeList);
			model.addAttribute("useList", useList);
			model.addAttribute("quotaList", quotaList);
			model.addAttribute("waterMain", waterMain);

		}
		return "rtable/waterMain-info";
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(String mainId, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != mainId) {
			waterMainService.delWaterMain(mainId);
			reportService.delReportItem(mainId);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
}
