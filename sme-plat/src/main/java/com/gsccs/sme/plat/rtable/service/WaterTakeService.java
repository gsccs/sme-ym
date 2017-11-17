package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.WaterTake;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface WaterTakeService {

	public void addWaterTake(WaterTake waterTake);

	public WaterTake getWaterTake(Integer id);

	public void delWaterTake(Integer id);

	public List<WaterTake> find(WaterTake waterTake, String order,
			int currPage, int pageSize);

	public int count(WaterTake waterTake);

	public void update(WaterTake waterTake);

}
