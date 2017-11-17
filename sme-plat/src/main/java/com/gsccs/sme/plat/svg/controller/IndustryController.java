package com.gsccs.sme.plat.svg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.base.CtreeGrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.IndustryT;
import com.gsccs.sme.plat.svg.service.IndustryService;

/**
 * 行业管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/industry")
public class IndustryController {

	@Autowired
	private IndustryService industryService;

	@RequestMapping(method = RequestMethod.GET)
	protected String industryList(HttpServletRequest req) {
		return "corp/industry-list";

	}

	@RequestMapping(value = "/treegrid", method = RequestMethod.POST)
	@ResponseBody
	public List<CtreeGrid> industryList(
			IndustryT industry,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			HttpServletRequest request) {
		List<IndustryT> list = industryService.find(industry, order, page, rows);
		List<CtreeGrid> tgList = new ArrayList<CtreeGrid>();
		for (IndustryT tg : list) {
			CtreeGrid ctg = new CtreeGrid();
			ctg.setId(tg.getId().toString());
			ctg.setParentId(tg.getParid().toString());
			ctg.setText(tg.getTitle());
			ctg.setIconCls("icon-file");
			tgList.add(ctg);
		}
		return tgList;
	}
	

	// 新增
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showCreateForm(Long id, Model model) {
		IndustryT industryT = null;
		if (null != id) {
			industryT = industryService.findById(id);
		}else{
			industryT = new IndustryT();
			industryT.setParid(0l);
		}
		model.addAttribute("industryT", industryT);
		return "corp/industry-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(@RequestBody IndustryT industryT, RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null == industryT) {
			msg.setSuccess(false);
			msg.setMsg("添加失败!");
			return msg;
		}
		if (null == industryT.getParid()) {
			industryT.setParid(0l);
		}
		industryT.setIndexnum(1);
		industryService.insert(industryT);
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody IndustryT industryT, RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null == industryT) {
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
			return msg;
		}
		if (null == industryT.getParid()) {
			industryT.setParid(0l);
		}
		industryService.update(industryT);
		msg.setSuccess(true);
		msg.setMsg("修改成功!");
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			industryService.delete(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public List<IndustryT> listData(Long pid, Model model,
			HttpServletResponse response) {
		List<IndustryT> industrylist = null;
		if (null == pid) {
			industrylist = industryService.find(null, "", 1, Integer.MAX_VALUE);
		} else {
			industrylist = industryService.findSubIndustry(pid);
		}
		return industrylist;
	}
	
	/**
	 * 行业树
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray treeList(Model model,
			HttpServletResponse response) {
		return industryService.findTree();
	}

	
}
