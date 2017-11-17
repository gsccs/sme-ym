package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.WaterUse;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface WaterUseService {

	public void addWaterUse(WaterUse waterUse);

	public WaterUse getWaterUse(Integer id);

	public void delWaterUse(Integer id);

	public List<WaterUse> find(WaterUse waterUse, String order,
			int currPage, int pageSize);

	public int count(WaterUse waterUse);

	public void update(WaterUse waterUse);

}
