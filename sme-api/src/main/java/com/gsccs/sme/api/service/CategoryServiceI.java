package com.gsccs.sme.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.shop.Category;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 类目API 提供了标准类目
 * 
 * @author x.d zhang
 * 
 */
public interface CategoryServiceI {

	/**
	 * 获取根类目
	 * 
	 * @return
	 */
	public List<Category> getRootCategory();

	/**
	 * 获取站点根类目
	 * 
	 * @param cateid
	 *            父级分类ID
	 * @return
	 */
	public List<Category> getSubCategory(Long cateid);

	/**
	 * 获取类目详情
	 * 
	 * @param cateId
	 * @return
	 */
	public Category getCategory(Long cateid);
	
	
	public JSONArray getCategoryTree();

}
