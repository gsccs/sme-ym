package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.EnergyMainMapper;
import com.gsccs.sme.plat.rtable.model.EnergyMain;
import com.gsccs.sme.plat.rtable.model.EnergyMainExample;

@Service
public class EnergyMainServiceImpl implements EnergyMainService {

	@Autowired
	private EnergyMainMapper energyMainMapper;

	@Override
	public EnergyMain getEnergyMain(String id) {
		return energyMainMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delEnergyMain(String id) {
		energyMainMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<EnergyMain> find(EnergyMain energyMain, String order, int currPage, int pageSize) {
		EnergyMainExample example = new EnergyMainExample();
		EnergyMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(energyMain, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return energyMainMapper.selectPageByExample(example);
	}

	public void proSearchParam(EnergyMain energyMain, EnergyMainExample.Criteria criteria) {
		if (null != energyMain) {
			if (null != energyMain.getCorpid()) {
				criteria.andCorpidEqualTo(energyMain.getCorpid());
			}
		}
	}

	@Override
	public int count(EnergyMain energyMain) {
		EnergyMainExample example = new EnergyMainExample();
		EnergyMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(energyMain, criteria);
		return energyMainMapper.countByExample(example);
	}

	@Override
	public void update(EnergyMain energyMain) {
		energyMainMapper.updateByPrimaryKey(energyMain);
	}

	@Override
	public void addEnergyMain(EnergyMain energyMain) {
		if (null != energyMain)
			energyMainMapper.insert(energyMain);
	}
}