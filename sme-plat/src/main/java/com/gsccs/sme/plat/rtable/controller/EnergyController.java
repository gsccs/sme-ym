package com.gsccs.sme.plat.rtable.controller;

import java.text.ParseException;
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
import com.gsccs.sme.plat.rtable.model.EnergyMain;
import com.gsccs.sme.plat.rtable.model.EnergyProduct;
import com.gsccs.sme.plat.rtable.model.EnergyTechnics;
import com.gsccs.sme.plat.rtable.service.EnergyMainService;
import com.gsccs.sme.plat.rtable.service.EnergyProductService;
import com.gsccs.sme.plat.rtable.service.EnergyTechnicsService;
import com.gsccs.sme.plat.rtable.service.ReportService;
import com.gsccs.sme.plat.svg.model.CorpT;

/**
 * 工业重点用能企业能源消耗情况月报控制类
 * 
 */
@Controller
@RequestMapping("/energyMain")
public class EnergyController extends BaseController{
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private EnergyMainService energyMainService;

	@Autowired
	private EnergyTechnicsService energyTechnicsService;

	@Autowired
	private EnergyProductService energyProductService;
	
	@Autowired
	private CorpService corpService;

	@RequestMapping(method = RequestMethod.GET)
	protected String getDkyyList(HttpServletRequest req, CorpT corpT, Model model) {
		List<CorpT> corpTList =corpService.find(corpT);
		model.addAttribute("corpTList", corpTList);
		return "rtable/energyMain-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid getDkyyList(EnergyMain energyMain,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<EnergyMain> list = energyMainService.find(energyMain, orderstr,
				page, rows);
		int count = energyMainService.count(energyMain);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, Long id) {
		Report report=reportService.getReport(id);
		model.addAttribute("report", report);
		CorpT corp=getCurrCorp();
		model.addAttribute("corp", corp);
		EnergyMain energyMain = null;
		model.addAttribute("energyMain", energyMain);
		return "rtable/energyMain-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(EnergyMain energyMain, EnergyProduct energyProduct,
			String gyName[], String[] p_product, String[] p_unit,
			String[] p_number, String[] p_a, String[] p_b, String[] p_c,
			EnergyTechnics energyTechnics,
			RedirectAttributes redirectAttributes,ReportItem reportItem, Model model) throws ParseException {
		String mainId = UUID.randomUUID().toString();
		if (null != energyMain) {
			energyMain.setMainId(mainId);
			energyMainService.addEnergyMain(energyMain);
		}
		// 工艺表添加
		if (null != gyName) {
			for (String name : gyName) {
				if (StringUtils.isNotEmpty(name)) {
					energyTechnics.setName(name);
					energyTechnics.setMainId(mainId);
					energyTechnicsService.addEnergyTechnics(energyTechnics);
				}
			}
		}
		// 产品表添加
		if (null != p_product) {
			for (int i = 0; i < p_product.length; i++) {
				if (StringUtils.isNotEmpty(p_product[i])) {
					energyProduct.setMainId(mainId);
					energyProduct.setProduct(p_product[i]);
					energyProduct.setUnit(p_unit[i]);
					energyProduct.setNumber(p_number[i]);
					energyProduct.setA(p_a[i]);
					energyProduct.setB(p_b[i]);
					energyProduct.setC(p_c[i]);
					energyProductService.addEnergyProduct(energyProduct);
				}
			}
		}
		//添加ReportItem
		reportItem.setId(mainId);
		//reportItem.setReportid(energyMain.getReportid());
		reportItem.setSubmitdate(energyMain.getStartdate());
		reportItem.setAddtime(new Date());
		reportItem.setCorpid(getCurrCorp().getId());
		reportItem.setUserid(getCurrUser().getId());
		reportItem.setIsattach(energyMain.getIsattach());
		reportService.addReportItem(reportItem);
		
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		model.addAttribute("returnMsg", msg);
		return "rtable/report-list";
	}

	// 查看详情
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String showUpdateForm(String mainId, EnergyProduct energyProduct,
			EnergyTechnics energyTechnics, Model model) {
		if (null != mainId) {
			EnergyMain energyMain = energyMainService.getEnergyMain(mainId);
			energyProduct.setMainId(energyMain.getMainId());
			energyTechnics.setMainId(energyMain.getMainId());
			List<EnergyProduct> productList = energyProductService.find(
					energyProduct, "", 1, 15);
			List<EnergyTechnics> technicsList = energyTechnicsService.find(
					energyTechnics, "", 1, 15);
			model.addAttribute("technicsList", technicsList);
			model.addAttribute("productList", productList);
			model.addAttribute("energyMain", energyMain);
		}
		return "rtable/energyMain-info";
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(String mainId, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != mainId) {
			energyMainService.delEnergyMain(mainId);
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
