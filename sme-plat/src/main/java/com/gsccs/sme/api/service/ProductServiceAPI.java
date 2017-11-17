package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ProductServiceI;
import com.gsccs.sme.plat.shop.model.ProductImgT;
import com.gsccs.sme.plat.shop.model.ProductT;
import com.gsccs.sme.plat.shop.service.ProductService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 产品服务接口
 * 
 * @author x.d zhang
 * 
 */
public class ProductServiceAPI implements ProductServiceI {

	@Autowired
	private ProductService productService;

	@Override
	public Product getProduct(Long id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		ProductT productT = productService.getProduct(id);
		if (null != productT) {
			Product product = new Product();
			BeanUtilsEx.copyProperties(product, productT);
			List<ProductImgT> imgTs = productService.getImgByPid(id);
			if (null != imgTs && imgTs.size()>0){
				List<Attach> images = new ArrayList<Attach>();
				for (ProductImgT imgT:imgTs){
					Attach attach = new Attach();
					attach.setId(imgT.getId().toString());
					attach.setFilepath(imgT.getUrl());
				}
				product.setImages(images);
			}
			return product;
		}
		return null;
	}

	@Override
	public void addProduct(Product product) throws ApiException {

		if (null == product) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			ProductT productT = new ProductT();
			BeanUtilsEx.copyProperties(productT, product);
			// BeanUtils.copyProperties(productT, product);
			productService.addProduct(productT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delProduct(Long ids) throws ApiException {
	}

	@Override
	public void updateProduct(Product product) throws ApiException {
		if (null == product) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			ProductT productT = new ProductT();
			BeanUtils.copyProperties(productT, product);
			productService.editProduct(productT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> queryProductList(Product param, String order,
			int page, int pagesize) throws ApiException {
		List<Product> list = null;
		ProductT t = null;
		if (null != param) {
			t = new ProductT();
			BeanUtilsEx.copyProperties(t, param);
		}

		List<ProductT> productTs = productService
				.find(t, order, page, pagesize);

		if (null != productTs && productTs.size() > 0) {
			list = new ArrayList<Product>();
			for (ProductT productT : productTs) {
				Product product_ = new Product();
				BeanUtilsEx.copyProperties(product_, productT);
				list.add(product_);
			}
		}
		return list;
	}

	@Override
	public int count(Product param) throws ApiException {
		if (null != param) {
			ProductT t = new ProductT();
			BeanUtilsEx.copyProperties(t, param);
			return productService.count(t);
		}
		return 0;
	}

}
