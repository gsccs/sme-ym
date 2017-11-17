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

import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 服务机构控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class SvorgController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private SvorgServiceI svorgAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 服务机构列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "svorg.html", method = RequestMethod.GET)
	public String scorplist(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num,
			String keyword,String scode,String subscode,
			String pcode,String ccode,String acode, String svgtype,Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("scode", scode);
		model.addAttribute("subscode", subscode);
		model.addAttribute("pcode", pcode);
		model.addAttribute("ccode", ccode);
		model.addAttribute("acode", acode);
		model.addAttribute("page", page);
		model.addAttribute("svgtype", svgtype);
		model.addAttribute("num", num);
		return "svorglist";
	}

	/**
	 * 服务机构详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/svorg-{id}.html", method = RequestMethod.GET)
	public String svorgDetail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "svorg_s";
		try {
			Svorg svorg = svorgAPI.getSvg(id);
			if (null != svorg){
				String svgtype = svorg.getSvgtype();
				if (svgtype.equals("G")){
					tempPath = "svorg_g";
				}
			}
			model.addAttribute("currSvorg", svorg);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

}
