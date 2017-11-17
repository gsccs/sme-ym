package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.shop.ProductImg;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 信息API
 * 
 * @author x.d zhang
 * @date 16-02-26
 * 
 */
public interface InfoServiceI {

	/**
	 * 获取单条信息
	 * @param id
	 * @param andAttach
	 * @return
	 * @throws ApiException
	 */
	public Info getInfo(Long id,boolean andAttach) throws ApiException;

	/**
	 * 添加信息
	 * 
	 * @param p
	 * @return 
	 */
	public void addInfo(Info info) throws ApiException;

	public void updateInfo(Info info) throws ApiException;

	public List<Info> queryInfoList(Info param, String order,
			int currPage, int pageSize) throws ApiException;

	public int count(Info param) throws ApiException;

	void delInfos(List<Long> ids) throws ApiException;
	
	public List<Attach> queryAttachs(Long infoid);
	
}
