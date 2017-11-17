package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.ActEnroll;
import com.gsccs.sme.api.domain.Park;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 园区API
 * 
 * @author x.d zhang
 * @date 16-02-26
 * 
 */
public interface ParkServiceI {

	/**
	 * 获取园区
	 */
	public Park getPark(Long id) throws ApiException;
	
	public List<Park> queryParkList(Park param, String order,
			int currPage, int pageSize) throws ApiException;

	public int count(Park param) throws ApiException;
	
	
	

}
