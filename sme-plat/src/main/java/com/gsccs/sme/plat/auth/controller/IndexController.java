package com.gsccs.sme.plat.auth.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.plat.Constants;
import com.gsccs.sme.plat.auth.model.MsgT;
import com.gsccs.sme.plat.auth.model.Resource;
import com.gsccs.sme.plat.auth.model.Resource.ResourceType;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.service.AuthService;
import com.gsccs.sme.plat.auth.service.MsgService;
import com.gsccs.sme.plat.auth.service.ResourceService;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.ConsultService;
import com.gsccs.sme.plat.svg.service.SvorgService;
import com.gsccs.sme.plat.web.bind.annotation.CurrentUser;

/**
 * 系统首页
 * @author x.d zhang
 *
 */
@Controller
public class IndexController {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private AuthService authService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private MsgService msgService;
	@Autowired
	private ConsultService consultService;

	@RequestMapping("/index")
	public String index(@CurrentUser User loginUser, Model model) {
		Set<String> permissions = authService.findPermissions(
				Constants.SERVER_APP_KEY, loginUser.getAccount());
		Resource param = new Resource();
		param.setParentId(0l);
		param.setType(ResourceType.menu);
		List<Resource> menus = resourceService.findMenus(permissions, param);
		model.addAttribute("menus", menus);
		return "index";
	}
	
	@RequestMapping("/main")
	public String main(@CurrentUser User loginUser, Model model) {
		Long svgid = loginUser.getOrgid();
		SvorgT svorgT = svorgService.findById(svgid);
		model.addAttribute("svorg", svorgT);
		return "main";
	}
	
	
	@RequestMapping("/platmsg")
	@ResponseBody
	public JSONObject topstatist(@CurrentUser User loginUser, Model model) {
		JSONObject object = new JSONObject();
		//督办任务
		object.put("tasks", 0);
		
		//业务咨询
		Consult consultparam = new Consult();
		consultparam.setSvgid(loginUser.getOrgid());
		consultparam.setStatus("0");
		Integer cstcount = consultService.count(consultparam);
		object.put("consult", cstcount);
		//平台通知
		MsgT msgParam = new MsgT();
		msgParam.setReceiver(loginUser.getOrgid());
		msgParam.setStatus("0");
		Integer msgcount = msgService.count(msgParam);
		object.put("notice", msgcount);
		return object;
	}

	@RequestMapping("/menu")
	@ResponseBody
	public List<Resource> menu(@CurrentUser User loginUser, Long pid,
			Model model) {
		Set<String> permissions = authService.findPermissions(
				Constants.SERVER_APP_KEY, loginUser.getAccount());
		if (null == pid) {
			pid = 1l;
		}
		Resource param = new Resource();
		param.setParentId(pid);
		List<Resource> menutree = resourceService.findMenus(permissions, param);
		return menutree;
	}

	
	
	@RequestMapping("/forward")
	public String forward(String path) {
		// BuyerAccount baccount = buyerAPI.getBuyerAccount(1000, 1001);
		/*
		 * if (null != baccount) { System.out.println("baccount:" +
		 * baccount.getName()); }
		 */
		return path;
	}

}
