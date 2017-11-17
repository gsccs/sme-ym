package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.plat.svg.model.SorderT;

public interface SorderService {

	public void insert(SorderT sorderT);

	public void update(SorderT sorderT);
	
	public void delSitem(String id);

	public SorderT findById(String id);

	public List<SorderT> find(SorderT sorderT);

	/**
	 * 分页查询
	 */
	public List<SorderT> find(SorderT sorderT, String order, int currPage,
			int pageSize);

	public int count(SorderT sorderT);
}
