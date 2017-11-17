package com.gsccs.sme.plat.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.shop.model.ProductT;
import com.gsccs.sme.plat.shop.service.ProductService;

/**
 * 平台产品管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "shop/product_list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			ProductT param, HttpServletRequest request) {
		List<ProductT> prodList = productService.find(param, order, page, rows);
		int totalCount = productService.count(param);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(prodList);
		datagrid.setTotal(Long.valueOf(totalCount));
		return datagrid;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String showForm(Long id, Model model) {
		ProductT productT = null;
		if (null!=id){
			productT = productService.getProduct(id);
		}
		model.addAttribute("product", productT);
		return "shop/product_view";
	}
	
}
