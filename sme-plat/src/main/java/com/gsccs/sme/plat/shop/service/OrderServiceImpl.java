package com.gsccs.sme.plat.shop.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.plat.shop.dao.OrderMapper;
import com.gsccs.sme.plat.shop.dao.OrderitemMapper;
import com.gsccs.sme.plat.shop.dao.ProductTMapper;
import com.gsccs.sme.plat.shop.model.OrderExample;
import com.gsccs.sme.plat.shop.model.OrderExample.Criteria;
import com.gsccs.sme.plat.shop.model.OrderT;
import com.gsccs.sme.plat.shop.model.OrderitemExample;
import com.gsccs.sme.plat.shop.model.OrderitemT;
import com.gsccs.sme.plat.shop.model.ProductT;
import com.gsccs.sme.plat.utils.DateUtil;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderitemMapper orderitemMapper;
	@Autowired
	private ProductTMapper productTMapper;

	@Override
	public List<OrderT> find(OrderT orders, String order, int currPage,
			int pageSize) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(orders, criteria);

		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		}
		return orderMapper.selectPageByExample(example);
	}

	@Override
	public String insert(OrderT order) {
		if (null == order || null == order.getProductid()){ 
			return null;
		}
		
		ProductT productT = productTMapper.selectByPrimaryKey(order.getProductid());
		if (null == productT){
			return null;
		}
		String ordersn = DateUtil.getOrderNum();
		order.setProductid(productT.getId());
		order.setSellerid(productT.getCorpid());
		order.setOrdersn(ordersn);
		order.setGoodsfee(productT.getPrice()==null?0.00:productT.getPrice());
		order.setTotalnum(null==order.getTotalnum()?1:order.getTotalnum());
		order.setTotalfee(order.getGoodsfee()*order.getTotalnum());
		order.setStatus("1");
		order.setAddtime(new Date());
		orderMapper.insert(order);
		return ordersn;
	}

	@Override
	public void update(OrderT order) {
		if (null != order) {
			orderMapper.updateByPrimaryKeySelective(order);
		}
	}

	@Override
	public OrderT findById(Long id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int count(OrderT order) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(order, criteria);
		return orderMapper.countByExample(example);
	}

	@Override
	public List<OrderitemT> findOItems(Long orderid) {
		OrderitemExample example = new OrderitemExample();
		OrderitemExample.Criteria criteria = example.createCriteria();
		OrderitemT param = new OrderitemT();
		param.setOrderid(orderid);
		proSearchParam(param, criteria);
		return orderitemMapper.selectByExample(example);
	}

	
	@Override
	public List<OrderitemT> findProductSaleItems(Long productid) {
		OrderitemExample example = new OrderitemExample();
		OrderitemExample.Criteria criteria = example.createCriteria();
		OrderitemT param = new OrderitemT();
		param.setProductid(productid);
		proSearchParam(param, criteria);
		return orderitemMapper.selectByExample(example);
	}

	@Override
	public int countItems(OrderitemT param) {
		OrderitemExample example = new OrderitemExample();
		OrderitemExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return orderitemMapper.countByExample(example);
	}


	/**
	 * 查询条件
	 * 
	 * @param orders
	 * @param sid
	 * @param criteria
	 */
	private void proSearchParam(OrderitemT param,
			OrderitemExample.Criteria criteria) {
		if (param != null) {
			if (param.getStatus() != null) {
				criteria.andStatusEqualTo(param.getStatus());
			}

			if (null != param.getOrderid()) {
				criteria.andOrderidEqualTo(param.getOrderid());
			}

			if (null != param.getProductid()) {
				criteria.andProductidEqualTo(param.getProductid());
			}

		}
	}

	/**
	 * 查询条件
	 * 
	 * @param orders
	 * @param sid
	 * @param criteria
	 */
	private void proSearchParam(OrderT param, OrderExample.Criteria criteria) {
		if (param != null) {
			if (param.getStatus() != null) {
				criteria.andStatusEqualTo(param.getStatus());
			}

			if (null != param.getSellerid()) {
				criteria.andSelleridEqualTo(param.getSellerid());
			}

			if (null != param.getBuyerid()) {
				criteria.andBuyeridEqualTo(param.getBuyerid());
			}
			
			
			if (null != param.getProductid()) {
				criteria.andProductidEqualTo(param.getProductid());
			}


		}
	}

	@Override
	public OrderT findByOrdersn(String ordersn) {
		OrderExample example = new OrderExample();
		Criteria c = example.createCriteria();
		if (StringUtils.isNotEmpty(ordersn)){
			c.andOrdersnEqualTo(ordersn);
			List<OrderT> orderlist = orderMapper.selectByExample(example);
			if (null != orderlist){
				return orderlist.get(0);
			}
		}
		return null;
	}

	@Override
	public void deleteOrder(String ordersn) {
		OrderExample example = new OrderExample();
		Criteria c = example.createCriteria();
		if(StringUtils.isNotEmpty(ordersn)){
			c.andOrdersnEqualTo(ordersn);
			orderMapper.deleteByExample(example);
		}
	}

}
