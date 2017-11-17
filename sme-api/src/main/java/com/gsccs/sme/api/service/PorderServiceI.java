package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Porder;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 订单API
 * 
 * @类名称：OrderServiceI
 */
public interface PorderServiceI {

	/**
	 * 根据订单Id查询
	 * 
	 * @param orderid
	 * @return
	 */
	public Porder getOrder(Long orderid) throws ApiException;

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public String createOrder(Porder order) throws ApiException;

	/**
	 * 订单取消
	 * 
	 * @param order
	 * @return
	 */
	public void orderCancel(String orderid) throws ApiException;

	/**
	 * 获得订单
	 * 
	 * @param o
	 * @return
	 * @throws ApiException
	 */
	public List<Porder> getOrderList(Porder o, String order, int currPage,
			int pageSize) throws ApiException;

	/**
	 * 获得产品订单列表
	 * 
	 * @param sid
	 * @param o
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<Porder> getProductOrderList(Long productid, String order,
			int currPage, int pageSize) throws ApiException;

	Integer countProductOrders(Long productid);

	/**
	 * 根据条件查询符合条件的条数
	 * 
	 * @param porder
	 * @return
	 * @throws ApiException
	 */
	public int getOrderCount(Porder porder) throws ApiException;

	/**
	 * 订单删除
	 * 
	 * @param orderid
	 * @return
	 */
	public boolean orderdelete(String orderid) throws ApiException;
}
