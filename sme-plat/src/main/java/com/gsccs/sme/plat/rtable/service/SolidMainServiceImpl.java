package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.SolidMainMapper;
import com.gsccs.sme.plat.rtable.model.SolidMain;
import com.gsccs.sme.plat.rtable.model.SolidMainExample;

@Service
public class SolidMainServiceImpl implements SolidMainService {

	@Autowired
	private SolidMainMapper solidMainMapper;

	@Override
	public SolidMain getSolidMain(String id) {
		return solidMainMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delSolidMain(String id) {
		solidMainMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SolidMain> find(SolidMain solidMain, String order, int currPage, int pageSize) {
		SolidMainExample example = new SolidMainExample();
		SolidMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(solidMain, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return solidMainMapper.selectPageByExample(example);
	}

	public void proSearchParam(SolidMain solidMain, SolidMainExample.Criteria criteria) {
		if (null != solidMain) {
			if (null != solidMain.getCorpid()) {
				criteria.andCorpidEqualTo(solidMain.getCorpid());
			}
		}
	}

	@Override
	public int count(SolidMain solidMain) {
		SolidMainExample example = new SolidMainExample();
		SolidMainExample.Criteria criteria = example.createCriteria();
		proSearchParam(solidMain, criteria);
		return solidMainMapper.countByExample(example);
	}

	@Override
	public void update(SolidMain solidMain) {
		solidMainMapper.updateByPrimaryKey(solidMain);
	}

	@Override
	public void addSolidMain(SolidMain solidMain) {
		if (null != solidMain)
			solidMainMapper.insert(solidMain);
	}
}