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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.AppealItem;
import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AppealServiceI;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 行政诉求控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class AppealController {

	@Autowired
	private AppealServiceI appealAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 行政诉求列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "appeal.html", method = RequestMethod.GET)
	public String appeallist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num, String keyword,
			Long gcode,Long svgid, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("svgid", svgid);
		model.addAttribute("gcode", gcode);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "appeallist";
	}

	/**
	 * 行政诉求详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appeal-{id}.html", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "appeal";
		AppealTopic appealTopic = null;
		try {
			appealTopic = appealAPI.getTopic(id);
			model.addAttribute("currAppealTopic", appealTopic);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

	
	/**
	 * 服务主题数据
	 * @param svgid
	 * @param pcode
	 * @param page
	 * @param num
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/appeal/topics", method = RequestMethod.GET)
	public Datagrid topiclist(Long svgid,Long scode,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num,Model model) {
		Datagrid datagrid = null;
		try {
			AppealTopic topic = new AppealTopic();
			topic.setSvgid(svgid);
			topic.setScode(scode);
			datagrid = appealAPI.queryTopicList(topic, "", page, num);
		} catch (ApiException e) {
			return new Datagrid();
		}
		return datagrid;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/appealtrace/{id}", method = RequestMethod.GET)
	public JSONArray traces(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		try {
			return appealAPI.queryTraces(id);
		} catch (ApiException e) {
			return new JSONArray();
		}
	}
	
	
	

	
}
