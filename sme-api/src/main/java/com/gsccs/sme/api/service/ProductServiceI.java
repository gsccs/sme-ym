package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 产品管理API
 * 
 * @author x.d zhang
 * @date 16-02-26
 * 
 */
public interface ProductServiceI {

	/**
	 * 获取服务项
	 */
	public Product getProduct(Long id) throws ApiException;

	/**
	 * 添加服务项
	 * 
	 * @param p
	 * @return 商品结构
	 */
	public void addProduct(Product product) throws ApiException;

	public void updateProduct(Product product) throws ApiException;

	/**
	 * 删除产品
	 * 
	 * @param ids
	 * @throws ApiException
	 */
	public void delProduct(Long id) throws ApiException;

	public List<Product> queryProductList(Product param, String order,
			int currPage, int pageSize) throws ApiException;

	public int count(Product param) throws ApiException;

}
