package com.gsccs.sme.plat.auth.service;

import java.util.List;

import com.gsccs.sme.plat.auth.model.AreaT;

/**
 */
public interface AreaService {

	List<AreaT> getByParId(Integer parentid);
	
	List<AreaT> findAreaList(String ids);

	/**
	 * 分页查询
	 */
	public List<AreaT> find(AreaT area, String order, int currPage, int pageSize);

	public int count(AreaT area);

	public String getAreaStr(Integer id);

}
