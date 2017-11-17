package com.gsccs.sme.plat.site.controller;

import java.text.ParseException;
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

import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.site.model.BannerT;
import com.gsccs.sme.plat.site.service.BannerService;
import com.gsccs.sme.plat.svg.model.SclassT;

/**
 * 站点热点管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/banner")
public class BannerController extends BaseController {

	@Autowired
	private BannerService bannerService;

	@RequestMapping(method = RequestMethod.GET)
	protected String bannerlist(Model model, SclassT sclassT,
			HttpServletRequest request) {
		return "site/banner-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid datagrid(Model model, BannerT banner,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) throws ParseException {
		Datagrid grid = new Datagrid();
		List<BannerT> list = bannerService.find(banner, orderstr, page, rows);
		int count = bannerService.count(banner);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String bannerForm(String id, Model model) {
		BannerT banner = null;
		if (null != id) {
			banner = bannerService.getBanner(id);
		}
		model.addAttribute("banner", banner);
		return "site/banner-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addInfo(@RequestBody BannerT banner, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == banner) {
			msg.setSuccess(false);
			msg.setMsg("信息保存失败，内容有误！");
			return msg;
		}
		try {
			bannerService.addBanner(banner);
			msg.setSuccess(true);
			msg.setMsg("信息发布成功!");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("信息发布失败!");
		}
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg bannerEdit(@RequestBody BannerT banner, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == banner || null == banner.getId()) {
			msg.setSuccess(false);
			msg.setMsg("信息保存失败，内容有误！");
			return msg;
		}
		try {
			System.out.println(banner.getUrl());
			bannerService.update(banner);
			msg.setSuccess(true);
			msg.setMsg("信息内容修改成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("信息内容修改失败!");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(String id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			bannerService.delete(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}

}
