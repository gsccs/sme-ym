package com.gsccs.sme.plat.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.plat.auth.model.Role;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.service.ResourceService;
import com.gsccs.sme.plat.auth.service.RoleService;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;

/*
 * 系统角色管理
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;

	//@RequiresPermissions("role:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("roleList", roleService.findAll());
		return "auth/role-list";
	}

	//@RequiresPermissions("role:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid roleList(User user,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<Role> roleList = roleService.findAll();
		int count = 0;
		if (null != roleList) {
			count = roleList.size();
		}
		datagrid.setRows(roleList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	//@RequiresPermissions("role:create")
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(Long id, Model model) {
		setCommonData(model);
		if (null != id) {
			model.addAttribute("role", roleService.findByRoleid(id));
		}
		return "auth/role-edit";
	}

	//@RequiresPermissions("role:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(Role role, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		roleService.createRole(role);
		json.setSuccess(true);
		json.setMsg("角色新增成功!");
		return json;
	}

	//@RequiresPermissions("role:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(Role role, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		roleService.updateRole(role);
		json.setSuccess(true);
		json.setMsg("角色信息修改成功!");
		return json;
	}
	
	
	/**
	 * 角色授权
	 * @param roleid
	 * @param resourceIds
	 * @param redirectAttributes
	 * @return
	 */
	//@RequiresPermissions("role:update")
	@RequestMapping(value = "/roleauth", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg roleauth(Long roleid,String resourceIds, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null != roleid){
			Role role = roleService.findByRoleid(roleid);
			role.setResourceIds(resourceIds);
			roleService.updateRole(role);
		}
		json.setSuccess(true);
		json.setMsg("角色信息修改成功!");
		return json;
	}
	
	

	//@RequiresPermissions("role:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(Long id, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		roleService.deleteRole(id);
		json.setMsg("删除成功");
		return json;
	}

	
	
	//@RequiresPermissions("role:create")
	@RequestMapping(value = "/authform", method = RequestMethod.GET)
	public String authform(Long id, Model model) {
		if (null != id) {
			model.addAttribute("role", roleService.findByRoleid(id));
		}
		return "auth/role-auth";
	}
	
	
	
	private void setCommonData(Model model) {
		model.addAttribute("resourceList", resourceService.findAll(null));
	}
	
}
