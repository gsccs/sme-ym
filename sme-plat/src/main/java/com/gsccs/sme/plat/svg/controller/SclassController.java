package com.gsccs.sme.plat.svg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.base.CtreeGrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.service.SclassService;

/**
 * 服务分类控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/sclass")
public class SclassController {

	@Autowired
	private SclassService sclassService;

	@RequestMapping(method = RequestMethod.GET)
	protected String sclassLIst(HttpServletRequest req) {
		return "sclass/sclass-list";

	}

	@RequestMapping(value = "/treegrid", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray sclassList(
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			HttpServletRequest request) {
		List<SclassT> list = sclassService.find(null);
		JSONArray rowArray = new JSONArray();
		for (SclassT tg : list) {
			JSONObject row = (JSONObject) JSON.toJSON(tg);
			row.put("parentId", tg.getParid());
			row.put("text", tg.getTitle());
			row.put("iconCls","icon-file");
			rowArray.add(row);
		}
		return rowArray;
	}
	

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, String id) {
		SclassT sclassT = null;
		model.addAttribute("sclassT", sclassT);
		model.addAttribute("op", "新增");
		return "sclass/sclass-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(SclassT sclassT) {
		if (null != sclassT) {
			sclassT.setParids("0");
			sclassT.setIndexnum(1);
			sclassService.insert(sclassT);
		}
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		return msg;
	}

	// 修改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showUpdateForm(Long id, Model model) {
		if (null != id && Long.SIZE > 0) {
			SclassT sclassT = sclassService.findById(id);
			model.addAttribute("sclassT", sclassT);
		}
		model.addAttribute("op", "修改");
		return "sclass/sclass-form";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(SclassT sclassT, RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != sclassT) {
			sclassService.update(sclassT);
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
			sclassService.delSclass(id);
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
	public List<SclassT> listData(Long pid,String typeid, Model model,
			HttpServletResponse response) {
		List<SclassT> sclasslist = null;
		if (null == pid) {
			SclassT sclassT = new SclassT();
			sclassT.setTypeid(typeid);
			sclasslist = sclassService.find(sclassT);
		} else {
			sclasslist = sclassService.findSubList(pid);
		}
		return sclasslist;
	}
}
