package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.SolidMain;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface SolidMainService {

	public void addSolidMain(SolidMain solidMain);

	public SolidMain getSolidMain(String id);

	public void delSolidMain(String id);

	public List<SolidMain> find(SolidMain solidMain, String order,
			int currPage, int pageSize);

	public int count(SolidMain solidMain);

	public void update(SolidMain solidMain);

}
