package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.EnergyProduct;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface EnergyProductService {

	public void addEnergyProduct(EnergyProduct energyProduct);

	public EnergyProduct getEnergyProduct(int id);

	public void delEnergyProduct(int id);

	public List<EnergyProduct> find(EnergyProduct energyProduct, String order,
			int currPage, int pageSize);

	public int count(EnergyProduct energyProduct);

	public void update(EnergyProduct energyProduct);

}
