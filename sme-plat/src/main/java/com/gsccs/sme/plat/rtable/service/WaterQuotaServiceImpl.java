package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.WaterQuotaMapper;
import com.gsccs.sme.plat.rtable.model.WaterQuota;
import com.gsccs.sme.plat.rtable.model.WaterQuotaExample;

@Service
public class WaterQuotaServiceImpl implements WaterQuotaService {

	@Autowired
	private WaterQuotaMapper waterQuotaMapper;

	@Override
	public WaterQuota getWaterQuota(Integer id) {
		return waterQuotaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delWaterQuota(Integer id) {
		waterQuotaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<WaterQuota> find(WaterQuota waterQuota, String order, int currPage, int pageSize) {
		WaterQuotaExample example = new WaterQuotaExample();
		WaterQuotaExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterQuota, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return waterQuotaMapper.selectPageByExample(example);
	}

	public void proSearchParam(WaterQuota waterQuota, WaterQuotaExample.Criteria criteria) {
		if (null != waterQuota) {
			if (StringUtils.isNotEmpty(waterQuota.getMainid())) {
				criteria.andMainidLike("%" + waterQuota.getMainid() + "%");
			}
		}
	}

	@Override
	public int count(WaterQuota waterQuota) {
		WaterQuotaExample example = new WaterQuotaExample();
		WaterQuotaExample.Criteria criteria = example.createCriteria();
		proSearchParam(waterQuota, criteria);
		return waterQuotaMapper.countByExample(example);
	}

	@Override
	public void update(WaterQuota waterQuota) {
		waterQuotaMapper.updateByPrimaryKey(waterQuota);
	}

	@Override
	public void addWaterQuota(WaterQuota waterQuota) {
		if (null != waterQuota)
			waterQuotaMapper.insert(waterQuota);
	}
}