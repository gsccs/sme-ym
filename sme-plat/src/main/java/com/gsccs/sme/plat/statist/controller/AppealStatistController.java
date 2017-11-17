package com.gsccs.sme.plat.statist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.StatistGovNum;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.svg.model.AppealItemT;
import com.gsccs.sme.plat.svg.service.AppealService;
import com.gsccs.sme.plat.svg.service.SvorgService;

/**
 * 政府服务事项统计分析控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/appeal/statist")
public class AppealStatistController extends BaseController {

	@Autowired
	private AppealService appealService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private DictService dictService;

	@RequestMapping(value = "/gitems", method = RequestMethod.GET)
	protected String items(ModelMap map, HttpServletRequest req) {
		return "statist/statist-gitems";
	}
	
	
	@RequestMapping(value = "/govnum", method = RequestMethod.GET)
	protected String svgnum(ModelMap map, HttpServletRequest req) {
		return "statist/statist-govnum";
	}


	/**
	 * 行政事项统计
	 * @param param
	 * @param page
	 * @param rows
	 * @param orderstr
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/gitems", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid sitemList(AppealItemT param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			ModelMap map) {
		Datagrid grid = new Datagrid();
		List<AppealItemT> list = appealService.find(param, orderstr, page, rows);
		int count = appealService.count(param);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	
	/**
	 * 各单位行政事项统计
	 * @param param
	 * @param page
	 * @param rows
	 * @param orderstr
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/govnum", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid svgnumList(AppealItemT param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			ModelMap map) {
		Datagrid grid = new Datagrid();
		List<StatistGovNum> list = appealService.statistSvgAppealNum();
		if (null != list){
			grid.setRows(list);
			grid.setTotal(Long.valueOf(list.size()));
		}
		return grid;
	}
	
}
