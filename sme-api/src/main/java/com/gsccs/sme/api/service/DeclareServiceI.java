package com.gsccs.sme.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.DeclareItem;
import com.gsccs.sme.api.domain.DeclareTopic;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 项目申报API
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface DeclareServiceI {

	/**
	 * 获取项目申报主题
	 */
	public DeclareTopic getTopic(Long id) throws ApiException;

	/**
	 * 获取项目申报主题
	 */
	public DeclareItem getItem(Long id) throws ApiException;

	/**
	 * 删除申报主题
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void deleteTopics(List<Long> ids) throws ApiException;
	
	public void deleteTopics(Long ids) throws ApiException;
	

	/**
	 * 删除申报记录
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void deleteItems(List<Long> ids) throws ApiException;

	/**
	 * 删除申报附件
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void deleteAttachs(List<Long> ids) throws ApiException;

	/**
	 * 添加申报项目
	 * 
	 * @param p
	 * @return
	 */
	public void addDeclareItem(DeclareItem sitem) throws ApiException;

	
	/**
	 * 更新申报项目
	 * 
	 * @param p
	 * @return
	 */
	public void editDeclareItem(DeclareItem sitem) throws ApiException;

	/**
	 * 查询申报记录
	 * 
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public Datagrid queryItemList(DeclareItem param, String order,
			int currPage, int pageSize) throws ApiException;

	/**
	 * 查询申报主题
	 * 
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public Datagrid queryTopicList(DeclareTopic param, String order,
			int currPage, int pageSize) throws ApiException;

	/**
	 * 查询申报附件
	 * 
	 * @param param
	 * @return
	 * @throws ApiException
	 */
	public List<Attach> queryAttachList(Attach param)
			throws ApiException;

	public JSONArray queryTraces(Long itemid) throws ApiException;
}
