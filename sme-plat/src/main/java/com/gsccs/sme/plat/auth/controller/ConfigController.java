package com.gsccs.sme.plat.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.plat.auth.model.Config;
import com.gsccs.sme.plat.auth.service.ConfigService;
import com.gsccs.sme.plat.bass.Datagrid;

@Controller
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

	@RequiresPermissions("config:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		return "auth/config-list";
	}

	@RequiresPermissions("config:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Config conf, HttpServletRequest request) {

		Datagrid datagrid = new Datagrid();
		List<Config> confList = configService.find(conf, currPage, pageSize);
		int count = configService.count(conf);
		datagrid.setRows(confList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	@RequiresPermissions("config:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		Config app = new Config();
		model.addAttribute("config", app);
		model.addAttribute("op", "新增");
		return "auth/config-edit";
	}

	@RequiresPermissions("config:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Config config, RedirectAttributes redirectAttributes) {
		// configService.createApp(app);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/config";
	}

	@RequiresPermissions("config:update")
	@RequestMapping(value = "/{code}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("code") String code, Model model) {
		model.addAttribute("config", configService.findByCode(code));
		model.addAttribute("op", "修改");
		return "auth/config-edit";
	}

	@RequiresPermissions("config:update")
	@RequestMapping(value = "/{code}/update", method = RequestMethod.POST)
	public String update(Config config, RedirectAttributes redirectAttributes) {
		configService.update(config.getCode(), config.getConfigvalue());
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/config";
	}

}
