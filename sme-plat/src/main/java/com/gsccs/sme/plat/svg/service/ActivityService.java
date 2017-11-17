package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.plat.svg.model.ActenrollT;
import com.gsccs.sme.plat.svg.model.ActivityT;

public interface ActivityService {

	public void insert(ActivityT activityT);

	public void update(ActivityT activityT);

	public void delActivity(Long id);

	public ActivityT findById(Long id);

	public List<ActivityT> find(ActivityT activityT);

	/**
	 * 分页查询
	 */
	public List<ActivityT> find(ActivityT activityT, String order,
			int currPage, int pageSize);

	public int count(ActivityT activityT);
	
	/*
	 * 活动报名
	 */
	public void insert(ActenrollT actenrollT);
	
	/*
	 * 活动报名
	 */
	public void delete(Long actid,Long userid);
	
	/**
	 * 分页查询
	 */
	public List<ActenrollT> find(ActenrollT actenrollT, String order,
			int currPage, int pageSize);
	public int count(ActenrollT actenrollT);
	
	public Datagrid enrollActList(Long userid, String order,
			int currPage, int pageSize);

}
