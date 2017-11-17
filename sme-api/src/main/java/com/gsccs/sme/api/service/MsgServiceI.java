package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.Msg;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 平台消息API
 * 
 * @author x.d zhang
 * 
 */
public interface MsgServiceI {

	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public Msg getMsg(String id) throws ApiException;

	/**
	 * 添加消息
	 * 
	 * @param msg
	 * @return
	 */
	public void addMsg(Msg msg) throws ApiException;
	
	/**
	 * 更新消息
	 * 
	 * @param mgs
	 * @return
	 */
	public void updateMsg(Msg msg) throws ApiException;

	/**
	 * 消息列表
	 * 
	 * @param param
	 * @param consult
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<Msg> findMsgList(Msg param, String order, int page,
			int pagesize) throws ApiException;
	
	public Integer countMsgs(Msg param) throws ApiException;
	
	/**
	 * 删除消息
	 * 
	 * @param id
	 * @return
	 */
	public void delete(String id) throws ApiException;
}
