package com.gsccs.sme.api.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.Collect;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 收藏服务接口
 * 
 * @author x.d zhang
 * 
 */
public interface CollectServiceI {

	public void addCollect(Collect collect) throws ApiException;

	public JSONArray getCollects(Collect collect, int page, int size)
			throws ApiException;

	public JSONObject collectStatist(Long siteid, Long buyerid)
			throws ApiException;

}
