package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.EnergyProductMapper;
import com.gsccs.sme.plat.rtable.model.EnergyProduct;
import com.gsccs.sme.plat.rtable.model.EnergyProductExample;

@Service
public class EnergyProductServiceImpl implements EnergyProductService {

	@Autowired
	private EnergyProductMapper energyProductMapper;

	@Override
	public EnergyProduct getEnergyProduct(int id) {
		return energyProductMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delEnergyProduct(int id) {
		energyProductMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<EnergyProduct> find(EnergyProduct energyProduct, String order, int currPage, int pageSize) {
		EnergyProductExample example = new EnergyProductExample();
		EnergyProductExample.Criteria criteria = example.createCriteria();
		proSearchParam(energyProduct, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return energyProductMapper.selectPageByExample(example);
	}

	public void proSearchParam(EnergyProduct energyProduct, EnergyProductExample.Criteria criteria) {
		if (null != energyProduct) {
			if (StringUtils.isNotEmpty(energyProduct.getProduct())) {
				criteria.andProductLike("%" + energyProduct.getProduct() + "%");
			}
			if (StringUtils.isNotEmpty(energyProduct.getMainId())) {
				criteria.andMainIdLike("%" + energyProduct.getMainId() + "%");
			}
		}
	}

	@Override
	public int count(EnergyProduct energyProduct) {
		EnergyProductExample example = new EnergyProductExample();
		EnergyProductExample.Criteria criteria = example.createCriteria();
		proSearchParam(energyProduct, criteria);
		return energyProductMapper.countByExample(example);
	}

	@Override
	public void update(EnergyProduct energyProduct) {
		energyProductMapper.updateByPrimaryKey(energyProduct);
	}

	@Override
	public void addEnergyProduct(EnergyProduct energyProduct) {
		if (null != energyProduct)
			energyProductMapper.insert(energyProduct);
	}
}