package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.shop.Category;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CategoryServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.ProductServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 企业产品管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="ProductCtl")
@RequestMapping(value = "/cp/product")
public class ProductController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ProductServiceI productAPI;
	@Autowired
	private CategoryServiceI categoryAPI;

	/**
	 * 产品列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String productList(Model model, HttpServletResponse response) {
		
		return "product/product-list";
	}
	
	/**
	 * 产品表单页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String productForm(Long id,Model model, HttpServletResponse response) {
		Product product = null;
		
		List<Category> categorieList = categoryAPI.getRootCategory();
		if (null!=id){
			try {
				product = productAPI.getProduct(id);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("product",product);
		model.addAttribute("categoryList",categorieList);
		return "product/product-form";
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
			Product product = new Product();
			Account user = accountAPI.getAccount(username);
			if (null != user) {
				product.setCorpid(user.getOrgid());
			}
			List<Product> products = productAPI.queryProductList(product,
					"addtime desc", page, pagesize);
			int count = productAPI.count(product);
			datagrid.setRows(products);
			datagrid.setTotal(Long.valueOf(count));
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	
	/**
	 * 保存产品信息
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg save(Product product, Model model,
			HttpServletResponse response) {
		JsonMsg json = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		if (null == product) {
			json.setSuccess(false);
			json.setMsg("产品发布失败，对象不存在");
			return json;
		}
		try {
			Account user = accountAPI.getAccount(username);
			product.setCorpid(user.getOrgid());
			if (null == product.getId()) {
				// 新增
				productAPI.addProduct(product);
				json.setSuccess(true);
				json.setMsg("产品发布成功");
			} else {
				// 修改
				productAPI.updateProduct(product);
				json.setSuccess(true);
				json.setMsg("产品更新成功");
			}
		} catch (ApiException e) {
			json.setSuccess(false);
			json.setMsg("产品发布失败!");
		}
		return json;
	}

	/**
	 * 删除商品
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(Long id, Model model, HttpServletResponse response) {
		JsonMsg json = new JsonMsg();
		try {
			productAPI.delProduct(id);
			json.setSuccess(true);
			json.setMsg("产品删除成功");
		} catch (ApiException e) {
			json.setSuccess(true);
			json.setMsg("产品删除成功");
		}
		return json;
	}

}
