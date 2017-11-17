package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.ActEnroll;
import com.gsccs.sme.api.domain.Activity;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务活动API
 * 
 * @author x.d zhang
 * @date 16-02-26
 * 
 */
public interface ActivityServiceI {

	/**
	 * 获取活动
	 */
	public Activity getActivity(Long id) throws ApiException;

	/**
	 * 添加活动
	 * 
	 * @param p
	 * @return 商品结构
	 */
	public void addActivity(Activity activity) throws ApiException;

	public void updateActivity(Activity activity) throws ApiException;

	/**
	 * 删除活动
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void delActivity(Long id) throws ApiException;

	public List<Activity> queryActivityList(Activity param, String order,
			int currPage, int pageSize) throws ApiException;

	public int count(Activity param) throws ApiException;
	
	/**
	 * 活动报名
	 * @param actEnroll
	 */
	public void addActEnroll(ActEnroll actEnroll) throws ApiException ;
	
	/**
	 * 取消活动报名
	 * @param actid
	 */
	public void cancelActEnroll(Long actid,Long userid) throws ApiException ;
	
	/**
	 * 查询报名的活动
	 * @param userid
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public Datagrid queryEnrollActList(Long userid, String order,
			int currPage, int pageSize) throws ApiException;
	
	

}
