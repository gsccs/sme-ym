package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.plat.svg.model.IndustryT;

public interface IndustryService {

	public void insert(IndustryT IndustryT);

	public void update(IndustryT IndustryT);
	
	public void delete(Long id);

	public IndustryT findById(Long id);

	public List<IndustryT> findSubIndustry(Long parid);

	/**
	 * 分页查询
	 */
	public List<IndustryT> find(IndustryT IndustryT, String order, int currPage,
			int pageSize);

	public int count(IndustryT IndustryT);
	
	public JSONArray findTree();
}
