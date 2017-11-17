package com.gsccs.sme.plat.statist.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.site.model.BannerT;
import com.gsccs.sme.plat.site.model.BannerT;

/**
 * 统计分析接口
 * 
 * @author x.d zhang
 * 
 */
public interface StatistService {

	/**
	 * 平台整体运行状态统计
	 * @return
	 */
	public JSONObject platStatist();

	/**
	 * 服务项目按分类统计
	 * @param order
	 * @return
	 */
	public JSONArray loadSitemClass(String order);
	
	/**
	 * 服务机构按分类统计
	 * @param order
	 * @return
	 */
	public JSONArray loadSvorgClass(String order);
	
	
	/**
	 * 行政事项统计
	 * @param order
	 * @return
	 */
	public JSONArray loadAppealTopicSvg(String order);

	
	/**
	 * 行政事项服务记录统计
	 * @param order
	 * @return
	 */
	public JSONArray loadAppealTopicGclass(String order);
}
