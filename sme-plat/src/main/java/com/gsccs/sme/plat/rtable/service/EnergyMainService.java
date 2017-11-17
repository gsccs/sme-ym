package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.EnergyMain;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface EnergyMainService {

	public void addEnergyMain(EnergyMain energyMain);

	public EnergyMain getEnergyMain(String id);

	public void delEnergyMain(String id);

	public List<EnergyMain> find(EnergyMain energyMain, String order,
			int currPage, int pageSize);

	public int count(EnergyMain energyMain);

	public void update(EnergyMain energyMain);

}
