package com.gsccs.sme.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsccs.sme.api.domain.Activity;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ActivityServiceI;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 服务活动控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class ActivityController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private SclassServiceI sclassAPI;
	@Autowired
	private ActivityServiceI activityAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 活动列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "activity.html", method = RequestMethod.GET)
	public String activitylist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num, String keyword,
			String scode, String subscode, String pcode, String ccode,
			String acode, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("scode", scode);
		model.addAttribute("subscode", subscode);
		model.addAttribute("pcode", pcode);
		model.addAttribute("ccode", ccode);
		model.addAttribute("acode", acode);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "activitylist";
	}

	/**
	 * 活动详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/activity-{id}.html", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "activity";

		Activity activity = null;
		try {
			activity = activityAPI.getActivity(id);
			model.addAttribute("currActivity", activity);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

}
