package com.gsccs.sme.plat.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.plat.auth.model.AreaT;
import com.gsccs.sme.plat.auth.service.AreaService;
import com.gsccs.sme.plat.bass.TreeGrid;

/**
 * 地域管理
 * 
 */
@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequiresPermissions("area:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "logist/area_list";
	}

	
	@RequestMapping(value = "/treegrid")
	@ResponseBody
	public TreeGrid list(
			@RequestParam(defaultValue = " code ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			AreaT area, HttpServletRequest request) {
		List<AreaT> areaList = areaService.find(area, order,
				page, rows);
		int totalCount = areaService.count(area);
		TreeGrid treeGrid = new TreeGrid();
		treeGrid.setRows(areaList);
		treeGrid.setTotal(Long.valueOf(totalCount));
		return treeGrid;
	}
	
	

}
