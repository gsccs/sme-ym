package com.gsccs.sme.plat.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.corp.CorpEnergy;
import com.gsccs.sme.api.domain.corp.CorpMsw;
import com.gsccs.sme.api.domain.corp.CorpRun;
import com.gsccs.sme.api.domain.corp.CorpTech;
import com.gsccs.sme.api.domain.corp.CorpWater;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.corp.service.DataService;

/**
 * 企业数据控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/cdata")
public class CorpdataController {

	@Autowired
	private CorpService corpService;
	@Autowired
	private DataService dataService;
	
	
	/**
	 * 经营数据
	 * @param map
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/run", method = RequestMethod.GET)
	protected String runList(ModelMap map,HttpServletRequest req) {
		return "corp/run-list";
	}
	
	/**
	 * 能耗情况
	 * @param map
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/energy", method = RequestMethod.GET)
	protected String corpList(ModelMap map,HttpServletRequest req) {
		return "corp/energy-list";
	}
	
	/**
	 * 用水统计
	 * @param map
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/water", method = RequestMethod.GET)
	protected String waterList(ModelMap map,HttpServletRequest req) {
		return "corp/tech-list";
	}
	
	/**
	 * 固体废弃物
	 * @param map
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/msw", method = RequestMethod.GET)
	protected String mswList(ModelMap map,HttpServletRequest req) {
		return "corp/msw-list";
	}
	
	/**
	 * 固体废弃物
	 * @param map
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/tech", method = RequestMethod.GET)
	protected String techList(ModelMap map,HttpServletRequest req) {
		return "corp/tech-list";
	}
	
	
	@RequestMapping(value="/run/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid runList(CorpRun param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<CorpRun> list = dataService.find(param,orderstr, page, rows);
		int count = dataService.count(param);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	@RequestMapping(value="/energy/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid energyList(CorpEnergy param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<CorpEnergy> list = dataService.find(param,orderstr, page, rows);
		int count = dataService.count(param);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	
	@RequestMapping(value="/water/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid waterList(CorpWater param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<CorpWater> list = dataService.find(param,orderstr, page, rows);
		int count = dataService.count(param);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	@RequestMapping(value="/msw/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid mswList(CorpMsw param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<CorpMsw> list = dataService.find(param,orderstr, page, rows);
		int count = dataService.count(param);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	
	@RequestMapping(value="/tech/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid techList(CorpTech param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<CorpTech> list = dataService.find(param,orderstr, page, rows);
		int count = dataService.count(param);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	
}
