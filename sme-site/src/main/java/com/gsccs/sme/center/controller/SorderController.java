package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SorderServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 服务订单管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="SorderCtl")
@RequestMapping("/cp/sorder")
public class SorderController {

	@Autowired
	private SvorgServiceI svorgAPI;
	@Autowired
	private SitemServiceI sitemAPI;
	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private SorderServiceI sorderAPI;

	/**
	 * 服务订单列表
	 * 
	 * @param model
	 * @param response
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String sorderList(String state, Model model,
			HttpServletResponse response) {
		return "order/sorder-list";
	}

	/**
	 * 创建订单
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg add(Long sitemid, Model model) {
		JsonMsg jsonmsg = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			if (null == sitemid) {
				jsonmsg.setCode("noitem");
				jsonmsg.setSuccess(false);
				jsonmsg.setMsg("服务项目不存在!");
				return jsonmsg;
			}
			Account user = accountAPI.getAccount(username);
			if (null == user) {
				jsonmsg.setCode("nolog");
				jsonmsg.setSuccess(false);
				jsonmsg.setMsg("用户未登录!");
				return jsonmsg;
			}
			Sitem sitem = sitemAPI.getSitem(sitemid);
			if (null == sitem) {
				jsonmsg.setCode("noitem");
				jsonmsg.setSuccess(false);
				jsonmsg.setMsg("服务项目不存在!");
				return jsonmsg;
			}

			Sorder sorder = new Sorder();
			sorder.setSitemid(sitemid);
			sorder.setSvgid(sitem.getSvgid());
			sorder.setCorpid(user.getOrgid());
			sorder.setTotalnum(1);
			sorder.setTotalfee(sitem.getPrice());
			sorderAPI.createSorder(sorder);
			jsonmsg.setSuccess(true);
			jsonmsg.setCode("ok");
			jsonmsg.setMsg("未知错误");
		} catch (Exception e) {
			jsonmsg.setSuccess(false);
			jsonmsg.setMsg("未知错误");
			e.printStackTrace();
		}
		return jsonmsg;
	}

	/**
	 * 订单详情页面
	 * 
	 * @param orderid
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String orderDetail(String orderid, Model model,
			HttpServletResponse response) {
		try {
			Sorder order = sorderAPI.getSorder(orderid);
			Sitem sitem = null;
			Svorg svorg = null;
			if (null != order) {
				sitem = sitemAPI.getSitem(order.getSitemid());
				svorg = svorgAPI.getSvg(order.getSvgid());
			}
			model.addAttribute("order", order);
			model.addAttribute("sitem", sitem);
			model.addAttribute("svorg", svorg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/sorder-detail";
	}

	/**
	 * 订单评价页面
	 * 
	 * @param orderid
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/eval", method = RequestMethod.GET)
	public String orderEval(String orderid, Model model,
			HttpServletResponse response) {
		try {
			Sorder order = sorderAPI.getSorder(orderid);
			Sitem sitem = null;
			Svorg svorg = null;
			if (null != order) {
				sitem = sitemAPI.getSitem(order.getSitemid());
				svorg = svorgAPI.getSvg(order.getSvgid());
			}
			model.addAttribute("order", order);
			model.addAttribute("sitem", sitem);
			model.addAttribute("svorg", svorg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/sorder-eval";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/eval", method = RequestMethod.POST)
	public JsonMsg orderEval(String orderid,Integer score,String eval, Model model) {
		JsonMsg jsonmsg = new JsonMsg();
		try {
			Sorder order = sorderAPI.getSorder(orderid);
			if(null != order){
				sorderAPI.orderEvaled(order.getCorpid(), orderid, score, eval);
			}
			jsonmsg.setSuccess(true);
			jsonmsg.setMsg("订单评价成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonmsg;
	}

	/**
	 * 分页查询订单列表
	 * 
	 * @param page
	 * @param pagesize
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public JSONObject datagrid(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, String state,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject json = new JSONObject();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = accountAPI.getAccount(username);
			Sorder param = new Sorder();
			List<Sorder> orderlist = sorderAPI.getCorpSorderList(
					user.getOrgid(), param, "addtime desc", page, pagesize);
			int total = sorderAPI.getCorpSorderCount(user.getOrgid(), param);
			json.put("orderlist", orderlist);
			json.put("total", total);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 订单取消
	 * 
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg orderCancel(String orderid, Model model,
			HttpServletResponse response, HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			Account user = accountAPI.getAccount(username);
			if (StringUtils.isEmpty(orderid)) {
				json.setSuccess(false);
				json.setMsg("订单取消失败，订单不存在。");
				return json;
			}
			sorderAPI.orderCancel(user.getOrgid(), orderid);
			json.setSuccess(true);
			json.setMsg("订单取消成功！");
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg("订单取消失败，未知错误");
		}
		return json;
	}

}
