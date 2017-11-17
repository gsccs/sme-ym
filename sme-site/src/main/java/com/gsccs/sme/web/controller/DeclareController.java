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

import com.gsccs.sme.api.domain.DeclareTopic;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.DeclareServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 项目申报控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class DeclareController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private DeclareServiceI declareAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 申报列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "declare.html", method = RequestMethod.GET)
	public String declarelist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num, String keyword,
			Long svgid, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("svgid", svgid);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "declarelist";
	}

	/**
	 * 申报详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/declare-{id}.html", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "declare";
		DeclareTopic declareTopic = null;
		try {
			declareTopic = declareAPI.getTopic(id);
			model.addAttribute("currDeclareTopic", declareTopic);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

}
