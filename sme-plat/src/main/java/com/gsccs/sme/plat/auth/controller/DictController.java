package com.gsccs.sme.plat.auth.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.plat.auth.model.DictGroupT;
import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;


/**
 * 数据字典
 * @author x.d zhang
 *
 */
@Controller
@RequestMapping("/dict")
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	protected String grouplist(HttpServletRequest req) {
		return "auth/dictGroup-list";

	}

	@RequestMapping(value = "/group/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid getDkyyList(DictGroupT dictGroup,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<DictGroupT> list = dictService.findGroupList(dictGroup);
		int count = dictService.countDictGroup(dictGroup);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	@RequestMapping(value = "/group/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(DictGroupT dictGroup,
			RedirectAttributes redirectAttributes) {
		if (null != dictGroup) {
			dictGroup.setId(UUID.randomUUID().toString());
			dictService.createDictGroupT(dictGroup);
		}
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		return msg;
	}

	// 修改
	@RequestMapping(value = "/group/form", method = RequestMethod.GET)
	public String showUpdateForm(String id, Model model) {
		DictGroupT dictGroup = null;
		if (StringUtils.isNotEmpty(id)) {
			dictGroup = dictService.getGroupById(id);
			model.addAttribute("dictGroup", dictGroup);
		}
		return "auth/dictGroup-form";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(DictGroupT dictGroup,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != dictGroup) {
			dictService.updateDictGroupT(dictGroup);
			msg.setSuccess(true);
			msg.setMsg("修改成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/group/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delgroup(String id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			dictService.deleteDictGroupT(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
	
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	protected String itemList(HttpServletRequest req) {
		return "auth/dictItem-list";

	}

	@RequestMapping(value = "/item/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid itemList(DictItemT dictItem, HttpServletRequest request,
			ModelMap map) {
		Datagrid grid = new Datagrid();
		List<DictItemT> list = dictService.findGroupAndItemList(dictItem);
		int count = dictService.countDictItem(dictItem);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}


	@RequestMapping(value = "/item/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(DictItemT dictItem,
			RedirectAttributes redirectAttributes) {
		if (null != dictItem) {
			dictItem.setId(UUID.randomUUID().toString());
			DictGroupT dictGroup = dictService.getGroupByTitle(dictItem
					.getGroupTitle());
			dictItem.setGroupid(dictGroup.getId());
			dictItem.setRemark(dictItem.getTitle());
			dictItem.setStatus("1");
			dictService.createDictItemT(dictItem);
		}
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		return msg;
	}

	// 修改
	@RequestMapping(value = "/item/form", method = RequestMethod.GET)
	public String showForm(String id,String groupid, Model model) {
		DictItemT dictItem  = null;
		if (StringUtils.isNotEmpty(id)) {
			dictItem = dictService.getDictById(id);
			model.addAttribute("dictItem", dictItem);
		}
		DictGroupT dictGroupT = dictService.getGroupById(groupid);
		model.addAttribute("dictGroup", dictGroupT);
		return "auth/dictItem-form";
	}

	@RequestMapping(value = "/item/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(DictItemT dictItem,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		DictGroupT dictGroup = dictService.getGroupByTitle(dictItem
				.getGroupTitle());
		dictItem.setGroupid(dictGroup.getId());
		dictItem.setRemark(dictItem.getTitle());
		dictItem.setStatus("1");
		dictService.updateDictItemT(dictItem);
		msg.setSuccess(true);
		msg.setMsg("修改成功!");
		return msg;
	}

	// 删除
	@RequestMapping(value = "/item/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(String id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			dictService.deleteDictItemT(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}

}
