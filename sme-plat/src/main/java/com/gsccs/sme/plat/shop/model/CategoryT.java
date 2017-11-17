package com.gsccs.sme.plat.shop.model;

import com.gsccs.sme.api.domain.shop.Category;

/**
 * 产品类目
 * 
 * @author x.d zhang
 * 
 */
public class CategoryT extends Category {

	private Integer indexnum;

	public Integer getIndexnum() {
		return indexnum;
	}

	public void setIndexnum(Integer indexnum) {
		if (null == indexnum) {
			indexnum = 0;
		}
		this.indexnum = indexnum;
	}

}