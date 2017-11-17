package com.gsccs.sme.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.base.Area;
import com.gsccs.sme.api.service.AreaServiceI;

/**
 * 地域管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class AreaController {

	@Autowired
	private AreaServiceI areaAPI;

	@ResponseBody
	@RequestMapping(value = "/areaList", method = RequestMethod.POST)
	public List<Area> getAreaList(Integer parid) {
		if (null == parid || parid == 0) {
			parid = 0;
		}
		List<Area> areas = areaAPI.getArea(parid);
		return areas;
	}

}
