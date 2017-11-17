package com.gsccs.sme.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsccs.sme.api.service.AppealServiceI;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 网上服务大厅
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class WsbsController {

	@Autowired
	private AppealServiceI appealAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;
	
	/**
	 * 网上服务大厅页
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "wsbs.html", method = RequestMethod.GET)
	public String wsbs(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return "wsbs";
	}

	
	/**
	 * 网上服务大厅页
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "wszx.html", method = RequestMethod.GET)
	public String wszx(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return "wszx";
	}
	
	
	/**
	 * 公共页面请求
	 * @param page
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/{page}.html", method = RequestMethod.GET)
	public String wszx(@PathVariable("page") String page,Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return page;
	}

	
}
