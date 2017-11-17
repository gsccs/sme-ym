package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.Porder;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.PorderServiceI;
import com.gsccs.sme.api.service.ProductServiceI;

/**
 * 产品订单管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="PorderCtl")
@RequestMapping(value = "/cp/porder")
public class PorderController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ProductServiceI productAPI;
	@Autowired
	private PorderServiceI porderAPI;

	/**
	 * 订单列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String orderlist(Model model, HttpServletResponse response) {
		return "order/porder-list";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public Datagrid datagrid(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			Account user = accountAPI.getAccount(username);
			Porder porder = new Porder();
			porder.setSellerid(user.getOrgid());
			List<Porder> sorders = porderAPI.getOrderList(porder, "", page,
					pagesize);
			int count = porderAPI.getOrderCount(porder);
			datagrid.setRows(sorders);
			datagrid.setTotal(Long.valueOf(count));
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 创建订单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg add(Long productid, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null == productid) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("产品不存在已不存在");
				return jsonMsg;
			}

			Product product = productAPI.getProduct(productid);
			if (null != product) {
				Account user = accountAPI.getAccount(username);
				Porder porder = new Porder();
				porder.setProductid(productid);
				porder.setSellerid(product.getCorpid());
				porder.setBuyerid(user.getOrgid());
				porderAPI.createOrder(porder);

				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("订单创建成功。");
			} else {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("产品不存在!");
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("订单创建失败。");
		}
		return jsonMsg;
	}

	/**
	 * 删除订单
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delOrder(String id, Model model, HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			porderAPI.orderdelete(id);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return jsonMsg;
	}

}
