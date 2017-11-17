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

import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.SorderT;
import com.gsccs.sme.plat.svg.service.SitemService;
import com.gsccs.sme.plat.svg.service.SorderService;

/**
 * 服务订单控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/sorder")
public class SorderController {

	@Autowired
	private SitemService sitemService;
	@Autowired
	private SorderService sorderService;
	@Autowired
	private DictService dictService;

	@RequestMapping(method = RequestMethod.GET)
	protected String sorderList(HttpServletRequest req) {
		return "sorder/sorder-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid sorderList(SorderT sorder,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "addtime desc") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<SorderT> list = sorderService.find(sorder, orderstr, page, rows);
		int count = sorderService.count(sorder);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 修改
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showOrderForm(String id, Model model) {
		SorderT sorder = sorderService.findById(id);
		model.addAttribute("sorder", sorder);
		return "sorder/sorder-form";
	}

	@RequestMapping(value = "/handler", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(Model model, SorderT sorderT) {
		JsonMsg msg = new JsonMsg();
		if (null != sorderT) {
			// sorderService.update(sorderT);
			msg.setSuccess(true);
			msg.setMsg("修改成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
		}
		return msg;
	}

}
