package com.gsccs.sme.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.ProductServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 产品控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class ProductController {
	@Autowired
	private ProductServiceI productAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 产品列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "product.html", method = RequestMethod.GET)
	public String productList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, String keyword,
			String cateid,String pcode,String ccode,String acode,
			Long corpid,Model model, HttpServletRequest request,
			HttpServletResponse response) {

		String tempPath = "productlist";
		try {
			model.addAttribute("cateid", cateid);
			model.addAttribute("corpid", corpid);
			model.addAttribute("pcode", pcode);
			model.addAttribute("ccode", ccode);
			model.addAttribute("acode", acode);
			model.addAttribute("keyword", keyword);
			model.addAttribute("page", page);
			model.addAttribute("pagesize", pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempPath;
	}

	/**
	 * 产品详情页
	 * 
	 * @param id
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/product-{id}.html", method = RequestMethod.GET)
	public String productDetail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		try {
			Product product = productAPI.getProduct(id);
			if (null != product && null != product.getCorpid()) {
				Corp corp = corpAPI.getCorp(product.getCorpid());
				if (null != corp) {
					model.addAttribute("corp", corp);
				}
			}
			model.addAttribute("currProduct", product);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "product";
	}

}
