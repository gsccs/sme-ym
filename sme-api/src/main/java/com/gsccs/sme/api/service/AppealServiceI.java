package com.gsccs.sme.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.AppealItem;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务诉求API
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface AppealServiceI {

	/**
	 * 获取服务诉求主题
	 */
	public AppealTopic getTopic(Long id) throws ApiException;

	/**
	 * 获取服务诉求主题
	 */
	public AppealItem getItem(Long id) throws ApiException;

	/**
	 * 删除诉求主题
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void deleteTopics(List<Long> ids) throws ApiException;
	
	/**
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void deleteTopics(Long id) throws ApiException;
	

	/**
	 * 删除诉求记录
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void deleteItems(List<Long> ids) throws ApiException;

	/**
	 * 删除诉求附件
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void deleteAttachs(List<Long> ids) throws ApiException;

	/**
	 * 添加诉求项目
	 * 
	 * @param p
	 * @return
	 */
	public void addAppealItem(AppealItem sitem) throws ApiException;

	
	/**
	 * 修改诉求内容
	 * 
	 * @param p
	 * @return
	 */
	public void editAppealItem(AppealItem sitem) throws ApiException;

	
	/**
	 * 查询诉求记录
	 * 
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public Datagrid queryItemList(AppealItem param, String order,
			int currPage, int pageSize) throws ApiException;

	/**
	 * 查询诉求主题
	 * 
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public Datagrid queryTopicList(AppealTopic param, String order,
			int currPage, int pageSize) throws ApiException;
	
	/**
	 * 查询诉求主题总数
	 * 
	 * @param param
	 * @return
	 * @throws ApiException
	 */
	public Integer countTopic(AppealTopic param);
	
	
	/**
	 * 查询诉求总数
	 * 
	 * @param param
	 * @return
	 * @throws ApiException
	 */
	public Integer countItem(AppealItem param);


	/**
	 * 查询诉求附件
	 * 
	 * @param param
	 * @return
	 * @throws ApiException
	 */
	public List<Attach> queryAttachList(Attach param)
			throws ApiException;
	
	/**
	 * 查询办理进度
	 * @param itemid
	 * @return
	 * @throws ApiException
	 */
	public JSONArray queryTraces(Long itemid)
			throws ApiException;

}
