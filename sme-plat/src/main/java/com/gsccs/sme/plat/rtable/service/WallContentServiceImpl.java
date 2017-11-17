package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.WallContentMapper;
import com.gsccs.sme.plat.rtable.model.WallContent;
import com.gsccs.sme.plat.rtable.model.WallContentExample;

@Service
public class WallContentServiceImpl implements WallContentService {

	@Autowired
	private WallContentMapper wallContentMapper;

	@Override
	public WallContent getWallContent(Integer id) {
		return wallContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delWallContent(Integer id) {
		wallContentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<WallContent> find(WallContent wallContent, String order, int currPage, int pageSize) {
		WallContentExample example = new WallContentExample();
		WallContentExample.Criteria criteria = example.createCriteria();
		proSearchParam(wallContent, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return wallContentMapper.selectPageByExample(example);
	}

	public void proSearchParam(WallContent wallContent, WallContentExample.Criteria criteria) {
		if (null != wallContent) {
			if (StringUtils.isNotEmpty(wallContent.getMainid())) {
				criteria.andMainidLike("%" + wallContent.getMainid() + "%");
			}
		}
	}

	@Override
	public int count(WallContent wallContent) {
		WallContentExample example = new WallContentExample();
		WallContentExample.Criteria criteria = example.createCriteria();
		proSearchParam(wallContent, criteria);
		return wallContentMapper.countByExample(example);
	}

	@Override
	public void update(WallContent wallContent) {
		wallContentMapper.updateByPrimaryKey(wallContent);
	}

	@Override
	public void addWallContent(WallContent wallContent) {
		if (null != wallContent)
			wallContentMapper.insert(wallContent);
	}
}