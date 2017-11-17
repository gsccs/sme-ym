package com.gsccs.sme.plat.shop.controller;

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

import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.shop.model.CategoryT;
import com.gsccs.sme.plat.shop.service.CategoryService;

/**
 * 产品分类控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	protected String categoryList(HttpServletRequest req) {
		return "shop/category-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid categoryList(CategoryT sclassT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<CategoryT> list = categoryService.find(null);
		int count = categoryService.count(sclassT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, String id) {
		CategoryT sclassT = null;
		model.addAttribute("sclassT", sclassT);
		model.addAttribute("op", "新增");
		return "shop/category-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(CategoryT sclassT, RedirectAttributes redirectAttributes) {
		if (null != sclassT) {
			if (sclassT.getParid() != 0)
				sclassT.setParids("0/" + sclassT.getParid());
			sclassT.setParids("0");
			sclassT.setIndexnum(1);
			categoryService.insert(sclassT);
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
			CategoryT sclassT = categoryService.findById(id);
			model.addAttribute("sclassT", sclassT);
		}
		model.addAttribute("op", "修改");
		return "shop/category-form";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(CategoryT sclassT, RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != sclassT) {
			categoryService.update(sclassT);
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
			categoryService.delSclass(id);
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
	public List<CategoryT> listData(Long pid, Model model,
			HttpServletResponse response) {
		List<CategoryT> sclasslist = null;
		if (null == pid) {
			sclasslist = categoryService.find(null);
		} else {
			sclasslist = categoryService.findSubCategory(pid);
		}
		return sclasslist;
	}
}
