package com.gsccs.sme.plat.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.site.model.LinkT;
import com.gsccs.sme.plat.site.service.LinkService;

/**
 * 友情链接控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/link")
public class LinkController {

	@Autowired
	private LinkService linkService;

	@RequestMapping(method = RequestMethod.GET)
	protected String linkList(ModelMap map,HttpServletRequest req) {
		LinkT param = new LinkT();
		param.setIsclass("1");
		List<LinkT> classlist = linkService.findAll(param, "ordernum");
		map.put("classlist", classlist);
		return "site/link-list";

	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid linkList(LinkT link,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<LinkT> list = linkService.find(link, orderstr, page, rows);
		int count = linkService.count(link);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String linkForm(String id,Model model) {
		LinkT link=null;
		if (StringUtils.isNotEmpty(id)){
			link = linkService.findById(id);
		}
		model.addAttribute("link", link);
		List<LinkT> listLink=linkService.findAll(link, null);
		model.addAttribute("listLink", listLink);
		model.addAttribute("op", "新增");
		return "site/link-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(LinkT link, RedirectAttributes redirectAttributes) {
		if (null != link) {
			linkService.add(link);
		}
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		return msg;
	}

	// 修改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showUpdateForm(String id, Model model) {
		if (null != id && Long.SIZE > 0) {
			LinkT link = linkService.findById(id);
			model.addAttribute("link", link);
		}
		LinkT link=null;
		List<LinkT> listLink=linkService.findAll(link, null);
		model.addAttribute("listLink", listLink);
		model.addAttribute("op", "修改");
		return "site/link-form";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(LinkT link, RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != link) {
			linkService.update(link);
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
	public JsonMsg del(String id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			linkService.del(id);
			msg.setSuccess(true);
			msg.setMsg("删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("删除失败!");
		}
		return msg;
	}
}
