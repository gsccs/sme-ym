package com.gsccs.sme.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsccs.sme.api.domain.Park;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.ParkServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 园区管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class ParkController {

	@Autowired
	private ParkServiceI parkAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 园区列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "park.html", method = RequestMethod.GET)
	public String parklist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num, String keyword,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "parklist";
	}

	/**
	 * 园区详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/park-{id}.html", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "park";

		Park park = null;
		try {
			park = parkAPI.getPark(id);
			if(null != park){
				String template = park.getTemplate();
				if (StringUtils.isNotEmpty(template)){
					tempPath = template;
				}
			}
			model.addAttribute("currPark", park);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

}
