package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.api.domain.StatistGovNum;
import com.gsccs.sme.plat.svg.model.SevalT;
import com.gsccs.sme.plat.svg.model.SitemT;

public interface SitemService {

	public void insert(SitemT sitemT);

	public void update(SitemT sitemT);

	public void delSitem(Long id);

	public SitemT findById(Long id);

	/**
	 * 分页查询
	 */
	public List<SitemT> find(SitemT sitemT, String order, int currPage,
			int pageSize);

	public int count(SitemT sitemT);

	public List<SitemT> findByExample(SitemT sitemT, String orderstr, int page,
			int rows);

	public void insert(SevalT sevalT);

	public void update(SevalT sevalT);

	public void delSitem(String id);

	public SevalT findById(String id);

	public List<SevalT> find(SevalT sevalT, String order, int currPage,
			int pageSize);
	
	public int count(SevalT sevalT);

}
