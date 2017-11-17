package com.gsccs.sme.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.site.Banner;

/**
 * 平台信息
 * @author ZhangTao
 *
 */
public interface PlatInfoServiceI {

	/**
	 * 平台统计信息
	 * @return
	 */
	public JSONObject statist();
	
	
	
}
