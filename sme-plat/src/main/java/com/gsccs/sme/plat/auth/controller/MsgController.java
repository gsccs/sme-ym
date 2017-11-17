package com.gsccs.sme.plat.auth.controller;

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

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.plat.auth.model.MsgT;
import com.gsccs.sme.plat.auth.service.MsgService;
import com.gsccs.sme.plat.bass.BaseController;

/**
 * 平台通知
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/msg")
public class MsgController extends BaseController {

	@Autowired
	private MsgService msgService;

	@RequestMapping(method = RequestMethod.GET)
	public String sendlist(Model model) {
		return "auth/msg-list";
	}

	/**
	 * 发送的消息
	 * 
	 * @param param
	 * @param order
	 * @param page
	 * @param rows
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/senddg", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid sendList(MsgT param,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		param.setSender(getCurrUser().getOrgid());
		List<MsgT> msgList = msgService.find(param, order, page, rows);
		int count = msgService.count(param);
		datagrid.setRows(msgList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 接受的消息
	 * 
	 * @param param
	 * @param order
	 * @param page
	 * @param rows
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/recedg", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid msgList(MsgT param,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		param.setReceiver(getCurrUser().getOrgid());
		List<MsgT> msgList = msgService.find(param, order, page, rows);
		int count = msgService.count(param);
		datagrid.setRows(msgList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showForm(String id, Model model) {
		MsgT msg = null;
		if (StringUtils.isNotEmpty(id)) {
			msg = msgService.findById(id);
		}
		model.addAttribute("msg", msg);
		return "auth/msg-form";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(MsgT msg) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == msg) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		msgService.createMsg(msg);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(MsgT param) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == param || StringUtils.isEmpty(param.getId())) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("更新失败");
		}
		msgService.updateMsg(param);
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("更新操作成功");
		return jsonMsg;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(String id) {
		JsonMsg jsonMsg = new JsonMsg();
		msgService.deleteMsg(id);
		jsonMsg.setSuccess(true);
		jsonMsg.setMsg("删除成功");
		return jsonMsg;
	}

}
