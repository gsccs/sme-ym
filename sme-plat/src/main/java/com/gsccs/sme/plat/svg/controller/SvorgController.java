package com.gsccs.sme.plat.svg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.svg.service.SvorgService;

/**
 * 社会服务机构控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/svorg")
public class SvorgController extends BaseController {

	@Autowired
	private SvorgService svorgService;

	@Autowired
	private DictService dictService;

	@Autowired
	private SclassService sclassService;

	@RequestMapping(value = "/slist", method = RequestMethod.GET)
	protected String ssvorgList(HttpServletRequest req) {
		return "svorg/ssvorg-list";
	}

	@RequestMapping(value = "/glist", method = RequestMethod.GET)
	protected String gsvorgList(HttpServletRequest req) {
		return "svorg/gsvorg-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid svorgList(SvorgT svorgT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "id desc") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		Subject subject = SecurityUtils.getSubject();
		List<SvorgT> list = null;
		/*
		 * if (subject.hasRole(Constants.ROLE_SYS_M)) {
		 * System.out.println("hasrole"); } else {
		 * System.out.println("not hasrole");
		 * svorgT.setId(getCurrUser().getOrgid()); }
		 */
		list = svorgService.find(svorgT, orderstr, page, rows);
		int count = svorgService.count(svorgT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增社会服务机构
	@RequestMapping(value = "/s/form", method = RequestMethod.GET)
	public String showCreateForm(Model model, Long id) {
		SvorgT svorgT = null;
		// 服务对象
		List<DictItemT> listSOBJ = dictService.getDictItems("SOBJ");
		model.addAttribute("listSOBJ", listSOBJ);
		// 一级服务分类
		SclassT sclassT = new SclassT();
		sclassT.setParid((long) 0);
		sclassT.setTypeid("S");
		List<SclassT> listSclass = sclassService.find(sclassT);
		model.addAttribute("listSclass", listSclass);

		if (null != id) {
			svorgT = svorgService.findById(id);
			model.addAttribute("svorgT", svorgT);
		}
		return "svorg/ssvorg-form";
	}

	// 新增社会服务机构
	@RequestMapping(value = "/g/form", method = RequestMethod.GET)
	public String gSvorgForm(Model model, Long id) {
		SvorgT svorgT = null;
		if (null != id) {
			svorgT = svorgService.findById(id);
		}
		model.addAttribute("svorgT", svorgT);
		return "svorg/gsvorg-form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg save(@RequestBody SvorgT param, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == param) {
			msg.setSuccess(false);
			msg.setMsg("新增机构失败，机构信息不完整。");
			return msg;
		} 
		
		if (null==param.getId()){
			svorgService.addSvorg(param);
			msg.setSuccess(true);
			msg.setMsg("新增机构成功!");
		}else{
			svorgService.update(param);
			msg.setSuccess(true);
			msg.setMsg("更新机构成功!");
		}
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody SvorgT svorgT, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null != svorgT) {
			svorgService.update(svorgT);
			msg.setSuccess(true);
			msg.setMsg("修改成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			svorgService.del(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
}
