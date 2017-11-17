package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.EnergyTechnics;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface EnergyTechnicsService {

	public void addEnergyTechnics(EnergyTechnics energyTechnics);

	public EnergyTechnics getEnergyTechnics(int id);

	public void delEnergyTechnics(int id);

	public List<EnergyTechnics> find(EnergyTechnics energyTechnics, String order,
			int currPage, int pageSize);

	public int count(EnergyTechnics energyTechnics);

	public void update(EnergyTechnics energyTechnics);

}
