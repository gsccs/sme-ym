package com.gsccs.sme.plat.svg.controller;

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

import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.service.ConsultService;
import com.gsccs.sme.plat.svg.service.SclassService;

/**
 * 咨询信息控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/consult")
public class ConsultController extends BaseController{

	@Autowired
	private ConsultService consultService;
	@Autowired
	private SclassService sclassService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	protected String consultList(HttpServletRequest req) {
		return "consult/consult-list";
	}

	
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid consultList(Consult consult,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "addtime desc") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		consult.setSvgid(getCurrUser().getOrgid());
		List<Consult> list = consultService.find(consult, orderstr, page,
				rows);
		int count = consultService.count(consult);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	
	@RequestMapping(value = "/replyList", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid replyList(Long parid,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "addtime desc") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		Consult consult = new Consult();
		consult.setSvgid(getCurrUser().getOrgid());
		consult.setParid(parid);
		List<Consult> list = consultService.find(consult, orderstr, page,
				rows);
		int count = consultService.count(consult);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	/**
	 * 咨询内容回复
	 * 
	 * @param model
	 * @param consultT
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String create(Long id, Model model) {
		Consult consult = consultService.findById(id);
		model.addAttribute("consult", consult);
		return "consult/consult-form";
	}
	
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg replay(@RequestBody Consult reply, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == reply || null == reply.getParid()) {
			msg.setSuccess(false);
			msg.setMsg("回复失败！");
			return msg;
		}
		try{
			reply.setSvgid(getCurrUser().getOrgid());
			consultService.insert(reply);
			Long consultid = reply.getParid();
			//更新咨询状态
			Consult consult = new Consult();
			consult.setId(consultid);
			consult.setStatus("1");
			consult.setIsshow(reply.getIsshow());
			consultService.update(consult);
			msg.setSuccess(true);
			msg.setMsg("回复成功！");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("回复失败！");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			consultService.delete(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}
}
