package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Expect;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 专家API
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface ExpertServiceI {

	/**
	 * 获取专家
	 */
	public Expect getExpert(String id) throws ApiException;

	/**
	 * 添加服务专家
	 * 
	 * @param p
	 * @return
	 */
	public void addExpert(Expect expert) throws ApiException;

	/**
	 * 更新服务专家
	 * 
	 * @param p
	 * @return
	 */
	public void updateExpert(Expect expert) throws ApiException;
	
	/**
	 * 获得服务专家列表
	 * 
	 * @param Expect
	 *            专家
	 * @param order
	 *            排序
	 * @return
	 * @throws ApiException
	 */
	public List<Expect> queryExpertList(Expect param, String orderstr,
			int page, int pagesize) throws ApiException;

	public Integer count(Expect param);

}
