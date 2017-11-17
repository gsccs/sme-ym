package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.SolidContentMapper;
import com.gsccs.sme.plat.rtable.model.SolidContent;
import com.gsccs.sme.plat.rtable.model.SolidContentExample;

@Service
public class SolidContentServiceImpl implements SolidContentService {

	@Autowired
	private SolidContentMapper solidContentMapper;

	@Override
	public SolidContent getSolidContent(Integer id) {
		return solidContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delSolidContent(Integer id) {
		solidContentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SolidContent> find(SolidContent solidContent, String order, int currPage, int pageSize) {
		SolidContentExample example = new SolidContentExample();
		SolidContentExample.Criteria criteria = example.createCriteria();
		proSearchParam(solidContent, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return solidContentMapper.selectPageByExample(example);
	}

	public void proSearchParam(SolidContent solidContent, SolidContentExample.Criteria criteria) {
		if (null != solidContent) {
			if (StringUtils.isNotEmpty(solidContent.getMainid())) {
				criteria.andMainidLike("%" + solidContent.getMainid() + "%");
			}
		}
	}

	@Override
	public int count(SolidContent solidContent) {
		SolidContentExample example = new SolidContentExample();
		SolidContentExample.Criteria criteria = example.createCriteria();
		proSearchParam(solidContent, criteria);
		return solidContentMapper.countByExample(example);
	}

	@Override
	public void update(SolidContent solidContent) {
		solidContentMapper.updateByPrimaryKey(solidContent);
	}

	@Override
	public void addSolidContent(SolidContent solidContent) {
		if (null != solidContent)
			solidContentMapper.insert(solidContent);
	}
}