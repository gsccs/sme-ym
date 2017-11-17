package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Porder;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.PorderServiceI;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.shop.model.OrderT;
import com.gsccs.sme.plat.shop.model.OrderitemT;
import com.gsccs.sme.plat.shop.service.OrderService;
import com.gsccs.sme.plat.shop.service.ProductService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 订单服务接口
 * 
 * @author x.d zhang
 * 
 */
public class PorderServiceAPI implements PorderServiceI {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CorpService corpService;
	@Autowired
	private ProductService productService;

	@Override
	public Porder getOrder(Long orderid) throws ApiException {
		Porder o = null;
		if (null == orderid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		OrderT t = orderService.findById(orderid);
		if (null != t) {
			o = new Porder();
			try {
				BeanUtils.copyProperties(o, t);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return o;
	}

	@Override
	public String createOrder(Porder o)
			throws ApiException {
		String oid = null;
		if (null == o) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		OrderT ordert = new OrderT();
		BeanUtilsEx.copyProperties(ordert, o);
		oid = orderService.insert(ordert);
		return oid;
	}

	@Override
	public List<Porder> getOrderList(Porder o, String order,
			int currPage, int pageSize) throws ApiException {
		List<Porder> list = null;
		OrderT t = new OrderT();
		if (null != o) {
			BeanUtilsEx.copyProperties(t, o);
		}

		List<OrderT> orderts = orderService.find(t,order, currPage,
				pageSize);

		if (null != orderts && orderts.size() > 0) {
			list = new ArrayList<Porder>();
			for (OrderT ordert : orderts) {
				Porder order_ = new Porder();
				BeanUtilsEx.copyProperties(order_, ordert);
				list.add(order_);
			}
		}
		return list;
	}

	

	@Override
	public int getOrderCount(Porder param) throws ApiException {
		OrderT t = null;
		if (null != param) {
			t = new OrderT();
			BeanUtilsEx.copyProperties(t, param);
		}
		int count = orderService.count(t);
		return count;
	}


	
	@Override
	public boolean orderdelete(String orderid) {
		try {
			orderService.deleteOrder(orderid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public List<Porder> getProductOrderList(Long productid, String order,
			int currPage, int pageSize) throws ApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countProductOrders(Long productid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void orderCancel(String orderid) throws ApiException {
		// TODO Auto-generated method stub
		
	}

}
