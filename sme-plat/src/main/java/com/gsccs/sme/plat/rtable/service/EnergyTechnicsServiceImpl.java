package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.EnergyTechnicsMapper;
import com.gsccs.sme.plat.rtable.model.EnergyTechnics;
import com.gsccs.sme.plat.rtable.model.EnergyTechnicsExample;

@Service
public class EnergyTechnicsServiceImpl implements EnergyTechnicsService {

	@Autowired
	private EnergyTechnicsMapper energyTechnicsMapper;

	@Override
	public EnergyTechnics getEnergyTechnics(int id) {
		return energyTechnicsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delEnergyTechnics(int id) {
		energyTechnicsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<EnergyTechnics> find(EnergyTechnics energyTechnics, String order, int currPage, int pageSize) {
		EnergyTechnicsExample example = new EnergyTechnicsExample();
		EnergyTechnicsExample.Criteria criteria = example.createCriteria();
		proSearchParam(energyTechnics, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return energyTechnicsMapper.selectPageByExample(example);
	}

	public void proSearchParam(EnergyTechnics energyTechnics, EnergyTechnicsExample.Criteria criteria) {
		if (null != energyTechnics) {
			if (StringUtils.isNotEmpty(energyTechnics.getName())) {
				criteria.andNameLike("%" + energyTechnics.getName() + "%");
			}
			if (StringUtils.isNotEmpty(energyTechnics.getMainId())) {
				criteria.andMainIdLike("%" + energyTechnics.getMainId() + "%");
			}
		}
	}

	@Override
	public int count(EnergyTechnics energyTechnics) {
		EnergyTechnicsExample example = new EnergyTechnicsExample();
		EnergyTechnicsExample.Criteria criteria = example.createCriteria();
		proSearchParam(energyTechnics, criteria);
		return energyTechnicsMapper.countByExample(example);
	}

	@Override
	public void update(EnergyTechnics energyTechnics) {
		energyTechnicsMapper.updateByPrimaryKey(energyTechnics);
	}

	@Override
	public void addEnergyTechnics(EnergyTechnics energyTechnics) {
		if (null != energyTechnics)
			energyTechnicsMapper.insert(energyTechnics);
	}
}