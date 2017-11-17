package com.gsccs.sme.plat.shop.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.plat.shop.model.CategoryT;

public interface CategoryService {

	public void insert(CategoryT categoryT);

	public void update(CategoryT categoryT);

	public void delSclass(Long id);

	public CategoryT findById(Long id);

	public List<CategoryT> find(CategoryT categoryT, String orderstr, int page,
			int pagesize);

	public List<CategoryT> find(CategoryT categoryT);

	public List<CategoryT> findSubCategory(Long parid);

	public int count(CategoryT categoryT);

	public List<CategoryT> findByParids(String string);
	
	public JSONArray findCategoryTree();
}
