package com.gsccs.sme.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Industry;
import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.IndustryServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 行业分类控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class IndustryController {

	@Autowired
	private IndustryServiceI industryAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/industryList", method = RequestMethod.POST)
	@ResponseBody
	public List<Industry> listData(Long parid, Model model,
			HttpServletResponse response) {
		List<Industry> sclasslist = null;
		if (null == parid) {
			sclasslist = industryAPI.getRootList();
		} else {
			sclasslist = industryAPI.getSubList(parid);
		}
		return sclasslist;
	}

}
