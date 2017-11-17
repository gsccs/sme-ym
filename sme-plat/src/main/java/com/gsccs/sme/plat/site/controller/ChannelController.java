package com.gsccs.sme.plat.site.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.base.CtreeGrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.site.model.ChanelT;
import com.gsccs.sme.plat.site.service.ChannelService;

/**
 * 信息分类控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@RequestMapping(method = RequestMethod.GET)
	protected String channelList(HttpServletRequest req) {
		return "site/channel-list";

	}
	
	@RequestMapping(value = "/treegrid", method = RequestMethod.POST)
	@ResponseBody
	public List<CtreeGrid> channelList(
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			HttpServletRequest request) {
		List<ChanelT> resourceList = channelService.find(null);
		List<CtreeGrid> tgList = new ArrayList<CtreeGrid>();
		for (ChanelT tg : resourceList) {
			CtreeGrid ctg = new CtreeGrid();
			ctg.setId(tg.getId().toString());
			ctg.setParentId(tg.getParid().toString());
			ctg.setText(tg.getTitle());
			ctg.setIconCls("icon-file");
			ctg.setUrl(tg.getUrl());
			tgList.add(ctg);
		}
		return tgList;
	}
	
	// 新增
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Long id,Long parid,Model model) {
		ChanelT channelT = null;
		if (null != id) {
			channelT = channelService.findById(id);
		}else{
			channelT = new ChanelT();
			channelT.setParid(parid);
		}
		model.addAttribute("channel", channelT);
		return "site/channel-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(@RequestBody ChanelT channelT) {
		JsonMsg msg = new JsonMsg();
		if (null == channelT) {
			msg.setSuccess(false);
			msg.setMsg("添加失败!");
			return msg;
		}
		if(null==channelT.getParid()){
			channelT.setParid(0l);
		}
		channelService.insert(channelT);
		msg.setSuccess(true);
		msg.setMsg("添加成功!");
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody ChanelT channelT) {
		JsonMsg msg = new JsonMsg();
		if (null == channelT) {
			msg.setSuccess(false);
			msg.setMsg("修改失败!");
			return msg;
		} 
		if(null==channelT.getParid()){
			channelT.setParid(0l);
		}
		channelService.update(channelT);
		msg.setSuccess(true);
		msg.setMsg("修改成功!");
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			channelService.delChannel(id);
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
	public List<ChanelT> listData(Long pid, Model model,
			HttpServletResponse response) {
		List<ChanelT> channList = null;
		if (null == pid) {
			channList = channelService.find(null);
		} else {
			channList = channelService.findSubChannel(pid);
		}
		return channList;
	}

	@RequestMapping(value = "/tree", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray tree(Model model) {
		return channelService.findChannelTree();
	}

}
