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

import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 中小企业控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class CorpController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 中小企业列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "corp.html", method = RequestMethod.GET)
	public String scorplist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num, String keyword,
			String scode, String subscode, String pcode, String ccode,
			String acode,Long parkid,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("scode", scode);
		model.addAttribute("subscode", subscode);
		model.addAttribute("pcode", pcode);
		model.addAttribute("ccode", ccode);
		model.addAttribute("acode", acode);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		model.addAttribute("parkid", parkid);
		return "corplist";
	}

	/**
	 * 中小企业详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/corp-{id}.html", method = RequestMethod.GET)
	public String corpDetail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "corp";
		try {
			Corp corp = corpAPI.getCorp(id);
			model.addAttribute("currCorp", corp);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

}
