package com.gsccs.sme.plat.shop.service;

import java.util.List;

import com.gsccs.sme.plat.shop.model.OrderT;
import com.gsccs.sme.plat.shop.model.OrderitemT;

/**
 * 订单服务接口
 * 
 */
public interface OrderService {
	
	/**
	 * 获取订单分页列表
	 * @param orders
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<OrderT> find(OrderT orders, String order, int currPage,
			int pageSize);

	/**
	 * 添加订单
	 * @param sid
	 * @param order
	 * @return
	 */
	public String insert(OrderT order);
	
	/**
	 * 修改订单
	 * @param templet
	 */
	public void update(OrderT order);
	
	/**
	 * 根据Id查询订单
	 * @param id
	 * @return
	 */
	public OrderT findById(Long id);
	
	/**
	 * 根据序列号查询订单
	 * @param ordersn
	 * @return
	 */
	public OrderT findByOrdersn(String ordersn);
	
	/**
	 * 删除订单
	 * @param sid
	 * @param ordersn
	 */
	public void deleteOrder(String ordersn);
	/**
	 * 查询总数
	 * @param order
	 * @param sid
	 * @return
	 */
	public int count(OrderT order);
	
	
	/**
	 * 查询订单详情
	 * @param sid
	 * @param oId
	 * @return
	 */
	public List<OrderitemT> findOItems(Long oId);
	
	/**
	 * 查询产品销售记录
	 * @param sid
	 * @param oId
	 * @return
	 */
	public List<OrderitemT> findProductSaleItems(Long pid);
	
	public int countItems(OrderitemT param);
	
	
	
}
