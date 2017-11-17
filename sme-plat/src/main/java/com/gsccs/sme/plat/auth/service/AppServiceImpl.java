package com.gsccs.sme.plat.auth.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.AppMapper;
import com.gsccs.sme.plat.auth.model.App;
import com.gsccs.sme.plat.auth.model.AppExample;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.model.UserExample;
import com.gsccs.sme.plat.auth.model.AppExample.Criteria;

/**
 * <p>
 * User: x.d zhang
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 * 
 */
@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppMapper appMapper;

	public App createApp(App app) {
		appMapper.insert(app);
		return appMapper.selectByPrimaryKey(app.getId());
	}

	public App updateApp(App app) {
		appMapper.updateByPrimaryKey(app);
		return appMapper.selectByPrimaryKey(app.getId());
	}

	public void deleteApp(Long appId) {
		appMapper.deleteByPrimaryKey(appId);
	}

	@Override
	public App findOne(Long appId) {
		return appMapper.selectByPrimaryKey(appId);
	}

	@Override
	public List<App> findAll() {
		AppExample example = new AppExample();
		Criteria c = example.createCriteria();

		return appMapper.selectByExample(example);
	}

	@Override
	public Long findAppIdByAppKey(String appKey) {
		AppExample example = new AppExample();
		Criteria c = example.createCriteria();
		c.andAppKeyEqualTo(appKey);
		List<App> applist = appMapper.selectByExample(example);
		if (null != applist && applist.size() > 0) {
			return applist.get(0).getId();
		}
		return null;
	}

	@Override
	public List<App> find(App param, String order, int currPage, int pageSize) {
		AppExample example = new AppExample();
		AppExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return appMapper.selectPageByExample(example);
	}

	@Override
	public Integer count(App param) {
		AppExample example = new AppExample();
		AppExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return appMapper.countByExample(example);
	}
	
	
	public void proSearchParam(App param, AppExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getName())) {
				criteria.andNameLike("%" + param.getName() + "%");
			}

			if (StringUtils.isNotEmpty(param.getAppKey())) {
				criteria.andAppKeyEqualTo(param.getAppKey());
			}
		}
	}
}
