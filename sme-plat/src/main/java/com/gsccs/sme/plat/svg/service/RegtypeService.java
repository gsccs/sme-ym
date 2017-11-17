package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.plat.svg.model.RegTypeT;

public interface RegtypeService {

	public void insert(RegTypeT regtype);

	public void update(RegTypeT regtype);

	public void delChannel(Long id);

	public RegTypeT findById(Long id);

	public List<RegTypeT> find(RegTypeT regtype, String orderstr, int page,
			int pagesize);

	public List<RegTypeT> find(RegTypeT regtype);

	public List<RegTypeT> findSubChannel(Long parid);

	public int count(RegTypeT regtype);

	public List<RegTypeT> findByParids(String string);
	
	public JSONArray findChannelTree();
}
