package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SorderServiceI;
import com.gsccs.sme.plat.svg.model.SorderT;
import com.gsccs.sme.plat.svg.service.SitemService;
import com.gsccs.sme.plat.svg.service.SorderService;
import com.gsccs.sme.plat.svg.service.SvorgService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 服务订单服务接口
 * 
 * @author x.d zhang
 * 
 */
public class SorderServiceAPI implements SorderServiceI {

	@Autowired
	private SorderService sorderService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private SitemService sitemService;

	@Override
	public Sorder getSorder(String id) throws ApiException {
		Sorder o = null;
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		SorderT t = sorderService.findById(id);
		if (null != t) {
			o = new Sorder();
			try {
				BeanUtils.copyProperties(o, t);
				// o.setState(SorderState.valueOf(t.getStatus()));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return o;
	}

	@Override
	public String createSorder(Sorder o) throws ApiException {
		String oid = null;
		if (null == o) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		SorderT ordert = new SorderT();
		BeanUtilsEx.copyProperties(ordert, o);
		// ordert.setStatus(SorderState.WAIT_PAY.name());
		sorderService.insert(ordert);

		/*
		 * SorderTrace trace = new SorderTrace();
		 * trace.setOperate(SorderState.CREATE.name()); trace.setSorderid(oid);
		 * trace.setSiteid(sid); trace.setOperuser("客户");
		 * trace.setRemark("您提交了订单，请等待系统确认."); sorderService.addTrace(sid,
		 * trace);
		 */
		return oid;
	}

	@Override
	public List<Sorder> getSvgSorderList(Long sid, Sorder o, String order,
			int currPage, int pageSize) throws ApiException {
		List<Sorder> list = null;
		SorderT t = new SorderT();
		if (null != o) {
			BeanUtilsEx.copyProperties(t, o);
			// t.setStatus(null == o.getState() ? "" : o.getState().name());
		}

		List<SorderT> orderts = sorderService
				.find(t, order, currPage, pageSize);

		if (null != orderts && orderts.size() > 0) {
			list = new ArrayList<Sorder>();
			for (SorderT ordert : orderts) {
				Sorder order_ = new Sorder();
				BeanUtilsEx.copyProperties(order_, ordert);
				// order_.setState(SorderState.valueOf(ordert.getStatus()));
				list.add(order_);
			}
		}
		return list;
	}

	@Override
	public List<Sorder> getCorpSorderList(Long sid, Sorder o, String order,
			int currPage, int pageSize) throws ApiException {
		SorderT t = null;
		if (null != o) {
			t = new SorderT();
			try {
				BeanUtils.copyProperties(t, o);
				// t.setStatus(null == o.getState() ? null :
				// o.getState().name());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		List<SorderT> ordertList = sorderService.find(t, order, currPage,
				pageSize);

		List<Sorder> apiSorderList = new ArrayList<Sorder>();
		for (SorderT ordert : ordertList) {
			Sorder apiSorder = new Sorder();
			try {
				BeanUtils.copyProperties(apiSorder, ordert);
				// apiSorder.setState(SorderState.valueOf(ordert.getStatus()));
				apiSorderList.add(apiSorder);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return apiSorderList;
	}

	@Override
	public void orderCancel(Long corpId, String orderid) throws ApiException {
		if (null == corpId || null == orderid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		SorderT ordert = sorderService.findById(orderid);
		if (null != ordert) {
			// ordert.setStatus(SorderState.CANCEL.name());
			sorderService.update(ordert);

			/*
			 * SorderTrace trace = new SorderTrace();
			 * trace.setOperate(SorderState.CANCEL.name());
			 * trace.setSorderid(ordersn); trace.setSiteid(sid);
			 * sorderService.addTrace(sid, trace);
			 */
		}
	}

	@Override
	public void orderPayment(Long sid, String orderid) throws ApiException {
		if (null == sid || null == orderid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		SorderT ordert = sorderService.findById(orderid);
	}

	@Override
	public boolean orderdelete(String orderid) {
		try {
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void orderEvaled(Long corpid, String orderid, Integer score,
			String eval) throws ApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public JSONArray orderTraceList(String orderid) throws ApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCorpSorderCount(Long corpid, Sorder param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Sorder> getSorderList(Sorder sorder, String order,
			int currPage, int pageSize) throws ApiException {
		SorderT t = null;
		if (null != sorder) {
			try {
				t = new SorderT();
				BeanUtils.copyProperties(t, sorder);
				// t.setStatus(null == o.getState() ? null :
				// o.getState().name());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		List<SorderT> ordertList = sorderService.find(t, order, currPage,
				pageSize);
		List<Sorder> apiSorderList = new ArrayList<Sorder>();
		for (SorderT ordert : ordertList) {
			Sorder apiSorder = new Sorder();
			try {
				BeanUtils.copyProperties(apiSorder, ordert);
				apiSorderList.add(apiSorder);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return apiSorderList;
	}

	@Override
	public Integer count(Sorder param) {
		SorderT t = null;
		if (null != param) {
			try {
				t = new SorderT();
				BeanUtils.copyProperties(t, param);
			} catch (IllegalAccessException e) {
				return 0;
			} catch (InvocationTargetException e) {
				return 0;
			}
		}
		return sorderService.count(t);
	}

}
