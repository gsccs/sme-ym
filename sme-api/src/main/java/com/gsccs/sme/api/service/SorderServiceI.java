package com.gsccs.sme.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务订单API
 * 
 * @类名称：SorderServiceI
 */
public interface SorderServiceI {

	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public Sorder getSorder(String id) throws ApiException;

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public String createSorder(Sorder order) throws ApiException;

	/**
	 * 订单取消
	 * 
	 * @param sid
	 * @param order
	 * @return
	 */
	public void orderCancel(Long corpid, String orderid) throws ApiException;

	/**
	 * 订单支付
	 * 
	 * @param sid
	 * @param ordersn
	 * @return
	 */
	public void orderPayment(Long corpid, String orderid) throws ApiException;

	/**
	 * 订单评价
	 * 
	 * @param sid
	 * @param ordersn
	 * @return
	 */
	public void orderEvaled(Long corpid, String orderid, Integer score,
			String eval) throws ApiException;

	/**
	 * 服务订单
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<Sorder> getSorderList(Sorder param, String order,
			int currPage, int pageSize) throws ApiException;
	public Integer count(Sorder param);
	/**
	 * 获得企业服务订单列表
	 * 
	 * @param corpid
	 * @param param
	 * @return
	 * @throws ApiException
	 */
	public List<Sorder> getCorpSorderList(Long corpid, Sorder param, String order,
			int currPage, int pageSize) throws ApiException;
	public int getCorpSorderCount(Long corpid, Sorder param);

	/**
	 * 获得服务机构订单
	 * 
	 * @param cid
	 * @param o
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<Sorder> getSvgSorderList(Long cid, Sorder o, String order,
			int currPage, int pageSize) throws ApiException;

	/**
	 * 订单跟踪列表
	 * 
	 * @param id
	 * @return
	 */
	public JSONArray orderTraceList(String orderid) throws ApiException;

	/**
	 * 订单删除
	 * 
	 * @param orderid
	 * @return
	 */
	public boolean orderdelete(String orderid) throws ApiException;
}
