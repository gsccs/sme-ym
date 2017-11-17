package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.WallMainMapper;
import com.gsccs.sme.plat.rtable.model.WallMain;
import com.gsccs.sme.plat.rtable.model.WallMainExample;

@Service
public class WallMainServiceImpl implements WallMainService {

	@Autowired
	private WallMainMapper wallMainMapper;

	@Override
	public WallMain getWallMain(String id) {
		return wallMainMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delWallMain(String id) {
		wallMainMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<WallMain> find(WallMain wallMain, String order, int currPage, int pageSize) {
		WallMainExample example = new WallMainExample();
		WallMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(wallMain, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return wallMainMapper.selectPageByExample(example);
	}

	public void proSearchParam(WallMain wallMain, WallMainExample.Criteria criteria) {
		if (null != wallMain) {
			if (null != wallMain.getCorpid()) {
				criteria.andCorpidEqualTo(wallMain.getCorpid());
			}
		}
	}

	@Override
	public int count(WallMain wallMain) {
		WallMainExample example = new WallMainExample();
		WallMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(wallMain, criteria);
		return wallMainMapper.countByExample(example);
	}

	@Override
	public void update(WallMain wallMain) {
		wallMainMapper.updateByPrimaryKey(wallMain);
	}

	@Override
	public void addWallMain(WallMain wallMain) {
		if (null != wallMain)
			wallMainMapper.insert(wallMain);
	}
}