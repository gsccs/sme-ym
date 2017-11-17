package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.corp.Consult;

public interface ConsultService {

	public void insert(Consult sitemT);

	public void update(Consult sitemT);

	public Consult findById(Long id);
	
	public void delete(Long id);

	/**
	 * 分页查询
	 */
	public List<Consult> find(Consult param, String order, int currPage,
			int pageSize);
	
	public List<Consult> findByParId(Long parid);
	public int count(Consult param);

	/**
	 * 分页查询
	 */
	public Datagrid datagrid(Consult consiltT, String order, int currPage,
			int pageSize);
	
	/**
	 * 分页查询
	 */
	public List<Consult> findReplyByCorpid(Long corpid, String order, int currPage,
			int pageSize);

	
}
