package com.gsccs.sme.web.api.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.CacheConst;
import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.shop.Brand;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.EvalServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@Service
public class RedisServiceImpl implements RedisService {

	private static Logger logger = Logger.getLogger("RedisCache");
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private SvorgServiceI svgAPI;
	@Autowired
	private SitemServiceI sitemAPI;
	@Autowired
	private SclassServiceI sclassAPI;
	@Autowired
	private EvalServiceI evalAPI;
	@Autowired
	private AccountServiceI accountAPI;

	
	@Override
	public String getRootPath() {
		String rootPath = (String) redisTemplate.boundValueOps(
				CacheConst.CONFIG_ROOT_PATH).get();
		if (!StringUtils.isNotEmpty(rootPath)) {
			rootPath = configAPI.getConfigVal(CacheConst.CONFIG_ROOT_PATH);
			if (StringUtils.isNotEmpty(rootPath)) {
				redisTemplate.boundValueOps(CacheConst.CONFIG_ROOT_PATH).set(
						rootPath);
			}
		}
		return rootPath;
	}

	public JSONArray getSiteCates(Long sid) {
		JSONArray cateArray = null;
		try {
			cateArray = (JSONArray) redisTemplate.boundValueOps(
					CacheConst.SITE_CATE_LIST_ + sid).get();
			if (null != cateArray) {
				return cateArray;
			} 
		} catch (Exception e) {
			
		}
		return cateArray;
	}

	@Override
	public Svorg getSVG(String id) {
		Svorg store = (Svorg) redisTemplate.boundValueOps(
				CacheConst.STORE_OBJ_ + id).get();
		if (null == store) {
			
		}
		return store;
	}

	@Override
	public Itemtype getSclass(String id) {
		Itemtype category = (Itemtype) redisTemplate.boundValueOps(
				CacheConst.CATE_OBJ_ + id).get();
		if (null == category) {
			//category = cateAPI.getCate(cid);
			if (null != category) {
				redisTemplate.boundValueOps(CacheConst.CATE_OBJ_ + id).set(
						category);
			}
		}
		return category;
	}

	

	@Override
	public Sitem getSitem(Long id) {
		// 获取产品信息
		Sitem sitem = null;
		try {
			sitem = (Sitem) redisTemplate.boundValueOps(
					CacheConst.PRODUCT_OBJ_+ id).get();
			if (sitem == null) {
				sitem = sitemAPI.getSitem(id);
				if (null != sitem) {
					redisTemplate.boundValueOps(
							CacheConst.PRODUCT_OBJ_+ id).set(
									sitem);
				}
			} else {
				logger.info("缓存" + CacheConst.PRODUCT_OBJ_ + id
						+ "命中");
			}
		} catch (Exception e) {
			try {
				sitem = sitemAPI.getSitem(id);
			} catch (ApiException e1) {
				logger.info("错误：请求产品数据 " + id + "错误");
			}
		}
		return sitem;
	}

	
	@Override
	public Account getAccount(String account) {
		Account user = null;
		try {
			user = (Account) redisTemplate.boundValueOps(
					CacheConst.BUYER_OBJ_ + account).get();
			if (user == null) {
				user = accountAPI.getAccount(account);
			}
		} catch (Exception e) {
			try {
				user = accountAPI.getAccount(account);
			} catch (ApiException e1) {

			}
		}
		return user;
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brand getBrand(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
