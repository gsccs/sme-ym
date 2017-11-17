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

import com.gsccs.sme.api.domain.Expect;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.ExpertServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 专家咨询控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class ExpertController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private ExpertServiceI expertAPI;
	@Autowired
	private SclassServiceI sclassAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 专家咨询页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "expert.html", method = RequestMethod.GET)
	public String expertlist(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num,
			String keyword,String scode,String subscode,
			String pcode,String ccode,String acode, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("scode", scode);
		model.addAttribute("subscode", subscode);
		model.addAttribute("pcode", pcode);
		model.addAttribute("ccode", ccode);
		model.addAttribute("acode", acode);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "expertlist";
	}

	/**
	 * 专家详情页
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/expert-{id}", method = RequestMethod.GET)
	public String expertDetail(@PathVariable("id") String id, Model model,
			HttpServletResponse response) {
		String tempPath = "expert";
		try {
			Expect expert = expertAPI.getExpert(id);
			model.addAttribute("currExpert", expert);
		} catch (ApiException e) {
			tempPath = "expert404";
		}
		return tempPath;
	}
}
