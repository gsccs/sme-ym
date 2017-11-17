package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Sitemeval;
import com.gsccs.sme.api.domain.shop.ProductImg;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务项API
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface SitemServiceI {

	/**
	 * 获取服务项
	 */
	public Sitem getSitem(Long id) throws ApiException;

	/**
	 * 添加服务项
	 * 
	 * @param p
	 * @return 商品结构
	 */
	public void addSitem(Sitem sitem) throws ApiException;

	public void updateSitem(Sitem sitem) throws ApiException;

	/**
	 * 删除产品
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void delSitem(Long id) throws ApiException;

	public List<Sitem> querySitemList(Sitem param, String order, int currPage,
			int pageSize) throws ApiException;

	public int count(Sitem param);
	
	
	/**
	 * 增加服务项目评价描述
	 * 
	 * @param seval
	 */
	public void addSitemEval(Sitemeval seval) throws ApiException;

	/**
	 * 增加服务项目评价描述
	 * 
	 * @param param
	 */
	public List<Sitemeval> findItemEvals(Sitemeval param, String order, int page,
			int pagesize) throws ApiException;
	
	public int count(Sitemeval param);

}
