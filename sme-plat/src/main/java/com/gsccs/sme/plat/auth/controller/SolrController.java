package com.gsccs.sme.plat.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.plat.bass.service.SolrService;
import com.gsccs.sme.plat.site.service.ContentService;

/**
 * 系统用户管理
 */
@Controller
@RequestMapping("/solr")
public class SolrController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg solrremove(ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		SolrService solrClient = new SolrService();
		solrClient.init();
		solrClient.remove();
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("初始化成功");
		return jsonMsg;
	}
	
	@RequestMapping(value = "/index/info", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg infoIndex(ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		contentService.index();
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("信息索引");
		return jsonMsg;
	}

	
}
