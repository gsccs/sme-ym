package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Industry;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.shop.ProductImg;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务项API
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface IndustryServiceI {

	/**
	 * 获取根类目
	 * 
	 * @return
	 */
	public List<Industry> getRootList();

	/**
	 * 获取站点根类目
	 * 
	 * @param classid
	 *            父级分类ID
	 * @return
	 */
	public List<Industry> getSubList(Long parid);

	/**
	 * 获取类目详情
	 * 
	 * @param cateId
	 * @return
	 */
	public Industry getIndustry(Long sclassid);

}
