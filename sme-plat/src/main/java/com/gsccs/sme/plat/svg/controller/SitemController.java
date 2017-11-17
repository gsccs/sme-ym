package com.gsccs.sme.plat.svg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SitemT;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.svg.service.SitemService;
import com.gsccs.sme.plat.utils.HtmlCode;

/**
 * 服务项目控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/sitem")
public class SitemController extends BaseController{

	@Autowired
	private SitemService sitemService;
	@Autowired
	private SclassService sclassService;
	@Autowired
	private DictService dictService;

	@RequestMapping(method = RequestMethod.GET)
	protected String sitemList(HttpServletRequest req, SclassT sclassT,
			Model model) {
		// 一级服务分类
		sclassT.setParid((long) 0);
		List<SclassT> list = sclassService.find(sclassT);
		model.addAttribute("list", list);
		return "store/sitem-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid sitemList(SitemT sitemT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		sitemT.setSvgid(getCurrUser().getOrgid());
		List<SitemT> list = sitemService.findByExample(sitemT, orderstr, page,
				rows);
		int count = sitemService.count(sitemT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model, String id, DictItemT dictItem,
			SclassT sclassT) {
		// 服务对象
		List<DictItemT> otypelist = dictService.getDictItemsByCode("SOBJ",
				dictItem);
		// 服务方式
		List<DictItemT> stypelist = dictService.getDictItemsByCode("STYPE",
				dictItem);
		// 收费模式
		List<DictItemT> ptypelist = dictService.getDictItemsByCode("PTYPE",
				dictItem);
		model.addAttribute("otypelist", otypelist);
		model.addAttribute("stypelist", stypelist);
		model.addAttribute("ptypelist", ptypelist);
		List<SclassT> list = sclassService.find(sclassT);
		model.addAttribute("list", list);
		return "store/sitem-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addSitem(Model model, SitemT sitemT) {
		JsonMsg msg = new JsonMsg();
		if (null == sitemT) {
			msg.setSuccess(false);
			msg.setMsg("服务项目发布失败！");
			return msg;
		}
		// 如果没有摘要，则自动生成
		if (StringUtils.isEmpty(sitemT.getRemark())
				&& StringUtils.isNotEmpty(sitemT.getContent())) {
			sitemT.setRemark(HtmlCode.replaceHtml(sitemT.getContent()));
			if (sitemT.getRemark().length() > 100) {
				sitemT.setRemark(sitemT.getRemark().substring(0, 100));
			}
		}
		sitemT.setSvgid(getCurrUser().getOrgid());
		sitemService.insert(sitemT);
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		model.addAttribute("returnMsg", msg);
		return msg;
	}

	// 修改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showUpdateForm(Long id, Model model, SclassT sclassT,
			DictItemT dictItem) {
		// 服务对象
		List<DictItemT> otypelist = dictService.getDictItemsByCode("SOBJ",
				dictItem);
		// 服务方式
		List<DictItemT> stypelist = dictService.getDictItemsByCode("STYPE",
				dictItem);
		// 收费模式
		List<DictItemT> ptypelist = dictService.getDictItemsByCode("PTYPE",
				dictItem);
		model.addAttribute("otypelist", otypelist);
		model.addAttribute("stypelist", stypelist);
		model.addAttribute("ptypelist", ptypelist);
		// 一级服务分类
		sclassT.setParid((long) 0);
		List<SclassT> list = sclassService.find(sclassT);
		model.addAttribute("list", list);
		if (null != id) {
			SitemT sitemT = sitemService.findById(id);
			model.addAttribute("sitemT", sitemT);
		}
		return "store/sitem-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(Model model, SitemT sitemT) {
		JsonMsg msg = new JsonMsg();
		if (null == sitemT) {
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
			model.addAttribute("returnMsg", msg);
			return "store/sitem-list";
		} 
		
		sitemT.setSproject(sitemT.getSproject());

		// 如果没有摘要，则自动生成
		if (StringUtils.isEmpty(sitemT.getRemark())
				&& StringUtils.isNotEmpty(sitemT.getContent())) {
			sitemT.setRemark(HtmlCode.replaceHtml(sitemT.getContent()));
			if (sitemT.getRemark().length() > 200) {
				sitemT.setRemark(sitemT.getRemark().substring(0, 200));
			}
		}
		sitemT.setSvgid(getCurrUser().getOrgid());
		sitemService.update(sitemT);
		msg.setSuccess(true);
		msg.setMsg("修改成功!");
		model.addAttribute("returnMsg", msg);
		return "store/sitem-list";
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			sitemService.delSitem(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}

	// 二级服务菜单获取
	@RequestMapping(value = "/getTags", method = RequestMethod.POST)
	@ResponseBody
	public String getTags(Long id, SclassT sclassT) {
		sclassT.setParid(id);
		List<SclassT> sonSclass = sclassService.find(sclassT);
		String sonSclassJson = JSON.toJSONString(sonSclass);
		return sonSclassJson;
	}
}
