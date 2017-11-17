package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.WaterMain;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface WaterMainService {

	public void addWaterMain(WaterMain waterMain);

	public WaterMain getWaterMain(String id);

	public void delWaterMain(String id);

	public List<WaterMain> find(WaterMain waterMain, String order,
			int currPage, int pageSize);

	public int count(WaterMain waterMain);

	public void update(WaterMain waterMain);

}
