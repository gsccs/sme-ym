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

import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.SneedBid;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.svg.service.SneedService;

/**
 * 企业需求控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/sneed")
public class SneedController extends BaseController {

	@Autowired
	private SneedService sneedService;

	@Autowired
	private SclassService sclassService;

	@RequestMapping(method = RequestMethod.GET)
	protected String sneedList(HttpServletRequest req) {
		return "sneed/sneed-list";

	}

	@RequestMapping(value = "/bidlist", method = RequestMethod.GET)
	protected String bidlist(HttpServletRequest req) {
		return "sneed/bid-list";
	}

	// 查看
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewSneed(Long id, Model model) {
		Sneed sneedT = null;
		if (null != id) {
			sneedT = sneedService.getSneed(id);
		}
		model.addAttribute("sneedT", sneedT);
		return "sneed/sneed-view";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid sneedList(Sneed sneedT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<Sneed> list = sneedService.find(sneedT, orderstr, page, rows);
		int count = sneedService.count(sneedT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	/**
	 * 需求投标记录
	 * 
	 * @param sneedid
	 * @param page
	 * @param rows
	 * @param orderstr
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/bid/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid sneedBidList(Long sneedid,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		SneedBid sneedBidT = new SneedBid();
		if (null != sneedid) {
			sneedBidT.setSneedid(sneedid);
		}
		sneedBidT.setSvgid(getCurrUser().getOrgid());
		List<SneedBid> list = sneedService.find(sneedBidT, orderstr, page,
				rows);
		int count = sneedService.count(sneedBidT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			sneedService.delSneed(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}

	/**
	 * 参与竞标
	 * 
	 * @param sneedBidT
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bid/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg sneedbidAdd(@RequestBody SneedBid sneedBidT, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == sneedBidT) {
			msg.setSuccess(false);
			msg.setMsg("提交失败，数据有误");
			return msg;
		}
		sneedBidT.setSvgid(getCurrUser().getOrgid());
		sneedService.addBid(sneedBidT);
		
		Long sneedid = sneedBidT.getSneedid();
		Sneed sneedT = sneedService.getSneed(sneedid);
		sneedT.setStatus("1"); //正在受理
		sneedService.update(sneedT);
		msg.setSuccess(true);
		msg.setMsg("提交成功!");
		return msg;
	}
	
	
	/**
	 * 需求已办理
	 * 
	 * @param bidid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bid/isdo", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg sneedbidIsDo(Long id, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null ==id) {
			msg.setSuccess(false);
			msg.setMsg("操作失败，数据有误");
			return msg;
		}
		SneedBid sneedBid = sneedService.find(id);
		if (null == sneedBid) {
			msg.setSuccess(false);
			msg.setMsg("操作失败，数据有误");
			return msg;
		}
		sneedBid.setStatus("1");
		sneedService.updateBid(sneedBid);
		msg.setSuccess(true);
		msg.setMsg("提交成功!");
		return msg;
	}
	
	/**
	 * 参与竞标
	 * 
	 * @param sneedBidT
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bid/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg sneedbidDel(Long id, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == id) {
			msg.setSuccess(false);
			msg.setMsg("操作失败，数据有误");
			return msg;
		}
		sneedService.delSneedBid(id);
		msg.setSuccess(true);
		msg.setMsg("提交成功!");
		return msg;
	}


}
