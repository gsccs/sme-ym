package com.gsccs.sme.plat.rtable.controller;

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

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.plat.auth.model.DictGroupT;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.rtable.model.PropT;
import com.gsccs.sme.plat.rtable.model.PropvalT;
import com.gsccs.sme.plat.rtable.service.PropService;
import com.gsccs.sme.plat.rtable.service.ReportService;

/**
 * 统计指标管理
 * 
 * @author x.d zhang
 * 
 */

@Controller
public class PropController {

	@Autowired
	private ReportService reportService;
	@Autowired
	private PropService propService;
	@Autowired
	private DictService dictService;

	@RequestMapping(value = "/prop",method = RequestMethod.GET)
	public String list(String reportid, ModelMap map) {
		map.addAttribute("reportid", reportid);
		return "report/prop-list";
	}

	@RequestMapping(value = "/prop/datagrid")
	@ResponseBody
	public Datagrid list(String reportid, ModelMap map,
			@RequestParam(defaultValue = " indexnum ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			HttpServletRequest request) {
		PropT propT = new PropT();
		if (StringUtils.isNotEmpty(reportid)) {
			propT.setReportid(reportid);
		}
		List<PropT> list = propService.find(propT, order, page, rows);
		int count = propService.count(propT);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	@RequestMapping(value = "/prop/form", method = RequestMethod.GET)
	public String showCreateForm(String id, String reportid, Model model) {
		PropT propT = null;

		// 获得数据字典分类
		DictGroupT dgt = new DictGroupT();
		List<DictGroupT> dgtList = dictService.findGroupList(dgt);

		model.addAttribute("dgtList", dgtList);
		model.addAttribute("reportid", reportid);
		if (StringUtils.isNotEmpty(id)) {
			propT = propService.getProp(id);
			model.addAttribute("prop", propT);
			return "report/prop-edit";
		} else {
			return "report/prop-add";
		}
	}

	@RequestMapping(value = "/prop/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addProp(PropT prop) {
		JsonMsg json = new JsonMsg();
		if (null != prop) {
			propService.addProp(prop);
		}
		json.setSuccess(true);
		json.setMsg("新增成功");
		return json;
	}

	@RequestMapping(value = "/prop/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg editProp(PropT param) {
		JsonMsg json = new JsonMsg();
		if (null != param) {
			propService.updateProp(param);
			json.setSuccess(true);
			json.setMsg("更新成功！");
		} else {
			json.setSuccess(false);
			json.setMsg("更新失败！");
		}
		return json;
	}
	
	@RequestMapping(value = "/prop/auth", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg propAuth(String propid,String svgids) {
		JsonMsg json = new JsonMsg();
		if (null != propid) {
			PropT propT = propService.getProp(propid);
			propT.setSvgids(svgids);
			propService.updateProp(propT);
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("保存失败。指标不存在");
		}
		return json;
	}

	/**
	 * 统计指标删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/prop/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(
			@RequestParam(value = "id", required = false) String ids) {
		JsonMsg json = new JsonMsg();
		if (StringUtils.isNotEmpty(ids)) {
			propService.delProp(ids);
			json.setSuccess(true);
			json.setMsg("属性删除成功！");
			return json;
		}
		json.setSuccess(false);
		json.setMsg("属性删除失败！");
		return json;
	}

	@RequestMapping(value = "/prop/list")
	@ResponseBody
	public JsonMsg proplist(String reportid, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (StringUtils.isEmpty(reportid)) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("请指定信息化产品产品！");
			return jsonMsg;
		}

		PropT propT = new PropT();
		propT.setReportid(reportid);
		List<PropT> proplist = propService.find(propT, "indexnum", 1,
				Integer.MAX_VALUE);
		jsonMsg.setSuccess(true);
		jsonMsg.setData(proplist);
		return jsonMsg;
	}
	
	@RequestMapping(value = "/propval/datagrid")
	@ResponseBody
	public Datagrid list(PropvalT param, ModelMap map,
			@RequestParam(defaultValue = " indexnum ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		if(null==param || null==param.getCorpid() || null==param.getReportid()){
			return datagrid;
		}
		List<PropvalT> list = propService.find(param, order, page, rows);
		int count = propService.count(param);
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	
	@RequestMapping(value = "/propval/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg savePropVal(@RequestBody List<PropvalT> propvlist) {
		JsonMsg json = new JsonMsg();
		if (null == propvlist || propvlist.size()<=0){
			json.setSuccess(false);
			json.setMsg("保存失败，无修改内容！");
		}
		propService.savePropvalList(propvlist);
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}
	
}
