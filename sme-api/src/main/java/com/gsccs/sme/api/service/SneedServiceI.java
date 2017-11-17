package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.CapitalAppl;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务需求API
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface SneedServiceI {

	/**
	 * 获取服务需求
	 */
	public Sneed getSneed(Long id) throws ApiException;

	/**
	 * 添加服务需求
	 * 
	 * @param p
	 * @return
	 */
	public void addSneed(Sneed sneed) throws ApiException;
	
	
	/**
	 * 更新需求
	 * @param sneed
	 * @throws ApiException
	 */
	public void updateSneed(Sneed sneed) throws ApiException;

	
	/**
	 * 获得服务需求列表
	 * 
	 * @param Sneed
	 *            服务需求
	 * @param orderstr
	 *            排序
	 * @return
	 * @throws ApiException
	 */
	public List<Sneed> querySneedList(Sneed param, String orderstr, int page,
			int pagesize) throws ApiException;

	public Integer count(Sneed param) throws ApiException;
	
	public void addSneedBid(Long sneedid,Long svgid,String remark) throws ApiException ;
	public Datagrid queryBidList(Long sneedid, String orderstr, int page,
			int pagesize) throws ApiException;
	public void setSneedBidStone(Long bidid) throws ApiException ;
	
	
	/**
	 * 融资需求
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<CapitalAppl> find(CapitalAppl param, String order, int currPage,
			int pageSize);
	
	public int count(CapitalAppl param);
	
	public void addCapitalAppl(CapitalAppl sneed);

	public CapitalAppl getCapitalAppl(Long id);

	public void delCapitalAppl(Long id);
}
