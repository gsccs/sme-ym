package com.gsccs.sme.web.api.service;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.shop.Brand;
import com.gsccs.sme.api.domain.shop.Product;

public interface RedisService {

	public String getRootPath();

	public Svorg getSVG(String id);

	public Brand getBrand(String id);

	public Account getAccount(String account);

	public Itemtype getSclass(String id);

	public Sitem getSitem(Long id);

	public Product getProduct(Long id);
}
