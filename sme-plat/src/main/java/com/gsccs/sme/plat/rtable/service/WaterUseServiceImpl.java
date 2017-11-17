package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.WaterUseMapper;
import com.gsccs.sme.plat.rtable.model.WaterUse;
import com.gsccs.sme.plat.rtable.model.WaterUseExample;

@Service
public class WaterUseServiceImpl implements WaterUseService {

	@Autowired
	private WaterUseMapper waterUseMapper;

	@Override
	public WaterUse getWaterUse(Integer id) {
		return waterUseMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delWaterUse(Integer id) {
		waterUseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<WaterUse> find(WaterUse waterUse, String order, int currPage, int pageSize) {
		WaterUseExample example = new WaterUseExample();
		WaterUseExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterUse, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return waterUseMapper.selectPageByExample(example);
	}

	public void proSearchParam(WaterUse waterUse, WaterUseExample.Criteria criteria) {
		if (null != waterUse) {
			if (StringUtils.isNotEmpty(waterUse.getMainid())) {
				criteria.andMainidLike("%" + waterUse.getMainid() + "%");
			}
		}
	}

	@Override
	public int count(WaterUse waterUse) {
		WaterUseExample example = new WaterUseExample();
		WaterUseExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterUse, criteria);
		return waterUseMapper.countByExample(example);
	}

	@Override
	public void update(WaterUse waterUse) {
		waterUseMapper.updateByPrimaryKey(waterUse);
	}

	@Override
	public void addWaterUse(WaterUse waterUse) {
		if (null != waterUse)
			waterUseMapper.insert(waterUse);
	}
}