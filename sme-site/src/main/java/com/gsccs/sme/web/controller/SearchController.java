package com.gsccs.sme.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.solr.service.QueryParam;
import com.gsccs.sme.solr.service.SolrClient;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 
 * 搜索
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class SearchController {

	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 搜索
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/search.html",method = RequestMethod.GET)
	public String search(String s, String c, String k,
			ModelMap map) {
		System.out.println("s="+s);
		System.out.println("c="+c);
		System.out.println("k="+k);
		// 查询参数
		map.put("s", s);
		map.put("c", c);
		map.put("k", k);
		return "search";
	}

	/**
	 * 查询结果列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/querylist", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject querylist(String keyword,String siteid, String cateid,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, 
			Model model) {
		JSONObject json = new JSONObject();
		System.out.println("keyword:" + keyword);
		String solrurl = configAPI.getConfigVal("SOLR_URL");
		SolrClient solrClient = new SolrClient();
		solrClient.init(solrurl);

		QueryParam param = new QueryParam();
		param.setSiteId(siteid);
		param.setCateId(cateid);
		param.setKeyword(keyword);
		param.setPage(page);
		param.setRows(rows);
		JSONObject facetjson = solrClient.queryFacet(param);
		JSONArray recordjson = solrClient.queryRecord(param);
		json.put("facets", facetjson);
		json.put("records", recordjson);
		return json;
	}
}
