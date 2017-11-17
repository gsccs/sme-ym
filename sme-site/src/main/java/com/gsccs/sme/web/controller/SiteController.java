package com.gsccs.sme.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 商城门户首页
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class SiteController {

	private Logger logger = Logger.getLogger(SiteController.class);

	@Autowired
	private SvorgServiceI shopAPI;
	@Autowired
	private SitemServiceI sitemAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 门户首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletResponse response) {
		return "redirect:/index.html";
	}
	
	/**
	 * 门户首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(Model model, HttpServletResponse response) {
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			// 域名
			// data.put("domain", redisService.getDomain(siteId.toString()));
			// data.put("store", redisService.getStore(siteId));
			// data.put("storey", storeyObj);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "index";
	}


}
