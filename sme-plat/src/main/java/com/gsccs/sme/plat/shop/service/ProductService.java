package com.gsccs.sme.plat.shop.service;

import java.util.List;

import com.gsccs.sme.plat.shop.model.ProductImgT;
import com.gsccs.sme.plat.shop.model.ProductT;

public interface ProductService {

	/**
	 * 添加产品
	 * 
	 * @param p
	 * @return
	 */
	public Long addProduct(ProductT p);

	/**
	 * 获得产品
	 * 
	 * @param sid
	 * @param pid
	 * @return
	 */
	public ProductT getProduct(Long pid);
	
	
	/**
	 * 产品列表
	 * @param param
	 * @param order
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<ProductT> find(ProductT param, String order, int page,
			int pagesize);

	int count(ProductT param);

	/**
	 * 修改产品状态
	 * 
	 * @param sid
	 * @param productId
	 * @param status
	 */
	public void editProductStatus(Long productId, String status);

	/**
	 * 删除产品
	 * 
	 * @param sid
	 * @param pId
	 */
	public void delProduct(Long pId);

	/**
	 * 编辑产品
	 * 
	 * @param sid
	 * @param pt
	 */
	public void editProduct(ProductT pt);

	/**
	 * 商品自动下架
	 * 
	 * @param sid
	 */
	public void productUnsale(Long sid);

	public List<ProductImgT> getImgByPid(Long pid);

	public Long[] addListImg(Long sid, List<ProductImgT> pitList);

}
