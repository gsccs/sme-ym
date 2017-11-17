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

import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.svg.model.AppealItemT;
import com.gsccs.sme.plat.svg.model.SitemT;
import com.gsccs.sme.plat.svg.service.SitemService;
import com.gsccs.sme.plat.svg.service.SvorgService;

/**
 * 社会服务项目控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/sitem/statist")
public class SitemStatistController extends BaseController {

	@Autowired
	private SitemService sitemService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private DictService dictService;

	@RequestMapping(value = "/sitems", method = RequestMethod.GET)
	protected String activityList(ModelMap map, HttpServletRequest req) {
		return "statist/statist-sitems";
	}
	
	
	@RequestMapping(value = "/svgnum", method = RequestMethod.GET)
	protected String svgnum(ModelMap map, HttpServletRequest req) {
		return "statist/statist-svgnum";
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
	@RequestMapping(value = "/sitems", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid sitemList(SitemT param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			ModelMap map) {
		Datagrid grid = new Datagrid();
		List<SitemT> list = sitemService.find(param, orderstr, page, rows);
		int count = sitemService.count(param);
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
	@RequestMapping(value = "/svgnum", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid svgnumList(AppealItemT param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			ModelMap map) {
		Datagrid grid = new Datagrid();
		/*List<StatistGroup> list = sitemService.statistSvgSitemNum();
		if (null != list){
			grid.setRows(list);
			grid.setTotal(Long.valueOf(list.size()));
		}*/
		return grid;
	}
	
}
