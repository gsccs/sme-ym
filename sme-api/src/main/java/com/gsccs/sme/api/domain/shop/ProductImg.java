package com.gsccs.sme.api.domain.shop;

import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 产品图片
 * 
 * @author x.d zhang
 * 
 */
public class ProductImg extends Domain {

	private static final long serialVersionUID = 6161182663923237286L;

	/**
	 * 产品图片ID
	 */
	private String id;

	/**
	 * 图片所属产品的ID
	 */
	private Long productId;

	/**
	 * 图片地址.(绝对地址,格式:http://host/image_path)
	 */
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
