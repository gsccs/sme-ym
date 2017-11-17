package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.shop.Category;
import com.gsccs.sme.api.service.CategoryServiceI;
import com.gsccs.sme.plat.shop.model.CategoryT;
import com.gsccs.sme.plat.shop.service.CategoryService;

/**
 * 产品类目服务接口
 * 
 * @author x.d zhang
 * 
 */
public class CategoryServiceAPI implements CategoryServiceI {

	@Autowired
	private CategoryService categoryService;

	@Override
	public Category getCategory(Long cateid) {
		CategoryT sclassT = categoryService.findById(cateid);
		if (null != sclassT) {
			Category c = new Category();
			try {
				BeanUtils.copyProperties(c, sclassT);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return c;
		}
		return null;
	}

	@Override
	public List<Category> getRootCategory() {
		List<Category> result = null;
		List<CategoryT> list = categoryService.find(null);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Category>();
			Category cate;
			for (CategoryT t : list) {
				cate = new Category();
				try {
					BeanUtils.copyProperties(cate, t);
					result.add(cate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<Category> getSubCategory(Long cateid) {
		List<Category> result = null;
		List<CategoryT> list = categoryService.findSubCategory(cateid);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Category>();
			Category cate;
			for (CategoryT t : list) {
				cate = new Category();
				try {
					BeanUtils.copyProperties(cate, t);
					result.add(cate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public JSONArray getCategoryTree() {
		return categoryService.findCategoryTree();
	}

}
