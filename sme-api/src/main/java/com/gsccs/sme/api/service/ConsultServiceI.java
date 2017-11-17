package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务咨询API
 * 
 * @author x.d zhang
 * 
 */
public interface ConsultServiceI {

	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public Consult getConsult(Long id) throws ApiException;

	/**
	 * 添加咨询内容
	 * 
	 * @param consult
	 * @return
	 */
	public void addConsult(Consult consult) throws ApiException;

	/**
	 * 咨询列表
	 * 
	 * @param param
	 * @param consult
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public Datagrid datagrid(Consult param, String order, int page,
			int pagesize) throws ApiException;
	
	/**
	 * 咨询列表
	 * 
	 * @param param
	 * @param consult
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<Consult> findConsultList(Consult param, String order, int page,
			int pagesize) throws ApiException;
	
	public Integer countConsults(Consult param) throws ApiException;
	/**
	 * 回复列表
	 * 
	 * @param parid
	 * @param consult
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public Datagrid getReplyList(Long parid, String order, int page,
			int pagesize) throws ApiException;
	
	/**
	 * 回复列表
	 * 
	 * @param parid
	 * @param consult
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<Consult> getReplyListByCorpid(Long corpid, String order, int page,
			int pagesize) throws ApiException;


	
	/**
	 * 删除咨询内容
	 * 
	 * @param consultid
	 * @return
	 */
	public boolean delete(Long id) throws ApiException;
}
