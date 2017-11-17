package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.WaterMainMapper;
import com.gsccs.sme.plat.rtable.model.WaterMain;
import com.gsccs.sme.plat.rtable.model.WaterMainExample;

@Service
public class WaterMainServiceImpl implements WaterMainService {

	@Autowired
	private WaterMainMapper waterMainMapper;

	@Override
	public WaterMain getWaterMain(String id) {
		return waterMainMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delWaterMain(String id) {
		waterMainMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<WaterMain> find(WaterMain waterMain, String order, int currPage, int pageSize) {
		WaterMainExample example = new WaterMainExample();
		WaterMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterMain, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return waterMainMapper.selectPageByExample(example);
	}

	public void proSearchParam(WaterMain waterMain, WaterMainExample.Criteria criteria) {
		if (null != waterMain) {
			if (null != waterMain.getCorpid()) {
				criteria.andCorpidEqualTo(waterMain.getCorpid());
			}
		}
	}

	@Override
	public int count(WaterMain waterMain) {
		WaterMainExample example = new WaterMainExample();
		WaterMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterMain, criteria);
		return waterMainMapper.countByExample(example);
	}

	@Override
	public void update(WaterMain waterMain) {
		waterMainMapper.updateByPrimaryKey(waterMain);
	}

	@Override
	public void addWaterMain(WaterMain waterMain) {
		if (null != waterMain)
			waterMainMapper.insert(waterMain);
	}
}