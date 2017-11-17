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

import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.ConsultServiceI;

/**
 * 信息咨询控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class ConsultController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private ConsultServiceI consultAPI;
	@Autowired
	private ConfigServiceI configAPI;

	/**
	 * 咨询页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "consults.html", method = RequestMethod.GET)
	public String declarelist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num, String keyword,
			Long svgid, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "consults";
	}

	/**
	 * 咨询详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/consult-{id}.html", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "consult";
		Consult consult = null;
		try {
			consult = consultAPI.getConsult(id);
			model.addAttribute("currConsult", consult);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}
	
	

}
