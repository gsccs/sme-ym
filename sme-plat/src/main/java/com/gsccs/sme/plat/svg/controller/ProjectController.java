package com.gsccs.sme.plat.svg.controller;

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

import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.ProjectT;
import com.gsccs.sme.plat.svg.model.IndustryT;
import com.gsccs.sme.plat.svg.service.ProjectService;
import com.gsccs.sme.plat.svg.service.IndustryService;

/**
 * 企业项目控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/cropProject")
public class ProjectController {

	@Autowired
	private ProjectService cropProjectService;

	@Autowired
	private DictService dictService;

	@Autowired
	private IndustryService industryService;

	@RequestMapping(method = RequestMethod.GET)
	protected String cropProjectList(Model model,HttpServletRequest req) {
		// 资金来源
		List<DictItemT> moneytypelist = dictService.getDictItems("MTYPE");
		model.addAttribute("moneytypelist", moneytypelist);
		// 行业类别
		List<IndustryT> industrylist = industryService.find(null, "", 1,
				Integer.MAX_VALUE);
		model.addAttribute("industrylist", industrylist);
		return "store/cropProject-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid cropProjectList(ProjectT cropProject,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<ProjectT> list = cropProjectService.find(cropProject, orderstr,
				page, rows);
		int count = cropProjectService.count(cropProject);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, String id, DictItemT dictItemT,
			IndustryT industryT) {
		ProjectT cropProject = null;
		model.addAttribute("cropProject", cropProject);
		// 资金来源
		List<DictItemT> listMTYPE = dictService.getDictItemsByCode("MTYPE",
				dictItemT);
		model.addAttribute("listMTYPE", listMTYPE);
		// 行业类别
		List<IndustryT> listIndustryT = industryService.find(industryT, "", 1,
				Integer.MAX_VALUE);
		model.addAttribute("listIndustryT", listIndustryT);
		return "store/cropProject-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(ProjectT cropProject, Model model,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != cropProject) {
			cropProjectService.add(cropProject);
			msg.setSuccess(true);
			msg.setMsg("新增项目成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("新增项目失败，项目信息不完整。");
		}
		model.addAttribute("returnMsg", msg);
		return "store/cropProject-list";
	}

	// 修改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showUpdateForm(Integer id, Model model, DictItemT dictItemT,
			IndustryT industryT) {
		// 资金来源
		List<DictItemT> listMTYPE = dictService.getDictItemsByCode("MTYPE",
				dictItemT);
		model.addAttribute("listMTYPE", listMTYPE);
		if (null != id && Long.SIZE > 0) {
			ProjectT cropProject = cropProjectService.findById(id);
			model.addAttribute("cropProject", cropProject);
		}
		// 行业类别
		List<IndustryT> listIndustryT = industryService.find(industryT, "", 1,
				100);
		model.addAttribute("listIndustryT", listIndustryT);
		return "store/cropProject-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(ProjectT cropProject, Model model,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != cropProject) {
			cropProjectService.update(cropProject);
			msg.setSuccess(true);
			msg.setMsg("修改成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
		}
		model.addAttribute("returnMsg", msg);
		return "store/cropProject-list";
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(Integer id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			cropProjectService.del(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
}
