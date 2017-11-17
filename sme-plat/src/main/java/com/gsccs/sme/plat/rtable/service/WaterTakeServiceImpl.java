package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.WaterTakeMapper;
import com.gsccs.sme.plat.rtable.model.WaterTake;
import com.gsccs.sme.plat.rtable.model.WaterTakeExample;

@Service
public class WaterTakeServiceImpl implements WaterTakeService {

	@Autowired
	private WaterTakeMapper waterTakeMapper;

	@Override
	public WaterTake getWaterTake(Integer id) {
		return waterTakeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delWaterTake(Integer id) {
		waterTakeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<WaterTake> find(WaterTake waterTake, String order, int currPage, int pageSize) {
		WaterTakeExample example = new WaterTakeExample();
		WaterTakeExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterTake, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return waterTakeMapper.selectPageByExample(example);
	}

	public void proSearchParam(WaterTake waterTake, WaterTakeExample.Criteria criteria) {
		if (null != waterTake) {
			if (StringUtils.isNotEmpty(waterTake.getMainid())) {
				criteria.andMainidLike("%" + waterTake.getMainid() + "%");
			}
		}
	}

	@Override
	public int count(WaterTake waterTake) {
		WaterTakeExample example = new WaterTakeExample();
		WaterTakeExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterTake, criteria);
		return waterTakeMapper.countByExample(example);
	}

	@Override
	public void update(WaterTake waterTake) {
		waterTakeMapper.updateByPrimaryKey(waterTake);
	}

	@Override
	public void addWaterTake(WaterTake waterTake) {
		if (null != waterTake)
			waterTakeMapper.insert(waterTake);
	}
}