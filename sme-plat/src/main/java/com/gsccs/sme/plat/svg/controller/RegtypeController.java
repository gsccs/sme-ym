package com.gsccs.sme.plat.svg.controller;

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

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.RegTypeT;
import com.gsccs.sme.plat.svg.service.RegtypeService;

/**
 * 企业注册类型控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/regtype")
public class RegtypeController {

	@Autowired
	private RegtypeService regtypeService;

	@RequestMapping(method = RequestMethod.GET)
	protected String regtypeList(HttpServletRequest req) {
		return "regtype/regtype-list";

	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid regtypeList(RegTypeT regtypeT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<RegTypeT> list = regtypeService.find(null);
		int count = regtypeService.count(regtypeT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, String id) {
		RegTypeT regtypeT = null;
		model.addAttribute("regtypeT", regtypeT);
		model.addAttribute("op", "新增");
		return "regtype/regtype-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(RegTypeT regtypeT,
			RedirectAttributes redirectAttributes) {
		if (null != regtypeT) {
			regtypeService.insert(regtypeT);
		}
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		return msg;
	}

	// 修改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showUpdateForm(Long id, Model model) {
		if (null != id) {
			RegTypeT regtypeT = regtypeService.findById(id);
			model.addAttribute("regtypeT", regtypeT);
		}
		model.addAttribute("op", "修改");
		return "regtype/regtype-form";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(RegTypeT regtypeT) {
		JsonMsg msg = new JsonMsg();
		if (null != regtypeT) {
			regtypeService.update(regtypeT);
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
			regtypeService.delChannel(id);
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
	public List<RegTypeT> listData(Long pid, Model model,
			HttpServletResponse response) {
		List<RegTypeT> regTypeTs = null;
		if (null == pid) {
			regTypeTs = regtypeService.find(null);
		} else {
			regTypeTs = regtypeService.findSubChannel(pid);
		}
		return regTypeTs;
	}

	@RequestMapping(value = "/tree", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray tree(Model model) {
		return regtypeService.findChannelTree();
	}

}
