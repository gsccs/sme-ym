package com.gsccs.sme.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.Industry;
import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.shop.Category;
import com.gsccs.sme.api.service.CategoryServiceI;
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
public class CategoryController {

	@Autowired
	private CategoryServiceI categoryAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/categoryList", method = RequestMethod.POST)
	@ResponseBody
	public List<Category> listData(Long parid, Model model,
			HttpServletResponse response) {
		List<Category> list = null;
		if (null == parid) {
			list = categoryAPI.getRootCategory();
		} else {
			list = categoryAPI.getSubCategory(parid);
		}
		return list;
	}

	@RequestMapping(value = "/categoryTree", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray categoryTree(Model model, HttpServletResponse response) {
		return categoryAPI.getCategoryTree();
	}

}
