package com.gsccs.sme.web.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.base.Area;
import com.gsccs.sme.api.domain.base.Dict;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.DictServiceI;

/**
 * 数据字典管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class DictController {

	@Autowired
	private DictServiceI dictAPI;
	
	/**
	 * 根据字典分组查询字典列表
	 * @param gcode 	分组编码
	 * @param groupid	分组ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dictlist", method = RequestMethod.POST)
	public List<Dict> getDictList(String gcode,String groupid) {
		if (StringUtils.isNotEmpty(gcode)) {
			return dictAPI.queryDictList(gcode, true);
		}
		return null;
	}
	

}
