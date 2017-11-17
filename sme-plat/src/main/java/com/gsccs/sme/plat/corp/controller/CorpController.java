package com.gsccs.sme.plat.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.site.model.BannerT;
import com.gsccs.sme.plat.svg.model.CorpT;
import com.gsccs.sme.plat.svg.model.IndustryT;
import com.gsccs.sme.plat.svg.model.ParkT;
import com.gsccs.sme.plat.svg.service.IndustryService;
import com.gsccs.sme.plat.svg.service.ParkService;

/**
 * 企业控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/corp")
public class CorpController {

	@Autowired
	private CorpService corpService;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private ParkService parkService;

	@RequestMapping(method = RequestMethod.GET)
	protected String corpList(ModelMap map, HttpServletRequest req) {
		List<ParkT> parklist = parkService.find(null, "", 1, Integer.MAX_VALUE);
		List<IndustryT> industryList = industryService.find(null, "", 1,
				Integer.MAX_VALUE);
		map.put("industryList", industryList);
		map.put("parklist", parklist);
		return "corp/corp-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid corpList(CorpT corp,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "addtime desc") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<CorpT> list = corpService.find(corp, orderstr, page, rows);
		int count = corpService.count(corp);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 查看详情
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Long id, Model model) {
		if (null != id) {
			CorpT corp = corpService.getCorp(id);
			model.addAttribute("corp", corp);
		}
		model.addAttribute("op", "修改");
		return "corp/corp-view";
	}

	// 查看详情
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Long id, ModelMap map) {
		CorpT corp = null;
		if (null != id) {
			corp = corpService.getCorp(id);
		}
		List<ParkT> parklist = parkService.find(null, "", 1, Integer.MAX_VALUE);
		map.put("corp", corp);
		map.put("parklist", parklist);
		return "corp/corp-form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg save(CorpT corp, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == corp) {
			msg.setSuccess(false);
			msg.setMsg("保存失败，内容有误！");
			return msg;
		}
		try {
			if (null == corp.getId()) {
				corpService.addCorp(corp);
			} else {
				corpService.updateCorp(corp);
			}
			msg.setSuccess(true);
			msg.setMsg("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("保存失败!");
		}
		return msg;
	}

}
