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

import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
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
public class SneedController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private SneedServiceI sneedAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 服务需求列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "sneed.html", method = RequestMethod.GET)
	public String sitemlist(@RequestParam(defaultValue = "1") int page,
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
		return "sneedlist";
	}

	/**
	 * 需求详情页
	 * 
	 * @param id
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sneed-{id}.html", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "sneed";
		Sneed sneed = null;
		Corp corp = null;
		if (null != id) {
			try {
				sneed = sneedAPI.getSneed(id);
				if (null != sneed) {
					Long corpid = sneed.getCorpid();
					corp = corpAPI.getCorp(corpid);
				}
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("currSneed", sneed);
		model.addAttribute("corp", corp);
		return tempPath;
	}

}
