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

import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.ExpertT;
import com.gsccs.sme.plat.svg.service.ExpertService;

/**
 * 服务专家控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/expert")
public class ExpertController {

	@Autowired
	private ExpertService expertService;
	
	@RequestMapping(method = RequestMethod.GET)
	protected String getDkyyList(HttpServletRequest req) {
		return "store/expert-list";
	}
	
	@RequestMapping(value="/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid getDkyyList(ExpertT expertT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<ExpertT> list = expertService.find(expertT,orderstr, page, rows);
		int count = expertService.count(expertT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	 //新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model,String id) {
		ExpertT expertT = null;
		model.addAttribute("expertT", expertT);
		model.addAttribute("op", "新增");
		return "store/expert-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(Model model, ExpertT expertT, RedirectAttributes redirectAttributes) {
		if (null != expertT) {
			expertService.insert(expertT);
		}
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		model.addAttribute("returnMsg", msg);
		return "store/expert-list";
	}
	
	// 修改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showUpdateForm(String id,
			Model model) {
		if(null !=id && Long.SIZE> 0){
			ExpertT expertT = expertService.findById(id);
			model.addAttribute("expertT", expertT);
		}
		model.addAttribute("op", "修改");
		return "store/expert-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(ExpertT expertT,Model model,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if(null !=expertT){
			expertService.update(expertT);
			msg.setSuccess(true);
			msg.setMsg("修改成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
		}
		model.addAttribute("returnMsg", msg);
		return "store/expert-list";
	}
	
	// 删除
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		@ResponseBody
		public JsonMsg del(String id, HttpServletRequest request) {
			JsonMsg msg = new JsonMsg();
			if (null != id) {
				expertService.delSitem(id);
				msg.setSuccess(true);
				msg.setMsg("记录删除成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("记录删除失败!");
			}
			return msg;
		}
}
