package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.plat.svg.model.ExpertT;

public interface ExpertService {

	public Long insert(ExpertT expertT);

	public void update(ExpertT expertT);

	public void delSitem(String id);

	public ExpertT findById(String id);

	public List<ExpertT> find(ExpertT expertT);

	/**
	 * 分页查询
	 */
	public List<ExpertT> find(ExpertT expertT, String order, int currPage,
			int pageSize);

	public int count(ExpertT expertT);
}
