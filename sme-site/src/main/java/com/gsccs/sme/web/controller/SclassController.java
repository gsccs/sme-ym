package com.gsccs.sme.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SneedServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 服务需求控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class SclassController {

	@Autowired
	private SclassServiceI sclassAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/sclassList", method = RequestMethod.POST)
	@ResponseBody
	public List<Itemtype> listData(Long pclassid,
			Model model, HttpServletResponse response) {
		List<Itemtype> sclasslist = null;
		if (null==pclassid){
			sclasslist = sclassAPI.getRootClass("S");
		}else{
			sclasslist = sclassAPI.getSubClass(pclassid);
		}
		return sclasslist;
	}

	
}
