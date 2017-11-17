package com.gsccs.sme.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.PorderItem;
import com.gsccs.sme.api.domain.base.Datagrid;

/**
 * 交易API 
 * 
 * @author x.d zhang
 * 
 */
public interface TradeServiceI {

	/**
	 * 获取产品购买记录列表
	 * 
	 * @param siteid
	 * @param pid
	 */
	public JSONObject getProductSaleList_m(Long siteid,Long pid,int page,int rows);

	
}
