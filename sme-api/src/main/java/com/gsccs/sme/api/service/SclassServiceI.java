package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Itemtype;

/**
 * 类目API 提供了标准类目
 * 
 * @author x.d zhang
 * 
 */
public interface SclassServiceI {

	/**
	 * 获取服务分类
	 * 
	 * @return
	 */
	public List<Itemtype> getRootClass(String type);
	

	/**
	 * 获取站点根类目
	 * 
	 * @param classid
	 *            父级分类ID
	 * @return
	 */
	public List<Itemtype> getSubClass(Long classid);

	/**
	 * 获取分类详情
	 * 
	 * @param classid
	 * @return
	 */
	public Itemtype getSclass(Long sclassid);
	
}
