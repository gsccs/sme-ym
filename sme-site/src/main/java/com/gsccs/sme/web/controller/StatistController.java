package com.gsccs.sme.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.AppealItem;
import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.service.AppealServiceI;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 统计分析控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class StatistController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private SclassServiceI sclassAPI;
	@Autowired
	private SvorgServiceI svorgAPI;
	@Autowired
	private AppealServiceI appealAPI;
	@Autowired
	private SitemServiceI sitemAPI;
	@Autowired
	private CorpServiceI corpAPI;
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
	@RequestMapping(value = "statist.html", method = RequestMethod.GET)
	public String statist(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		return "statist";
	}
	
	/**
	 * 获取平台统计数据
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getAllNum", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllNum(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		Svorg svorg = new Svorg();
		svorg.setSvgtype("G");
		Integer govnum = svorgAPI.count(svorg);
		svorg.setSvgtype("S");
		Integer socnum = svorgAPI.count(svorg);
		Integer topicnum = appealAPI.countTopic(new AppealTopic());
		Integer sitemnum = sitemAPI.count(new Sitem());
		Integer corpnum = corpAPI.count(new Corp());
		
		jsonObject.put("govnum", govnum);
		jsonObject.put("socnum", socnum);
		jsonObject.put("topicnum", topicnum);
		jsonObject.put("sitemnum", sitemnum);
		jsonObject.put("corpnum", corpnum);
		return jsonObject;
	}
	
	
	/**
	 * 获取网上办事大厅统计数据
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getWsbsNum", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getWsbsNum(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		Svorg svorg = new Svorg();
		svorg.setSvgtype("G");
		Integer govnum = svorgAPI.count(svorg);
		Integer topicnum = appealAPI.countTopic(new AppealTopic());
		Integer itemnum = appealAPI.countItem(new AppealItem());
		jsonObject.put("govnum", govnum);
		jsonObject.put("topicnum", topicnum);
		jsonObject.put("itemnum", itemnum);
		return jsonObject;
	}

}
