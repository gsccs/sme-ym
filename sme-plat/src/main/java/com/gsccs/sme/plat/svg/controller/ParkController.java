package com.gsccs.sme.plat.svg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.ParkT;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.ParkService;
import com.gsccs.sme.plat.svg.service.SvorgService;
import com.gsccs.sme.plat.utils.HtmlCode;

/**
 * 园区管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/park")
public class ParkController extends BaseController{

	@Autowired
	private ParkService parkService;
	@Autowired
	private SvorgService svorgService;
	
	@RequestMapping(method = RequestMethod.GET)
	protected String parkList(HttpServletRequest req) {
		return "corp/park-list";
	}
	
	@RequestMapping(value="/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid parkList(ParkT park,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<ParkT> list = parkService.find(park,orderstr, page, rows);
		int count = parkService.count(park);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showForm(Long id, Model model, SclassT sclassT) {
		
		if (null != id) { // 修改
			ParkT park = parkService.findById(id);
			model.addAttribute("park", park);
		}
		SvorgT param = new SvorgT();
		param.setSvgtype("G");
		List<SvorgT> svorgList = svorgService.find(param, "", 1, Integer.MAX_VALUE);
		model.addAttribute("svorgList", svorgList);
		return "corp/park-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg add(@RequestBody ParkT park, Model model) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != park) {
				// 如果没有摘要，则自动生成
				if (StringUtils.isEmpty(park.getRemark())
						&& StringUtils.isNotEmpty(park.getContent())) {
					park.setRemark(HtmlCode.replaceHtml(park.getContent()));
					if (park.getRemark().length() > 200) {
						park.setRemark(park.getRemark().substring(0, 200));
					}
				}

				parkService.insert(park);
				msg.setSuccess(true);
				msg.setMsg("添加成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("添加失败，请检查园区数据正确！");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("添加失败，未知的错误原因！");
		}
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody ParkT park, Model model,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != park) {
			// 如果没有摘要，则自动生成
			if (StringUtils.isEmpty(park.getRemark())
					&& StringUtils.isNotEmpty(park.getContent())) {
				park.setRemark(HtmlCode.replaceHtml(park.getContent()));
				if (park.getRemark().length() > 200) {
					park.setRemark(park.getRemark().substring(0, 200));
				}
			}
			parkService.update(park);
			msg.setSuccess(true);
			msg.setMsg("园区信息修改成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("园区信息修改失败，请检查园区数据正确！");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg delete(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != id) {
				parkService.delete(id);
				msg.setSuccess(true);
				msg.setMsg("园区删除成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("删除失败，园区不存在！");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("删除失败,未知的错误原因！");
		}
		return msg;
	}
	
}
