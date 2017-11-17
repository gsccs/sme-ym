package com.gsccs.sme.plat.auth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.base.CtreeGrid;
import com.gsccs.sme.plat.auth.model.Resource;
import com.gsccs.sme.plat.auth.service.ResourceService;
import com.gsccs.sme.plat.bass.JsonMsg;

/**
 * 系统资源管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@ModelAttribute("types")
	public Resource.ResourceType[] resourceTypes() {
		return Resource.ResourceType.values();
	}

	////@RequiresPermissions("resource:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		return "auth/resource-list";
	}

	////@RequiresPermissions("resource:view")
	@RequestMapping(value = "/treegrid", method = RequestMethod.POST)
	@ResponseBody
	public List<CtreeGrid> resourceList(
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			HttpServletRequest request) {
		List<Resource> resourceList = resourceService.findAll(null);
		List<CtreeGrid> tgList = new ArrayList<CtreeGrid>();
		for (Resource tg : resourceList) {
			CtreeGrid ctg = new CtreeGrid();
			ctg.setId(tg.getId().toString());
			ctg.setParentId(tg.getParentId().toString());
			ctg.setText(tg.getName());
			ctg.setIconCls("icon-file");
			ctg.setType(tg.getType().getInfo());
			ctg.setUrl(tg.getUrl());
			ctg.setPermission(tg.getPermission());
			/*
			 * if(categoryService.hasChildren(tg.getId())){
			 * ctg.setState("closed"); }
			 */
			tgList.add(ctg);
		}
		return tgList;
	}

	////@RequiresPermissions("resource:create")
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(Long parentId, Long id, Model model) {
		if (null != parentId) {
			Resource parent = resourceService.findOne(parentId);
			model.addAttribute("parent", parent);
		}
		if (null != id) {
			Resource resource = resourceService.findOne(id);
			model.addAttribute("resource", resource);
		}
		return "auth/resource-edit";
	}

	
	//@RequiresPermissions("resource:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(Resource resource,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		resourceService.createResource(resource);
		json.setSuccess(true);
		json.setMsg("新增子节点成功");
		return json;
	}

	//@RequiresPermissions("resource:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(Resource resource,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		resourceService.updateResource(resource);
		json.setMsg("修改成功");
		json.setSuccess(true);
		return json;
	}

	//@RequiresPermissions("resource:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg delete(Long id, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		resourceService.deleteResource(id);
		json.setMsg("删除成功");
		json.setSuccess(true);
		return json;
	}
	
	
	@RequestMapping(value = "/tree", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray tree(RedirectAttributes redirectAttributes) {
		return resourceService.findSysMenuTree();
	}

}
