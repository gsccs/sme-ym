package com.gsccs.sme.plat.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.api.domain.base.CtreeGrid;
import com.gsccs.sme.plat.auth.model.Organization;
import com.gsccs.sme.plat.auth.service.OrganizationService;
import com.gsccs.sme.plat.bass.JsonMsg;

/**
 * 组织机构管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/org")
public class OrganController {

	@Autowired
	private OrganizationService organizationService;

	@RequiresPermissions("org:view")
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		return "auth/org-list";
	}

	@RequiresPermissions("org:view")
	@RequestMapping(value = "/treegrid", method = RequestMethod.POST)
	@ResponseBody
	public List<CtreeGrid> treegrid(Organization org,Model model) {
		List<Organization> orglist = organizationService.findAll();
		// treegrid.setRows(organizationService.getOrgTreeToJson());
		List<CtreeGrid> tgList = new ArrayList<CtreeGrid>();
		for (Organization tg : orglist) {
			CtreeGrid ctg = new CtreeGrid();
			ctg.setId(tg.getId().toString());
			ctg.setParentId(tg.getParentId().toString());
			ctg.setText(tg.getName());
			ctg.setIconCls("icon-file");
			/*
			 * if(categoryService.hasChildren(tg.getId())){
			 * ctg.setState("closed"); }
			 */
			tgList.add(ctg);
		}
		return tgList;
	}

	@RequiresPermissions("org:create")
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(Long parentId, Model model) {
		Organization parent = organizationService.findOne(parentId);
		model.addAttribute("parent", parent);
		Organization child = new Organization();
		child.setParentId(parentId);
		child.setParentIds(parent.makeSelfAsParentIds());
		model.addAttribute("child", child);
		return "auth/org-edit";
	}

	@RequiresPermissions("org:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(Organization organization) {
		JsonMsg json = new JsonMsg();
		organizationService.createOrganization(organization);
		json.setSuccess(true);
		json.setMsg("新增成功！");
		return json;
	}

	@RequiresPermissions("org:update")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(Organization organization,
			RedirectAttributes redirectAttributes) {
		organizationService.updateOrganization(organization);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/organization/success";
	}

	@RequiresPermissions("org:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		organizationService.deleteOrganization(id);
		redirectAttributes.addFlashAttribute("msg", "删除成功");
		return "redirect:/organization/success";
	}

	@RequiresPermissions("org:update")
	@RequestMapping(value = "/{sourceId}/move", method = RequestMethod.GET)
	public String showMoveForm(@PathVariable("sourceId") Long sourceId,
			Model model) {
		Organization source = organizationService.findOne(sourceId);
		model.addAttribute("source", source);
		model.addAttribute("targetList",
				organizationService.findAllWithExclude(source));
		return "organization/move";
	}

	@RequiresPermissions("organization:update")
	@RequestMapping(value = "/{sourceId}/move", method = RequestMethod.POST)
	public String move(@PathVariable("sourceId") Long sourceId,
			@RequestParam("targetId") Long targetId) {
		Organization source = organizationService.findOne(sourceId);
		Organization target = organizationService.findOne(targetId);
		organizationService.move(source, target);
		return "redirect:/organization/success";
	}

	@RequiresPermissions("organization:view")
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success() {
		return "organization/success";
	}

}
