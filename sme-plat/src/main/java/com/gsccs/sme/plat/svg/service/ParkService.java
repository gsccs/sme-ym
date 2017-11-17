package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.plat.svg.model.ParkT;

public interface ParkService {

	public void insert(ParkT parkT);

	public void update(ParkT parkT);

	public void delete(Long id);

	public ParkT findById(Long id);

	/**
	 * 分页查询
	 */
	public List<ParkT> find(ParkT parkT, String order, int currPage,
			int pageSize);

	public int count(ParkT parkT);

}
