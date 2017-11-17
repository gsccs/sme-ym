package com.gsccs.sme.plat.auth.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.plat.auth.model.App;
import com.gsccs.sme.plat.auth.service.AppService;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private AppService appService;

	@RequiresPermissions("app:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		return "auth/app-list";
	}

	// @RequiresPermissions("user:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid appList(App param,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<App> userList = appService.find(param, order, page, rows);
		int count = appService.count(param);
		datagrid.setRows(userList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showCreateForm(Long id, Model model) {
		App app = null;
		if (null != id) {
			app = appService.findOne(id);
		} else {
			app = new App();
			app.setAppKey(UUID.randomUUID().toString());
			app.setAppSecret(UUID.randomUUID().toString());
		}
		model.addAttribute("app", app);
		return "auth/app-form";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(App app) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == app) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		appService.createApp(app);
		jsonMsg.setMsg("新增成功");
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(App app, RedirectAttributes redirectAttributes) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == app) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		appService.updateApp(app);
		jsonMsg.setMsg("修改成功");
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(Long id, RedirectAttributes redirectAttributes) {
		JsonMsg jsonMsg = new JsonMsg();
		appService.deleteApp(id);
		jsonMsg.setMsg("删除成功");
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

}
