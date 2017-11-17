package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.WaterQuota;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface WaterQuotaService {

	public void addWaterQuota(WaterQuota waterQuota);

	public WaterQuota getWaterQuota(Integer id);

	public void delWaterQuota(Integer id);

	public List<WaterQuota> find(WaterQuota waterQuota, String order,
			int currPage, int pageSize);

	public int count(WaterQuota waterQuota);

	public void update(WaterQuota waterQuota);

}
