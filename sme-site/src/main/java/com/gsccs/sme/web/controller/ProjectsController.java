package com.gsccs.sme.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 *  
 * 工程项目
 * @author x.d zhang
 * 
 */
@Controller
public class ProjectsController {

	/**
	 * 工程项目
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "project.html",method = RequestMethod.GET)
	public String project(String s, String c, String k,
			ModelMap map) {
		// 查询参数
		map.put("s", s);
		map.put("c", c);
		map.put("k", k);
		return "project";
	}

	
}
